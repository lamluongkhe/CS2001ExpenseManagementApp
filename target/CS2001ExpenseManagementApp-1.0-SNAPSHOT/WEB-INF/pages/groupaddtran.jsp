<%-- 
    Document   : groupaddtran
    Created on : Sep 11, 2023, 11:24:18 PM
    Author     : defaultuser0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-1">EXPENSE MANAGEMENT</h1>

<c:url value="/groups/transactions/${id}/addtrans" var="action"/>
<form:form method="post" action="${action}" modelAttribute="transaction" enctype="multipart/form-data">
    <!--    Dinh lai Id cua san pham khi update-->
    <form:hidden path="id"/> 
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" 
                    path="amount" id="amount" placeholder="input amount"/>
        <label for="amount">Amount</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" 
                    path="type" id="type" placeholder="input type"/>
        <label for="type">Type</label>
        <form:errors path="type" element="div" cssClass="text-danger" />
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
                <c:choose>
                    <c:when test="${c.id == transaction.categoryId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="category" class="form-label">Select list categories</label>
    </div>

    <div class ="form-floating mt-1">
        <button class="btn btn-info">
            <c:choose>
                <c:when test="${transaction.id == null}">
                    Add Transaction
                </c:when>
                <c:otherwise>
                    Update Transaction
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
