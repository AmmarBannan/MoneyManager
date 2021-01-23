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
    <title>Title</title>
</head>
<hr>
<a href="/incomes">Dashboard</a>
<h1>Welcome Page <c:out value="${user.username}"></c:out></h1>
<a4>income</a4>
<table>
    <thead>
    <th>Incomes</th><th>Plans</th><th>Expenses</th>
    </thead>
    <tbody>

    <c:forEach items="${ incomes }" var="income">
        <c:forEach items="${ plans }" var="plan">
            <c:forEach items="${ expenses }" var="expense">
                <tr>
                    <td><a href="/edit/i/${ income.id }">${ income.amount } </a>  </td>
                    <td><a href="/edit/p/${ plan.id }">${ plan.name } </a>   </td>
                    <td><a href="/edit/e/${ expense.id }"> ${ expense.description }</td>
                </tr>
            </c:forEach>
        </c:forEach>
    </c:forEach>
    </tbody>


</table>
<%--<select name="incmoe" size="2">--%>
<%--<c:forEach items="${ incomes }" var="income">--%>
<%--    <option><a href="/edit/i/${ income.id }">${ income.amount } </a>              </option>--%>
<%--</c:forEach>--%>
<%--</select>--%>
<%--<a4>plans</a4>--%>
<%--<select name="plans" size="2">--%>
<%--    <c:forEach items="${ plans }" var="plan">--%>
<%--        <option><a href="/edit/p/${ plan.id }">${ plan.name } </a>                  </option>--%>
<%--    </c:forEach>--%>
<%--</select>--%>
<%--<a4>expenses</a4>--%>
<%--<select name="expenes" size="2">--%>
<%--    <c:forEach items="${ expenses }" var="expense">--%>
<%--        <option><a href="/edit/e/${ expense.id }"> ${ expense.description }</a>         </option>--%>
<%--    </c:forEach>--%>
<%--</select>--%>
<hr>
<c:if test = "${testa > 0}">
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
    <c:if test = "${testa == 0}">
<hr>
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
        <c:if test = "${test < 0}">
<hr>
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

</body>
</html>
