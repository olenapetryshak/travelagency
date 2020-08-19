<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<table class="table table-hover table-responsive">
    <tr>
        <th>price</th>
        <th>type</th>
    </tr>
    <c:forEach var="room" items="${availableRooms}">
        <tr>
            <td>${room.price}</td>
            <td>${room.type}</td>
            <td><a href="${contextPath}/booking?from=${from}&to=${to}&roomId=${room.id}">book </a></td>
        </tr>
    </c:forEach>
</table>
