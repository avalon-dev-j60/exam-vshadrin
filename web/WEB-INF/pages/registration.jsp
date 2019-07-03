<%-- 
    Document   : registration
    Created on : 04.07.2019, 1:52:17
    Author     : vasha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>

<common:layout title="Registration">
    
    <div class="one half centered">
        <h2>Registration</h2>
        <auth:registration/>
    </div>
        
</common:layout>
