var VOTE_URL="/j/comment/",SUCCESS_MSG="<span>已投票</span>",vote_comment=function(t){var e=$(t.target),a=e.data("cid"),n=VOTE_URL+a+"/vote";$.post_withck(n,function(t){var t=$.parseJSON(t);return 1===t.r?(alert("重复投票啦！"),!1):($("#c-"+a).text(t.count),e.parent().append(SUCCESS_MSG),void $("#btn-"+a).remove())})},delete_comment=function(t){var e=$(t.target),a=e.data("cid"),n=e.data("url")+a+"/delete";$.post_withck(n,function(t){var t=$.parseJSON(t);return 1===t.r?(alert("hmmm, 戳错了..."),!1):void e.parents(".comment-item").fadeOut("slow")})};