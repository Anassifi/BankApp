<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bank Application</title>
</head>
<body>
<div>
    <h1>Bank Management</h1>
    <h2>
        <a href="/new">Add New Account</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Accounts</a>

    </h2>
</div>
<div align="center">
    <c:if test="${accounts != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${accounts == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${accounts != null}">
                            Edit Account
                        </c:if>
                        <c:if test="${accounts == null}">
                            Add New Account
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${accounts != null}">
                    <input type="hidden" name="id" value="<c:out value='${accounts.id}' />" />
                </c:if>
                <tr>
                    <th>Firstname: </th>
                    <td>
                        <input type="text" name="firstname" size="45"
                               value="<c:out value='${accounts.firstname}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Lastname: </th>
                    <td>
                        <input type="text" name="lastname" size="45"
                               value="<c:out value='${accounts.lastname}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="email" name="email" size="255"
                               value="<c:out value='${accounts.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Password: </th>
                    <td>
                        <input type="password" name="password" size="45"
                               value="<c:out value='${accounts.password}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Numero de tel: </th>
                    <td>
                        <input type="text" name="numerotel" size="45"
                               value="<c:out value='${accounts.numeroTel}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Add account" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
