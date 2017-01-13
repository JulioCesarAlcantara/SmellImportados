<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
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
                            <a href="#">Contacts</a>
                        </li>
                        <li>
                            <a href="login.jsp">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
       
       <div id ="redor">
            <div class="container">
        
            <form class="form-signin" action="produtos" method="post">

                    <h2 class="form-signin-heading">Cadastro de Produtos </h2><br>
                    <input type="hidden" name="cmd" value="saveAdd"/>
                    <input type="name" id="inputName" class="form-control" placeholder="Nome do Produto " name="nomeProduto"></br>                    
                    <br><input type="number" id="inputPreco" class="form-control" placeholder="Preco do produto" name="precoProduto"></br>
                    <br><input type="text" id="inputDescricao" class="form-control" placeholder="Descrição do Produto " name="descricaoProduto"></br>
                    <br><input type="file" id="inputImagem" class="btn btn-default btn-file" name="imagemProduto1"></br>
                    <br><input type="file" id="inputImagem" class="btn btn-default btn-file" name="imagemProduto2"></br>
                    <br><input type="file" id="inputImagem" class="btn btn-default btn-file" name="imagemProduto3"></br>
                    <br><input type="text" id="inputPalavraChaveProduto" class="form-control" placeholder="Palavra Chave ..." name="palavra1"></br>
                    <br><input type="text" id="inputPalavraChaveProduto" class="form-control" placeholder="Palavra Chave ..." name="palavra2"></br>
                    <br><input type="text" id="inputPalavraChaveProduto" class="form-control" placeholder="Palavra Chave ..." name="palavra3"></br><br>
                    <input type="radio" name="categoria" value="m"> Masculino
                    <input type="radio" name="categoria" value="f"> Feminino
                    
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Salvar">Cadastrar</button>
                   
        </form> 
        </div>
       </div>
    </body>
</html>
