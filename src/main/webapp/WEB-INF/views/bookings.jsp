<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>

<div class="container p-2">
    <h2>User Bookings:</h2>
</div>
<table class="table table-hover table-responsive">
    <tr>
        <th>Id</th>
        <th>Date from</th>
        <th>Date to</th>
        <th>Room</th>
        <th>Hotel</th>
    </tr>
    <c:forEach var="booking" items="${bookings}">
        <tr>
            <td>${booking.id}</td>
            <td>${booking.from}</td>
            <td>${booking.to}</td>
            <td>${booking.room}</td>
            <td>${booking.room.hotel}</td>
            <td><a href="${contextPath}/booking/${booking.id}/cancel_page">cancel </a> </td>
        </tr>
    </c:forEach>
</table>