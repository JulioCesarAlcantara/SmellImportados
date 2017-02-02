<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cdc.model.Estado"%>
<%@page import="java.util.List"%>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
        <link href="sistemCSS_1.css" rel="stylesheet">
    </head>
    <body>
        <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand"><span>Smell Importados</span><br></a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                    <i class="fa fa-3x fa-car fa-fw pull-right text-muted"></i>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="TelaPrincipal.jsp">Home</a>
                        </li>                    </ul>
                </div>
            </div>
        </div>
        <div id ="redor">
            <div class="container">

                <a href="clientes?cmd=add" >Cadastrar novo Cliente</a>
                <div style="padding: 10px; margin:10px;">
                    <table>
                        <tr>
                            <th> ID - Atualizar </th>
                            <th> Nome </th>
                            <th> Excluir </th>
                        </tr>
                        <c:forEach var="lista" items="${ requestScope.clienteList }">
                            <tr>
                                <td><a href="clientes?cmd=update&id=${lista.idCliente}"> ${lista.idCliente} </a></td>
                                <td>${lista.nomeCliente}</td>
                                <td><a href="clientes?cmd=del&id=${lista.idCliente}"> Excluir Cliente</a></td>
                            </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
