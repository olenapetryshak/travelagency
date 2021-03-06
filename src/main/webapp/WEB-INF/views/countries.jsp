<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>

<div class="container p-2">
    <h2>Select country</h2>
</div>
<table class="table table-hover table-responsive">
    <tr>
        <th>Name</th>
    </tr>
    <c:forEach var="country" items="${countries}">
        <tr>
            <td>${country.name}</td>
            <td><a href="${contextPath}/hotels?countryId=${country.id}">view </a> </td>
        </tr>
    </c:forEach>
</table>