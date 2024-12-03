<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册页面</title>
</head>
<body>
<h4>用户注册页面</h4>
<form action="regist-user2" method="post">
    <table>

        <tr><td>用户名：</td>
            <td><input type="text" name="username" size="15"></td></tr>
        <tr><td>密码：</td>
            <td><input type="password" name="password" size="16"></td></tr>
        <tr><td>性别：</td>
            <td><input type="radio" name="sex" value="male" checked>男
                <input type="radio" name="sex" value="female">女</td></tr>
        <tr><td>地址：</td>
            <td><input type="text" name="address" size="20"></td></tr>
        <tr><td>生日：</td>
            <td><input type="date" name="birthday"></td></tr>
        <tr><td>会员类型：</td>
            <td><select name="usertype">
                <option value="ordinary" selected>普通会员</option>
                <option value="silver">银卡会员</option>
                <option value="golden">金卡会员</option>
                <option value="whitediamond">白钻会员</option>
            </select></td></tr>
        <tr><td><input type="submit" name="submit" value="提交"></td>
            <td><input type="reset" name="reset" value="重置"></td></tr>
    </table>
</form>
</body>
</html>