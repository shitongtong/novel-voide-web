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
        子依读书
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
    <script src="/js/jquery.js" ></script>
    <script src="/js/tabs.js" ></script>
    <script src="/js/index.js" ></script>
    <script src="/js/slide.js" ></script>
    <script src="/js/bubble.js" ></script>
    <script src="/js/cookie.js" ></script>
    <script src="/js/ajax.js" ></script>
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
                            <span>${user.name}</span><span class="arrow"></span>
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
                    <a href="/home?userUuid=${user.userUuid}"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-book&quot;,&quot;uid&quot;:&quot;0&quot;}">读书</a>
                </li>
                <li class="">
                    <a href="https://movie.douban.com/" target="_blank"
                       data-moreurl-dict="{&quot;from&quot;:&quot;top-nav-click-movie&quot;,&quot;uid&quot;:&quot;0&quot;}">视频</a>
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
                            <span class="">图书列表</span>
                        </h2>
                    </div>
                    <div class="bd">
                        <div class="carousel">
                            <div class="slide-list" <%--style="width: 4050px; left: -675px;"--%>>
                                <c:forEach items="${novelListList}" var="novelList">
                                    <ul class="list-col list-col5 list-express slide-item clone">

                                        <c:forEach items="${novelList}" var="novel">
                                            <li class="">
                                                <div class="cover">
                                                    <a href="/comment?novelUuid=${novel.novelUuid}&userUuid=${user.userUuid}"
                                                       title="${novel.name}">
                                                        <img src="${novel.photo}" class="" width="176px"
                                                             height="202px" alt="${novel.name}">
                                                    </a>
                                                </div>
                                                <div class="info">
                                                    <div class="title">
                                                        <a class=""
                                                           href="/comment?novelUuid=${novel.novelUuid}&userUuid=${user.userUuid}"
                                                           title="${novel.name}">${novel.name}</a>
                                                    </div>
                                                    <div class="author">
                                                            ${novel.author}
                                                    </div>
                                                    <div class="more-meta">
                                                        <h4 class="title">
                                                                ${novel.name}
                                                        </h4>
                                                        <p>
                                              <span class="author">
                                                      ${novel.author}
                                              </span>
                                                        </p>
                                                        <p class="abstract">

                                                                ${novel.intro}
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


        <script type="text/javascript" src="./js/14a849b70e265daa.js"></script>
        <!-- mako -->


        <script>
            window.user_id = window.user_id || ''
            define.config({
                'ui/slide': 'Book.slide'
                , 'ui/bubble': 'Book.Bubble'
            })
            Do.add('book/index', {path: 'https://img3.doubanio.com/f/book/50b2790ba59deba551045acc3fd335f868155ec8/js/book/index.js'})
            Do.add('ui/slide', {path: 'https://img3.doubanio.com/f/book/2f473e3eae1803f9e743ea632607ad4f9677fb3b/js/book/ui/slide.js'})
            Do.add('ui/bubble', {path: 'https://img3.doubanio.com/f/book/95c407df830e0ab6119ed622ee42033acf0af414/js/book/ui/bubble.js'})
            Do.add('widget/tabs', {path: 'https://img3.doubanio.com/f/book/1c240c18b397f6c8583254c27b9c1f1ecebb6075/js/book/widget/tabs.js'})
            Do('book/index')
        </script>


        <script type="text/javascript">
            var _paq = _paq || [];
            _paq.push(['trackPageView']);
            _paq.push(['enableLinkTracking']);
            (function () {
                var p = (('https:' == document.location.protocol) ? 'https' : 'http'), u = p + '://fundin.douban.com/';
                _paq.push(['setTrackerUrl', u + 'piwik']);
                _paq.push(['setSiteId', '100001']);
                var d = document, g = d.createElement('script'), s = d.getElementsByTagName('script')[0];
                g.type = 'text/javascript';
                g.defer = true;
                g.async = true;
                g.src = p + '://s.doubanio.com/dae/fundin/piwik.js';
                s.parentNode.insertBefore(g, s);
            })();
        </script>

        <script type="text/javascript">
            var setMethodWithNs = function (namespace) {
                var ns = namespace ? namespace + '.' : ''
                        , fn = function (string) {
                    if (!ns) {
                        return string
                    }
                    return ns + string
                }
                return fn
            }

            var gaWithNamespace = function (fn, namespace) {
                var method = setMethodWithNs(namespace)
                fn.call(this, method)
            }

            var _gaq = _gaq || []
                    , accounts = [
                {id: 'UA-7019765-1', namespace: 'douban'}
                , {id: 'UA-7019765-16', namespace: ''}
            ]
                    , gaInit = function (account) {
                gaWithNamespace(function (method) {
                    gaInitFn.call(this, method, account)
                }, account.namespace)
            }
                    , gaInitFn = function (method, account) {
                _gaq.push([method('_setAccount'), account.id])


                _gaq.push([method('_addOrganic'), 'google', 'q'])
                _gaq.push([method('_addOrganic'), 'baidu', 'wd'])
                _gaq.push([method('_addOrganic'), 'soso', 'w'])
                _gaq.push([method('_addOrganic'), 'youdao', 'q'])
                _gaq.push([method('_addOrganic'), 'so.360.cn', 'q'])
                _gaq.push([method('_addOrganic'), 'sogou', 'query'])
                if (account.namespace) {
                    _gaq.push([method('_addIgnoredOrganic'), '豆瓣'])
                    _gaq.push([method('_addIgnoredOrganic'), 'douban'])
                    _gaq.push([method('_addIgnoredOrganic'), '豆瓣网'])
                    _gaq.push([method('_addIgnoredOrganic'), 'www.douban.com'])
                }

                if (account.namespace === 'douban') {
                    _gaq.push([method('_setDomainName'), '.douban.com'])
                }

                _gaq.push([method('_setCustomVar'), 1, 'responsive_view_mode', 'desktop', 3])

                _gaq.push([method('_setCustomVar'), 2, 'login_status', '0', 2]);

                _gaq.push([method('_trackPageview')])
            }

            for (var i = 0, l = accounts.length; i < l; i++) {
                var account = accounts[i]
                gaInit(account)
            }


            ;
            (function () {
                var ga = document.createElement('script');
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                ga.setAttribute('async', 'true');
                document.documentElement.firstChild.appendChild(ga);
            })()
        </script>

</body>
</html>
