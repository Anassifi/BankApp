<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 2/22/2021
  Time: 6:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Bank Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: cadetblue">
            <div>
                <h1 class="navbar-brand">Bank Management App</h1>
            </div>

            <ul class="navbar-nav">
                <li>
                    <a href="<%= request.getContextPath() %>/account" class="nav-link">Accounts</a>
                </li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
        <div class="container">
            <h3 class="text-center">List of Accounts</h3>
            <hr>
            <div class="container text-left">

                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                    New Account</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Phone num</th>
                </tr>
                </thead>
                <tbody>

                <%--@elvariable id="accounts" type="java.util.List"--%>
                <c:forEach var="account" items="${accounts}">
                    <tr>
                        <td><c:out value="${account.id_account}" /></td>
                        <td><c:out value="${account.firstName}" /></td>
                        <td><c:out value="${account.lastName}" /></td>
                        <td><c:out value="${account.email}" /></td>
                        <td><c:out value="${account.password}" /></td>
                        <td><c:out value="${account.numeroTel}" /></td>
                        <td>
                            <a class="btn btn-success" href="edit?id=<c:out value='${account.id_account}' />">Edit</a>
                            <a class="btn btn-danger" href="delete?id=<c:out value='${account.id_account}' />">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</body>
</html>
