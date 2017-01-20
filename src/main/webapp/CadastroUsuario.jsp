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
        
            <form class="form-signin" action="usuarios" method="post">
                    <h2 class="form-signin-heading">Cadastro de Usuários </h2><br>
                <input type="hidden" name="cmd" value="saveAdd" /> 
                <input type="text" class="form-control" placeholder="Nome " name="nomeUsuario"><br/>
             
               <input type="email" class="form-control" placeholder="Email" name="emailUsuario" /> 
               <br>
               <input type="text" class="form-control" placeholder="Telefone 1" name="telefone1Usuario" /> 
               <br>
               <input type="text" class="form-control" placeholder="Telefone 2" name="telefone2Usuario" /> 
               <br>
               <label> Tipo Usuário </label><br />
                 <input type="radio" name="tipoUsuario" value="a"> Adm do Sistema<br>
                 <input type="radio" name="tipoUsuario" value="g"> Gerente da Loja<br>
                 <input type="radio" name="tipoUsuario" value="e"> Encarregado<br>
                 <input type="radio" name="tipoUsuario" value="v"> Vendedor<br>
               <br>
               <input type="text" class="form-control" placeholder="Data de nascimento" name="dataNascimentoUsuario" /> 
               <br>
               <label> Sexo </label><br />
                 <input type="radio" name="sexoUsuario" value="m"> Masculino<br>
                 <input type="radio" name="sexoUsuario" value="f"> Feminino<br> 
               <br>
               <input type="password" class="form-control" placeholder="Senha" name="passwordUsuario" />
               <br>
               
                <button class="btn btn-lg btn-primary btn-block" type="submit" value="Salvar">Cadastrar</button>
            </form>
        </div>
       </div>
    </body>
</html>
