<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
<head>
    <title>Meals</title>
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

    <jsp:useBean id="meals" scope="request" type="java.util.List"/>
    <c:forEach items="${meals}" var="meal">
        <tr>
            <c:choose>
                <c:when test="${meal.excess}">
                    <td><font color="red"><c:out value="${meal.id}" /></font></td>
                    <td><font color="red"> <c:out value="${fn:replace(meal.dateTime, 'T', ' ')}" /></font></td>
                    <td><font color="red"><c:out value="${meal.description}" /></font></td>
                    <td><font color="red"><c:out value="${meal.calories}" /></font></td>

                </c:when>
                <c:otherwise>
                    <td><c:out value="${meal.id}" /></td>
                    <td><c:out value="${fn:replace(meal.dateTime, 'T', ' ')}" /></td>
                    <td><c:out value="${meal.description}" /></td>
                    <td><c:out value="${meal.calories}" /></td>
                </c:otherwise>
            </c:choose>


            <td><a href="meals?action=edit&Id=<c:out value="${meal.id}"/>">Update</a></td>
            <td><a href="meals?action=delete&Id=<c:out value="${meal.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>