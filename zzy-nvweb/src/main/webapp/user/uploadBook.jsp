<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>上传</title>
</head>
<body>

用户名:${user.name}
<br/><br/>
<form id="uploadForm" action="/upload" enctype="multipart/form-data" method="post">
    <input type="hidden" name="userUuid" value="${user.userUuid}">
    小说上传:<input type="file" name="file" id="file">
    <br>
    小说名称:<input type="text" name="name" id="name">
    <br>
    小说作者:<input type="text" name="author" id="author">
    <br>
    小说简介:<textarea id="intro" name="intro" rows="3"></textarea>
    <input type="submit" value="提交">
</form>
<br/><br/>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $("#uploadForm").submit(function () {
            var name = $("#name").val();    //获取提交的值
            if (name.length == 0) {     //进行判断，如果获取的值为0那么提示账号不能为空
                alert("小说名称不能为空！");
                return false;
            }
            var author = $("#author").val();    //获取提交的值
            if (author.length == 0) {   //进行判断，如果获取的值为0那么提示账号不能为空
                alert("小说作者不能为空！");
                return false;
            }
        });
    });
</script>
</body>
</html>
