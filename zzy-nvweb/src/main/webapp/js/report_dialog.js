function generate_report_dialog(e){"undefined"==typeof dui?$.getScript("/js/ui/dialog.js",function(){_generate_report_dialog(e)}):_generate_report_dialog(e)}function _generate_report_dialog(e){function t(e){return e.test(location.pathname)}function o(e){return e.test(location.pathname)}function i(e){return location.pathname.indexOf(e)>=0}var n="8",r=e.type||"";r||(r="content",o(/^\/(subject|game|app)\/\w+/)||t(/movie|music|book/)?(r="subject",i("discussion")&&(r=["comment","subject"])):o(/^\/people\/\w+/)&&(r="account")),r=r instanceof Array?r.join(","):r;var a='<span class="up">举报已提交</span>',d="http://help.douban.com/help/ask",l="/j/misc/report_form?type="+r,c="/misc/audit_report",u='<span>为了便于工作人员进行受理，请您通过<a target="_blank" href="'+d+'">豆瓣帮助中心</a>详细描述内容</span>',p="<h3>提交详细信息</h3>",s=e.report_url?e.report_url:location.href,f=e.reason?e.reason:0,h="#report_value input[type=radio]:checked",_=dui.Dialog({title:e.title?e.title:"选择举报原因",url:e.url?e.url:l,width:e.width?e.width:380,cls:e.cls?e.cls:"report-dialog"});_.report_url=s,_.is_report_dlg_singleton||(_.body.delegate(".btn-report","click",function(){if(f=$(h).val(),"other"==f)_.node.find(".hd").html(p),_.node.find(".bd").html(u),_.update(),_.body.delegate(".bd a","click",function(){_.close()});else{var e="",t=$(".victim-form .victim-msg").hide();if(f===n){if(e=$("#report_value .victim-input").val()||"",!e)return t.text("被冒充帐号 id 不能为空").show();if(e.length>100)return t.text("被冒充帐号 id 最多不能超过 100 个字符").show()}$.post_withck(c,{url:_.report_url,reason:f,extra_msg:e},function(){_.node.find(".hd").hide(),_.node.find(".bd").html(a),_.update(),setTimeout(function(){_.close()},1e3)})}}),_.is_report_dlg_singleton=!0),_.open(),_.body.delegate("input[type=radio]","click",function(){var e=$(h).val();e===n?_.node.find(".victim-form").show():_.node.find(".victim-form").hide()}),_.node.find(".hd").show(),_.update()}