//Code that inserts a branding bar if the user viewed a lens and then navigated to a page in the lens.

//Note: This _is_ done on body.onload (causes screen flicker, but doesn't break IE 7 and 8).
jQuery(document).ready(function() {
    //Light-weight branding (LWB)
    if (jQuery('.cnx_branding_banner a:visible').length == 0){
        var rawCookie = readCookie('lenses')
        if (rawCookie){
            var cookieLenses = rawCookie.replace(/"/g,'').split('|');
            var numcookies = cookieLenses.length
            var cookiePaths = [];
            a = document.createElement('a');
            for ( i=0 ; i < numcookies; i++ ) {
              a.href = cookieLenses[i];
              cookiePaths.push(a.pathname)
            }
            
            var brand = null;
            var brandindex = -1;
            jQuery('.cnx_branding_banner a').each(function(i,banner){
              var path = banner.pathname;
              if (cookiePaths.indexOf(path) > brandindex ) {
                brand = banner;
                brandindex = cookiePaths.indexOf(path);
              }
            });
            if (brand){
                jQuery(brand).parent().show();
                var href = brand.getAttribute('href');
                jQuery(".cnx_branding_logo a[href='"+href+"']").parent().show();
            };
        }
    }
        
}) ;

