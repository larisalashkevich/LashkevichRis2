<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/css/style.css"%></style>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotels Search</title>
</head>
<body>
<h1>Hotels Search</h1>
<form action="/ris2/hotels" method="GET">
    <label for="availability">Availability:</label>
    <select id="availability" name="availability">
        <option value="available">Available</option>
        <option value="unavailable">Unavailable</option>
    </select>
    <br>
    <label for="minPrice">Minimum Price:</label>
    <input type="number" id="minPrice" name="minPrice" required>
    <br>
    <label for="maxPrice">Maximum Price:</label>
    <input type="number" id="maxPrice" name="maxPrice" required>
    <br>
    <input type="submit" value="Search">
</form>

<h2>Hotel List:</h2>
<table>
    <tr>
        <th>Title</th>
        <th>Stars</th>
        <th>Price</th>
        <th>Availability</th>
    </tr>
    <c:forEach var="hotel" items="${hotels}">
        <tr>
            <td class="hotel-title"><c:out value="${hotel.title}" /></td>
            <td class="hotel-stars"><c:out value="${hotel.stars}" /></td>
            <td class="hotel-price"><c:out value="${hotel.price}" /></td>
            <td class="hotel-availability"><c:out value="${hotel.available ? 'Available' : 'Unavailable'}" /></td>
            <td class="hotel-action">
                <form action="/ris2/hotels" method="POST">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="hidden" name="id" value="${hotel.id}">
                    <input type="submit" value="DELETE">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>