<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xx.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xx
  Date: 2022/8/1
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <STYLE>
        table{
            align-content: center;
            width: 500px;
            border: 1px solid red;
            border-collapse: collapse;
        }

        th , td{
            border: 1px solid blue;
        }
    </STYLE>

</head>
<body>

    <%
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 1; i <= 10; i++) {
            studentList.add(new Student(i,"name"+i ,18+i,"phone"+i));
        }
        request.setAttribute("stus", studentList);
    %>
    <table>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>年龄</th>
            <th>电话</th>
        </tr>
        <%--
        items 表示遍历的集合
        var 表示遍历到的数据
        begin 表示遍历的开始索引值
        end 表示结束的索引值
        step 属性表示遍历的步长值
        varStatus 属性表示当前遍历到的数据的状态
        for（int i = 1; i < 10; i+=2）
        --%>
        <c:forEach  begin="2" end="7" step="2" varStatus="status" items="${requestScope.stus}" var="stu"><tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${status.current}</td>
        </tr>
        </c:forEach>

    </table>

</body>
</html>
