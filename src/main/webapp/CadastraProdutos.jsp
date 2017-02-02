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
                    <input type="hidden" name="cmd" value="saveAdd"/>
                    <input type="hidden" name="imagem1" id="imagem1"/>
                    <input type="hidden" name="imagem2" id="imagem2"/>
                    <input type="hidden" name="imagem3" id="imagem3"/>
                    <fieldset class="well the-fieldset">  
                        <legend> Dados do Produto</legend>
                        <input type="text" id="inputName" class="form-control" placeholder="Nome do Produto " name="nomeProduto"></br>                    
                        <br><input type="number" id="inputPreco" class="form-control" placeholder="Preco do produto" name="precoProduto"></br>
                        <br><input type="number" id="inputPreco" class="form-control" placeholder="Quantidade" name="quantidadeProduto"></br>                    
                        <br><input type="text" id="inputDescricao" class="form-control" placeholder="Descrição do Produto " name="descricaoProduto"></br>
                    </fieldset>

                    <fieldset class="well the-fieldset">
                        <legend>Imagens</legend>
                        <br><input type="file" id="inputImagem1" onchange="exibirSrcImagem1(this)" class="btn btn-default" name="imagemProduto1" /></br>
                        <br><input type="file" id="inputImagem2" onchange="exibirSrcImagem2(this)" class="btn btn-default" name="imagemProduto2" /></br>
                        <br><input type="file" id="inputImagem3" onchange="exibirSrcImagem3(this)" class="btn btn-default" name="imagemProduto3" /></br>
                    </fieldset>
                    
                    <fieldset class="well the-fieldset">
                        <legend>Categoria</legend>
                        <input type="radio" name="categoria" value="m"> Masculino
                        <input type="radio" name="categoria" value="f"> Feminino
                    </fieldset>
                    <button class="btn btn-lg btn-primary" type="submit" value="Salvar">Cadastrar</button>

                </form> 
            </div>
        </div>
    </body>
</html>
