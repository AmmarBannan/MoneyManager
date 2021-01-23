<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Material Bootstrap Wizard by Creative Tim</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>

    <!-- CSS Files -->
    <%--    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>--%>
    <%--    <link href="assets/css/material-bootstrap-wizard.css" rel="stylesheet"/>--%>
    <%--    <link href="assets/css/demo.css" rel="stylesheet"/>--%>
    <script src="${contextPath}/js/bootstrap.min.js"></script>
    <link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/css/material-bootstrap-wizard.css" rel="stylesheet">
    <link href="${contextPath}/css/demo.css" rel="stylesheet">

    <%--    <link rel="stylesheet" type="text/css"  href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />--%>
    <%--    <c:url value="/css/demo.css" var="jstlCss" />--%>
    <%--    <link href="${jstlCss}" rel="stylesheet" />--%>
    <%--    <c:url value="/css/material-bootstrap-wizard.css" var="jstlCss" />--%>
    <%--    <link href="${jstlCss}" rel="stylesheet" />--%>
</head>

<body>
<div class="image-container set-full-height" style="background-image: url('/img/back.jpg')">

<!-- Big container -->
<div class="container">
<div class="row">
<div class="col-sm-8 col-sm-offset-2">
<!-- Wizard container -->
<div class="wizard-container">
<div class="card wizard-card" data-color="red" id="wizard">
<%--<form action="" method="">--%>
<div class="wizard-header">
    <h3 class="wizard-title">
        Money manager
    </h3>
    <h5>Our Website will help you to manage your expenses and plan your budget</h5>
</div>
<div class="wizard-navigation">
    <ul>
        <li><a href="#details" data-toggle="tab">Registration</a></li>
        <li><a href="#description" data-toggle="tab">Login</a></li>
    </ul>
</div>

<div class="tab-content">
<div class="tab-pane" id="details">
<div class="row">
<div class="col-sm-12">
    <h4 class="info-text">Don't hava account! Register.</h4>
</div>
<form:form method="POST" modelAttribute="user" class="form-signin">
    <div class="col-sm-6">
    <div class="input-group">
    <span class="input-group-addon">
    <i class="material-icons">group</i>
    </span>
    <spring:bind path="username">
        <div class="form-group label-floating ${status.error ? 'has-error' : ''}>
            <form:label path="username" class="control-label">Username</form:label>
            <form:input type="text" path="username" class="form-control"></form:input>
            <form:errors path="username" class="form-control"></form:errors>
        </div>
    </spring:bind>
    </div>

    <div class="input-group">
    <span class="input-group-addon">
    <i class="material-icons">email</i>
    </span>
    <spring:bind path="email">
        <div class="form-group label-floating ${status.error ? 'has-error' : ''}">
            <form:label path="email" class="control-label">Your Email</form:label>
            <form:input type="email" path="email" class="form-control"></form:input>
            <form:errors path="email" class="form-control"></form:errors>
        </div>
    </spring:bind>
    </div>
    </div>
    <div class="col-sm-6">
    <div class="input-group">
    <span class="input-group-addon">
    <i class="material-icons">lock_outline</i>
    </span>
    <spring:bind path="password">
        <div class="form-group label-floating ${status.error ? 'has-error' : ''}">
            <form:label path="email" class="control-label">Your Password</form:label>
            <form:input type="password" path="password" class="form-control"></form:input>
            <form:errors path="password" class="form-control"></form:errors>
        </div>
    </spring:bind>
    </div>
    <div class="input-group">
    <span class="input-group-addon">
    <i class="material-icons">lock_outline</i>
    </span>
    <spring:bind path="passwordConfirmation">
        <div class="form-group label-floating ${status.error ? 'has-error' : ''}">
            <form:label path="passwordConfirmation" class="control-label">Confirm Password</form:label>
            <form:input type="password" path="passwordConfirmation" class="form-control"></form:input>
            <form:errors path="passwordConfirmation" class="form-control"></form:errors>
        </div>
    </spring:bind>
    </div>
    </div>
    <button class='btn btn-previous btn-fill btn-danger btn-wd' type="submit">Submit</button>
</form:form>
    </div>
    </div>
    <%--    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>--%>


    <form method="POST" action="${contextPath}/login" class="form-signin">


        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input  type="text" name="email" class="form-control" />
            <input name="password" type="password" class="form-control" />
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>


    <div class="tab-pane" id="description">
        <form method="POST" action="${contextPath}/login" class="form-signin">
    <div class="row ${error != null ? 'has-error' : ''}">
    <div class="col-sm-12">
    <h4 class="info-text">Welcome back! login to your account.</h4>
    </div>
    <div class="col-sm-6">
    <div class="input-group">
    <span class="input-group-addon">
    <i class="material-icons">email</i>
    </span>
    <div class="form-group label-floating">

    <label class="control-label">Your Email</label>
    <input name="email" type="email" class="form-control"/>
        <span>${message}</span>
    </div>
    </div>
    </div>
    <div class="col-sm-6">
    <div class="input-group">
    <span class="input-group-addon">
    <i class="material-icons">lock_outline</i>
    </span>
    <div class="form-group label-floating">
    <label class="control-label">Your Password</label>
    <input name="password" type="password" class="form-control" />
        <span>${error}</span>
    </div>
    </div>
    </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
    <!-- <div class="tab-pane" id="description">
    <div class="row">
    <h4 class="info-text"> </h4>
    <div class="col-sm-6 col-sm-offset-1">
    <div class="form-group">
    <label>Room description</label>
    <textarea class="form-control" placeholder="" rows="6"></textarea>
    </div>
    </div>
    <div class="col-sm-4">
    <div class="form-group">
    <label class="control-label">Example</label>
    <p class="description">"The room really nice name is recognized as being a really awesome room. We use it every sunday when we go fishing and we catch a lot. It has some kind of magic shield around it."</p>
    </div>
    </div>
    </div>
    </div> -->
    <div class="wizard-footer">
    <div class="pull-right">
    <input type='button' class='btn btn-next btn-fill btn-danger btn-wd' name='next'
    value='Next'/>

    </div>
    <div class="pull-left">
    <input type='button' class='btn btn-previous btn-fill btn-danger btn-wd'
    name='previous'
    value='Previous'/>


    </div>
    <div class="clearfix"></div>
    </div>
    </div>
    </div> <!-- wizard container -->
    </div>
    </div> <!-- row -->
    </div> <!-- big container -->

    <div class="footer">
    <div class="container text-center">
    Made with <i class="fa fa-heart heart"></i> by Money Manager Team </a>Mais Ammar Nidal</a>
    </div>
    </div>
    </div>

</body>
    <!-- Core JS Files -->
    <script src="/js/jquery-2.2.4.min.js" type="text/javascript"></script>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/js/jquery.bootstrap.js" type="text/javascript"></script>

    <!-- Plugin for the Wizard -->
    <script src="/js/material-bootstrap-wizard.js"></script>

    <!-- More information about jquery.validate here: http://jqueryvalidation.org/ -->
    <script src="/js/jquery.validate.min.js"></script>


</html>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--<meta charset="utf-8">--%>
<%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->&ndash;%&gt;--%>
<%--<meta name="description" content="Money Managment">--%>
<%--<meta name="author" content="">--%>

<%--<title>Create an account</title>--%>

<%--<link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">--%>
<%--<link href="${contextPath}/static/css/common.css" rel="stylesheet">--%>
<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>--%>
<%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>

<%--<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
<%--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>

<%--</head>--%>

<%--<body>--%>

<%--<div class="container">--%>

<%--<form:form method="POST" modelAttribute="user" class="form-signin">--%>
<%--   <h2 class="form-signin-heading">Create your account</h2>--%>
<%--  <spring:bind path="username">--%>
<%--     <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--          <form:input type="text" path="username" class="form-control" placeholder="Username"--%>
<%--                       autofocus="true"></form:input>--%>
<%--            <form:errors path="username"></form:errors>--%>
<%--       </div>--%>
<%--    </spring:bind>--%>

<%--   <spring:bind path="email">--%>
<%--        <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--           <form:input type="email" path="email" class="form-control" placeholder="Email"--%>
<%--                       autofocus="true"></form:input>--%>
<%--          <form:errors path="email"></form:errors>--%>
<%--        </div>--%>
<%--   </spring:bind>--%>

<%--   <spring:bind path="password">--%>
<%--        <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--          <form:input type="password" path="password" class="form-control"--%>
<%--                      placeholder="Password"></form:input>--%>
<%--           <form:errors path="password"></form:errors>--%>
<%--       </div>--%>
<%--    </spring:bind>--%>

<%--   <spring:bind path="passwordConfirmation">--%>
<%--       <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--            <form:input type="password" path="passwordConfirmation" class="form-control"--%>
<%--                       placeholder="Confirm your password"></form:input>--%>
<%--          <form:errors path="passwordConfirmation"></form:errors>--%>
<%--       </div>--%>
<%--  </spring:bind>--%>

<%-- <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>--%>
<%--</form:form>--%>
<%--</div>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>