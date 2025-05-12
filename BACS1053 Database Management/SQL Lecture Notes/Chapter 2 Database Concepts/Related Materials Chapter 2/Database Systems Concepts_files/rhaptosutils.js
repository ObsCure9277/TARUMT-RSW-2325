//// rhaptosutils.js - common Javascript utility functions

// the cookie scripts were copied from here: http://www.xs4all.nl/~ppk/js/cookies.html
// which asks if i want to be redirected here: http://www.quirksmode.org/
// which has an apparently cnx-friendly copyright notice here: http://www.quirksmode.org/about/copyright.html
// createCookie() and readCookie() are also here (though slightly modified from quirksmode):
//   CMFPlone/skins/plone_ecmascript/cookie_functions.js
// modified createCookie() to take a path argument

function createCookie(name,value,days,path) {
  var expires;
  var path;
  var newCookie;
  if (days) {
    var date = new Date();
    date.setTime(date.getTime()+(days*24*60*60*1000));
    expires = "; expires="+date.toGMTString();
  } 
  else {
    expires = "";
  }
  if (path) {
    path = "/" + path;
  } else {
    path = "/";
  }
  newCookie = name + "=" + value + expires + "; path=" + path;
  document.cookie = newCookie;
}

function readCookie(name) {
  var nameEQ = name + "=";
  var ca = document.cookie.split(';');
  for(var i=0;i < ca.length;i++) {
    var c = ca[i];
    while (c.charAt(0)==' ') c = c.substring(1,c.length);
    if (c.indexOf(nameEQ) == 0) {
      return c.substring(nameEQ.length,c.length);
    }
  }
  return null;
}


// get all elements with certain class; should be in the DOM, but isn't

function getElementsByClassName(classname){
  var isOpera = navigator.userAgent.indexOf("Opera") != -1 ? true : false;
  var rl = new Array();
  var re = new RegExp('(^| )'+classname+'( |$)');
  var ael = document.all && !isOpera ? document.all : document.getElementsByTagName('*');
  for (i=0, j=0 ; i<ael.length ; i++) {
    if(re.test(ael[i].className)) {
       rl[j] = ael[i];
       j++;
    }
  }
  return rl;
}


// functions to store and read the state of various collapsible elements; all
// stored in a single cookie
twistycookie = "collapsibleElements";

// returns mapping object of keys/element names and their values.
// read keys of interest, and ignore the rest. like:
//  dict = twistyRead()
//  state = dict.cnx_toc
// values are as set in 'twistyWrite'. if no such attribute, it was never set.
// do not pass in characters '|', ';', '='
function twistyRead() {
  var retval = new Object();
  var cookievalue = readCookie(twistycookie);
  if (cookievalue != null) {
    var entries = cookievalue.split('|');
    for(var i=0;i < entries.length;i++) {
      var entry = entries[i];
      var broken = entry.split('=');
      key = broken[0];
      val = broken[1];
      retval[key] = val;
    }
  }
  return retval
}

// pass key/value pair for element name and state to store in the cookie.
// caller is responsible for not duplicating keys.
// no return value
function twistyWrite(key, val) {
  var cookiestr = "";
  var cookieinfo = twistyRead();
  cookieinfo[key] = val;
  
  for (i in cookieinfo) {
    cookiestr = cookiestr + i + "=" + cookieinfo[i] + "|";
  }
  cookiestr = cookiestr.substring(0, cookiestr.length-1);  // chop off last pipe

  createCookie(twistycookie, cookiestr, 365)
}

// helper for twist_toggle: does a child of passed elt have specific class?
// if so, return it, otherwise, false
function child_has_class(parelt, classstr) {
  var retval = null;
  var children = parelt.childNodes;
  var child;
  for(var c=0; c < children.length; c++) {
    child = children[c];
    if (child.className == classstr) {
      retval = child;
      break;
    }
  }
  return retval;
}

// change state of twisty element, and persist changes
// called by onclick handler; give it the id of the element
// it will switch out visibility of elements '%{id}_expand' and '%{id}_collapse'
// and also toggle display state of '%{id}_contents' between "none" and 'contentdisplay',
// with default value for 'contentdisplay' as 'block'. ('inline' is the only other real choice.)
// if you provide a conterpart to '_contents' called '_hidden_contents', that will be toggled in
// reverse; allows you to provide some "closed" content for the closed state
function twist_toggle(id, contentdisplay) {
  if (contentdisplay == undefined ) {
    contentdisplay = 'block';
  }

  // required elements
  var contents = document.getElementById(id + '_contents').style;
  var expand = document.getElementById(id + '_expand').style;
  var collap = document.getElementById(id + '_collapse').style;

  // optional elements
  var hiddenelt = document.getElementById(id + '_hidden_contents');
  var hidden = new Object();  // even if not a real elt.style, we can use .display (etc), just without effect
  if (hiddenelt) {
    hidden = hiddenelt.style;
  }

  // swap expand/collapse display
  var expanddisplay = expand.display;
  expand.display = collap.display;
  collap.display = expanddisplay;


  // toggle contents display
  if (contents.display == 'none') {
    contents.display = contentdisplay;
    hidden.display = 'none';
  } else {
    contents.display = 'none';
    hidden.display = contentdisplay;
  }

  // persist change
  twistyWrite(id, contents.display);
}
