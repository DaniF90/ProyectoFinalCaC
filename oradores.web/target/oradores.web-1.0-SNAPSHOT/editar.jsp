<%-- 
    Document   : editar
    Created on : 19/12/2023, 17:10:49
    Author     : Daniel
--%>
<%@page import="com.codoacodo2.model.Orador"%>
<html>
    <head>
            <%@include file="head.jsp" %>	
    </head>

    <body>
        <main>
            <!-- ACA VA EL NAVBAR  -->
            <%@include file="navbar.jsp" %>
            <div class="container min-vh-100 d-flex justify-content-center align-items-center">
                <section>
                    <% 
                        Orador orador = (Orador)request.getAttribute("orador");
                    %>
                    <h3>Editar orador</h3>
                    <!--  JSP -->
                    <form method="POST" style="width: 150%" action="<%=request.getContextPath()%>/api/EditarOradorController">
                            <input type="hidden" id="id" name="id" value="<%=orador.getId()%>">
                            <div class="mb-3 my-4">
                              <label for="nombre" class="form-label">Nombre</label>
                              <input name="nombre" value="<%=orador.getNombre()%>" type="text" class="form-control" id="nombre" placeholder="Nombre" maxlength="50">
                            </div>
                            <div class="mb-3">
                              <label for="apellido" class="form-label">Apellido</label>
                              <input name="apellido" value="<%=orador.getApellido()%>" type="text" class="form-control" id="apellido" placeholder="Apellido" maxlength="50">
                            </div>
                            <div class="mb-3">
                                <label for="edad" class="form-label">Edad</label>
                                <input name="edad" value="<%=orador.getEdad()%>" type="text" class="form-control" id="edad" placeholder="Edad" maxlength="3">
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input value="<%=orador.getEmail()%>" name="email" type="text" class="form-control" id="email" placeholder="Email" maxlength="50">
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Tema</label>
                                <input value="<%=orador.getTema()%>" name="tema" type="text" class="form-control" id="tema" placeholder="Tema" maxlength="50">
                            </div>
                            <button class="btn btn-primary my-4">
                                Guardar
                            </button>
                    </form>
                </section>
            </div>
        </main>
        <%@include file="footer.jsp" %>
    </body>	
</html>