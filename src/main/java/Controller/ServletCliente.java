package Controller;

import Conexao.DAO;
import DAO.ClienteDAO;
import Model.ClienteModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente", "/TelaPrincipal"})
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
        System.out.println("aqui 0");
        String cmd = request.getParameter("cmd");
        DAO dao;
        request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));

        if (cmd == null) {
            cmd = "principal";
        }

        try {
            dao = new ClienteDAO();
            RequestDispatcher rd = null;
            if (cmd.equalsIgnoreCase("cadastraCliente")) {
                Integer idCidadeCliente = Integer.parseInt(request.getParameter("idCidadeCliente"));
                String nomeCliente = request.getParameter("nomeCliente");
                String sexoCliente = request.getParameter("sexoCliente");
                String cpfCliente = request.getParameter("cpfCliente");
                String telefone1Cliente = request.getParameter("telefone1Cliente");
                String telefone2Cliente= request.getParameter("telefone2Cliente");
                String emailCliente= request.getParameter("emailCliente");
                String enderecoCliente = request.getParameter("endereçocliente");
                String cepCliente = request.getParameter("cepCliente");
                
                System.out.println("aqui 1");
               
                ClienteModel cliente = new ClienteModel(nomeCliente, sexoCliente, cpfCliente, telefone1Cliente, telefone2Cliente, emailCliente, enderecoCliente, cepCliente);                  
                dao.cadastra(cliente);
                rd=request.getRequestDispatcher("/TelaPrincipal.jsp");

            }
            
              rd.forward(request, response);
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
