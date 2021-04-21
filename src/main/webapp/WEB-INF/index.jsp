<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Dojo And Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>
    <div class="container">
        <h1>Dojos and Ninjas</h1>
        <ul>
            <c:forEach items="${allDojos}" var="dojo">
                <li>
                    <a href="/dojos/${dojo.id}">${dojo.name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <a href="/ninjas/new">New Ninja</a>
    <a href="/dojos/new">New Dojo</a>
</body>

</html>