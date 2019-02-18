<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Meals</title>

    <style>
        .excess {
            color: red;
        }

        .normal {
            color: green;
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>

<table border=1>
    <thead>
    <tr>
        <th>id</th>
        <th>Время еды</th>
        <th>Описание</th>
        <th>Калории</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${meals}" var="meal">
        <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr class="${meal.excess ? 'excess':'normal'}">

            <td><c:out value="${meal.id}"/></td>
            <td><c:out value="${fn:replace(meal.dateTime, 'T', ' ')}"/></td>
            <td><c:out value="${meal.description}"/></td>
            <td><c:out value="${meal.calories}"/></td>


            <td><a href="meals?action=edit&Id=<c:out value="${meal.id}"/>">Update</a></td>
            <td><a href="meals?action=delete&Id=<c:out value="${meal.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="meals?action=insert">Add Meal</a></p>
</body>
</html>