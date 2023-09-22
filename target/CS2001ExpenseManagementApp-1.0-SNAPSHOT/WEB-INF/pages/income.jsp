<%-- 
    Document   : income
    Created on : Sep 1, 2023, 11:17:37 PM
    Author     : defaultuser0
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<c:url value="/js/main.js"/>"></script>
<!DOCTYPE html>
<c:url value="/incomes" var="inc"/>
<section class="container">
    <h1 class="text-center text-info mt-1">LIST INCOME</h1>

    <form class="d-flex justify-content-end" action = "${inc}">
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
            <c:forEach items="${income}" var="i" >
                <tr>
                    <td>${i.id}</td>
                    <td>${i.title}</td>
                    <td>${i.type}</td>
                    <td>${i.amount}</td>
                    <td>${i.description}</td>
                    <td>${i.date}</td>
                    <td>
                        <a href="<c:url value="/incomes/add/${i.id}"/>" class="btn btn-success">Update</a>
                        <c:url value="/api/transactions/${i.id}" var="api"/>
                        <button class="btn btn-danger" onclick="deleteTrans('${api}')">Delete</button>
                    </td>
                </tr>
                <c:set var="amount" value="${i.amount}" />
                <c:set var="totalAmount" value="${totalAmount + amount}" />
            </c:forEach>
        </tbody>
    </table>     
    <h2>Tổng số tiền Thu: ${totalAmount} Đồng</h2>
    <div class="d-flex justify-content-end">
        <a href="<c:url value="/incomes/add"/>" class="btn btn-info mt-1">Add Income</a>
    </div>


    <div class = "d-flex justify-content-center">
        <c:if test = "${counter > 1}">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="${inc}">All page</a></li>
                    <c:forEach begin = "1" end = "${counter}" var = "i">
                        <c:url value = "/incomes" var = "pageUrl">
                            <c:param name = "page" value = "${i}"></c:param>
                        </c:url>
                    <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>

</section>
