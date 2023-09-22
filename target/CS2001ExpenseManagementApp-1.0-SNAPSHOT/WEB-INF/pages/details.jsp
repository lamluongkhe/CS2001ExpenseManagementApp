<%-- 
    Document   : details
    Created on : Sep 10, 2023, 3:35:42 PM
    Author     : defaultuser0
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info mt-1">DETAIL GROUP</h1>
<table class="table table-hover">
    <thead>
        <tr class="btn-info">
            <th></th>
            <th></th>
            <th></th>
            <th>Id</th>
            <th>Thành viên trong nhóm</th>
            <th>Vai trò</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${detail}" var="i" >
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>${i.id}</td>
                <td>${i.userId.username}</td>
                <td>${i.roleingroup}</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>

        </c:forEach>
    </tbody>

</table>
<c:forEach items="${groupmember}" var="i">
    <c:if test="${i.roleingroup == 'Admin'}">
        <div class="d-flex justify-content-end">
            <a href="<c:url value="/details/${id}/add"/>" class="btn btn-info mt-1">Add User</a>
        </div>
    </c:if>
</c:forEach>








