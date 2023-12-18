<%-- 
    Document   : Index
    Created on : 15/12/2023, 00:05:34
    Author     : Daniel
--%>

<!DOCTYPE html>
<html lang="es-ar" data-bs-theme="light">
    <head>
        <%@include file="head.jsp" %>
        <title>Oradores Web</title>
    </head>
        <body>
            
            <!-- ACA VA EL NAVBAR  -->
            <%@include file="navbar.jsp" %>
            
            <img src="./assets/images/Razones-para-aprender-a-programar-con-Java.jpg" class="vh-100 vw-100 img-fluid" alt="Programando_con_Java"/>
            <script src="<%=request.getContextPath()%>./assets/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
            <footer id="footer"><%@include file="footer.jsp" %></footer>
	</body>	
</html>
