<%--
  Created by IntelliJ IDEA.
  User: pccorner
  Date: ٢٠/٠١/٢٠٢١
  Time: ٠٦:٢٣ م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${user.username}</h1>
<form:form action="/plan/new" method="POST" modelAttribute="plan">
    <p>
        <form:label path="name">name</form:label>
        <form:input path="name" class="input" />
    </p>
    <p>
        <form:label path="limitz">limit Money</form:label>
        <form:errors path="limitz"/>
        <form:input path="limitz"/>
    </p>
    <p>
        <form:label path="start_datez">start date</form:label>
        <form:errors path="start_datez"/>
        <form:input  path="start_datez" type="date"/>
    </p>
    <p>
        <form:label path="end_datez">end date</form:label>
        <form:errors path="end_datez"/>
        <form:input  path="end_datez" type="date"/>
    </p>

    <input type="submit" value="Submit"/>
</form:form>


</body>
</html>