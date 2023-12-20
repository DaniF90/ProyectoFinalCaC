<%-- 
    Document   : infoOrador
    Created on : 20/12/2023, 19:07:11
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>Oradores Web</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container min-vh-100 d-flex justify-content-center align-items-center">
            <iframe width="760" height="515" src="https://www.youtube.com/embed/y3mgKuZC6jo?si=S4MB38Ehb7otNRdN" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        </div>
        
        
            <script src="<%=request.getContextPath()%>./assets/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
            <footer id="footer"><%@include file="footer.jsp" %></footer>
    </body>
</html>
