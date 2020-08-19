<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="header.jsp"/>

<div class="container p-2">
    <h2><sec:authentication property="name"/>, you are welcome to Travel-Agency</h2>
</div>

<div class="row justify-content-center">
    <div class="justify-content-center">
        <button class="btn btn-success btn-lg" onclick="window.location='/countries'">
            Search
        </button>
    </div>
</div>