<%-- 
    Document   : TelaPrincipal
    Created on : 31/10/2016, 15:57:02
    Author     : cesar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cdc.model.ImagemProduto"%>
<%@page import="cdc.model.ImagemProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cdc.model.ListaImagemProduto" %>
<%@page import="cdc.model.ProdutoDAO" %>
<%@page import="cdc.model.Produto" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html><head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
                        </li>
                        <li>
                            <a href="CadastroClientes.jsp">Clientes</a>
                        </li>
                        <li>
                            <a href="#">Contacts</a>
                        </li>
                        <li>
                            <a href="Login.jsp">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="section">
            <div class="background-image background-image-fixed"></div>
            <div class="container">
                <div class="row">                   
                    <div>  
                        <c:forEach var="lista" items="${requestScope.listaComTudo}">                           
                            <table style="width: 25%" class="table table-responsive">
                                <tr>
                                    <td> <img src="${lista.imagem1}"> </td> 
                                    <td rowspan="3" valign="top">
                                        <div id="menu" >
                                            <form action="FinalizaCompra" method="">
                                            <input type="hidden" name="idPro" value="${lista.idProduto}"
                                            <big><big><big><big><big><big><big><big><big><big><h2> ${lista.nomeProduto} </h2>
                                            <br><h4>${lista.descricaoProduto}</h4>
                                            <br><h3>R$ ${lista.precoProduto}</h3>
                                            <br><input type="submit" value="Comprar" class="btn btn-primary"> 

                                            </form>
                                        </div>
                                    </td> 
                                </tr> 
                                <tr>
                                    <td> <img src="${lista.imagem2}"> </td>
                                </tr>
                                <tr>
                                    <td> <img src="${lista.imagem3}"> </td>  
                                </tr>
                            </table> 



                        </c:forEach> 
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
