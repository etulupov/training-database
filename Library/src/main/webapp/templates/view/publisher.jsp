<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="/css/table.css"/>

<table class="t1">
    <tr>
        <th class="id">id</th>
        <th>name</th>
        <th>book_count</th>
        <th class="delete"></th>
    </tr>


    <c:forEach var="currItem" items="${tableData}" varStatus="rowCounter">
        <c:choose>
            <c:when test="${rowCounter.count % 2 == 0}">
                <c:set var="rowStyle" scope="page" value="odd"/>
            </c:when>
            <c:otherwise>
                <c:set var="rowStyle" scope="page" value="even"/>
            </c:otherwise>
        </c:choose>
        <tr class="${rowStyle}">
            <td align="right" class="id">
                <c:out value="${currItem.getId()}"/>
            </td>
            <td>
                <c:out value="${currItem.getName()}"/>
            </td>
            <td>
                <c:out value="${currItem.getBookCount()}"/>
            </td>
            <td class="delete">

                <a href='<c:out value="?delete=${currItem.getId()}"/>' class="highlight"><img
                        src="../../images/delete.png"/></a>
            </td>
        </tr>
    </c:forEach>
</table>

