<%@page import="cdc.model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cdc.model.Promocao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import=" cdc.model.ProdutoPromocaoDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Associar Produto/Promoção</title>
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
                            boolean ehNova = false;
                            if (sessao.isNew()) {

                                sessao.invalidate();
                                ehNova = true;
                            } else {
                                sessao.setMaxInactiveInterval(300);
                                try {
                                    tipoUsuario = sessao.getAttribute("tipoUsuario").toString();
                                } catch (Exception e) {
                                    tipoUsuario = "c";
                                    ehNova = true;
                                    //out.print(e);
                                }
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

                        <%if (!ehNova) {%><li>
                            <a href="login?cmd=logout">Sair</a>
                        </li>
                        <%}%>
                    </ul>
                </div>
            </div>
        </div>
        <div id ="redor">
            <div class="container">

                <form class="form-signin" action="produtoPromocao" method="post">

                    <input type="hidden" name="cmd" value="saveAdd"/>
                    <% List<Promocao> list = new ArrayList<Promocao>();
                        ProdutoPromocaoDAO prodPromo = new ProdutoPromocaoDAO();
                        list = prodPromo.buscaPromocoesParaCombo(); %>

                    <h2 class="form-signin-heading">Produtos/Promoções </h2><br>
                    <label> Escolha uma promoção</label> <br />
                    <br><select class="form-control" name ="idPromocao">
                        <option value="-1">Escolha uma promoção</option>
                        <%for (Promocao promocao : list) { %>

                        <option value="<%out.print(promocao.getIdPromocao());%>"> <%out.print(promocao.getNomePromocao());%></option>

                        <% }%>
                    </select> 
                    <br />


                    <% List<Produto> list1 = new ArrayList<Produto>();
                                ProdutoPromocaoDAO prodPromo1 = new ProdutoPromocaoDAO();
                                list1 = prodPromo1.buscaProdutosParaCombo(); %>

                    <label> Escolha um produto</label> <br /><br/>
                    <%for (Produto produto : list1) { %>

                    <input type="checkbox" name="idProduto" value="<%out.print(produto.getIdProduto());%>"> <%out.print(produto.getNomeProduto());%> <br/>

                    <% }%>

                    <br /><br/>




                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Salvar">Cadastrar</button>
                </form>
            </div>
        </div>
    </body>
</html>
