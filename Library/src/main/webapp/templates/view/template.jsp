<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style type="text/css">

    #left {

        width: 250px;
        float: left;
        padding-left: 20px;
        padding-right: 20px;
    }

    #content {


    }


</style>



<div id="left">

    <jsp:include page="${menuPage}"/>
</div>
<div id="content">
            <jsp:include page="${tablePage}"/>

</div>