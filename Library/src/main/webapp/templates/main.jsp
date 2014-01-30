<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Library</title>
    <link rel="icon" type="image/png" href="/images/library.png">
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
</head>
<body>


<div id="header">


    <ul id="display-inline-block-example">
        <li class="logo"><img src="/images/library.png" style="width: 45px; height: 45px; vertical-align: middle ; margin-top: -5px;"/></li>
        <li><a href="/books">Browse tables</a></li>
        <li><a href="/show">Show books</a></li>
        <li><a href="/createBook">Add new book</a></li>
    </ul>
</div>

<div id="content" >


    <c:choose>
        <c:when test="${errorMessage != null}">
            <div id="error">


                <img style="width: 60px; height: 60px; vertical-align: middle" src="../images/messagebox_warning.png">
                <span style="">${errorMessage}</span>


            </div>
        </c:when>

    </c:choose>


    <jsp:include page="${contentPage}"/>

</div>

<div id="footer" style="color: #999;">The Library (c) 2012</div>


</body>
</html>