
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/incomes">Dashboard</a>
<h1>Welcome Page <c:out value="${user.username}"></c:out></h1>
<%--<form th:action="/expense/new" method="post">--%>
<%--    <div>--%>
<%--        <label for="amount" id="amount">amount</label>--%>
<%--        <input type="number" name="amount"/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <label for="description" id="description">description</label>--%>
<%--        <textarea name="description" id="comment" cols="20" rows="4"></textarea>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <span><c:out value="${ error }" /></span>--%>
<%--        <label id="date" for="date">date</label>--%>
<%--        <input type="date" name="amount"  />--%>
<%--    </div>--%>
<%--    <input type="hidden" value="${_csrf.token}"/>--%>
<%--    <button>Send</button>--%>
<%--</form>--%>
<form:form action="/expense/new" method="POST" modelAttribute="expense">
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
        <form:label path="date">date</form:label>
        <form:errors path="date"/>
        <form:input  path="date" type="date"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
