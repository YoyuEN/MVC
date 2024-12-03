<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/28
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>客户编号：${customer.getId()}</p>
<p>客户姓名：${customer.getName()}</p>
<p>客户地址：${customer.getAddress()}</p>
<p>客户余额：${customer.getBalance()}</p>
</body>
</html>
