
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<a href="/incomes">Dashboard</a>
<h1>New Song</h1>
<h1>Welcome Page <c:out value="${currentUser.username}"></c:out></h1>
<form:form action="/incomes/new" method="POST" modelAttribute="income">
    <p>
        <form:label path="amount">Money Amount</form:label>
        <form:errors path="amount"/>
        <form:input path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>
    <p>
        <form:label path="date">Date</form:label>
        <form:errors path="date"/>
        <form:input  path="date" type="date"/>
    </p>

    <input type="submit" value="Submit"/>
</form:form>
