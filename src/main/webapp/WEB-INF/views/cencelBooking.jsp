<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="header.jsp"/>

<div class="container p-2">
    <h2><sec:authentication property="name"/>, you can cancel booking: </h2>
</div>
<table class="table table-bordered table-responsive-md table-striped text-center">
    <thead>
    <tr>
        <th class="text-center">Id</th>
        <th class="text-center">From</th>
        <th class="text-center">To</th>
        <th class="text-center">Room</th>
        <th class="text-center"></th>
    </tr>
    </thead>
    <tbody>
    <tr modelAttribute="booking">
        <td>${booking.id}</td>
        <td>${booking.from}</td>
        <td>${booking.to}</td>
        <td>${room.type}</td>
        <td><a href="/booking/${booking.id}/cancel" class="btn btn-danger btn-rounded btn-sm my-0">Cancel Booking</a>
        </td>

    </tr>
    </tbody>
</table>
</div>
</div>
