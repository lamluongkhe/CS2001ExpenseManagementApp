 
<!--Document   : formuserupdate
Created on : Sep 2, 2023, 10:40:49 PM
Author     : defaultuser0-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-1">ADD EXPENSE</h1>

<c:url value="/formusers/update" var="action"/>
<form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
    <form:hidden path="id"/> 
    <form:hidden path="avatar"/> 
    <form:hidden path="password"/> 
    <form:hidden path="username"/> 
    <form:hidden path="email"/> 
    <form:hidden path="firstName"/> 
    <form:hidden path="lastName"/> 
    <form:hidden path="phone"/> 
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" for="file"
                    id="file" placeholder="Enter avatar..." path="file"/>
        <label for="avatar" class="form-label">Avatar</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:select class="form-control" 
                     path="active" id="active" placeholder="input active" >
            <option value="true" selected>True</option>
            <option value="false" selected>False</option>
        </form:select>
        <label for="active"></label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-control" 
                     path="userRole" id="userRole" placeholder="input userRole" >
            <option  selected>ROLE_USER</option>
        </form:select>
        <label for="active"></label>
    </div>   

    <div class ="form-floating mt-1">
        <button class="btn btn-info">
            <c:choose>
                <c:when test="${user.id == null}">
                    Add User
                </c:when>
                <c:otherwise>
                    Update User
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
