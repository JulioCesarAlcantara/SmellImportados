

<%@page import="cdc.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cdc.model.ListaImagemProduto" %>
<%@page import="cdc.model.ProdutoDAO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
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
                        <%
                            HttpSession sessao = request.getSession(true);
                            String tipoUsuario = "c";
                            boolean ehNova;
                            if (sessao.isNew()) {
                                //continua
                                sessao.invalidate();

                                ehNova = true;
                            } else {
                                sessao.setMaxInactiveInterval(150);
                                tipoUsuario = sessao.getAttribute("tipoUsuario").toString();
                                ehNova = false;
                            }
                        %>
                        <li>
                            <a href="TelaPrincipal.jsp">Home</a>
                        </li>
                        <% if (tipoUsuario.equalsIgnoreCase("a") || tipoUsuario.equalsIgnoreCase("v")) {%>
                        <li>
                            <a href="clientes?cmd=listar">Gerenciar Clientes</a>
                        </li>
                        <%}%>
                        <%
                            if (tipoUsuario.equalsIgnoreCase("a")) {
                        %>
                        <li>
                            <a href="usuarios?cmd=listar">Gerenciar Usuarios</a>
                        </li>
                        <%}%>

                        <%
                            if (tipoUsuario.equalsIgnoreCase("g")) {
                        %>

                        <li>
                            <a href="promocao?cmd=listar">Gerenciar Promoções</a>
                        </li>
                        <%}%>

                        <%
                            if (tipoUsuario.equalsIgnoreCase("e")) {
                        %>
                        <li>
                            <a href="produtos?cmd=listar">Gerenciar Produtos</a>
                        </li>

                        <%}
                            if (tipoUsuario.equalsIgnoreCase("c") && !ehNova) {
                                String idCliente = sessao.getAttribute("idUsuarioLogin").toString();
                        %>
                        <li>
                            <a href="clientes?cmd=update&id=<%out.println(idCliente);%>">Alterar meus Dados</a>
                        </li>


                        <li>
                            <form action="Carrinho" method="get"> 
                                <input type="submit" class="btn btn-lg" value="Meu Carrinho"/>  
                            </form>
                        </li>
                        <%}%>

                        <li>
                            <a href="Login.jsp">Login</a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <footer class="section section-primary">
            <div class="container">
                <div class="row">
                    <div class="col-xs-6">
                        <p class="text-info text-right">
                        <div class="container">
                            <div class="row">
                                <form action="PesquisaProduto" method="post">
                                    <input type="hidden" name="cmd" value="pesquisa"/>
                                    <input type="text" class="form form-control-static col-lg-6 col-md-6 col-sm-5 col-xs-2" name="palavraPesquisa" placeholder="Pesquise por um produto aqui ..." />
                                    <input type="submit" class="btn btn-success col-lg-1 col-md-1 col-sm-2 col-xs-1" value="Pesquisar" />
                                </form>
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-md-12 hidden-lg hidden-md hidden-sm text-left">
                                <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a>
                                <a href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
                                <a href="#"><i class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a>
                                <a href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <% List<ListaImagemProduto> list = new ArrayList<ListaImagemProduto>();
            ProdutoDAO produto = new ProdutoDAO();
            String pesquisa = request.getParameter("palavraPesquisa");

            if (pesquisa != null) {
                list = produto.buscaProdutoPesquisado(pesquisa);
            } else {
                list = produto.listaTodos();
            }

            if (list.isEmpty()) {
                response.sendRedirect("TelaPrincipalVazia.jsp");
            }
        %>
        <div class="section">
            <div class="background-image background-image-fixed"></div>
            <div class="container">
                <div class="row">       

                    <% for (ListaImagemProduto proIm : list) { %>
                    <form action="MontaCompra" method="get">                        
                        <div class="col-md-3 col-sm-5" >   
                            <input type="hidden" name="idProduto" value="<%out.print(proIm.getIdProduto());%>"/>      
                            <a href="MostraProdutoCompra.jsp"><h2><%out.print(proIm.getNomeProduto()); %></h2></a>
                            <a href="MostraProdutoCompra.jsp"><img src="<%out.print(proIm.getImagem1());%>" class="img-responsive img-thumbnail"></a>

                            <br><br>
                            <p><%out.print(proIm.getDescricaoProduto());%>
                                <br>
                            <h3> R$ <%out.print(proIm.getPrecoProduto());%></h3>
                            <input type="submit" value="Comprar"> 
                        </div>
                    </form>
                    <%}%>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <ul class="pagination">
                            <li class="">
                                <a href="#">Prev</a>
                            </li>
                            <li class="">
                                <a href="#">1</a>
                            </li>
                            <li>
                                <a href="#">2</a>
                            </li>
                            <li>
                                <a href="#">3</a>
                            </li>
                            <li>
                                <a href="#">4</a>
                            </li>
                            <li>
                                <a href="#">5</a>
                            </li>
                            <li>
                                <a href="#">Next</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row text-center">
                    <div class="col-xs-3 text-center">
                        <a><i class="fa fa-5x fa-fw fa-instagram"></i></a>
                    </div>
                    <div class="col-xs-3">
                        <a><i class="fa fa-5x fa-fw fa-twitter"></i></a>
                    </div>
                    <div class="col-xs-3">
                        <a><i class="fa fa-5x fa-fw fa-facebook"></i></a>
                    </div>
                    <div class="col-xs-3 text-center">
                        <a><i class="fa fa-5x fa-fw fa-github"></i></a>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
