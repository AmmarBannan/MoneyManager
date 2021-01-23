<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--    <title>Welcome Page</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Welcome Page <c:out value="${currentUser.username}"></c:out></h1>--%>

<%--<form id="logoutForm" method="POST" action="/logout">--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--    <input type="submit" value="Logout!" />--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->--%>
<%--    <meta name="description" content="">--%>
<%--    <meta name="author" content="">--%>

<%--    <title>Create an account</title>--%>

<%--    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>

<%--    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
<%--    <!--[if lt IE 9]>--%>
<%--    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
<%--    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
<%--    <![endif]-->--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>

<%--    <c:if test="${pageContext.request.userPrincipal.name != null}">--%>
<%--        <form id="logoutForm" method="POST" action="${contextPath}/logout">--%>
<%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--        </form>--%>

<%--        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>--%>

<%--    </c:if>--%>

<%--</div>--%>
<%--<!-- /container -->--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome Page</title>
</head>
<body>
<h1>Welcome Page <c:out value="${currentUser.username}"></c:out></h1>
<a href="/user">Setting</a>
<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!"/>
</form>

<a href="/incomes/new">Addincome</a>
<a href="/plan/new">add plan</a>
<a href="/expense/new">add expense</a>
<a href="/history">history</a>
<a href="/category/new">add category</a>
<table>
    <thead>
    <tr><th>Amount</th><th>description</th><th>date</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${ incomes }" var="income">
        <tr>
            <td>${ income.amount }</td>
            <td>${ income.description}</td>
            <td>${ income.createdAt}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<h3>plan</h3>
<table>
    <thead>
    <tr><th>name</th><th>data</th><th>maxlimit</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${ plans }" var="plan">
        <tr>
            <td>${ plan.name }</td>
            <td>SD/${ plan.start_datez}  ED/${ plan.end_datez}</td>
            <td>${ plan.limitz}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>Total balance:${ balance }</h2>
</body>
</html>