<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans" class="ua-mac ua-webkit book-new-nav">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="Sun, 6 Mar 2005 01:00:00 GMT">
    <title>${novel.name}</title>
    <link type="text/css" rel="stylesheet" href="/css/dialog.css">
    <link type="text/css" rel="stylesheet" href="/css/setting_standalone.css">
    <link type="text/css" rel="stylesheet" href="/css/report_dialog.css">
    <link href="/css/master.css" rel="stylesheet" type="text/css">
    <link href="/css/init.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/subject.css">
    <link rel="stylesheet" href="/css/comment2.css">
    <link href="/css/like.css" rel="stylesheet">
    <link href="/css/bundle.css" rel="stylesheet" type="text/css">
    <link href="/css/bundle(1).css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/report.css">

    <script type="text/javascript" src="/js/report_dialog.js" ></script>
    <script type="text/javascript" src="/js/setting_standalone.js" ></script>
    <script type="text/javascript" defer="" src="/js/piwik.js"></script>
    <script type="text/javascript" src="/js/ad.release.js" ></script>
    <script type="text/javascript" src="/js/libs.js"></script>
    <script type="text/javascript" src="/js/dialog.js"></script>
    <script type="text/javascript" async="" src="/js/vds.js"></script>
    <script src="/js/jquery.js"></script>
    <script src="/js/master.js"></script>
    <script src="/js/jquery.snippet.js"></script>
    <script src="/js/do.js" data-cfg-autoload="false"></script>
    <script src="/js/dialog.js"></script>
    <script src="/js/hide.js"></script>
    <script src="/js/unfold.js"></script>
    <script src="/js/ga.js" async="true"></script>
    <script src="/js/bundle.js" defer="defer"></script>
    <script src="/js/bundle(2).js" defer="defer"></script>
</head>
<body>

<div id="db-global-nav" class="global-nav">
    <div class="bd">

        <div class="top-nav-info">
            <ul>
                <li class="nav-user-account">
                    <a target="_blank" href="#" class="bn-more">
                        <span>${user.name}的帐号</span><span class="arrow"></span>
                    </a>
                    <div class="more-items">
                        <table cellpadding="0" cellspacing="0">
                            <tbody>
                            <tr>
                                <td>
                                    <a href="/user/info?userUuid=${user.userUuid}">个人主页</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="/user/logout">退出</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </li>
            </ul>
        </div>


        <div class="global-nav-items">
            <ul>
                <li class="">
                    <a href="/home?userUuid=${user.userUuid}"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-main&quot;,&quot;uid&quot;:&quot;178031345&quot;}">首页</a>
                </li>
                <li class="on">
                    <a href="/home?userUuid=${user.userUuid}"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-book&quot;,&quot;uid&quot;:&quot;178031345&quot;}">读书</a>
                </li>
                <li class="">
                    <a href="https://movie.douban.com/" target="_blank"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-movie&quot;,&quot;uid&quot;:&quot;178031345&quot;}">视频</a>
                </li>
            </ul>
        </div>

    </div>
</div>
<div id="db-nav-book" class="nav">
    <div class="nav-wrap">
        <div class="nav-primary">
        </div>
    </div>
    <div class="nav-secondary">
    </div>
</div>
<div id="wrapper">
    <div id="dale_book_subject_top_icon" ad-status="loaded"></div>
    <h1>
        <span property="v:itemreviewed">${novel.name}</span>
        <div class="clear"></div>
    </h1>

    <div id="content">
        <div class="grid-16-8 clearfix">
            <div class="article">
                <div class="indent">
                    <div class="subjectwrap clearfix">
                        <div class="subject clearfix">
                            <div id="mainpic" class="">
                                <a class="nbg" href="${novel.photo}" title="${novel.name}">
                                    <img src="${novel.photo}" title="点击看大图" alt="${novel.name}" rel="v:photo"
                                         style="width: 176px;height: 202px">
                                </a>
                            </div>
                            <div id="info" class="">
                                <span>
                                  <span class="pl"> 作者</span>:
                                        <a class="" href="#">${novel.author}</a>
                                </span>
                                <br>
                            </div>
                        </div>
                        <div id="interest_sectl" class="">
                        </div>
                    </div>
                </div>
                <div class="related_info">
                    <h2>
                        <span class="">内容简介</span>
                        &nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·
                    </h2>
                    <div class="indent" id="link-report">
                          <span class="short">
                            <div class="intro">
                                ${novel.intro}
                            </div>
                           </span>
                        <div class="mod-hd">
                            <h2>
                                <span class="">我来评论</span>
                                &nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·
                                  <span class="pl">&nbsp;
                                     </span>
                            </h2>
                            <form id="addCommentForm" method="post" action="/user/addComment">
                                <input type="hidden" name="userUuid" value="${user.userUuid}"/>
                                <input type="hidden" name="novelUuid" value="${novel.novelUuid}"/>
                                <textarea rows="5" name="comment" style="width: 500px"></textarea>
                                <br/>
                                <input type="submit" name="submit"/>
                            </form>
                            <h2>
                                <span class="">短评</span>
                                &nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·&nbsp;·
                              <span class="pl">&nbsp;
                                 </span>
                            </h2>
                            <div id="comment-list-wrapper" class="indent">
                                <div id="comments" class="comment-list hot show">
                                    <ul>
                                            <c:forEach items="${dtoList}" var="dto">
                                                <li class="comment-item" data-cid="1351321688">
                                                    <div class="comment">
                                                        <h3>
                                                            <span class="comment-vote" style="float: right">
                                                                <span id="c-1351321688" class="vote-count">${dto.usernum}</span>
                                                                <a href="/user/addUsenum?commentUuid=${dto.commentUuid}" id="btn-1351321688" class="j vote-comment" data-cid="1351321688">有用</a>
                                                            </span>
                                                            <span class="comment-info">
                                                                <a href="javascript:;">${dto.userName}</a>
                                                                <span>
                                                                    <fmt:formatDate value="${dto.createTime}" pattern="yyyy-MM-dd"/>
                                                                </span>
                                                            </span>
                                                        </h3>
                                                        <p class="comment-content">
                                                            ${dto.content}
                                                        </p>
                                                    </div>
                                                </li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
