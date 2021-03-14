<%--
  Created by IntelliJ IDEA.
  User: Ammar
  Date: 1/23/2021
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        a{
            text-decoration: none;
        }
    </style>

    <title>edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<body>



<h3><c:out value="${user.username}"></c:out></h3>




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





<table class="table table-borderless" style="overflow: auto">
    <tbody>
    <tr>
        <th scope="row">income</th>
        <c:forEach items="${ incomes }" var="income">
        <td>  <a href="/edit/i/${ income.id }" style="text-decoration:none">${ income.amount } </a> <a href="/deleteincome/${income.id}"> @D</a>  </td>
        </c:forEach>
    </tr>
    <tr>
        <th scope="row">plan</th>
        <c:forEach items="${ plans }" var="plan">
        <td> <a href="/edit/p/${ plan.id }" style="text-decoration:none">${ plan.name } </a><a href="/deleteplan/${plan.id}"> @D</a>   </td>
        </c:forEach>
    </tr>
    <tr>
        <th scope="row">expense</th>
        <c:forEach items="${ expenses }" var="expense">
        <td> <a href="/edit/e/${ expense.id }" style="text-decoration:none"> ${ expense.description }</a><a href="/deleteexpense/${expense.id}"> @D</a>  </td>
        </c:forEach>
    </tr>
    <tr>
        <th scope="row">expense</th>
        <c:forEach items="${ user.categories }" var="cat">
            <td> <a href="/edit/e/${ cat.id }" style="text-decoration:none"> ${ cat.name }</a><a href="/deletecat/${cat.id}"> @D</a>  </td>
        </c:forEach>
    </tr>
    </tbody>
</table>




<%--<div style="width: 50px">--%>
<%--<table>--%>
<%--    <thead>--%>
<%--        <th>Incomes</th><th>Plans</th><th>Expenses</th>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--        <c:forEach items="${ incomes }" var="income">--%>
<%--            <td><a href="/edit/i/${ income.id }">${ income.amount } </a>  </td>--%>
<%--        </c:forEach>--%>

<%--        <c:forEach items="${ plans }" var="plan">--%>
<%--            <td><a href="/edit/p/${ plan.id }">${ plan.name } </a>   </td>--%>
<%--        </c:forEach>--%>

<%--        <c:forEach items="${ expenses }" var="expense">--%>
<%--            <td><a href="/edit/e/${ expense.id }"> ${ expense.description }</td>--%>
<%--        </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>
<%--</div>--%>

<hr>
<c:if test = "${testa == 0}">
<a4>income</a4>
<form:form action="/editincome/${income.id}" method="POST" modelAttribute="income">
    <p>
        <form:label path="amount">limit Money</form:label>
        <form:input type="number" path="amount" class="input" />
    </p>
    <p>
        <form:label path="description">description</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</c:if>

<c:if test = "${testa == 1}">
<a4>plan</a4>
<form:form action="/editplan/${plan.id}" method="POST" modelAttribute="plan">
    <p>
        <form:label path="limitz">limit Money</form:label>
        <form:input type="number" path="limitz" class="input" />
    </p>
    <p>
        <form:label path="name">description</form:label>
        <form:errors path="name"/>
        <form:input type="text" path="name"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</c:if>

<c:if test = "${testa == 2}">
<a4>expense</a4>
    <form:form action="/editexpense/${expense.id}" method="POST" modelAttribute="expense">
        <p>
            <form:label path="amount">limit Money</form:label>
            <form:input type="number" path="amount" class="input" />
        </p>
        <p>
            <form:label path="description">description</form:label>
            <form:errors path="description"/>
            <form:input path="description"/>
        </p>
        <p>
            <form:select  path="category">
                <c:forEach items="${ categories }" var="category">
                    <option value="${ category.id }">${ category.name }</option>
                </c:forEach>
            </form:select>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</c:if>

<c:if test = "${testa == 3}">
<a4>Categories</a4>
<form:form action="/editcat/${cate.id}" method="POST" modelAttribute="cate">
    <p>
        <form:label path="name">new name</form:label>
        <form:errors path="name"/>
        <form:input type="text" path="name"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</c:if>
</body>
</html>
