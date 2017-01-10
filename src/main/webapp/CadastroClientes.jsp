<%-- 
    Document   : CadastraUsuario
    Created on : 28/10/2016, 11:21:31
    Author     : cesar
--%>

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

                <form class="form-signin" action="TelaPrincipal" method="post">
                    
                    <h2 class="form-signin-heading">Cadastro de Clientes ... </h2>
                    <input type="hidden" name="cmd" value="cadastraCliente"/>
                    <input type="name" id="inputName" class="form-control" placeholder="Nome " name="nomeCliente"></br>                    
                    <br><input type="email" id="inputEmail" class="form-control" placeholder="Email" name="emailCliente"></br>
                    <br><input type="text" id="inputCPF" class="form-control" placeholder="CPF " name="cpfCliente"  pattern="\d{3}\.\d{3}\.\d{3}-\d{2}"></br>
                    <br><input type="tel" id="inputTelefone1" class="form-control" placeholder="Telefone1" name="telefone1Cliente"></br>
                    <br><input type="tel" id="inputTelefone2" class="form-control" placeholder="Telefone2" name="telefone2Cliente"></br>
                    <input type="radio" id="inputSexo" class="radio-inline" name="gender" value="male"> Masculino
                    <input type="radio" id="inputSexo" class="radio-inline" name="gender" value="female"> Feminino
                    <input type="radio" id="inputSexo" class="radio-inline" name="gender" value="other"> Outro <br> 
                    <br><input type="text" id="inputEndereco" class="form-control" placeholder="Endereço" name="enderecoCliente" ></br>
                    <br><input type="number" id="inputCep" class="form-control" placeholder="CEP" name="cepCliente"></br>
                    
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="cadastraCliente">Cadastrar</button>
                </form>
            </div>
        </div>
    </body>
</html>
