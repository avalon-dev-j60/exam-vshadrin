<%-- 
    Document   : common
    Created on : 03.07.2019, 22:24:17
    Author     : vasha
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title" required="true"%>

<!DOCTYPE html>

<html>
    <head>
        <title>
            ${title}
        </title>
            <link href="${pageContext.servletContext.contextPath}/css/groundwork.css"
                  type="text/css"
                  rel="stylesheet">
    </head>
    <body>
        <header class="row one half centered padded">
            <div class="one fourth padded">
                <a href="${pageContext.servletContext.contextPath}/"
                   rel="home">
                Home
                </a>
            </div>
            <div class="one fourths padded">
            <a href="${pageContext.servletContext.contextPath}/someinfo"
              >
                Some information
            </a> 
            </div>  
            <div class="one fourths padded">
            <a href="${pageContext.servletContext.contextPath}/about"
              >
                About
            </a>
            </div>
               <div class="one  padded">   
            <a href="${pageContext.servletContext.contextPath}/singin"
               >
                Sign in
            </a>
            </div>
        </header>
        
        <section class="three fourths centered padded justify">
            
            <jsp:doBody/>

        </section>       
                
    </body> 
    
</html>
    