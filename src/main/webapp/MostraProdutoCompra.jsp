<%-- 
    Document   : TelaPrincipal
    Created on : 31/10/2016, 15:57:02
    Author     : cesar
--%>

<%@page import="cdc.model.ImagemProduto"%>
<%@page import="cdc.model.ImagemProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cdc.model.ListaImagemProduto" %>
<%@page import="cdc.model.ProdutoDAO" %>
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
                    <a class="navbar-brand"><span>JCAL Ecommerce</span><br></a>
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
                            <a href="login.jsp">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <% 
            List<ListaImagemProduto> list = new ArrayList<ListaImagemProduto>();
            ImagemProdutoDAO produto = new ImagemProdutoDAO();
            list = produto.listaProdutosParaCompra("4");
        %>
        <div class="section">
            <div class="background-image background-image-fixed"></div>
            <div class="container">
                <div class="row">
                    <% for (ListaImagemProduto proIm : list) { %>
                    <div class="col-lg-12 col-sm-5" >      
                        <a <img src="<%out.print(proIm.getImagem1());%>"></a>
                        <br>
                        <a <h2><%out.print(proIm.getNomeproduto()); %></h2></a>
                        
                                                    
                    </div><%}%>
                    </form>
                </div>
            </div>
        </div>
                    
                    <div id="menu" class="media-right col-lg-2                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ">
                        
                        Teste de menu
                    </div> 
    </body>
</html>
