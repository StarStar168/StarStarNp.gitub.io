<%--
  Created by IntelliJ IDEA.
  User: xx
  Date: 2022/8/2
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/01_jsp/servlet01" encType="multipart/form-data" method="post">
        用户名:<input type="text" name="username"/> <br>
        头像:<input type="file" name="photo"/> <br>
        <input type="submit" value="上传">
    </form>





</body>
</html>
