<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xx.Student" %><%--
  Created by IntelliJ IDEA.
  User: xx
  Date: 2022/7/31
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            align-content: center;
            width: 500px;
            border: 1px solid red;
            border-collapse: collapse;
        }
        th , td{
            border: 1px solid blue;
        }
    </style>

</head>
<body>

<%
    List<Student> list = new ArrayList<Student>();
    for (int i = 1; i < 11; i ++) {
        list.add(new Student(i,"name"+i,18+i,"phone"+i));
    }%>
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>电话号码</td>
        <td>操作</td>
    </tr>
    <% for(Student student : list) { %>
<tr>
    <td><%= student.getId() %></td>
    <td><%= student.getName() %></td>
    <td><%= student.getAge() %></td>
    <td><%= student.getPhone() %></td>
    <td><%= "修改、删除"%></td>
</tr>
    <% } %>
</table>
<%
%>
</body>
</html>
