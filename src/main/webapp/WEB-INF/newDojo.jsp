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
        <h1>New Dojo</h1>
        <form:form action="/dojos/create" method="post" modelAttribute="dojo">
            <p>
                <form:label path="name">Dojo Name</form:label>
                <form:errors path="name" />
                <form:input path="name" />
            </p>
            <input type="submit" value="Submit" />
        </form:form>
    </div>
</body>

</html>