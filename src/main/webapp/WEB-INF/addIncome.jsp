<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Income</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
    <script defer
            src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>
<div class="container">
    <div class="myheader">
        <p class="cleardisplayblock">Create a new income</p>
    </div>
    <section>
        <div class="columns">
            <div class="column">

                <%--@elvariable id="income" type=""--%>
                <form:form method="POST" action="/Incomes/new" modelAttribute="income">
                    <table>
                        <tr>
                            <td><form:label path="amount">amount:</form:label></td>
                            <td><form:input path="amount" class="input"/></td>
                                <%--                            <td><form:errors path="amount" /></td> --%>
                        </tr>
                        <tr>
                            <td><form:label path="description">description:</form:label></td>
                            <td><form:input path="description" class="input"/></td>
                                <%--                                 <td><form:errors path="de" /></td> --%>
                        </tr>
                    </table>
                    <div class="buttons has-addons is-centered">
                        <input type="submit" value="Create" class="button"/>
                    </div>
                </form:form>
                <p>
                    <form:errors path="income.*"></form:errors>
                </p>
                <p><c:out value="${errors}"/></p>

            </div>
            <div class="column"></div>
        </div>

    </section>
</div>
</body>
</html>