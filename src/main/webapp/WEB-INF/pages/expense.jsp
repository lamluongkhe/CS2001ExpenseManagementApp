<%-- 
    Document   : expense
    Created on : Sep 1, 2023, 11:27:24 PM
    Author     : defaultuser0
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<c:url value="/js/main.js"/>"></script>
<!DOCTYPE html>
<c:url value="/expenses" var="exp"/>
<section class="container">
    <h1 class="text-center text-info mt-1">LIST EXPENSE</h1>
    <form class="d-flex justify-content-end" action = "${exp}">
        <h4 class=" me-2 mt-2 mb-2">Lọc từ ngày: </h4>
        <input class="form-control w-25 me-2 mb-2" type="date" name="fromDate" placeholder="FormDate dd/mm/yyyy">
        <h4 class=" me-2 mt-2 mb-2">Lọc đến ngày: </h4>
        <input class="form-control w-25 me-2 mb-2" type="date" name="toDate" placeholder="ToDate dd/mm/yyyy">
        <button class="btn btn-primary me-2 mt-2 mb-2" type="submit">Tìm</button>
    </form>
    <table class="table table-hover">
        <thead>
            <tr class="btn-info">
                <th>Id</th>
                <th>Title</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Description</th>
                <th>Date</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:set var="totalAmount" value="0" />
            <c:forEach items="${expense}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.title}</td>
                    <td>${e.type}</td>
                    <td>${e.amount}</td>
                    <td>${e.description}</td>
                    <td>${e.date}</td>   
                    <td>
                        <a href="<c:url value="/expenses/add/${e.id}"/>" class="btn btn-success">Update</a>
                        <c:url value="/api/transactions/${e.id}" var="apiDel"/>
                        <button class="btn btn-danger" onclick="deleteExpense('${apiDel}')">Delete</button>
                    </td>
                </tr>
                <c:set var="amount" value="${e.amount}" />
                <c:set var="totalAmount" value="${totalAmount + amount}" />
            </c:forEach>

        </tbody>
    </table>

    <h2>Tổng số tiền Chi: ${totalAmount} Đồng</h2>
    <div class="d-flex justify-content-end">
        <a href="<c:url value="/expenses/add"/>" class="btn btn-info mt-1">Add Expense</a>
    </div>
    <div class = "d-flex justify-content-center">
        <c:if test = "${counter > 1}">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="${exp}">All page</a></li>
                    <c:forEach begin = "1" end = "${counter}" var = "counter">
                        <c:url value = "/expenses" var = "pageUrl">
                            <c:param name = "page" value = "${counter}"></c:param>
                        </c:url>
                    <li class="page-item"><a class="page-link" href="${pageUrl}">${counter}</a></li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>

</section>
