<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="header.jsp"/>

<div class="card">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Our hotels</h3>
    <div class="card-body">
        <div id="table" class="table-editable">
            <form class="form=-group">
                <div class="input-group">
                    <select class="custom-select" name="countryId">
                        <option selected>${currentCountry.name}</option>
                        <c:forEach items="${countries}" var="country">
                            <option value="${country.id}">
                                    ${country.name}
                            </option>
                        </c:forEach>
                    </select>
                    <div class="input-group-append">
                        <input type="submit" class="btn btn-primary" value="Select country">
                    </div>
                </div>
            </form>
            <a href="/hotels" class="bnt bnt-success">See all</a>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <thead>
                <tr>
                    <th class="text-center">Name</th>
                    <th class="text-center"></th>
                    <sec:authorize access="hasRole('MANAGER')">
                        <th class="text-center">Add room</th>
                    </sec:authorize>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="hotel" items="${hotels}">
                    <tr>
                        <td>${hotel.name}</td>
                        <td><a href="/hotels/${hotel.id}/hotel">view </a></td>
                        <sec:authorize access="hasRole('MANAGER')">
                            <td>
                    <a href="/hotels/${hotel.id}/rooms"
                                                  class="btn btn-danger btn-rounded btn-sm my-0">Add Room</a>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
<sec:authorize access="hasRole('MANAGER')">
     <span class="table-add float-right mb-3 mr-2"><a href="/hotels/new" class="btn btn-success" >Add hotel</a></span>
</sec:authorize>

    </div>
</div>
