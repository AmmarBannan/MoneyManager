<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
<h3><c:out value="${ error }"/></h3>

<form:form action="/expense/new" method="POST" modelAttribute="expense">
    <p>
        <form:label path="amount">limit Money</form:label>
        <form:input type="number" path="amount" class="input"/>
    </p>
    <p>
        <form:label path="description">description</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>
    <p>
        <form:label path="date">date</form:label>
        <form:errors path="date"/>
        <form:input path="date" type="date"/>
    </p>
    <p>
        <form:select path="category">
            <c:forEach items="${ categories }" var="category">
                <option value="${ category.id }">${ category.name }</option>
            </c:forEach>
        </form:select>
    </p>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>