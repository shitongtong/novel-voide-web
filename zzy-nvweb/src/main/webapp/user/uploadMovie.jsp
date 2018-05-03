<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>上传</title>
</head>
<body>

用户名:${user.name}
<br/><br/>
<form id="uploadForm" action="/uploadMovie" enctype="multipart/form-data" method="post">
    <input type="hidden" name="userUuid" value="${user.userUuid}">
    电影上传:<input type="file" name="file" id="file">
    <br>
    <br>
    名称:<input type="text" name="name" id="name">
    <br>
    <br>
    导演:<input type="text" name="director" id="director">
    <br>
    <br>
    编剧:<input type="text" name="screenwriter" id="screenwriter">
    <br>
    <br>
    主演:<input type="text" name="starring" id="starring">
    <br>
    <br>
    简介:<textarea id="intro" name="intro" rows="3"></textarea>
    <input type="submit" value="提交">
</form>
<br/><br/>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $("#uploadForm").submit(function () {
            var name = $("#name").val();    //获取提交的值
            if (name.length == 0) {     //进行判断，如果获取的值为0那么提示账号不能为空
                alert("名称不能为空！");
                return false;
            }
            var director = $("#director").val();    //获取提交的值
            if (director.length == 0) {   //进行判断，如果获取的值为0那么提示账号不能为空
                alert("导演不能为空！");
                return false;
            }
            var screenwriter = $("#screenwriter").val();    //获取提交的值
            if (screenwriter.length == 0) {   //进行判断，如果获取的值为0那么提示账号不能为空
                alert("编剧不能为空！");
                return false;
            }
            var screenwriter = $("#screenwriter").val();    //获取提交的值
            if (screenwriter.length == 0) {   //进行判断，如果获取的值为0那么提示账号不能为空
                alert("主演不能为空！");
                return false;
            }
        });
    });
</script>
</body>
</html>
