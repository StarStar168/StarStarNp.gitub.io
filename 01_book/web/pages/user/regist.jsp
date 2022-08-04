<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>

    <%--静态包含 base标签、css样式、jQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        //页面加载
        $(function () {
            //单击注册事件
            $("#sub_btn").click(function () {
                //验证正则表达式
                var username = $("#username").val();//获取username的值
                var usernamePat = /^\w{5,8}$/;
                if (!usernamePat.test(username)) {//和正则表达式比较
                    $("span.errorMsg").text("用户名不合法");
                    return false
                }

                //验证用户密码
                var password = $("#password").val();
                var passwordPat = /^\w{6,12}$/;
                if (!passwordPat.test(password)) {//和正则表达式比较
                    $("span.errorMsg").text("密码不合法");
                    return false
                }

                //确认用户密码
                var rePassword = $("#repwd").val();
                if (rePassword != password) {//和第一次密码比较
                    $("span.errorMsg").text("两次密码不一致");
                    return false
                }

                //验证电子邮箱地址
                var email = $("#email").val();
                var emailPat = /^\w+@\w+\.com$/;
                if (!emailPat.test(email)) {//和正则表达式比较
                    $("span.errorMsg").text("邮箱格式输入有误");
                    return false
                }

                //验证验证码
                var code = $("#code").val();
                if (code != "bnbnp") {
                    $("span.errorMsg").text("验证码输入错误");
                    return false;
                } else if (code == null || code == "") {
                    $("span.errorMsg").text("验证码不能为空");
                } else {
                    $("span.errorMsg").empty();
                }

            })
        })


    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册StarStar书城会员</h1>
                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="registServlet" />
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username"
                                    value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"
                                   value="${requestScope.password}"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"
                                   value="${requestScope.password}"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="email" id="email"
                               value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" id="code" name="code"
                               value="${requestScope.code}"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/foot.jsp" %>

</body>
</html>