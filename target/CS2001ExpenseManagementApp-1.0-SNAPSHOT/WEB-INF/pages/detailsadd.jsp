<%-- 
    Document   : detailsadd
    Created on : Sep 10, 2023, 3:58:02 PM
    Author     : defaultuser0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<c:url value="/details/${id}/add" var="action"/>
<h1>ADD USER FOR GROUP</h1>
<form:form method="post" action="${action}" modelAttribute="users">
    <div class="form-floating">
        <form:select class="form-select" id="username" name="username" path="id">
            <c:forEach items="${user}" var="u">
                <option value="${u.id}" selected>${u.username} - ${u.id}</option>
            </c:forEach>
        </form:select>
        <label for="category" class="form-label">Select list categories</label>
    </div>
    <div class ="form-floating mt-1">
        <button class="btn btn-info">
            Add Expense
        </button>
    </div>
</form:form>
