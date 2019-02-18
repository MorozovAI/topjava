<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 18.02.2019
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>MEAL</title>
</head>
<body>
<form method="POST" action='meals' name="edit">
    <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealTo"/>
    ID : <input type="text" readonly="readonly" name="ID"
                     value="<c:out value="${meal.id}" />" /> <br />
    Description : <input
        type="text" name="Description"
        value="<c:out value="${meal.description}" />" /> <br />
    Calories : <input
        type="text" name="Calories "
        value="<c:out value="${meal.calories}" />" /> <br />
    Datetime : <input
        type="text" name="dob"
        value="<fmt:formatDate pattern="MM/dd/yyyy" value="${meal.dateTime}" />" /> <br />
</form>
</body>
</html>
