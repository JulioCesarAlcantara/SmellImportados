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

                <form class="form-signin" action="clientes" method="post">
                    
                    <h2 class="form-signin-heading">Cadastro de Clientes </h2><br>
                    <input type="hidden" name="cmd" value="saveAdd"/>
                    <input type="text" id="inputName" class="form-control" placeholder="Nome " name="nomeCliente"></br>                    
                    <br><input type="email" id="inputEmail" class="form-control" placeholder="Email" name="emailCliente"></br>
                    <br><input type="text" id="inputCPF" class="form-control" placeholder="CPF " name="cpfCliente"></br>
                    <br><input type="text" id="inputDt" class="form-control" placeholder="Data Nascimento " name="dataNascimentoCliente"></br>
                    <br><input type="tel" id="inputTelefone1" class="form-control" placeholder="Telefone1" name="telefone1Cliente"></br>
                    <br><input type="tel" id="inputTelefone2" class="form-control" placeholder="Telefone2" name="telefone2Cliente"></br>
                    <input type="radio" name="sexoCliente" value="m"> Masculino <br><br>
                    <input type="radio" name="sexoCliente" value="f"> Feminino <br>
                    <br><input type="text" id="inputEndereco" class="form-control" placeholder="Endereço" name="enderecoCliente" ></br>
                    <br><select class="form-control" name ="estadoCliente">
                        <option value="GO">Goiás</option>
                        <option value="TO">Tocantins</option>
                        <option value="SP">São Paulo</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <option value="PB">Paraíba</option>
                        <option value="BA">Bahia</option>
                        <option value="MG">Minas Gerais</option>
                        <option value="RS">Rio Grande do Sul</option>
                    </select> 
                    <br><input type="text" id="inputCid" class="form-control" placeholder="Cidade" name="cidadeCliente"></br>
                    <br><input type="text" id="inputCep" class="form-control" placeholder="CEP" name="cepCliente"></br>

                    <br><input type="number" id="inputCep" class="form-control" placeholder="CEP" name="cepCliente"></br>
                    
                    <input type="password" id="inputpassword" class="form-control" placeholder="Senha" name="passwordCliente"></br>
                    
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Salvar">Cadastrar</button>
                </form>
            </div>
        </div>
    </body>
</html>
