//// dynamic.js - dynamic content page elements, usually with ExtJS
// used to be popup.js

//// GLOSSARY HOVER INFO ////

function removeDefinition(link) {
  var gp = link.parentNode.parentNode;
  if(gp.lastChild.flag) {
    gp.removeChild(gp.lastChild);
  }
  return true;
}

function createDefinition(link) {
  nodeId = link.href.split('#');
  if (nodeId.length <= 1) {
    return false;
  }
  var node = document.getElementById(nodeId[1]);
  var nodeDDs = node.getElementsByTagName('dd');
  var nodeDL = document.createElement('dl');

  for (var i=0; i < nodeDDs.length; i++) {
    var dd = nodeDDs.item(i);
    nodeDL.appendChild(dd.cloneNode(true));
  }

  var span = document.createElement("span");
  span.className = "lensinfo hiddenStructure";
  span.appendChild(nodeDL);

  link.parentNode.parentNode.appendChild(span);
  span.flag = true;
  return false;
}

function addGlossaryToolTip(link) {
  var hrefparts;
  var linkTargetId;
  var bGotTargetId;
  var nodeDL;
  var nodeDDs;
  var strDLHtml;
  var nodeDD;

  hrefparts = link.href.split('#');
  bGotTargetId = ( hrefparts.length > 1 );
  if ( !bGotTargetId ) {
    return false;
  }

  linkTargetId = hrefparts[1];
  nodeDL = document.getElementById(linkTargetId);
  if ( nodeDL && nodeDL.nodeName.toLowerCase() == 'dl' ) {
    nodeDDs = nodeDL.getElementsByTagName('dd');

    if ( nodeDDs && nodeDDs.length > 0 ) {
      strDLHtml = "<dl>";

      for (var i=0; i < nodeDDs.length; i++) {
        nodeDD = nodeDDs.item(i);
        if ( nodeDD ) {
          strDLHtml = strDLHtml + "<dd>" + nodeDD.innerHTML + "</dd>";
        }
      }

      strDLHtml = strDLHtml + "</dl>";

      if (link.setAttributeNS) { link.setAttributeNS("ext", "qtip", strDLHtml); }
      else                     { link.setAttribute  ("ext:qtip",    strDLHtml); }
    }
  }

  return false;
}


//// LENS DIALOGS ////

var switchLenses = function(){
    var lens_switch = Ext.get('cnx_switch_inner').dom;
    var selval = lens_switch.value;
    var all = lens_switch.getElementsByTagName('option');  //childNodes;
    var len = all.length;
    for (var x = 0; x <= len; x++) {
        var elt = all[x];
        if (elt) {
            var eltval = elt.value;
            var frm = Ext.get(eltval).dom;
            if (eltval == selval) {
                frm.style.display = 'block';
            } else {
                frm.style.display = 'none';
            }
        }
    }
}

var afterLoad = function(oElement, bSuccess, oResponse){
    // unhide lens select button
    var switcher = Ext.get('cnx_lens_switch')
    if (switcher) {
        switcher.dom.style.display = 'block';

        switchLenses();

        var lens_switch = Ext.get('cnx_switch_inner');
        lens_switch.on('change', switchLenses);
    }

    // if login form, set came_from field intelligently
    var login = Ext.get('portlet-login');
    if (login) {
        // hack to get dialog relaunched; see other globalTarget uses
        var whichdialog = "unknown";
        if (globalTarget) {
            whichdialog = globalTarget.id;
        }

        var came_from = login.child('input[name=came_from]');
        var baseurl = document.URL;
        came_from.dom.value = baseurl + "#login=" + whichdialog;
    }

    // LensAdd.resize();
}

var globalTarget;   // for setting came_from; see in afterLoad above. hack: won't be necessary forever.

// create the lens addition popup application (single instance)
var LensAdd = function(){
    // everything in this space is private and only accessible in the HelloWorld block

    // define some private variables
    var targetelt, title, body, showBtn, dialogUpdater, defaultTitle;
    var contentId, version, urlbase, innerform = "", title;

    var dialogheight = 300;
    var dialogwidth = 500;

    // return a public interface
    return {
        init : function(){
             Ext.select('a.cnx_lens_trigger_link', true).on('click', this.showEvent, this, {stopEvent : true});

             // Strip the HTML for the popup into a title and body
             var dialog = Ext.get("cnx_lens_popup");
             //IE6 won't find the div, so we'll create one.
             if (!dialog) {
               var dialogDom = Ext.DomHelper.insertBefore(Ext.getBody(), 
            	 {tag:'div', cls:'cnx_popup', children:[
                   {tag:'div', cls:'x-dlg-hd', children:['Add to a lens']},
                   {tag:'div', cls:'x-dlg-hd', children:['Add this content to my lens:']}
                 ]});
               dialog = Ext.get(dialogDom);
             }
             title = dialog.first().dom.innerHTML;
             body = dialog.last().removeClass('x-dlg-bd').dom;
             // detach the dialog
             dialog.dom.parentNode.removeChild(dialog.dom);

/*             submitBtn = Ext.get('cnx_lens_simple_submit');
             submitBtn.on('click', this.submitForm, this, {stopEvent : true});*/

            // hack to relaunch dialog after login; see also globalTarget
            var preceededby = "#login=";
            var fragment = document.URL.match(preceededby+".*");
            if (fragment && fragment.length==1) {
                var fragid = fragment[0].slice(preceededby.length, fragment[0].length);
                if (fragid) {
                    bLoggingInBeforeReuseEdit = ( fragid.indexOf('reuse_edit') != -1 )
                    if (bLoggingInBeforeReuseEdit) return;
                    var trigger = Ext.get(fragid);
                    if (trigger) {
                        this.showDialog(trigger);
                    }
                } else {
                    alert("You are now logged in. Please click 'A lens' or 'My Favorites' again to continue.");
                }
            }
        },

        showEvent : function(event){
            var eventTarget = event.getTarget();
            this.showDialog(eventTarget);
        },

        showDialog : function(eventTarget){
            var elt;
            var difftarget = targetelt != eventTarget;
            targetelt = eventTarget;
            globalTarget = targetelt;
            showBtn = Ext.get(eventTarget);

            if (!contentId || difftarget) {
                contentId = showBtn.child('input.cnx_lens_contentId').dom.value;
            }
            if (!version || difftarget) {
                version = showBtn.child('input.cnx_lens_version').dom.value;
            }
            if (!urlbase || difftarget) {
                elt = showBtn.child('input.cnx_lens_urlbase');
                if (elt) {
                    urlbase = elt.dom.value + '/';
                } else {
                    urlbase = "";
                }
            }
            if (!innerform || difftarget) {
                elt = showBtn.child('input.cnx_lens_innerform');
                if (elt) {
                    innerform = elt.dom.value;
                } else {
                    innerform = "lens_add_inner";
                }
            }

                // Windows always need to be recreated
                var dialog = new Ext.Window({
                        title:title,
                        contentEl:body,
                        autoTabs:false,
                        closable:true,
                        collapsible:false,
                        y: 175,
                        width:dialogwidth,
                        shadow:false,
                        minWidth:300,
                        minHeight:250,
                        proxyDrag: true
                });
                //dialog.addButton('Add this Content', dialog.hide, dialog).disable();
                //dialog.addButton('Close', dialog.hide, dialog);
                //popupBody.dom.parentNode.removeChild(popupBody.dom);
                defaultTitle = title;

            if (!dialogUpdater || difftarget) {
                dialogUpdater = Ext.get(body).getUpdateManager();
                dialogUpdater.update({url:urlbase+innerform,
                                      callback:afterLoad,
                                      params: {contentId: contentId, version: version}
                                     });
            }

            elt = showBtn.child('input.cnx_lens_title');
            if (elt) {
                title = elt.dom.value;
                dialog.setTitle(title);
            }
            else {
                // use the default dlg title
                title = defaultTitle;
                dialog.setTitle(title);
            }

            dialog.show(showBtn.dom);
        },

//         submitForm : function(){
//             dialogUpdater = Ext.get('cnx_lens_results').getUpdateManager();
//             dialogUpdater.formUpdate('cnx_lensform');
//         },

        // not used yet...
        makeForm : function(){
            if(!lensform){ // lazy initialize the form and only create it once
                lensform = new Ext.form.Form({
                                  labelWidth: 75,
                                  url:'addLens'
                           });
                lensform.applyToFields('cnx_lensform');
            }
        }
    };
}();

// using onDocumentReady instead of window.onload initializes the application
// when the DOM is ready, without waiting for images and other resources to load
Ext.onReady(LensAdd.init, LensAdd, true);



//// HOVER INFO BOXES ////

Ext.onReady(function() {
    var morden = new Ext.Shadow({mode:'sides', offset:4});
    morden.hide();

    var animShow = false; //{duration: 0.35};
    var animHide = false; //true;

    //var layer;

    var active = false;

    //* on mouseover, set active to true. if it stays this way after some delay, we'll show box
    var hoverOnNotice = function(e) {
        active = true;
    }

    //* on mouseout, set active to false. if false after some delay, don't show box
    var hoverOffNotice = function(e) {
        active = false;
        hoverOff(e);
    }

    //* triggered some time after mouseover, checks 'active' to determine if we've left the link since
    //* hover box is not shown if a hoverOffNotice has happened
    var hoverOnTest = function(e) {
        if (active) {
            hoverOn(e);
        }
    }

    //* display hover box, with drop shadow
    var hoverOn = function(e) {
        //a = Ext.get(e.target);
        var li = Ext.get(e.target).up('.lensinfowrap');
        var block = li.child('.lensinfo');
        if (block) {
            block.removeClass('hiddenStructure');   // accessibility-related
            //block.alignTo(li, 'bl-tr?');  // original
            block.alignTo(li, 'tl-br?');   // to keep low for content actions bar
            //block.alignTo(li, 'bl-tr?', [5, 25]); //better
            //block.alignTo(li, 'br-tr?');  // for #6037
            //block.alignTo(li, 'r-l?');  // experimental
            block.show(animShow);
            morden.show(block);
            //layer = new Ext.Layer({cls:"x-tip", shadow:"drop", shim: true, constrain:true, shadowOffset:3}, block.dom);
            //layer.alignTo(li, 'bl-tr?');
            //layer.show(animShow);
        }
    }

    //* hide hover box and drop shadow
    var hoverOff = function(e) {
        var li = Ext.get(e.target).up('.lensinfowrap');
        var block = li.child('.lensinfo');
        if(block) {
          block.hide(animHide);
        }
        morden.hide();
        //layer.hide(animHide);
    }

    // ...CSS moves lensinfos to (0,0) like we might do with a 'position()' here
    //Ext.select('.lensinfo').hide(false); // otherwise, it'll be in the wrong position the first time

    Ext.select('.lenslink').on('mouseover', hoverOn, this, {stopEvent : true});
    Ext.select('.lenslink').on('mouseout', hoverOff, this, {stopEvent : true});

    if (true) {
    //if (Ext.isIE && !Ext.isIE7) {
        // unibroswer does the equivalent of the following:
        // Ext.select('.hovlink').on('mouseover', createDefinition);
        // Ext.select('.hovlink').on('mouseout',  removeDefinition);
        Ext.select('.hovlink').on('mouseover', hoverOn,  this, {stopEvent : true});
        Ext.select('.hovlink').on('mouseout',  hoverOff, this, {stopEvent : true});
        // for mouse dwell... except that 'delay' doesn't work in IE6 yet.
        //Ext.select('.hovlink').on('mouseover', hoverOnTest, this, {stopEvent : true, delay : 200});
        //Ext.select('.hovlink').on('mouseover', hoverOnNotice, this, {stopEvent : true});
        //Ext.select('.hovlink').on('mouseout', hoverOffNotice, this, {stopEvent : true});
    }
    else {
        // waiting for ExtJs 2.x before making this live
        var cnxlinks;

        cnxlinks = Ext.select('.hovlink');
        if ( cnxlinks && cnxlinks.elements.length > 0 ) {
            var i, cnxlink;
            for (i=0; i<cnxlinks.elements.length; i++) {
                cnxlink = cnxlinks.elements[i];
                if (cnxlink.setAttributeNS) { cnxlink.setAttributeNS("ext", "qtip", "Undefined."); }
                else                        { cnxlink.setAttribute  ("ext:qtip",    "Undefined."); }
                addGlossaryToolTip(cnxlink);
                if (cnxlink.setAttributeNS) { cnxlink.setAttributeNS("ext", "qclass", "lensinfo"); }
                else                        { cnxlink.setAttribute  ("ext:qclass",    "lensinfo"); }
            }
            Ext.QuickTips.init();
            // delay before tool tip is displayed
            Ext.QuickTips.showDelay = 500; /* for ExtJS 2.2: Ext.QuickTips.getQuickTip().showDelay = 2000; */
            // delay after mouseout event fires before the tool tip is hidden
            Ext.QuickTips.hideDelay = 0;
            // controls whether the tool tip goes away after "awhile"
            Ext.QuickTips.autoDismiss = false;
            // controls the maximun width of the tool tip
            Ext.QuickTips.maxWidth = 375;
        }
    }
});



//// CONTENT ACTIONS BAR ////

//* if JS, show various elements (which will already be shown if we have JS cookie set)
Ext.onReady(function() {
    var printelt = Ext.get('cnx_actions_print');
    if (printelt && printelt.dom.style.display=='none') {
      printelt.dom.style.display = 'block';
    }

    var bar = Ext.get('cnx_actions_top');
    if (bar && bar.dom.style.display=='none') {
      bar.dom.style.display = 'block';
    }

    var re_bottom = Ext.get('cnx_actions_category_reuse_edit');
    if (re_bottom && re_bottom.dom.style.display=='none') {
      re_bottom.dom.style.display = 'block';
    }

    var twitbook_top = Ext.get('cnx_social_media_top');
    if (twitbook_top && twitbook_top.dom.style.display=='none') {
      twitbook_top.dom.style.display = 'block';
    }
    var twitbook_bottom = Ext.get('cnx_social_media_bottom');
    if (twitbook_bottom && twitbook_bottom.dom.style.display=='none') {
      twitbook_bottom.dom.style.display = 'block';
    }

});

//* toggle "on" class on click
var toggleMenu = function(e) {
    var elt = Ext.get(e.target);
    if (!elt.is('div.ca_menu')) {
        elt = elt.up('div.ca_menu');
    }

    if (elt) {
      elt.toggleClass('ca_menu_on');
    }
}

//* toggle between "full" and "empty" star on hover over favorites link
var starToggle = function(e) {
    var elt = Ext.get(e.target);
    if (elt.up('.ca_favorites')) {
        elt = elt.up('.ca_favorites');
        elt.removeClass('ca_favorites');
        elt.addClass('ca_in_favorites');
    } else {
        elt = elt.up('.ca_in_favorites');
        elt.removeClass('ca_in_favorites');
        elt.addClass('ca_favorites');
    }
}

Ext.onReady(function() {
    // set positions absolutely so that the z-axis CSS commands can work and the A lays over the DIV
    //Ext.select('.ca_menu div.ca_drop_contents').move('t', 0, false);
    //Ext.select('.ca_menu a.ca_button_link').move('t', 0, false);

    Ext.select('.ca_menu').addClassOnOver('ca_menu_on');
    Ext.select('.ca_button_link:not(.ca_single)').on('click', toggleMenu, this, {stopEvent : true});
    Ext.select('.ca_drop_close').on('click', toggleMenu, this, {stopEvent : true});

    Ext.select('.ca_favorites a').on('mouseover', starToggle, this, {stopEvent : true});
    Ext.select('.ca_favorites a').on('mouseout', starToggle, this, {stopEvent : true});
    Ext.select('.ca_in_favorites a').on('mouseover', starToggle, this, {stopEvent : true});
    Ext.select('.ca_in_favorites a').on('mouseout', starToggle, this, {stopEvent : true});
});


//// DYNAMIC PAGE ELEMENT LOADING ////

var relatedUpdater;
var recentReplace = function(e) {
    var urlContent;
    var charLast;
    if(!relatedUpdater){
        urlContent = window.location.href;
        charLast = urlContent[urlContent.length-1];
        if ( charLast != '/' ) {
            urlContent += '/';
        }
        // Get the recently viewed HTML. Used only when viewing a module or a collection
        // Uses magic global variable portal_url defined in main_template
        relatedUpdater = Ext.get('cnx_recentview_contents').getUpdateManager();
        relatedUpdater.update({url:portal_url+"/portlet_recentview_inner",
                               params:{urlContent: urlContent}});
    }
}

Ext.onReady(function(e) {
    // handle shown/not shown based on cookie-set values
    var uparrow = Ext.get("cnx_recentview_collapse").dom.style.display;  // elt is named for action, not state

    if (uparrow == "none") {   // this is true for known-hidden and initial (both none) states
        // no show: register and blank warning message
        Ext.get('cnx_recentview_contents').dom.style.display = 'none';
        Ext.get("cnx_recentview_header").on('click', this.recentReplace, this, {preventDefault: true});
    } else {
        // show: loading recent view
        recentReplace(null);
    }
});

var reuse_edit_dialog;  // global which enables closing of window

var afterLoadReuseEdit = function(oElement, bSuccess, oResponse){
    //xxxxx
    var animShow = false; //{duration: 0.35};
    var animHide = false; //true;

    var morden = new Ext.Shadow({mode:'sides', offset:4});
    morden.hide();

    var hoverOn = function(e) {
        var li = Ext.get(e.target).up('.lensinfowrap');
        var block = li.child('.lensinfo');
        if (block) {
            block.removeClass('hiddenStructure');
            block.alignTo(li, 'tl-bl');
            block.show(animShow);
            morden.show(block);
        }
    };

    var hoverOff = function(e) {
        var li = Ext.get(e.target).up('.lensinfowrap');
        var block = li.child('.lensinfo');
        if(block) {
          block.addClass('hiddenStructure');
          block.hide(animHide);
        }
        morden.hide();
    };

    Ext.select('#cnx_derive_copy_help').on('mouseover', hoverOn, reuse_edit_dialog, {stopEvent : true});
    Ext.select('#cnx_derive_copy_help').on('mouseout', hoverOff, reuse_edit_dialog, {stopEvent : true});

    // if login form, set came_from field intelligently
    var login = Ext.get('portlet-login');
    if (login) {
        // hack to get dialog relaunched; see other globalTarget uses
        var whichdialog = "unknown";
        if (globalTarget) {
            whichdialog = globalTarget.id;
        }

        var came_from = login.child('input[name=came_from]');
        var baseurl = document.URL;
        came_from.dom.value = baseurl + "#login=" + whichdialog;
    }

    // Bind events
    var binder = function()
    {
        jQuery("#reuse_edit_form :submit").click(
            function(event){
                if (this.name == 'cancel')
                {
                    event.preventDefault();
                    reuse_edit_dialog.close();
                }
                else
                    jQuery("#reuse_edit_button").attr('value', this.name);
            }
        );

        jQuery("#reuse_edit_form").submit(
        function(event) 
        {
            event.preventDefault();
            var form = jQuery("#reuse_edit_form");
            var serialized = form.formSerialize();

            // Indicate that a request is in progress
            var el = jQuery("#cnx_reuse_edit_inner");
            el.html('<span class="cnx_ajax_working"><img src="ajax_loading.gif" /> Working</span>');

            jQuery.post(
                form.attr('action'), 
                serialized,
                function(data)
                {
                    if (data.indexOf('close:') == 0)                    
                    {
                        var msg = data.substr(7);
                        jQuery("#content_template_messages").html('<div class="cnx_success_message">'+msg+'</div>');
                        reuse_edit_dialog.close();
                    }
                    else if (data.indexOf('Redirect:') == 0)                    
                    {
                        var url = data.substr(10);
                        jQuery("#cnx_reuse_edit_inner").html('Redirecting to '+ url);
                        document.location.href = url;
                    }
                    else
                    {
                        jQuery("#cnx_reuse_edit_inner").html(data);
                        binder();
                    };
                }
            );
        }
        );
    }        
    binder();
}

// Create the reuse / edit popup application (single instance)
var ReuseEdit = function(){
    var targetelt, title, body, showBtn, dialogUpdater, defaultTitle;
    var contentId, version, urlbase, innerform = "", title;

    var dialogheight = 450;
    var dialogwidth = 500;

    // return a public interface
    return {
        init : function(){
             Ext.select('a.cnx_reuse_edit_trigger_link', true).on('click', this.showEvent, this, {stopEvent : true});

             // Strip the HTML for the popup into a title and body
             var dialog = Ext.get("cnx_reuse_edit_popup");
             title = dialog.first().dom.innerHTML;
             body = dialog.last().removeClass('x-dlg-bd').dom;
             // detach the dialog
             dialog.dom.parentNode.removeChild(dialog.dom);

            // hack to relaunch dialog after login; see also globalTarget
            var preceededby = "#login=";
            var fragment = document.URL.match(preceededby+".*");
            if (fragment && fragment.length==1) {
                var fragid = fragment[0].slice(preceededby.length, fragment[0].length);
                if (fragid) {
                    if (fragid.indexOf('_reuse_') == -1) return;
                    var trigger = Ext.get(fragid);
                    if (trigger) {
                        this.showDialog(trigger);
                    }
                } else {
                    alert("You are now logged in. Please click 'A lens' or 'My Favorites' again to continue.");
                }
            }
        },

        showEvent : function(event){
            var eventTarget = event.getTarget();
            this.showDialog(eventTarget);
        },

        showDialog : function(eventTarget){
            var elt;
            //var difftarget = targetelt != eventTarget;
            var difftarget = true;
            targetelt = eventTarget;
            globalTarget = targetelt;
            showBtn = Ext.get(eventTarget);

            if (!contentId || difftarget) {
                contentId = showBtn.child('input.cnx_reuse_edit_contentId').dom.value;
            }
            if (!version || difftarget) {
                version = showBtn.child('input.cnx_reuse_edit_version').dom.value;
            }
            if (!urlbase || difftarget) {
                elt = showBtn.child('input.cnx_reuse_edit_urlbase');
                if (elt) {
                    urlbase = elt.dom.value + '/';
                } else {
                    urlbase = "";
                }
            }

//            alert(innerform);
//            alert(difftarget);
            if (!innerform || difftarget) {
                elt = showBtn.child('input.cnx_reuse_edit_innerform');
                if (elt) {
                    innerform = elt.dom.value;
                } else {
                    innerform = "reuse_edit_inner";
                }
            }

                // Windows always need to be recreated
                var dialog = new Ext.Window({
                        Shadow: false,
                        shadow: false,
                        title:title,
                        contentEl:body,
                        autoTabs:false,
                        closable:true,
                        collapsible:false,
                        width:dialogwidth,
                        y: 100,
                        minWidth:300,
                        minHeight:250,
                        proxyDrag: true
                });

                //dialog.addButton('Add this Content', dialog.hide, dialog).disable();
                //dialog.addButton('Close', dialog.hide, dialog);
                //popupBody.dom.parentNode.removeChild(popupBody.dom);
                defaultTitle = title;

            if (!dialogUpdater || difftarget) {
                dialogUpdater = Ext.get(body).getUpdateManager();
                dialogUpdater.update({url:urlbase+innerform,                                    
                                      callback:afterLoadReuseEdit,
                                      params: {contentId: contentId, version: version}
                                     });
            }

            elt = showBtn.child('input.cnx_reuse_edit_title');
            if (elt) {
                title = elt.dom.value;
                dialog.setTitle(title);
            }
            else {
                // use the default dlg title
                title = defaultTitle;
                dialog.setTitle(title);
            }

            // assign to global
            reuse_edit_dialog = dialog;                 
            
            dialog.show(showBtn.dom);
        },

        // not used yet...
        makeForm : function(){
            if(!aform){ // lazy initialize the form and only create it once
                aform = new Ext.form.Form({
                                  labelWidth: 75,
                                  url:'reuseEdit'
                           });
                aform.applyToFields('cnx_reuse_edit_form');
            }
        }
    };
}();

// using onDocumentReady instead of window.onload initializes the application
// when the DOM is ready, without waiting for images and other resources to load
Ext.onReady(ReuseEdit.init, ReuseEdit, true);



// variable and function below for preventing users in IE from choosing a disabled option 
// in the work area dropdown (e.g. the line reading "Shared Workgroups:").

var lastEnabledIndex = 0;

function disableInIE(select) {
    if(select.options[select.options.selectedIndex].disabled) {
        select.selectedIndex = lastEnabledIndex;
    } else {
        lastEnabledIndex = select.selectedIndex;
    }
}
