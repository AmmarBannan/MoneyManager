<<<<<<< HEAD
=======
<%--
  Created by IntelliJ IDEA.
  User: Ammar
  Date: 1/22/2021
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>

>>>>>>> b59787f4103aa518a01d69b83b5af0496316177d
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hestory</title>
</head>
<body>
<<<<<<< HEAD
<h1>${username} hestory</h1>
<a href="/incomes">Dashboard</a>
<H3>Incomes</H3>


<table>
    <thead>
    <tr>
        <th>Amount</th><th>description</th><th>date</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${ incomes }" var="income">
        <td>${ income.amount }</td>
        <td>${ income.description}</td>
        <td>${ income.date}</td></tr>
    </c:forEach>
    </tr>
    </tbody>
</table>

<H3>Expenses</H3>

<table>
    <thead>
    <tr>
        <th>Amount</th><th>description</th><th>date</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${ expenses }" var="expense">
        <td>${ expense.amount }</td>
        <td>${ expense.description}</td>
        <td>${ expense.date}</td></tr>
    </c:forEach>
    </tr>
    </tbody>
</table>
</body>
</html>
=======
    <h1>${username} hestory</h1>
    <a href="/incomes">Dashboard</a>
    <H3>Incomes</H3>


    <table>
        <thead>
            <tr>
                <th>Amount</th><th>description</th><th>date</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <c:forEach items="${ incomes }" var="income">
                    <td>${ income.amount }</td>
                    <td>${ income.description}</td>
                    <td>${ income.date}</td></tr>
                </c:forEach>
            </tr>
        </tbody>
    </table>

    <H3>Expenses</H3>

    <table>
        <thead>
        <tr>
            <th>Amount</th><th>description</th><th>date</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <c:forEach items="${ expenses }" var="expense">
            <td>${ expense.amount }</td>
            <td>${ expense.description}</td>
            <td>${ expense.date}</td></tr>
        </c:forEach>
        </tr>
        </tbody>
    </table>
</body>
</html>
>>>>>>> b59787f4103aa518a01d69b83b5af0496316177d
