
<%-- 
    Document   : index
    Created on : Aug 21, 2023, 10:24:57 PM
    Author     : defaultuser0
--%>

<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
crossorigin="anonymous"></script>
<script src="<c:url value="/js/main.js"/>"></script>
<c:url value="/" var="action" />
<se:authorize access="hasRole('ROLE_ADMIN')">

    <!--Trang giao dich-->

    <section class="container">
        <h1 class="text-center text-info mt-1">LIST EXPENSE</h1>
        <table class="table table-hover">
            <thead>
                <tr class="btn-info">
                    <th>Id</th>
                    <th>Title</th>
                    <th>Type</th>
                    <th>Amount</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${transactions}" var="t">
                    <tr>
                        <td>${t.id}</td>
                        <td>${t.title}</td>
                        <td>${t.type}</td>
                        <td>${t.amount}</td>
                        <td>${t.description}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-end">
            <a href="<c:url value="/transactions"/>" class="btn btn-info mt-1">Add Expense</a>
        </div>
        <div class = "d-flex justify-content-center">
            <c:if test = "${counter > 1}">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="${action}">All page</a></li>
                        <c:forEach begin = "1" end = "${counter}" var = "i">
                            <c:url value = "/" var = "pageUrl">
                                <c:param name = "page" value = "${i}"></c:param>
                            </c:url>
                        <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                        </c:forEach>
                </ul>
            </c:if>
        </div>

    </section>
</se:authorize>
<se:authorize access="hasRole('ROLE_USER')">
    

</se:authorize>



