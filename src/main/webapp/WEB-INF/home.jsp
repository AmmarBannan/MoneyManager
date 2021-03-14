
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<body>


<h3>Welcome <c:out value="${currentUser.username}"></c:out></h3>




<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" >MoneyManager</a>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/incomes/new">Addincome</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/plan/new">add plan</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/expense/new">add Expense</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/edit/i/1">edit</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/history">history</a>
                </li>

            </ul>
            <input href="/user" type="submit" value="setting"/> |
            <form id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Logout!"/>
            </form>

        </div>
    </div>
</nav>
<%--<a href="/incomes/new">Add income</a>--%>
<%--<a href="/plan/new">add plan</a>--%>
<%--<a href="/expense/new">add expense</a>--%>
<%--<a href="/history">history</a>--%>
<%--<a href="/category/new">add category</a>--%>
<%--<a href="/edit/i/1">edit</a>--%>

<div style="display: inline-flex">
<div style="display: block">
<h3 style="font-family: 'Arabic Typesetting'"> notes</h3>

<div class="list-group" style=" overflow:auto;height:250px;width:325px; margin-right:100px"  >
    <c:forEach items="${ notes }" var="note">
        <label class="list-group-item">
        <input class="form-check-input me-1" type="checkbox" value="">
            ${ note.description }
    </label>
    </c:forEach>
</div>
<form:form action="/newnote" method="POST" modelAttribute="note">
    <p>
        <input type="submit" value="write a note"/>
        <form:errors path="description"/>
        <form:input path="description" class="input"/>
    </p>
</form:form>
</div>
    <div style="display: blockoverflow:auto;">
        <caption>Incomes</caption>
        <table class="table caption-top" style="overflow:auto;height:200px;width:30%" >

            <thead>
            <tr>
                <th scope="col">description</th>
                <th scope="col">date</th>
                <th scope="col">Amount</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ incomes }" var="income">
                <tr>
                    <td>${ income.description}</td>
                    <td>${ income.createdAt}</td>
                    <td>${ income.amount }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="list-group" style=" overflow:auto;height:250px;width:400px; margin-right:100px"  >
        <caption>Plans</caption>
        <table class="table caption-top" style="overflow:auto;" >

            <thead>
            <tr>
                <th scope="col">description</th>
                <th scope="col">date</th>
                <th scope="col">Amount</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ plans }" var="plan">
                <tr>
                    <td>${ plan.name }</td>
                    <td style="font-size: 8px">${ plan.start_datez} <br>To ${ plan.end_datez}</td>
                    <td>${ plan.limitz}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div style="float: right">
            <form:form action="/category/new" method="POST" modelAttribute="category">
                <p>
                    <input type="submit" value="add new category"/>
                    <form:errors path="name"/>
                    <form:input path="name" class="input"/>
                </p>
            </form:form>
        </div>
    </div>
</div>





<div style="display:inline-flex ">
<div style="align-content: center;width:600px " >
    <div >
        <c:if test = "${balance < 0}">
        <h2 style="color: darkred">Total balance:${ balance }</h2
            <h4 style="color: red">you have debits</h4>
        </c:if>
        <c:if test = "${balance > 0}">
            <h2 style="color: darkgreen">Total balance:${ balance }</h2>
        </c:if>
        <canvas id="myChart"></canvas>
    </div>

    <script>

        let xd = [];
        <c:forEach items="${values}" var="y">
        xd.push(${y.intValue()});
        </c:forEach>
        console.log(xd);
        let yd = [];
        <c:forEach items="${dates}" var="y">
        yd.push(${y.intValue()});
        </c:forEach>
        console.log(yd);
        <%--var vals=val;--%>
        <%--var dates = ${ values.values };--%>
        // console.log("hello", document.getElementById('date')," Hi", vals);

        let myChart=document.getElementById('myChart').getContext('2d');
        let barChart = new Chart(myChart,{
            type:'line',
            data:{
                labels:yd,
                datasets:[{
                    label: 'amount',
                    data:xd
                }]
            },
            option:{}
        });
    </script>

</div>

<div div style="align-content: center;width:600px ">
    <div >
        <canvas id="Chart"></canvas>
    </div>

    <script>

        let xx = [];
        <c:forEach items="${persent}" var="y">
        xx.push(${y.intValue()});
        </c:forEach>
        console.log(xx);
        let yy = [];
        <c:forEach items="${categories}" var="y">
        yy.push("${y}");
        </c:forEach>
        console.log(yy);
        <%--var vals=val;--%>
        <%--var dates = ${ values.values };--%>
        // console.log("hello", document.getElementById('date')," Hi", vals);

        let ffff=document.getElementById('Chart').getContext('2d');
        let yyy = new Chart(ffff,{
            type:'pie',
            data:{
                labels:yy,
                datasets:[{
                    label: 'amount',
                    data:xx,backgroundColor:[
                        'rgba(0,0,0,1) ' ,
                        'rgba(255,255,255,1) ',
                        'rgba(100,100,100,1) ',
                        'rgba(210,210,210,1) ',
                        'rgba(50,40,50,0.3) ',
                        'rgba(192,192,192,1) ',
                    ]
                }]
            },
            option:{}
        });
    </script>

</div>
    </div>








</div>








<%--///////////////////////////--%>

<%--<input type="hidden" id="date" items="${dates}">--%>
<%--<input type="hidden" id="val" value="${ values }">--%>
<%--<br>--%>
<%--<c:forEach items="${ dates }" var="plan">--%>
<%--    <tr>--%>
<%--        <td>${plan}</td>/--%>
<%--    </tr>--%>
<%--</c:forEach>--%>
<%--<br>--%>
<%--<c:forEach items="${ values }" var="plan">--%>
<%--    <tr>--%>
<%--        <td>${ plan}</td>/--%>
<%--    </tr>--%>
<%--</c:forEach>--%>
<%--<br>--%>
<%--///////////////////////////////////////--%>
<%--<br>--%>
<%--<c:forEach items="${ categories }" var="plan">--%>
<%--    <tr>--%>
<%--        <td>${ plan}</td>/--%>
<%--    </tr>--%>
<%--</c:forEach>--%>
<%--<br>--%>
<%--<c:forEach items="${ persent }" var="plan">--%>
<%--    <tr>--%>
<%--        <td>${ plan}</td>/--%>
<%--    </tr>--%>
<%--</c:forEach>--%>
<%--<br>--%>
<%--////////////////////////////--%>
<br>
       <center>  <a5> @edit by diaa</a5></center>
</body>
</html>