function exp_dialog(e){var t=document.documentElement;return 0-parseInt(e.offsetHeight/2)+(TBWindowMargin=t&&t.scrollTop||document.body.scrollTop)+"px"}function exp_overlay(e){return 0-parseInt(e.offsetHeight/2)+(TBWindowMargin=document.documentElement&&document.documentElement.scrollTop||document.body.scrollTop)+"px"}!function(e,t,n){if("undefined"==typeof DoubanShare){var o={},r=[],a="//img3.doubanio.com/pics/loading.gif",d=".lnk-douban-sharing",l='<div style="padding:30px 0;text-align:center;font-size:14px;color:#060;">分享成功!</div>',c='<div class="rectitle"><span class="gact rr"><a href="#" class="lnk-close">x</a></span><span class="m" >{TITLE}</span></div><div class="bd" style="position:relative;line-height:0;font-size:0;"></div>',u=function(e,t,i){var n;return/device-mobile/i.test(document.documentElement.className)&&(i=.9*document.documentElement.clientWidth),"undefined"!=typeof dui&&dui.Dialog?(n=dui.Dialog({width:i||500,content:e,title:t,isHideClose:0},!0).open(),n.node.addClass("dui-dialog-rec").find(".bd").css({position:"relative",padding:"10px 0 0 0","line-height":0,"font-size":0})):(n=$("#dialog"),0===n.length&&($('<div id="overlay"></div><div id="dialog" class="dialog-shuo"  style="width:'+(i||500)+'px;"></div>').appendTo("body"),n=$("#dialog")),n.html(e),s(),n.find(".lnk-close").click(function(e){e.preventDefault(),f()})),n},s=function(){if("undefined"!=typeof dui&&dui.Dialog&&o.currentDialog)return void o.currentDialog.update();var e=$.browser.msie?-2:16,i=$("#dialog")[0],n=i.offsetWidth,r=(t.body.offsetWidth-n)/2;$("#overlay").css({height:i.offsetHeight+e,width:n+16,left:r+5+"px"}),i.style.left=r+"px"},f=function(){return"undefined"!=typeof dui&&dui.Dialog&&o.currentDialog?(o.currentDialog.close(),void m.fire()):($("#overlay, #dialog").remove(),void m.fire())},g=function(){return r.push(1),"db-sharing-iframe"+r.length},p=function(){var e=t.createElement("iframe");return e.setAttribute("scrolling","no"),e.setAttribute("frameBorder","0"),e.setAttribute("width","100%"),e.setAttribute("allowTransparency","true"),e.src="",e},h=function(e){var t=p(),i=g()+ +new Date+(0|1e6*Math.random()),r=(e.css||"",e.text||"",e.heading||"推荐到豆瓣"),d=e.image?280:230,l=u(c.replace("{TITLE}",r),r,e.width);o.currentDialog=l,$(t).load(function(){try{t.setAttribute("height",t.contentWindow.document.body.clientHeight),s()}catch(e){}}),t.setAttribute("id",i),t.setAttribute("height",e.height||d),t.src=n+$.param(e)+"&alt=xd&callback=DoubanShare.callback&_stamp="+i,l.node?l.node.find(".bd").css("background","url("+a+") 48% 48% no-repeat").eq(0).html("").append(t):l.find(".bd").css("background","url("+a+") 48% 48% no-repeat").html("").append(t),s()},m=function(e){m.callback.push(e)},b=function(e){h(e)},v=function(){$("html").delegate(d,"click",function(e){var t=$(e.currentTarget),n=t.data(),o=["user_id","object_kind","object_id"];e.preventDefault();for(i in n)"number"==typeof n[i]&&(n[i]=t.attr("data-"+i));reportDa={from:"snsrec2share"};for(i in o){var r=o[i];reportDa[r]=n[r]||0}moreurl&&moreurl(e.currentTarget,reportDa),h(n)})};m.callback=[],m.fire=function(){for(;m.callback.length;)m.callback.pop()()},v(),o.cacheUrl={},o.updateDialog=function(e){var t=o.currentDialog;return t.node?(t.node.find("iframe").css("height",e+"px"),void t.update()):(e&&$("#dialog iframe").css("height",e+"px"),void s())},o.closeDialog=function(){var e=o.currentDialog;e.node?(e.node.find(".hd").hide(),e.node.find(".bd").css("background","none").html(l)):(e.find(".rectitle").hide(),e.find(".bd").css("background","none").html(l)),s(),setTimeout(function(){f()},1e3)},o.share=b,o.onDialogClose=m,e.DoubanShare=o,(new Image).src=a}}(window,document,rec_url);