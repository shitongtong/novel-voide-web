<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans" class="ua-mac ua-webkit">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        ${user.name}
    </title>

    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="Sun, 6 Mar 2005 01:00:00 GMT">

    <link href="/css/douban.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" defer="" async="" src="/js/piwik.js"></script>
    <script async="" src="/js/gtm.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/do.js" data-cfg-autoload="false"></script>
    <script type="text/javascript" src="/js/douban.js"></script>


    <script type="text/javascript" src="/js/follow.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-sortable.js"></script>
    <script type="text/javascript" src="/js/mine_dragdrop.js"></script>

    <script src="/js/ga.js" async="true"></script>
</head>

<body>


<link href="/css/bundle.css" rel="stylesheet" type="text/css">


<div id="db-global-nav" class="global-nav">
    <div class="bd">

        <div class="top-nav-info">
            <ul>
                <li class="nav-user-account">
                    <a target="_blank" href="#" class="bn-more" rel="off">
                        <span>${user.name}的帐号</span><span class="arrow"></span>
                    </a>
                    <div class="more-items">
                        <table cellpadding="0" cellspacing="0">
                            <tbody>
                            <tr>
                                <td>
                                    <a href="/user/info">个人主页</a>
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
                <li class="on">
                    <a href="/home?userUuid=${user.userUuid}"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-main&quot;,&quot;uid&quot;:&quot;178031345&quot;}">首页</a>
                </li>
                <li class="">
                    <a href="/home?userUuid=${user.userUuid}" target="_blank"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-book&quot;,&quot;uid&quot;:&quot;178031345&quot;}">读书</a>
                </li>
                <li class="">
                    <a href="https://movie.douban.com/" target="_blank"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-movie&quot;,&quot;uid&quot;:&quot;178031345&quot;}">电影</a>
                </li>
            </ul>
        </div>

    </div>
</div>


<script src="/js/bundle.js" defer="defer"></script>

<link href="/css/bundle(1).css" rel="stylesheet" type="text/css">


<div id="db-nav-sns" class="nav">
    <div class="nav-wrap">
        <div class="nav-primary">

        </div>
    </div>
</div>


<script src="/js/bundle(2).js" defer="defer"></script>


<div id="wrapper">
    <div id="content">
        <div class="grid-16-8 clearfix">
            <div class="article drop-area ui-sortable">
                <div id="db-usr-profile">
                    <div class="info">
                        <ul>
                            <li><a id="" href="/user/info">我的书架</a></li>
                            <li><a id="usr-profile-nav-statuses"
                                   href="/user/video">我的视频</a></li>
                            <c:if test="${user.type==1}">
                                <li><a id="" href="/user/manager">用户管理</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>


                <script type="text/javascript" src="/js/ajaxfileupload.js"></script>
                <script type="text/javascript" src="/js/imgsel.js"></script>
                <script type="text/javascript" src="/js/userguide.js"></script>


                <div class="sort " id="book">
                    <%--<div class="photo-btns">
                        <span class="btn-pic-upload">
                            <a class="lnk-create lnk-create-album" target="_blank" href="/user/addBook?userUuid=${user.userUuid}">
                                <i>+</i>新增小说</a>
                        </span>
                    </div>--%>
                    <div>
                        <table>
                            <tr>
                                <th>用户名</th>
                                <th>注册时间</th>
                                <th>操作</th>
                            </tr>
                            <c:forEach items="${userList}" var="user1">
                                <tr>
                                    <td>${user1.name}</td>
                                    <td>
                                        <fmt:formatDate value="${user1.createTime}" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>
                                        <a href="/user/deleteUser?deleteUserUuid=${user1.userUuid}&userUuid=${user.userUuid}">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>


                <div class="sort " id="movie">


                </div>


            </div>
            <div class="aside drop-area ui-sortable">


                <div id="profile">


                    <div class="infobox">
                        <div class="ex1"><span></span></div>
                        <div class="bd">

                            <div class="basic-info">

                                <img src="/image/user_normal.jpg" class="userface" alt="">

                                <div class="user-info">
                                    <div class="pl">
                                        <fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"/>加入
                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>


                </div>


                <script src="/js/jquery.elastic.js"></script>


            </div>

</body>
</html>
