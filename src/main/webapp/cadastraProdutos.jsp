<%-- 
    Document   : cadastraProdutos
    Created on : 12/01/2017, 23:28:37
    Author     : cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-signin" action="clientes" method="post">

                    <h2 class="form-signin-heading">Cadastro de Produtos ... </h2><br>
                    <input type="hidden" name="cmd" value="saveAdd"/>
                    <input type="name" id="inputName" class="form-control" placeholder="Nome do Produto " name="nomeProduto"></br>                    
                    <br><input type="number" id="inputPreco" class="form-control" placeholder="Preco do produto" name="precoProduto"></br>
                    <br><input type="text" id="inputDescricao" class="form-control" placeholder="Descrição do Produto " name="descricaoProduto"></br>
                    <br><input type="file" id="inputImagem" class="form-control" placeholder="Imagem do Produto " name="imagemProduto"></br>
                    <br><input type="text" id="inputPalavraChaveProduto" class="form-control" placeholder="Palavra Chave ..." name="palavra1PalavraChave"></br>
                    <br><input type="text" id="inputPalavraChaveProduto" class="form-control" placeholder="Palavra Chave ..." name="palavra2PalavraChave"></br>
                    <br><input type="text" id="inputPalavraChaveProduto" class="form-control" placeholder="Palavra Chave ..." name="palavra3PalavraChave"></br><br>
                    <input type="radio" name="categoria" value="m"> Masculino
                    <input type="radio" name="categoria" value="f"> Feminino
                    
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Salvar">Cadastrar</button>
                   
        </form> 
    </body>
</html>
