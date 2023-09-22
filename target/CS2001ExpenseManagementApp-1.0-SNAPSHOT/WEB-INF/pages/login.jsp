<%-- 
    Document   : login
    Created on : Aug 24, 2023, 9:18:52 AM
    Author     : defaultuser0
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class = "text-center text-danger">LOGIN</h1>
<c:url value="/login" var="action"/>
<c:if  test="${param.error != null }">
    <div class = "alert alert-danger">
        Username or Password error!!!
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class = "alert alert-danger">
        You don't have access !!!
    </div>
</c:if>
<form method="post" action="${action}" >
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="username" placeholder="Enter email..." name="username">
        <label for="username" class="form-label">Username</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="password" class="form-control" id="password" placeholder="Enter password..." name="password">
        <label for="password" class="form-label">Password</label>
    </div>
  

    <div class="d-flex justify-content-center">
        <input type="submit" value="login" class="btn btn-danger" />
    </div>
      <div class="d-flex justify-content-end">
          <span>Please <a href="<c:url value="/register"/>" style="text-decoration: none"> REGISTER </a> at here</span>
    </div>
</form>





