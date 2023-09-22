<%-- 
    Document   : incomeadd
    Created on : Sep 2, 2023, 3:19:56 PM
    Author     : defaultuser0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-1">ADD INCOME</h1>

<c:url value="/incomes/add" var="action"/>
<form:form method="post" action="${action}" modelAttribute="income" enctype="multipart/form-data">
    <form:hidden path="id"/> 
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" min='0'
                    path="amount" id="amount" placeholder="input amount"/>         
        <label for="amount">Amount</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select type="text" class="form-control" 
                     path="type" id="type" placeholder="input type" >
            <option selected>Income</option>
        </form:select>
        <label for="type"></label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" 
                    path="title" id="title" placeholder="input title"/>
        <label for="title">Title</label>
        <form:errors path="title" element="div" cssClass="text-danger" />
    </div>

    <div class="form-floating">
        <form:textarea class="form-control" 
                       path="description" id="description" placeholder="input description"/>
        <label for="description">Description</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="date" class="form-control"
                    path="date" id="date" placeholder="input date"/>
        <label for="date" >date</label>
    </div>

    <div class="form-floating">
        <form:select class="form-select" id="category" name="category" path="categoryId">
            <c:forEach items="${categories}" var="c">
                <c:if  test="${c.type == 'Income'}">
                    <option value="${c.id}">${c.name}</option>
                </c:if>
            </c:forEach>
        </form:select>
        <label for="category" class="form-label">Select list categories</label>
    </div>

    <div class ="form-floating mt-1">
        <button class="btn btn-info">
            <c:choose>
                <c:when test="${income.id == null}">
                    Add Income
                </c:when>
                <c:otherwise>
                    Update Income
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>

