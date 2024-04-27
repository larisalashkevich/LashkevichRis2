<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/css/style.css"%></style>

<html>
<head>
    <title>Hotels</title>
</head>
<body>
<h1>Search Results</h1>
<table>
    <tr>
        <th>Title</th>
        <th>Type</th>
        <th>Tables</th>
        <th>Average Price</th>
        <th>Action</th>
    </tr>
    <c:forEach var="hotel" items="${hotels}">
        <tr>
            <td class="hotel-title"><c:out value="${hotel.title}" /></td>
            <td class="hotel-stars"><c:out value="${hotel.stars}" /></td>
            <td class="hotel-price"><c:out value="${hotel.price}" /></td>
            <td class="hotel-availability"><c:out value="${hotel.available ? 'Available' : 'Unavailable'}" /></td>
            <td class="hotel-action">
                <form action="/ris2/hotels" method="POST">
                    <input type="hidden" name="id" value="${hotel.id}">
                    <input type="submit">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>