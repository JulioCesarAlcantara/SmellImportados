package cdc.controller;
import cdc.model.Usuario;
import cdc.model.UsuarioDAO;
import cdc.util.DAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erik
 */
//@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cmd = request.getParameter("cmd");
        DAO dao;

        request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));
        //stando o valor default do cmd
        if (cmd == null) {
            cmd = "principal";
        }

        try {
            dao = new UsuarioDAO();
            RequestDispatcher rd = null; //setando o objeto "despachador"
            if (cmd.equalsIgnoreCase("saveAdd")) {
                String nomeUsuario = request.getParameter("nomeUsuario");
                String telefone1Usuario = request.getParameter("telefone1Usuario");
                String telefone2Usuario = request.getParameter("telefone2Usuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String tipoUsuario = request.getParameter("tipoUsuario");
                String dataNascimentoUsuario = request.getParameter("dataNascimentoUsuario");
                String sexoUsuario = request.getParameter("sexoUsuario");
                String passwordUsuario = request.getParameter("passwordUsuario");

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(dataNascimentoUsuario).getTime());

                Usuario usuario = new Usuario(nomeUsuario, telefone1Usuario, telefone2Usuario, emailUsuario, tipoUsuario, data, sexoUsuario, passwordUsuario);
                dao.salvar(usuario);
                getServletContext().getRequestDispatcher("/TelaPrincipal.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("listar")) {
                List usuarioList = dao.listaTodos();//recebendo o ArrayList com todos os autores
                request.setAttribute("usuarioList", usuarioList); //enviando parametros via request
                //setando o despachador
                getServletContext().getRequestDispatcher("/usuarios.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("update")) {
                Usuario usuario;
                Integer idUsuario = Integer.parseInt(request.getParameter("id"));

                List usuarioList = dao.procura(new Usuario(idUsuario));
                request.setAttribute("usuarioList", usuarioList);
                getServletContext().getRequestDispatcher("/AlteraUsuario.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("saveUpdate")) {
                Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                String nomeUsuario = request.getParameter("nomeUsuario");
                String telefone1Usuario = request.getParameter("telefone1Usuario");
                String telefone2Usuario = request.getParameter("telefone2Usuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String tipoUsuario = request.getParameter("tipoUsuario");
                String dataNascimentoUsuario = request.getParameter("dataNascimentoUsuario");
                String sexoUsuario = request.getParameter("sexoUsuario");
                String passwordUsuario = request.getParameter("passwordUsuario");

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(dataNascimentoUsuario).getTime());

                Usuario usuario = new Usuario(idUsuario, nomeUsuario, telefone1Usuario, telefone2Usuario, emailUsuario, tipoUsuario, data, sexoUsuario, passwordUsuario);
                dao.atualizar(usuario);
                getServletContext().getRequestDispatcher("/usuarios?cmd=listar").forward(request, response);

            } else if (cmd.equalsIgnoreCase("add")) {
                getServletContext().getRequestDispatcher("/CadastroUsuario.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("del")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Usuario uso = new Usuario(id);
                dao.excluir(uso);
                getServletContext().getRequestDispatcher("/usuarios?cmd=listar").forward(request, response);
            } 

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
