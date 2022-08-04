<%--
  Created by IntelliJ IDEA.
  User: xx
  Date: 2022/7/31
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">九九乘法表</h1>
    <table width="600px" align="center">
        <% for (int i = 1; i < 10; i++) { %>
            <tr>
            <%  for (int j = 1; j <= i; j++) { %>
                <td> <%=  j + "x" + i + "=" + i * j %> </td>
                    <% } %>
                         </tr>
                          <% } %>
    </table>
</body>
</html>
