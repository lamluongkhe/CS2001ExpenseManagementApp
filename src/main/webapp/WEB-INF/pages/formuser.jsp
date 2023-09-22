<%-- 
    Document   : formuser
    Created on : Sep 2, 2023, 10:02:33 PM
    Author     : defaultuser0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:url value="/formusers" var="formU"/>
<section class="container">
    <h1 class="text-center text-info mt-1">LIST USER</h1>
    <table class="table table-hover">
        <thead>
            <tr class="btn-info">
                <th>Id</th>
                <th>Email</th>
                <th>LastName</th>
                <th>FirstName</th>
                <th>Phone</th>
                <th>Active</th>
                <th></th>
            </tr>
        </thead>
        <tbody>

            <c:forEach items="${user}" var="u">
                <c:if test="${u.userRole == 'ROLE_USER'}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.email}</td>
                        <td>${u.lastName}</td>
                        <td>${u.firstName}</td>
                        <td>${u.phone}</td>
                        <td>${u.active}</td>
                        <td>
                            <a href="<c:url value="/formusers/update/${u.id}"/>" class="btn btn-success">Update</a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
    <!--    <div class="d-flex justify-content-end">
            <a href="<c:url value="/formusers/update"/>" class="btn btn-info mt-1">Add Income</a>
        </div>-->
    <div class = "d-flex justify-content-center">
        <c:if test = "${counter > 1}">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="${inc}">All page</a></li>
                    <c:forEach begin = "1" end = "${counter}" var = "counter">
                        <c:url value = "/incomes" var = "pageUrl">
                            <c:param name = "page" value = "${counter}"></c:param>
                        </c:url>
                    <li class="page-item"><a class="page-link" href="${pageUrl}">${counter}</a></li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>

</section>
