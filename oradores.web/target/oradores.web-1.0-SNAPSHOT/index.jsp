<%-- 
    Document   : index
    Created on : 19/12/2023, 16:23:45
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
        <img src="./assets/images/CCM website homepage (original photo).jpg" class="vh-100 vw-100 img-fluid" alt="Programando_con_Java"/>
            
        <script src="<%=request.getContextPath()%>./assets/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <footer id="footer"><%@include file="footer.jsp" %></footer>
    </body>
</html>
