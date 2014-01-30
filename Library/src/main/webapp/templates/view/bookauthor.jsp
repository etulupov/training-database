<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" type="text/css" href="/css/table.css"/>


<table class="t1">
    <tr>

        <th>book_id</th>
        <th>author_id</th>
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

            <td>
                <c:out value="${currItem.getBookId()}"/>
            </td>
            <td>
                <c:out value="${currItem.getAuthorId()}"/>
            </td>
            <td class="delete">

                <a href='<c:out value="?authorId=${currItem.getAuthorId()}&bookId=${currItem.getBookId()}"/>' class="highlight"><img
                        src="../../images/delete.png"/></a>
            </td>
        </tr>
    </c:forEach>
</table>

