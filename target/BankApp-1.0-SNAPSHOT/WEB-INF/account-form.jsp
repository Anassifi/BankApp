<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 2/22/2021
  Time: 6:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${requestScope.account != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${requestScope.account == null}">
                    <form action="insert" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${requestScope.account != null}">
                            Edit Account
                        </c:if>
                        <c:if test="${requestScope.account == null}">
                            Add New Account
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${requestScope.account != null}">
                        <input type="hidden" value="<%=request.getParameter("id")%>" name="id"/>
                </c:if>

                <fieldset class="form-group">
                    <label>Firstname
                        <input type="text" value="<c:out value="${requestScope.account.firstName}"/>" class="form-control" name="firstname" required/>
                    </label>
                </fieldset>

                <fieldset class="form-group">
                    <label>Lastname
                        <input type="text" value="<c:out value="${requestScope.account.lastName}"/>" class="form-control" name="lastname" required/>
                    </label>
                </fieldset>

                <fieldset class="form-group">
                    <label>Email
                        <input type="email" value="<c:out value="${requestScope.account.email}"/>" class="form-control" name="email" required/>
                    </label>
                </fieldset>

                <fieldset class="form-group">
                    <label>Password
                        <input type="password" value="<c:out value="${requestScope.account.password}"/>" class="form-control" name="password" required/>
                    </label>
                </fieldset>

                <fieldset class="form-group">
                    <label>Phone number
                        <input type="text" value="<c:out value="${requestScope.account.numeroTel}"/>" class="form-control" name="numerotel" required/>
                    </label>
                </fieldset>

                <button type="submit" class="btn btn-success">Add account</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
