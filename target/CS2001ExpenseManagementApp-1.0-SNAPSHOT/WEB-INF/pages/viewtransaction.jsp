<%-- 
    Document   : viewtransaction
    Created on : Sep 5, 2023, 10:26:01 PM
    Author     : defaultuser0
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<c:url value="/js/main.js"/>"></script>
<!DOCTYPE html>
<c:url value="/viewTrans" var="views"/>
<section class="container">
    <h1 class="text-center text-info mt-1">LIST VIEW</h1>
    <form class="d-flex justify-content-end" action = "${views}">
        <h4 class=" me-2 mt-2">Lọc từ ngày: </h4>
        <input class="form-control w-25 me-2" type="date" name="fromDate" placeholder="FormDate dd/mm/yyyy">
        <h4 class=" me-2 mt-2">Lọc đến ngày: </h4>
        <input class="form-control w-25 me-2" type="date" name="toDate" placeholder="ToDate dd/mm/yyyy">
        <button class="btn btn-primary me-2 mt-2" type="submit">Tìm</button>
    </form>
        
    <form class="d-flex justify-content-end" action = "${views}">
        <h4 class=" me-2 mt-2">Lọc theo Quý của Năm: </h4>
        <input class="form-control w-25 me-2 mt-2 mb-2" type="number" min='0' max='4' name="quarter" placeholder="Input Quarter">
        <input class="form-control w-25 me-2 mt-2  mb-2" type="text" name="year" placeholder="Input year">
        <button class="btn btn-primary me-2 mt-2  mb-2" type="submit">Tìm</button>
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
            </tr>
        </thead>
        <tbody>
            <c:set var="totalAmount" value="0" />
            <c:forEach items="${view}" var="v" >

                <tr>
                    <td>${v.id}</td>
                    <td>${v.title}</td>
                    <td>${v.type}</td>
                    <td>${v.amount}</td>
                    <td>${v.description}</td>
                    <td>${v.date}</td>
                </tr>  
                <c:set var="amount" value="${v.amount}" />
                <c:set var="totalAmount" value="${totalAmount + amount}" />
            </c:forEach>
        </tbody>
    </table>
    <form action = "${views}" id="select">
        <select name="numberItem" onchange="document.getElementById('select').submit();">
            <option value="">Select number show transaction</option>
            <option value="10">10</option>
            <option value="20">20</option>
        </select>
    </form>
    <h1>Tổng số tiền: ${totalAmount} Đồng</h1>
    <c:if test="${totalAmount <= (-500)}">
        <h2 class="text-danger">CHI QUÁ NHIỀU CẦN TIẾT KIỆM LẠI!!!</h2>
    </c:if>
    <div class = "d-flex justify-content-center">
        <c:if test = "${counter > 1}">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="${views}">All page</a></li>
                    <c:forEach begin = "1" end = "${counter}" var = "counter">
                        <c:url value = "/viewTrans" var = "pageUrl">
                            <c:param name = "page" value = "${counter}"></c:param>
                        </c:url>
                    <li class="page-item"><a class="page-link" href="${pageUrl}">${counter}</a></li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>

</section>
