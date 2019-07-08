<%-- 
    Document   : registration
    Created on : 04.07.2019, 1:53:48
    Author     : vasha
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<form action="${pageContext.servletContext.contextPath}/registration"
      method="post">

    <div class="row gap-bottom">
        <common:error/>
    </div>
    
    <div class="row gap-bottom">
        <input type="text" 
               name="login"
               value="${param.login}"
               placeholder="Login"
               required>
    </div>
    
    <div class="row gap-bottom">
        <input type="password" 
               name="password"
               placeholder="Password"
               required>
    </div>
    
    <div class="row gap-bottom">
        <input type="password" 
               name="confirmation"
               placeholder="Confirm password"
               required>
    </div>
    
    <div class="row gap-bottom">
        <button class="centered">
            Register
        </button>
    </div>
    
</form>