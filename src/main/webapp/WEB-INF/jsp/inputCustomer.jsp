<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册页面</title>
</head>
<body>
<h4>用户注册页面</h4>
<form action="save-customer" method="post">
    <table>
        <tr><td>客户编号：</td> <td><input type="number"
                                      name="id" size="5"></td></tr>
        <tr><td>客户名：</td>
            <td><input type="text" name="name" size="15"></td></tr>
        <tr><td>客户地址：</td>
            <td><input type="text" name="address" size="15"></td></tr>
        <tr><td>客户余额：</td> <td><input type="number"
                                      name="balance" size="5"></td></tr>

        <tr><td><input type="submit" name="submit" value="提交"></td>
            <td><input type="reset" name="reset" value="重置"></td></tr>
    </table>
</form>
</body>
</html>
