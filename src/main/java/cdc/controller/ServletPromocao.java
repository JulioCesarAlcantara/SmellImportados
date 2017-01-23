package cdc.controller;

import cdc.model.Promocao;
import cdc.model.Usuario;
import cdc.model.PromocaoDAO;
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
public class ServletPromocao extends HttpServlet {

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
            dao = new PromocaoDAO();
            RequestDispatcher rd = null; //setando o objeto "despachador"
            if (cmd.equalsIgnoreCase("saveAdd")) {
                String nomePromocao = request.getParameter("nomePromocao");
                String dataInicioPromocao = request.getParameter("dataInicioPromocao");
                String dataFimPromocao = request.getParameter("dataFimPromocao");
                Float descontoPromocao = Float.parseFloat(request.getParameter("descontoPromocao"));
                String statusPromocao = request.getParameter("statusPromocao");

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dataI = new java.sql.Date(format.parse(dataInicioPromocao).getTime());
                java.sql.Date dataF = new java.sql.Date(format.parse(dataFimPromocao).getTime());

                Promocao promo = new Promocao(nomePromocao, dataI, dataF, descontoPromocao, statusPromocao);
                dao.salvar(promo);
                getServletContext().getRequestDispatcher("/promocao?cmd=listar").forward(request, response);
            } else if (cmd.equalsIgnoreCase("listar")) {
                List promocaoList = dao.listaTodos();//recebendo o ArrayList com todos os autores
                request.setAttribute("promocaoList", promocaoList); //enviando parametros via request
                //setando o despachador
                getServletContext().getRequestDispatcher("/promocoes.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("update")) {
                Integer idPromocao = Integer.parseInt(request.getParameter("id"));

                List promocaoList = dao.procura(new Promocao(idPromocao));
                request.setAttribute("promocaoList", promocaoList);
                getServletContext().getRequestDispatcher("/AlteraPromocao.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("saveUpdate")) {
                Integer idPromocao = Integer.parseInt(request.getParameter("idPromocao"));
                String nomePromocao = request.getParameter("nomePromocao");
                String dataInicioPromocao = request.getParameter("dataInicioPromocao");
                String dataFimPromocao = request.getParameter("dataFimPromocao");
                Float descontoPromocao = Float.parseFloat(request.getParameter("descontoPromocao"));
                String statusPromocao = request.getParameter("statusPromocao");

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dataI = new java.sql.Date(format.parse(dataInicioPromocao).getTime());
                java.sql.Date dataF = new java.sql.Date(format.parse(dataFimPromocao).getTime());

                Promocao promo = new Promocao(idPromocao, nomePromocao, dataI, dataF, descontoPromocao, statusPromocao);
                dao.atualizar(promo);
                getServletContext().getRequestDispatcher("/promocao?cmd=listar").forward(request, response);

            } else if (cmd.equalsIgnoreCase("add")) {
                getServletContext().getRequestDispatcher("/CadastroPromocao.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("del")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Promocao promo = new Promocao(id);
                dao.excluir(promo);
                getServletContext().getRequestDispatcher("/promocao?cmd=listar").forward(request, response);
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
