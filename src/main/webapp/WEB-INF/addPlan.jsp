<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<body>


<h3> <c:out value="${user.username}"></c:out></h3>




<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="/incomes">MoneyManager</a>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">

                    <a class="nav-link active" aria-current="page" href="/incomes/new">Addincome</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/plan/new">add plan</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/expense/new">add Expense</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/edit/i/1">edit</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/history">history</a>
                </li>

            </ul>
            <input href="/user" type="submit" value="setting"/> |
            <form id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Logout!"/>
            </form>

        </div>
    </div>
</nav>
<form:form action="/plan/new" method="POST" modelAttribute="plan">
    <p>
        <form:label path="name">name</form:label>
        <form:input path="name" class="input"/>
    </p>
    <p>
        <form:label path="limitz">limit Money</form:label>
        <form:errors path="limitz"/>
        <form:input path="limitz"/>
    </p>
    <p>
        <form:label path="start_datez">start date</form:label>
        <form:errors path="start_datez"/>
        <form:input path="start_datez" type="date"/>
    </p>
    <p>
        <form:label path="end_datez">end date</form:label>
        <form:errors path="end_datez"/>
        <form:input path="end_datez" type="date"/>
    </p>

    <input type="submit" value="Submit"/>
</form:form>


</body>
</html>