<%-- 
    Document   : group
    Created on : Sep 8, 2023, 9:30:40 PM
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
<c:url value="/groups" var="action"/>
<section class="container">
    <h1 class="text-center text-info mt-1">LIST GROUP</h1>

    <table class="table table-hover">
        <thead>
            <tr class="btn-info">
                <th></th>
                <th></th>
                <th></th>
                <th>Id</th>
                <th>NameGroup</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${groupmember}" var="gm" >
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>${gm.id}</td>
                    <td>${gm.teamgroupId.name}</td>
                    <td>
                        <a href="<c:url value="/details/${gm.teamgroupId.id}"/>" class="btn btn-success">Details</a>
                         <a href="<c:url value="/groups/transactions/${gm.teamgroupId.id}"/>" class="btn btn-success">Show Transaction</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>     
    <div class="d-flex justify-content-end">
        <a href="<c:url value="/groups/add"/>" class="btn btn-info mt-1">Add Group</a>
    </div>
</section>

