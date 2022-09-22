<%-- 
    Document   : DatosPersonal
    Created on : 21 set. 2022, 20:05:33
    Author     : ricardo
--%>

<%@page import="Modelos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <%-- Menu --%>
        <link href="font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet prefetch" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <%-- Formulario --%>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/styles_frm.css" rel="stylesheet" type="text/css"/>
        <title>.:: Datos Cliente ::.</title>
    </head>
    <body>
        <div class="container">
            <ul id="nav">
                <li><a href="pagHome.jsp"><i class="fa fa-home" aria-hidden="true"></i> Inicio</a></li>
                <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i> Cliente</a>
                    <span id="sl"></span>
                    <ul class="subs">
                        <ul>
                            <li><a href="Controlador?id=DatosPersonal"><i class="fa fa-folder-open" aria-hidden="true"></i>  Datos Personales</a></li>
                            <li><a href="Controlador?id=DietaPersonal"><i class="fa fa-folder-open" aria-hidden="true"></i>  Dieta</a></li>
                            <li><a href="Controlador?id=EjercicioPersonal"><i class="fa fa-folder-open" aria-hidden="true"></i>  Ejercicios</a></li>
                        </ul>
                    </ul>
                </li>
                <li><a href="https://us04web.zoom.us/j/75116216620?pwd=PAR9QDRU7yeJfpKdwSNbbZUCUAOS7r.1" target="_blank"><i class="fa fa-video-camera" aria-hidden="true"></i> Enlace en vivo</a>
                    <span id="s1"></span>
                </li>
                <li><a href="pagLogin.jsp"><i class="fa fa-arrow-right" aria-hidden="true"></i> Salir</a></li>
            </ul>
        </div>
        
        <form action="Controlador" method="post">
            <div class="container" id="advanced-search-form">
                <center><span><img src="imagenes/carnet_cliente_2.jpg"></span><h2>Datos personal</h2></center> 
                <div class="row">
                    <% List<Cliente> ddlListaCliente_datos = (List<Cliente>) request.getAttribute("DatosCliente");
                        if (ddlListaCliente_datos != null)
                            for (Cliente tabla_cliente_datos : ddlListaCliente_datos) {%>
                    <label for="first-name">Nombre completo</label>
                    <input type="text" class="form-control" value="<%= tabla_cliente_datos.getNombreCliente()%>" disabled="true" name="nombreCliente" id="nombreCliente" >
                </div>
                <div class="row">
                    <label for="first-name">DNI</label>
                    <input type="text" class="form-control" value="<%= tabla_cliente_datos.getDNI()%>" disabled="true"  name="nombreCliente" id="nombreCliente" >
                </div>
                <div class="row">
                    <label for="first-name">Peso Inicial</label>
                    <input type="text" class="form-control" value="<%= tabla_cliente_datos.getPeso_inicial()%>" disabled="true" name="nombreCliente" id="nombreCliente">
                </div>
                <div class="row">
                    <label for="first-name">Talla</label>
                    <input type="text" class="form-control" value="<%= tabla_cliente_datos.getTalla()%>" disabled="true" name="nombreCliente" id="nombreCliente">
                </div>
                <div class="row">
                    <label for="first-name">Peso Final</label>
                    <input type="text" class="form-control" value="<%= tabla_cliente_datos.getPeso_actual()%>" disabled="true" name="nombreCliente" id="nombreCliente">
                </div>
                <div class="row">
                    <label for="first-name">IMC</label>
                    <input type="text" class="form-control" value="<%= tabla_cliente_datos.getIMC()%>" disabled="true" name="nombreCliente" id="nombreCliente" >
                </div>
                <div class="row">

                    <label for="first-name">Estado</label>

                    <input type="text" class="form-control" value="<%= tabla_cliente_datos.getObservacion()%>" disabled="true" name="nombreCliente" id="nombreCliente" >
                </div>
            </div>
        </form>
        <%}%>
    </body>
</html>
