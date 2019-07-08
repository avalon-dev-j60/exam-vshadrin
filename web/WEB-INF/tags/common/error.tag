<%-- 
    Document   : error
    Created on : 08.07.2019, 23:53:03
    Author     : vasha
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setBundle basename="edu.blog.resources.errors"/>

<%@attribute name="exception"%>

<c:if test="${not empty exception}">
    <p class="box error">
        <fmt:message key="${exception.message}"/>
    </p>
</c:if>