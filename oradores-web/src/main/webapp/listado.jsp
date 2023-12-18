<%@page import="java.util.List"%>
<%@page import="com.codoacodo.model.Orador"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-ar" data-bs-theme="light">
    <head>
        <<%@include file="head.jsp" %>
        <title>Listado de Oradores</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <main>
            <div class="container py-5 my-5">
                    <h2 class="text-uppercase text-center">Listado de Oradores</h2>
                        <!--<table class="table tbl-fixed table-bordered table-sm table-striped table-hover border border-success align-middle">-->
                        <table id="example" class="table table-bordered table-sm table-striped table-hover border align-middle display nowrap" style="width:100%">    
                            <thead class="table-dark">    
                                <tr class="table-active text-uppercase text-white">
                                    <th scope="col">ID</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellido</th>
                                    <th scope="col">Edad</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Tema</th>
                                    <th scope="col">Fecha Alta</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>    
                            <% 
                            //codigo java
                            //obtener el listado desde el request
                            //se guardo bajo el nombre de "listado"
                            List<Orador> listado = (List<Orador>)request.getAttribute("listado");
                            %>
                            <tbody>
                            <%
                            for( Orador  unOrador : listado) {
                            %>

                                <tr>
                                    <th scope="row"> <%=unOrador.getId()%> </th>
                                    <td><%=unOrador.getNombre() %></td>
                                    <td><%=unOrador.getApellido() %></td>
                                    <td><%=unOrador.getEdad() %></td>
                                    <td><%=unOrador.getEmail() %></td>
                                    <td><%=unOrador.getTema() %></td>
                                    <td><%=unOrador.getFechaAlta() %></td>
                                    <td class="d-flex">
                                        <a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/api/EditarController?id=<%=unOrador.getId()%>" role="button">Editar</a> |
                                        <a class="btn btn-danger btn-sm" href="<%=request.getContextPath()%>/api/EliminarController?id=<%=unOrador.getId()%>" role="button">Eliminar</a> 
                                    </td>
                                </tr>
                                <%
                    }
                %>
                                <tfoot class="table-dark">
                                    <tr class="table-active text-uppercase">
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Edad</th>
                                        <th>Email</th>
                                        <th>Tema</th>
                                        <th>Fecha Alta</th>
                                        <th>Acciones</th>
                                    </tr>
                                </tfoot>               
                            </tbody>
                        </table>
                                
                                
                        <!--Button trigger modal-->
                        <button type="button" class="btn btn-success btn-sm" data-bs-toggle="modal" data-bs-target="#modal1">Nuevo Orador</button>
                        <!--Aca va el Modal-->
                        <div class="modal fade" tabindex="-1" id="modal1">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Nuevo Orador</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form method="post" action="<%=request.getContextPath()%>/api/CreateController">
                                            <div class="my-3 mx-3">
                                                <label> Nombre </label>
                                                <input name="nombre"  type="text" class="form-control" id="nombreTextarea" placeholder="" maxlength="50">
                                            </div>
                                            <div class="my-3 mx-3">
                                                <label> Apellido </label>
                                                <input name="apellido" type="text" class="form-control" id="apellidoTextarea" placeholder="" maxlength="50">
                                            </div>
                                            <div class="my-3 mx-3">
                                                <label> Edad </label>
                                                <input name="edad" type="number" class="form-control" id="edadNumber" placeholder="" maxlength="3">
                                            </div>
                                            <div class="my-3 mx-3">
                                                <label> Email </label>
                                                <input name="email" type="text" class="form-control" id="emailTextarea" placeholder="" maxlength="50">
                                            </div>
                                            <div class="my-3 mx-3">
                                                <label> Tema </label>
                                                <input name="tema" type="text" class="form-control" id="temaTextarea" placeholder="" maxlength="250">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                <button class="btn btn-primary my-3">Dar de alta</button>
                                            </div>
                                        </form>    
                                    </div>
                                </div>
                            </div>
                        </div>
               
            </div>           
        </main>
        <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
        <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.5.0/js/dataTables.responsive.min.js"></script>
        <script>
            new DataTable('#example');
            
            const myModal = bootstrap.Modal.getOrCreateInstance('#modal1');

            window.addEventListener('shown.bs.modal', () => {
                myModal.show();
            });
        </script>
        <script>
            
        </script>    
        <%@include file="footer.jsp" %>
    </body>
</html>
