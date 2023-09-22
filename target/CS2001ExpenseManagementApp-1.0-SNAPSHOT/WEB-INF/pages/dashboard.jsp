<%-- 
    Document   : dashboard
    Created on : Sep 1, 2023, 11:27:17 PM
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


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<c:url value="/dashboards" var="action"/>

<h1 class="text-center text-success mt-1">STATS</h1>
<div >
    <canvas id="myChart" width="400" height="100"></canvas>
</div>
<form class="d-flex justify-content-center">
    <h4 class=" me-2 mt-2 mb-2">Nhập Tháng: </h4>
    <input class="form-control w-25 me-2 mt-2 mb-2 "  id="month" type="number" placeholder="Input month">
    <button class="btn btn-primary me-2 mt-2 mb-2"  type="button" onclick="getMonth()">Search Month</button>
</form>
<form class="d-flex justify-content-center">
    <h4 class=" me-2 mt-2 mb-2">Nhập Năm: </h4>
    <input class="form-control w-25 me-2 mt-2 mb-2" id="year" type="number" placeholder="Input Year">
    <button class="btn btn-primary me-2 mt-2 mb-2 " type="button" onclick="getYear()">Search Year</button>
    <button class="btn btn-danger me-2 mt-2 mb-2" type="button" onclick="deleteChart()">Delete Chart</button>
</form>
<form class="d-flex justify-content-center">
    <h4 class=" me-2 mt-2 mb-2">Nhập Tháng Năm: </h4>
    <input class="form-control w-25 me-2 mt-2 mb-2" id="month1" type="number" placeholder="Input Month">
    <input class="form-control w-25 me-2 mt-2 mb-2" id="year1" type="number" placeholder="Input Year">
    <button class="btn btn-primary me-2 mt-2 mb-2 " type="button" onclick="GetMY()">Search Year</button>
</form>
<script src="<c:url value="/js/chart.js"/>"></script>

<script src="<c:url value="/js/main.js"/>"></script>