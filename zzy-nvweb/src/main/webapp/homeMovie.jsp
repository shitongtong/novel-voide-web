<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN" class="ua-mac ua-webkit book-new-nav">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Expires" content="Sun, 6 Mar 2005 01:00:00 GMT">

    <title>
        子依电影
    </title>
    <link href="/css/bundle(1).css" rel="stylesheet" type="text/css">
    <link href="/css/master.css" rel="stylesheet" type="text/css">
    <link href="/css/init.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/45d9f697c1994c21.css">
    <link href="/css/bundle.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" defer="" async="" src="/js/piwik.js"></script>
    <script type="text/javascript" src="/js/ad.release.js"></script>
    <script type="text/javascript" async="" src="/js/vds.js"></script>
    <script src="/js/jquery.js"></script>
    <script src="/js/bundle.js" defer="defer"></script>
    <script src="/css/define.js"></script>
    <script src="/js/ga.js"></script>
    <script src="/js/bundle(2).js" defer="defer"></script>
    <script src="/js/jquery.js"></script>
    <script src="/js/tabs.js"></script>
    <script src="/js/index.js"></script>
    <script src="/js/slide.js"></script>
    <script src="/js/bubble.js"></script>
    <script src="/js/cookie.js"></script>
    <script src="/js/ajax.js"></script>
    <script src="/js/init.js"></script>

</head>
<body>

<div id="db-global-nav" class="global-nav">
    <div class="bd">
        <div class="top-nav-info">
            <c:if test="${user !=null}">
                <ul>
                    <li class="nav-user-account">
                        <a target="_blank" href="#" class="bn-more">
                            <span>${user.name}的账号</span><span class="arrow"></span>
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
            </c:if>
            <c:if test="${user == null}">
                <a href="http://localhost:8080/login.jsp" class="nav-login" rel="nofollow">登录</a>
                <a href="http://localhost:8080/register.jsp" class="nav-register" rel="nofollow">注册</a>
            </c:if>
        </div>


        <div class="global-nav-items">
            <ul>
                <li class="">
                    <a href="/home?userUuid=${user.userUuid}"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-main&quot;,&quot;uid&quot;:&quot;0&quot;}">首页</a>
                </li>
                <li class="on">
                    <a href="/home?userUuid=${user.userUuid}" target="_blank"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-book&quot;,&quot;uid&quot;:&quot;0&quot;}">读书</a>
                </li>
                <li class="">
                    <a href="/homeMovie?userUuid=${user.userUuid}" target="_blank"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-movie&quot;,&quot;uid&quot;:&quot;0&quot;}">电影</a>
                </li>
            </ul>
        </div>

    </div>
</div>


<div id="db-nav-book" class="nav">
    <div class="nav-wrap">
    </div>
</div>

<div id="wrapper">
    <div id="content">
        <div class="grid-16-8 clearfix">
            <div class="article">
                <div class="section books-express ">
                    <div class="hd">
                        <h2 class="">
                            <span class="">电影列表</span>
                        </h2>
                    </div>
                    <div class="bd">
                        <div class="carousel">
                            <div class="slide-list" style="height: auto">
                                <c:forEach items="${movieListList}" var="movieList">
                                    <ul class="list-col list-col5 list-express slide-item clone">
                                        <c:forEach items="${movieList}" var="movie">
                                            <li class="">
                                                <div class="cover">
                                                    <a href="/movieComment?movieUuid=${movie.movieUuid}&userUuid=${user.userUuid}"
                                                       title="${movie.name}">
                                                        <img src="${movie.photo}" class="" width="284px"
                                                             height="177px" alt="${movie.name}">
                                                    </a>
                                                </div>
                                                <div class="info">
                                                    <div class="title">
                                                        <a class=""
                                                           href="/movieComment?movieUuid=${movie.movieUuid}&userUuid=${user.userUuid}"
                                                           title="${movie.name}">${movie.name}</a>
                                                    </div>
                                                    <div class="more-meta">
                                                        <h4 class="title">
                                                                ${movie.name}
                                                        </h4>
                                                        <p class="abstract">
                                                                ${movie.intro}
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
