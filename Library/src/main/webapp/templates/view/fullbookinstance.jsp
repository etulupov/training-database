<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" type="text/css" href="/css/table.css"/>


<table class="t1">
    <tr>
        <th class="id">id</th>
        <th>title</th>
        <th>authors</th>
        <th>publisher</th>
        <th>year</th>
        <th>isbn</th>
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

        <c:set var="flag" scope="page" value="false"/>
        <c:forEach var="item" items="${currItem}" varStatus="rowCounter">
            <tr class="${rowStyle}">


                <td align="right" class="id">
                    <c:out value="${item.getId()}"/>
                </td>
                <c:choose>
                    <c:when test="${flag.equals(\"false\")}">
                        <td rowspan="${currItem.size()}">
                            <c:out value="${item.getBook().getTitle()}"/>
                        </td>
                        <td rowspan="${currItem.size()}">
                            <c:forEach var="author" items="${item.getBook().getAuthors()}">
                                <c:out value="${author.getName()}"/> <br/>
                            </c:forEach>
                        </td>
                        <c:set var="flag" scope="page" value="true"/>
                    </c:when>
                </c:choose>


                <td>
                    <c:out value="${item.getPublisher().getName()}"/>
                </td>
                <td>
                    <c:out value="${item.getYear()}"/>
                </td>
                <td>
                    <c:out value="${item.getIsbn()}"/>
                </td>
                <td class="delete">

                    <a href='<c:out value="?delete=${item.getId()}"/>' class="highlight"><img
                            src="../../images/delete.png"/></a>
                </td>
            </tr>
        </c:forEach>

    </c:forEach>
</table>

