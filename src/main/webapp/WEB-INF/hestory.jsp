<%--
  Created by IntelliJ IDEA.
  User: Ammar
  Date: 1/22/2021
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hestory</title>
</head>
<body>
    <h1>${user.username} hestory</h1>

    <H3>Incomes</H3>

    <table>
        <thead>
            <tr>
                <th>Amount</th><th>description</th><th>date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ incomes }" var="income">
                <td>${ income.amount }</td>
                <td>${ income.description}</td>
                <td>${ income.date}</td></tr>
            </c:forEach>
        </tbody>
    </table>

    <H3>Expenses</H3>

    <H3>Incomes</H3>

    <table>
        <thead>
        <tr>
            <th>Amount</th><th>description</th><th>date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ expenses }" var="expense">
            <td>${ expense.amount }</td>
            <td>${ expense.description}</td>
            <td>${ expense.date}</td></tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
