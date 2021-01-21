
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/incomes">Dashboard</a>
<h1>Welcome Page <c:out value="${user.username}"></c:out></h1>
<form:form action="/plan/new" method="POST" modelAttribute="plan">
    <p>
        <form:label path="name">Plan Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="maxlimit">limit Money</form:label>
        <form:errors path="maxlimit"/>
        <form:input path="maxlimit"/>
    </p>
    <p>
        <form:label path="startdate">startdate</form:label>
        <form:errors path="startdate"/>
        <form:input  path="startdate" type="date" name="begin"
                     placeholder="dd-mm-yyyy" value=""
                     min="1997-01-01" max="2030-12-31"/>
    </p>
    <p>
        <form:label path="enddate">enddate</form:label>
        <form:errors path="enddate"/>
        <form:input  path="enddate" type="date"/>
    </p>

    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
