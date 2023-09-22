<%-- 
    Document   : signup
    Created on : Aug 24, 2023, 12:24:39 PM
    Author     : defaultuser0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class = "text-center text-danger">REGISTER</h1>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <form:input type="email" class="form-control" for="email"
                    id="email" placeholder="Enter email..." path="email"/>
        <label for="email" class="form-label">email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" for="firstName"
                    id="firstName" placeholder="Enter firstName..." path="firstName"/>
        <label for="firstName" class="form-label">FirstName</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" for="lastName"
                    id="lastName" placeholder="Enter lastName..." path="lastName"/>
        <label for="lastName" class="form-label">LastName</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" for="lastName"
                    id="phone" placeholder="Enter phone..." path="phone"/>
        <label for="phone" class="form-label">Phone</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" for="username"
                    id="username" placeholder="Enter username..." path="username"/>
        <label for="username" class="form-label">Username</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" for="file"
                    id="file" placeholder="Enter avatar..." path="file"/>
        <label for="avatar" class="form-label">Avatar</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" for="password"
                    class="form-control" id="password" placeholder="Enter password..." path="password"/>
        <label for="password" class="form-label">Password</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" for="confirm-password"
                    class="form-control" id="confirm-password" placeholder="Enter confirmpassword..." path="confirmPassword"/>
        <label for="password" class="form-label">ConfimPassword</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <input type="submit" value="register" class="btn btn-danger" />
    </div>
</form:form>
