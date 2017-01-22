<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Promoção</title>
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

                <form class="form-signin" action="promocao" method="post">

                    <h2 class="form-signin-heading">Alterar Promoção </h2><br>
                    <input type="hidden" name="cmd" value="saveUpdate"/>
                    <input type="text" id="inputId" class="form-control" placeholder="Nome " name="idPromocao" value="${promocaoList.get(0).idPromocao}" readonly>  <br/>                 
                    <input type="text" id="inputName" class="form-control" placeholder="Nome " name="nomePromocao" value="${promocaoList.get(0).nomePromocao}">                    
                    <br><input type="text" id="inputDti" class="form-control" placeholder="Data do Início" name="dataInicioPromocao" value="${promocaoList.get(0).dataInicioPromocao}">                   
                    <br><input type="text" id="inputDtf" class="form-control" placeholder="Data do Fim" name="dataFimPromocao" value="${promocaoList.get(0).dataFimPromocao}">
                    <br><input type="text" id="inputDesconto" class="form-control" placeholder="Percentual de desconto (%)" name="descontoPromocao" value="${promocaoList.get(0).descontoPromocao}"><br/>
                    <c:if test= "${promocaoList.get(0).statusPromocao eq 'A'}">

                        <input type="radio" name="statusPromocao" value="A" checked> Ativa <br><br>
                        <input type="radio" name="statusPromocao" value="I"> Inativa <br><br>
                    </c:if>

                    <c:if test= "${promocaoList.get(0).statusPromocao eq 'I'}">

                        <input type="radio" name="statusPromocao" value="A"> Ativa <br><br>
                        <input type="radio" name="statusPromocao" value="I" checked> Inativa <br><br>
                    </c:if>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Salvar">Alterar</button>
                </form>
            </div>
        </div>
    </body>
</html>
