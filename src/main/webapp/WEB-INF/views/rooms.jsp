<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>

<div class="container p-2">
    <h2>Select room</h2>
</div>
<table class="table table-hover table-responsive">
    <tr>
        <th>price</th>
        <th>type</th>
    </tr>
    <c:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.price}</td>
            <td>${"some type"}</td>
        </tr>
    </c:forEach>
</table>
