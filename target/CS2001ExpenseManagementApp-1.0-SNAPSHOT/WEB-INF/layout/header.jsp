<%-- 
    Document   : header
    Created on : Aug 22, 2023, 10:59:38 AM
    Author     : defaultuser0
--%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<c:url value="/" var="action"/>
<se:authorize access="hasRole('ROLE_ADMIN')">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${action}">EXEPENSE MANAGEMENT</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${action}"><i class="fa fa-fw fa-home"></i>Home</a>
                    </li>
                    <c:forEach items="${categories}" var="c">
                        <c:url value="/" var="cateAction">
                            <c:param name="cateId" value="${c.id}" />
                        </c:url>
                        <li class="nav-item">
                            <a class="nav-link" href="${cateAction}">${c.name}</a>
                        </li>
                    </c:forEach>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/formusers"/>">User</a>
                    </li>
                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name != null}">
                            <li class="nav-item">
                                <a class="nav-link text-success" href="<c:url value="/" />"><i class="fa fa-fw fa-user"></i>${pageContext.request.userPrincipal.name}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-danger" href="<c:url value="/logout" />">Logout</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="<c:url value="/login" />">Login</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <form class="d-flex" action="${action}">

                    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                    <button class="btn btn-primary" type="submit">Tìm</button>

                </form>
            </div>
        </div>
    </nav>
</se:authorize>
<se:authorize access="hasRole('ROLE_USER')">
    <c:url value="/dashboards" var="d"/>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${d}">EXEPENSE MANAGEMENT</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav me-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/dashboards"/>">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/viewTrans"/>">View Transaction</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/incomes"/>">Income</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/expenses"/>">Expense</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/groups"/>">Group</a>
                    </li>

                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name != null}">
                            <li class="nav-item">
                                <a class="nav-link text-success" href="<c:url value="/" />"><i class="fa fa-fw fa-user"></i>${pageContext.request.userPrincipal.name}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-danger" href="<c:url value="/logout" />">Logout</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="<c:url value="/login" />">Login</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <c:url value="viewTrans" var="action"/>
                <form class="d-flex" action="${action}">

                    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                    <button class="btn btn-primary" type="submit">Tìm</button>

                </form>
            </div>
        </div>
    </nav>
</se:authorize>