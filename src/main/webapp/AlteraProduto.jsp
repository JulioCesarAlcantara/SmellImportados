<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
        <link href="sistemCSS_1.css" rel="stylesheet">

        <script>
            function exibirSrcImagem1(evento) {
                var fr = new FileReader();
                fr.onload = function () {
                    //console.log(fr.result);
                    document.getElementById("imagem1").value = fr.result;
                };
                fr.readAsDataURL((evento.target || window.event.srcElement).files[0]);
            }

            function exibirSrcImagem2(evento) {
                var fr = new FileReader();
                fr.onload = function () {
                    //console.log(fr.result);
                    document.getElementById("imagem2").value = fr.result;
                };
                fr.readAsDataURL((evento.target || window.event.srcElement).files[0]);
            }

            function exibirSrcImagem3(evento) {
                var fr = new FileReader();
                fr.onload = function () {
                    //console.log(fr.result);
                    document.getElementById("imagem3").value = fr.result;
                };
                fr.readAsDataURL((evento.target || window.event.srcElement).files[0]);
            }
        </script>

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
                    </ul>
                </div>
            </div>
        </div>

        <div id ="redor">
            <div class="controls form-horizontal well">

                <form class="form-signin" action="produtos" method="post">

                    <h2 class="form-signin-heading">Cadastro de Produtos </h2><br>
                    <input type="hidden" name="cmd" value="saveUpdate"/>
                    <input type="hidden" name="imagem1" id="imagem1"/>
                    <input type="hidden" name="imagem2" id="imagem2"/>
                    <input type="hidden" name="imagem3" id="imagem3"/>
                    <fieldset class="well the-fieldset">  
                        <legend> Dados do Produto</legend>
                        <input type="hidden" id="inputId" class="form-control" name="idProduto" value="${produtoList.get(0).idProduto}">     <br/>              
                        <input type="text" id="inputName" class="form-control" placeholder="Nome do Produto " name="nomeProduto" value="${produtoList.get(0).nomeProduto}">                   
                        <br><input type="text" id="inputPreco" class="form-control" placeholder="Preco do produto" name="precoProduto" value="${produtoList.get(0).precoProduto}">
                        <br><input type="text" id="inputQtd" class="form-control" placeholder="Quantidade" name="quantidadeProduto" value="${produtoList.get(0).quantidadeProduto}">                    
                        <br><input type="text" id="inputDescricao" class="form-control" placeholder="Descrição do Produto " name="descricaoProduto" value="${produtoList.get(0).descricaoProduto}">
                    </fieldset>

                    <fieldset class="well the-fieldset">
                        <legend>Categoria</legend>
                        <c:if test= "${produtoList.get(0).categoriaProduto eq 'm'}">
                            <input type="radio" name="categoria" value="m" checked> Masculino
                            <input type="radio" name="categoria" value="f"> Feminino
                        </c:if>

                        <c:if test= "${produtoList.get(0).categoriaProduto eq 'f'}">
                            <input type="radio" name="categoria" value="m"> Masculino
                            <input type="radio" name="categoria" value="f" checked> Feminino
                        </c:if>
                    </fieldset>
                    <button class="btn btn-lg btn-primary" type="submit" value="Salvar">Alterar</button>

                </form> 
            </div>
        </div>
    </body>
</html>
