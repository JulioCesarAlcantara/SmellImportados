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
                       
                    </ul>
                </div>
            </div>
        </div>
        <div id ="redor">
            <div class="container">

                <form class="form-signin" action="login" method="post">
                    
                    <h2 class="form-signin-heading">Login </h2><br>
                    <input type="hidden" name="cmd" value="login"/>
                    <input type="email" id="inputName" class="form-control" placeholder="Email " name="emailUsuario"></br>                    
                    <br><input type="password" id="inputDt" class="form-control" placeholder="Insira sua senha" name="passwordUsuario"></br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Logar">Entrar</button> <br>
                    Não tem uma conta? Cadastre-se agora<br/>
                    <a href="CadastroClientes.jsp" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> Cadastrar </a>
                       
                </form>
            </div>
        </div>
    </body>
</html>
