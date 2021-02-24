<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bank Application</title>
</head>
<body>
<div style="text-align: center">
    <h1>Accounts Management</h1>
    <h2>
        <a href="/new">Add New Account</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Accounts</a>

    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Accounts</h2></caption>
        <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Numero tel</th>
            <th>Created At</th>

        </tr>
        <c:forEach var="accounts" items="${accountList}">
            <tr>
                <td><c:out value="${accounts.id}" /></td>
                <td><c:out value="${accounts.firstname}" /></td>
                <td><c:out value="${accounts.lastname}" /></td>
                <td><c:out value="${accounts.email}" /></td>
                <td><c:out value="${accounts.password}" /></td>
                <td><c:out value="${accounts.numeroTel}" /></td>
                <td><c:out value="${accounts.createdAt}" /></td>

                <td>
                    <a href="/edit?id=<c:out value='${accounts.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${accounts.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>