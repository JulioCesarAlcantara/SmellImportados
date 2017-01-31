/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.Usuario;
import cdc.model.UsuarioDAO;
import cdc.util.DAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erik
 */
public class ServletLogin extends HttpServlet {

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

        if (cmd == null) {
            cmd = "principal";
        }

        try {
            UsuarioDAO usu = new UsuarioDAO();
            RequestDispatcher rd = null;
            if (cmd.equalsIgnoreCase("login")) {
                //  Integer idCidadeCliente = Integer.parseInt(request.getParameter("idCidadeCliente"));
                String email = request.getParameter("emailUsuario");
                String senha = request.getParameter("passwordUsuario");
                System.out.println("parei aqui");
                boolean resultado = usu.verificaLogin(email, senha);

                if (resultado) {
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(60);
                    UsuarioDAO usuario = new UsuarioDAO();

                    String idUsuario = Integer.toString(usuario.buscaIdUsuarioPeloLogin(email));

                    session.setAttribute("idUsuarioLogin", idUsuario);
                    UsuarioDAO user = new UsuarioDAO();
                    Usuario usuario1 = new Usuario();
                    usuario1.setIdUsuario(Integer.parseInt(idUsuario));
                    List<Usuario> usuarioList = user.procura(usuario1);
                    String tipoUsuario = null;
                    for (Usuario us : usuarioList) {
                        tipoUsuario = us.getTipoUsuario();
                    }
                    if (tipoUsuario != null) {
                        session.setAttribute("tipoUsuario", tipoUsuario);
                    }
                    System.out.println(tipoUsuario);
                    getServletContext().getRequestDispatcher("/TelaPrincipal.jsp");

                } else {
                    getServletContext().getRequestDispatcher("/CadastroCliente.jsp").forward(request, response);
                }
                //    rd = request.getRequestDispatcher("/TelaPrincipal.jsp");

                getServletContext().getRequestDispatcher("/TelaPrincipal.jsp").forward(request, response);

            } else {
                rd = request.getRequestDispatcher("/index.html");

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
