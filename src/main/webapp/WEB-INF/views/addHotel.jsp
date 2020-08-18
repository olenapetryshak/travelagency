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
            <springForm:form modelAttribute="hotel">
                <springForm:hidden path="id"/>
                <div class="form-group">
                    <label for="name">Name</label>
                    <springForm:input path="name" class="form-control" id="name"
                                      cssErrorClass="form-control is-invalid"/>
                    <springForm:errors path="name" cssClass="error"/>
                </div>
                <label for="name">Country</label>
                <springForm:select path="countryId" class="form-control" id="country"
                                   cssErrorClass="form-control is-invalid">
                    <springForm:option value="${null}" label="-------SELECT COUNTRY-------"/>
                    <springForm:options items="${countries}" itemValue="id" itemLabel="name"/>
                </springForm:select>
                <springForm:errors path="countryId" cssClass="error"/>
                <input type="submit" value="create">
            </springForm:form>
        </div>
    </div>
</div>

</body>
</html>