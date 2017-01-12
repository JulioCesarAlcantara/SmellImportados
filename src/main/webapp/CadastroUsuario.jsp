<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1> Smell Importados </h1>
        <div style="padding:10px; background-color: #cccccc; text-align: center;">
            <span style='padding: 5px'>
                <a href="autores?cmd=listar" title="Clique para listar os autores">Produtos </a>
            </span>
             <span style='padding: 5px'>
                <a href="autores?cmd=listar" title="Clique para listar os autores">Categorias</a>
            </span>
            <span style="padding: 5px">
            <a href="publicacoes?cmd=listar" title="Clique para listar as publicações">Sobre nós</a>
            </span>
            <span style="padding: 5px">
            <a href="addAutor.jsp" title="Clique para cadastrar novo autor">Novo Cliente</a>
            </span>
        </div>
        
         <div style="padding: 10px; margin:10px;">
             <p><h1> Cadastra Usuários </h1></p>
            <form action="usuarios" method="post">
                <input type="hidden" name="cmd" value="saveAdd" /> 
                <label> Nome do Usuário </label>
                <input type="text" name="nomeUsuario"/>
                <br /><br />
               <label> Telefone 1 </label>
               <input type="text" name="telefone1Usuario" /> 
               <br><br />
               <label> Telefone 2 </label>
               <input type="text" name="telefone2Usuario" /> 
               <br><br />
               <label> Email </label>
               <input type="email" name="emailUsuario" /> 
               <br><br />
               <label> Tipo Usuário </label><br />
                 <input type="radio" name="tipoUsuario" value="a"> Adm do Sistema<br>
                 <input type="radio" name="tipoUsuario" value="g"> Gerente da Loja<br>
                 <input type="radio" name="tipoUsuario" value="e"> Encarregado<br>
                 <input type="radio" name="tipoUsuario" value="v"> Vendedor<br>
               <br><br />
               <label> Data de Nascimento </label>
               <input type="text" name="dataNascimentoUsuario" /> 
               <br><br />
               <label> Sexo </label><br />
                 <input type="radio" name="sexoUsuario" value="m"> Masculino<br>
                 <input type="radio" name="sexoUsuario" value="f"> Feminino<br> 
               <br><br />
               
               <input type="submit" value="Salvar">
            </form>
        </div>
    </body>
</html>
