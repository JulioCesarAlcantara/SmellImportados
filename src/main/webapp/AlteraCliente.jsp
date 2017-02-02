<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        
                    </ul>
                </div>
            </div>
        </div>
        <div id ="redor">
            <div class="container">

                <form class="form-signin" action="clientes" method="post">

                    <h2 class="form-signin-heading">Alteração de Clientes </h2><br>
                    <input type="hidden" name="cmd" value="saveUpdate"/>
                    <input type="text" id="inputId" class="form-control" placeholder="id " name="idCliente" value="${clienteList.get(0).idCliente}">  <br/>                  
                    <input type="text" id="inputName" class="form-control" placeholder="Nome " name="nomeCliente" value="${clienteList.get(0).nomeCliente}">                   
                    <br><input type="email" id="inputEmail" class="form-control" placeholder="Email" name="emailCliente" value="${clienteList.get(0).emailCliente}">
                    <br><input type="text" id="inputCPF" class="form-control" placeholder="CPF " name="cpfCliente" value="${clienteList.get(0).cpfCliente}">
                    <br><input type="text" id="inputDt" class="form-control" placeholder="Data Nascimento " name="dataNascimentoCliente" value="${clienteList.get(0).dataNascimentoCliente}">
                    <br><input type="tel" id="inputTelefone1" class="form-control" placeholder="Telefone1" name="telefone1Cliente" value="${clienteList.get(0).telefone1Cliente}">
                    <br><input type="tel" id="inputTelefone2" class="form-control" placeholder="Telefone2" name="telefone2Cliente" value="${clienteList.get(0).telefone2Cliente}">
                    <c:if test= "${clienteList.get(0).sexoCliente eq 'm'}">
                        <input type="radio" name="sexoCliente" value="m" checked> Masculino <br><br>
                        <input type="radio" name="sexoCliente" value="f"> Feminino <br>

                    </c:if>

                    <c:if test= "${clienteList.get(0).sexoCliente eq 'f'}">
                        <input type="radio" name="sexoCliente" value="m" > Masculino <br><br>
                        <input type="radio" name="sexoCliente" value="f" checked> Feminino <br>

                    </c:if>

                    <br><input type="text" id="inputEndereco" class="form-control" placeholder="Endereço" name="enderecoCliente" value="${clienteList.get(0).enderecoCliente}">
                    <br><select class="form-control" name ="estadoCliente">

                        <c:if test= "${clienteList.get(0).estadoCliente eq 'GO'}">
                            <option value="GO" selected>Goias</option>
                            <option value="TO">Tocantins</option>
                            <option value="SP">São Paulo</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="PB">Paraíba</option>
                        </c:if>

                        <c:if test= "${clienteList.get(0).estadoCliente eq 'TO'}">
                            <option value="GO" >Goias</option>
                            <option value="TO" selected>Tocantins</option>
                            <option value="SP">São Paulo</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="PB">Paraíba</option>
                        </c:if>

                        <c:if test= "${clienteList.get(0).estadoCliente eq 'SP'}">
                            <option value="GO" >Goias</option>
                            <option value="TO" >Tocantins</option>
                            <option value="SP" selected>São Paulo</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="PB">Paraíba</option>
                        </c:if>

                        <c:if test= "${clienteList.get(0).estadoCliente eq 'RJ'}">
                            <option value="GO" >Goias</option>
                            <option value="TO" >Tocantins</option>
                            <option value="SP">São Paulo</option>
                            <option value="RJ" selected>Rio de Janeiro</option>
                            <option value="PB">Paraíba</option>
                        </c:if>

                        <c:if test= "${clienteList.get(0).estadoCliente eq 'PB'}">
                            <option value="GO" >Goias</option>
                            <option value="TO" >Tocantins</option>
                            <option value="SP">São Paulo</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="PB" selected>Paraíba</option>
                        </c:if>


                    </select> 
                    <br><input type="text" id="inputCid" class="form-control" placeholder="Cidade" name="cidadeCliente" value="${clienteList.get(0).cidadeCliente}">
                    <br><input type="text" id="inputCep" class="form-control" placeholder="CEP" name="cepCliente" value="${clienteList.get(0).cepCliente}">

                    <input type="password" id="inputpassword" class="form-control" placeholder="Senha" name="passwordCliente" value="${clienteList.get(0).passwordCliente}">

                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Alterar">Alterar</button>
                </form>
            </div>
        </div>
    </body>
</html>
