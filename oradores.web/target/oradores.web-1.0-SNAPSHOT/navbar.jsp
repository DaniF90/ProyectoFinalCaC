<%-- 
    Document   : navbar
    Created on : 19/12/2023, 16:27:45
    Author     : Daniel
--%>

<nav class="navbar bg-dark fixed-top navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand text-light mx-4" href="https://inscripcionesagencia.bue.edu.ar/codoacodo/" target="_blank"> <img src="<%=request.getContextPath()%>/assets/images/codoacodologo1.png" alt="Codoacodo_logo">ORADORES WEB</a>
            <button class="navbar-toggler bg-warning px-1" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                <div class="offcanvas-header bg-dark">
                    <h5 class="offcanvas-title text-light" id="offcanvasNavbarLabel">Menú</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body bg-dark">
                    <ul class="navbar-nav justify-content-center flex-grow-1 pe-4 gap-4 ms-auto">
                        <li class="nav-item">
                            <a class="nav-link text-light" href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light" href="<%=request.getContextPath()%>/api/ListadoOradorController">Quiero ser Orador</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light" href="${pageContext.request.contextPath}/infoOrador.jsp">¿Qué es ser un orador?</a>
                        </li>
                        <!--<li class="nav-item">
                            <a class="nav-link text-light" href="<%=request.getContextPath()%>/alta.jsp">Alta</a>
                        </li>-->
                        <li class="nav-item">
                            <a class="nav-link active text-light" href="#Acerca_de" aria-current="page">Contacto</a>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </div>
</nav>
