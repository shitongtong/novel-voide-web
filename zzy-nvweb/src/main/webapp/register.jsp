<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta property="wb:webmaster" content="572c54c2cc00c6fb">
    <meta name="referrer" content="always">

    <title>
        欢迎加入子依读书
    </title>


    <link type="text/css" rel="stylesheet" href="/css/register.css">
    <link type="text/css" rel="stylesheet" href="/css/dialog.css">


</head>
<body>

<div class="header">

</div>

<div class="wrapper">

    <h1>
        欢迎加入子依读书
    </h1>

    <div class="article">

        <form id="registerForm" method="post" action="/register">

            <div class="item extra-tips">
                <label>用户名</label>
                <input id="name" name="name" type="text" class="basic-input" maxlength="15" tabindex="3" value="">
                <div id="nameError" style="display:inline;color:red;"></div>
            </div>

            <div class="item extra-tips">
                <label>密码</label>
                <input id="password" name="password" type="password" class="basic-input" tabindex="2" maxlength="20">
                <div id="passwordError" style="display:inline;color:red;"></div>
            </div>
            <div class="item extra-tips">
                <label>确认密码</label>
                <input id="relpassword" name="relpassword" type="password" class="basic-input" tabindex="2" maxlength="20">
                <div id="relpasswordError" style="display:inline;color:red;"></div>
            </div>
            <c:if test="${msg !=''}">
                <div id="errorMsg" style="display:inline;color:red;">
                        ${msg}
                </div>
            </c:if>
            <div class="item-submit">
                <label>&nbsp;</label>
                <input type="submit" name="register" value="注册" id="button" class="btn-submit enabled" tabindex="6">
            </div>
        </form>

    </div>
    <div class="aside">
        <ul class="sidenav">
            <li>&gt;&nbsp;已经拥有帐号? <a rel="nofollow" href="http://localhost:8080/login.jsp">直接登录</a></li>

        </ul>

    </div>
</div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/validate.js"></script>
<script type="text/javascript" src="/js/dialog.js"></script>
<script type="text/javascript" src="/js/cookie.js"></script>
<script type="text/javascript" src="/js/do.js"></script>
<script>
    $(document).ready(function(){
        $("#registerForm").submit(function(){
            $("#nameError").html("");
            $("#passwordError").html("");
            $("#relpasswordError").html("");
            $("#errorMsg").html("");

            var name=$("#name").val();//获取提交的值
            if(name.length==0){//进行判断，如果获取的值为0那么提示账号不能为空
                //alert("aa");//测试使用
                $("#nameError").html("账号不能为空");
                return false;
            }

            //密码进行验证不能为空
            var password=$("#password").val();//获取提交的密码的值
            if(password.length==0){
                $("#passwordError").html("密码不能为空");
                return false;
            }
            if(password.length > 10){
                $("#passwordError").html("密码长度不能超多10");
                return false;
            }

            //确认密码进行验证
            var relpassword=$("#relpassword").val();//获取提交的确认密码的值
            if(relpassword.length==0){
                $("#relpasswordError").html("确认密码不能为空哦");
                return false;
            }

            if(password!=relpassword){
                $("#relpasswordError").html("确认密码输入不正确，请重新输入");
                return false;
            }
        });
    });



</script>

</body>
</html>
