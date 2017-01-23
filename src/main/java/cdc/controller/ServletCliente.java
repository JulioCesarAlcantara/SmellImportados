package cdc.controller;

import cdc.model.ClienteDAO;
import Model.ClienteModel;
import java.io.IOException;
import cdc.util.DAO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
//@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente", "/TelaPrincipal"})
public class ServletCliente extends HttpServlet {

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
            dao = new ClienteDAO();
            RequestDispatcher rd = null;
            if (cmd.equalsIgnoreCase("saveAdd")) {
                //  Integer idCidadeCliente = Integer.parseInt(request.getParameter("idCidadeCliente"));
                String nomeCliente = request.getParameter("nomeCliente");
                String sexoCliente = request.getParameter("sexoCliente");
                String cpfCliente = request.getParameter("cpfCliente");
                String dataNascimentoCliente = request.getParameter("dataNascimentoCliente");
                String telefone1Cliente = request.getParameter("telefone1Cliente");
                String telefone2Cliente = request.getParameter("telefone2Cliente");
                String emailCliente = request.getParameter("emailCliente");
                String enderecoCliente = request.getParameter("enderecoCliente");
                String cepCliente = request.getParameter("cepCliente");
                String cidadeCliente = request.getParameter("cidadeCliente");
                String estadoCliente = request.getParameter("estadoCliente");
                String passwordCliente = request.getParameter("passwordCliente");

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(dataNascimentoCliente).getTime());
                System.out.println(data);

                ClienteModel cliente = new ClienteModel(nomeCliente, telefone1Cliente, telefone2Cliente, emailCliente, cepCliente, data, sexoCliente, cpfCliente, enderecoCliente, cepCliente, passwordCliente, cidadeCliente, estadoCliente);
                dao.salvar(cliente);
                getServletContext().getRequestDispatcher("/TelaPrincipal.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("listar")) {
                List clienteList = dao.listaTodos();//recebendo o ArrayList com todos os autores
                request.setAttribute("clienteList", clienteList); //enviando parametros via request
                //setando o despachador
                getServletContext().getRequestDispatcher("/clientes.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("update")) {
                Integer idCliente = Integer.parseInt(request.getParameter("id"));

                List clienteList = dao.procura(new ClienteModel(idCliente));
                request.setAttribute("clienteList", clienteList);
                getServletContext().getRequestDispatcher("/AlteraCliente.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("saveUpdate")) {
                Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
                String nomeCliente = request.getParameter("nomeCliente");
                String sexoCliente = request.getParameter("sexoCliente");
                String cpfCliente = request.getParameter("cpfCliente");
                String dataNascimentoCliente = request.getParameter("dataNascimentoCliente");
                String telefone1Cliente = request.getParameter("telefone1Cliente");
                String telefone2Cliente = request.getParameter("telefone2Cliente");
                String emailCliente = request.getParameter("emailCliente");
                String enderecoCliente = request.getParameter("enderecoCliente");
                String cepCliente = request.getParameter("cepCliente");
                String cidadeCliente = request.getParameter("cidadeCliente");
                String estadoCliente = request.getParameter("estadoCliente");
                String passwordCliente = request.getParameter("passwordCliente");

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(dataNascimentoCliente).getTime());
                System.out.println(data);
                ClienteModel cliente = new ClienteModel(idCliente, nomeCliente, telefone1Cliente, telefone2Cliente, emailCliente, cepCliente, data, sexoCliente, cpfCliente, enderecoCliente, cepCliente, passwordCliente, cidadeCliente, estadoCliente);
                dao.atualizar(cliente);
                getServletContext().getRequestDispatcher("/clientes?cmd=listar").forward(request, response);

            } else if (cmd.equalsIgnoreCase("add")) {
                getServletContext().getRequestDispatcher("/CadastroClientes.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("del")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                ClienteModel cli = new ClienteModel(id);
                dao.excluir(cli);
                getServletContext().getRequestDispatcher("/clientes?cmd=listar").forward(request, response);
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
