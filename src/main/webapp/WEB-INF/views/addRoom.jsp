<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="header.jsp"/>

<style type="text/css">
    .error {
        color: red;
    }
</style>
<body>

<div class="container">

    <br/>
</div>

<div class="container p-4 my-2 border">
    <div class="row">
        <div class="col align-self-center">
            <springForm:form modelAttribute="room" action="/rooms/new" method="post">
                <springForm:hidden path="id"/>
                <springForm:hidden path="hotelId"/>
                <div class="form-group">
                    <label for="price">Price</label>
                    <springForm:input path="price" class="form-control" id="price"
                                      cssErrorClass="form-control is-invalid"/>
                    <springForm:errors path="price" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="type">Type</label>
                    <springForm:input path="type" class="form-control" id="type"
                                      cssErrorClass="form-control is-invalid"/>
                    <springForm:errors path="type" cssClass="error"/>
                </div>
                <input type="submit" value="create">
            </springForm:form>
        </div>
    </div>
</div>

</body>
</html>