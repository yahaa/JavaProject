<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: zihua
  Date: 16-12-22
  Time: 下午9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" ACTION="/person/addPerson" modelAttribute="user">
    <table>
        <tr>
            <td>id :</td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td>name :</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>idCard :</td>
            <td><input type="text" name="idCard"/></td>
        </tr>address
        <tr>
            <td>phone :</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>address :</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>address :</td>
            <td><input type="submit" name="add"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
