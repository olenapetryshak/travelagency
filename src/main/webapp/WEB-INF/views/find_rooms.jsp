<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<head>
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<div class="container">
    <h2 class="form-signin-heading">Enter your dates:</h2>
    <form action="${contextPath}/rooms/available" method="post">
        <input name="hotelId" value="${hotelId}" hidden>
        <label>From <input name="from" placeholder="YYYY-MM-DD"></label>
        <label>To <input name="to" placeholder="YYYY-MM-DD"></label>
        <input type="submit" value="submit">
    </form>
</div>
