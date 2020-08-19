<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>

<div class="container p-2">
    <h2>Select user</h2>
</div>
<table class="table table-hover table-responsive">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td><a href="${contextPath}/users/${user.id}/bookings">view </a> </td>
        </tr>
    </c:forEach>
</table>