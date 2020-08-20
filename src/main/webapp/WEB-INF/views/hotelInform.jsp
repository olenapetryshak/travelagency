<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="header.jsp"/>

<div class="container p-2">
    <h2><sec:authentication property="name"/>, you can book a room in this hotel: </h2>
</div>
<table class="table table-bordered table-responsive-md table-striped text-center">
    <thead>
    <tr>
        <th class="text-center">Hotel id</th>
        <th class="text-center">Name</th>
        <th class="text-center">Country</th>
        <th class="text-center"></th>
    </tr>
    </thead>
    <tbody>
    <tr modelAttribute="booking">
        <td>${hotel.id}</td>
        <td>${hotel.name}</td>
        <td>${hotel.country}</td>
        <td><a href="/hotels/${hotel.id}/find_rooms" class="btn btn-danger btn-rounded btn-sm my-0">Book</a>
        </td>

    </tr>
    </tbody>
</table>
</div>
</div>
