!function(){var t,e,n=document,r=window,i={},o={},s=function(t){return t.constructor===Array},a={autoLoad:!0,coreLib:["//img3.doubanio.com/js/jquery.min.js"],mods:{}},c=n.getElementsByTagName("script"),u=c[c.length-1],d=[],l=!1,f=[],h=function(t,e,r,s,a){var u=c[0];if(t){if(i[t])return o[t]=!1,void(s&&s(t,a));if(o[t])return void setTimeout(function(){h(t,e,r,s,a)},1);o[t]=!0;var d,l=e||t.toLowerCase().split(/\./).pop().replace(/[\?#].*/,"");if("js"===l?(d=n.createElement("script"),d.setAttribute("type","text/javascript"),d.setAttribute("src",t),d.setAttribute("async",!0)):"css"===l&&(d=n.createElement("link"),d.setAttribute("type","text/css"),d.setAttribute("rel","stylesheet"),d.setAttribute("href",t),i[t]=!0),d){if(r&&(d.charset=r),"css"===l)return u.parentNode.insertBefore(d,u),void(s&&s(t,a));d.onload=d.onreadystatechange=function(){this.readyState&&"loaded"!==this.readyState&&"complete"!==this.readyState||(i[this.getAttribute("src")]=!0,s&&s(this.getAttribute("src"),a),d.onload=d.onreadystatechange=null)},u.parentNode.insertBefore(d,u)}}},p=function(t){if(t&&s(t)){for(var e,n=0,r=[],i=a.mods,o=[],c={},u=function(t){var e,n,r=0;if(c[t])return o;if(c[t]=!0,i[t].requires){for(n=i[t].requires;"undefined"!=typeof(e=n[r++]);)i[e]?(u(e),o.push(e)):o.push(e);return o}return o};"undefined"!=typeof(e=t[n++]);)i[e]&&i[e].requires&&i[e].requires[0]&&(o=[],c={},r=r.concat(u(e))),r.push(e);return r}},y=function(){l=!0,d.length>0&&(e.apply(this,d),d=[])},m=function(){n.addEventListener?n.removeEventListener("DOMContentLoaded",m,!1):n.attachEvent&&n.detachEvent("onreadystatechange",m),y()},v=function(){if(!l){try{n.documentElement.doScroll("left")}catch(t){return r.setTimeout(v,1)}y()}},g=function(){if("complete"===n.readyState)return r.setTimeout(y,1);var t=!1;if(n.addEventListener)n.addEventListener("DOMContentLoaded",m,!1),r.addEventListener("load",y,!1);else if(n.attachEvent){n.attachEvent("onreadystatechange",m),r.attachEvent("onload",y);try{t=null===r.frameElement}catch(t){}document.documentElement.doScroll&&t&&v()}},E=function(t){t&&s(t)&&(this.queue=t,this.current=null)};E.prototype={_interval:10,start:function(){return this.current=this.next(),this.current?void this.run():void(this.end=!0)},run:function(){var t,e=this,n=this.current;return"function"==typeof n?(n(),void this.start()):void("string"==typeof n&&(a.mods[n]?(t=a.mods[n],h(t.path,t.type,t.charset,function(t){e.start()},e)):/\.js|\.css/i.test(n)?h(n,"","",function(t,e){e.start()},e):this.start()))},next:function(){return this.queue.shift()}},t=u.getAttribute("data-cfg-autoload"),"string"==typeof t&&(a.autoLoad="true"===t.toLowerCase()),t=u.getAttribute("data-cfg-corelib"),"string"==typeof t&&(a.coreLib=t.split(",")),e=function(){var t,e=[].slice.call(arguments);f.length>0&&(e=f.concat(e)),a.autoLoad&&(e=a.coreLib.concat(e)),t=new E(p(e)),t.start()},e.add=function(t,e){t&&e&&e.path&&(a.mods[t]=e)},e.delay=function(){var t=[].slice.call(arguments),n=t.shift();r.setTimeout(function(){e.apply(this,t)},n)},e.global=function(){var t=[].slice.call(arguments);f=f.concat(t)},e.ready=function(){var t=[].slice.call(arguments);return l?e.apply(this,t):void(d=d.concat(t))},e.css=function(t){var e=n.getElementById("do-inline-css");e||(e=n.createElement("style"),e.type="text/css",e.id="do-inline-css",n.getElementsByTagName("head")[0].appendChild(e)),e.styleSheet?e.styleSheet.cssText=e.styleSheet.cssText+t:e.appendChild(n.createTextNode(t))},a.autoLoad&&e(a.coreLib),e.define=e.add,e._config=a,e._mods=a.mods,this.Do=e,g()}();