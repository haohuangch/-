<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
    <title>系统注册</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <body>
    <form id="sysRegist" method="post" name="sysRegist" action="${pageContext.request.contextPath}/account/regist.do">
        <h2>注册</h2>
        <p>用户名：</p>
        <input type="text" value="${account.name}" name="name" id="name" >
        <p>手机号：</p>
        <input type="text" value="${account.phone}" name="phone" id="phone">
        <p>密码：</p>
        <input type="text" value="${account.loginPwd}" name="loginPwd" id="loginPwd">
    </form>
        <button text="注册" name="registBtn" onclick=regist()></button>
    </body>
<script>
    function regist() {
        var name = $("#name").val();
        var phone = $("#phone").val();
        var loginPwd = $("#loginPwd").val();
        if(name == null && name == ''){
            alert("用户名不能为空！");
        }
        if(phone == null && phone == ''){
            alert("手机号不能为空！")
        }
        if(loginPwd == null && loginPwd == ''){
            alert("密码不能为空！")
        }
        $("#sysRegist").submit();
    }
</script>
</html>