<%-- 
    Document   : groupadd
    Created on : Sep 9, 2023, 9:47:04 PM
    Author     : defaultuser0
--%>

<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
crossorigin="anonymous"></script>
<c:url value="/groups/add" var="action"/>
<form:form method="post" action="${action}" modelAttribute="group" enctype="multipart/form-data"> 
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control"
                    path="name" id="name" placeholder="input name"/>         
        <label for="name">name</label>
    </div>
     <div class ="form-floating mt-1">
        <button class="btn btn-info">
            <c:choose>
                <c:when test="${group.id == null}">
                    Add Income
                </c:when>
                <c:otherwise>
                    Update Income
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
