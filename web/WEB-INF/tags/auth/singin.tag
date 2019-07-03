<%-- 
    Document   : singin
    Created on : 04.07.2019, 0:40:14
    Author     : vasha
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<form action="${pageContext.servletContext.contextPath}/login"
      method="POST"
      class="centered"
      style="max-width: 3in">
    
    <div class="row gap-bottom">
        <label>Login:</label>
        <input type="text" 
               name="login" 
               placeholder="Type your name ...">
    </div>
    
    <div class="row gap-bottom">
        <label>Password:</label>
        <input type="password" 
               name="password" 
               placeholder="Your password ...">
    </div>
    
    <div class="row">
        <a href="${pageContext.servletContext.contextPath}/registration">
            Registration
        </a>
        <button class="pull-right success">
            Sign in
        </button>
    </div>
    
</form>