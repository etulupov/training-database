<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/menu.css"/>


<div class="title">Tables</div>
<ul id="menu">

    <c:forEach var="currItem" items="${viewerPaths}" varStatus="rowCounter">

        <c:choose>
            <c:when test="${currItem.getFirst().equals(servletPath)}">
                <c:set var="rowStyle" scope="page" value="selected"/>
            </c:when>
            <c:otherwise>
                <c:set var="rowStyle" scope="page" value=""/>
            </c:otherwise>
        </c:choose>
        <li><a class="${rowStyle}" href="${currItem.getFirst()}">${currItem.getSecond()}</a></li>


    </c:forEach>


</ul>
<br/>

<div class="title">Actions</div>
<ul id="menu">

    <li><a href="${addPage}">Add new row</a></li>
</ul>
