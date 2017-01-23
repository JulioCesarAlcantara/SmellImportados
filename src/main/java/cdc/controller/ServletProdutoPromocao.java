/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.ProdutoPromocao;
import cdc.model.ProdutoPromocaoDAO;
import cdc.model.Promocao;
import cdc.util.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erik
 */
public class ServletProdutoPromocao extends HttpServlet {

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
        ProdutoPromocaoDAO dao;

        request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));
        //stando o valor default do cmd
        if (cmd == null) {
            cmd = "principal";
        }

        try {
            dao = new ProdutoPromocaoDAO();
            RequestDispatcher rd = null; //setando o objeto "despachador"
            if (cmd.equalsIgnoreCase("saveAdd")) {
                Integer idPromocao = Integer.parseInt(request.getParameter("idPromocao"));
                String[] idProduto = request.getParameterValues("idProduto");
                Integer id;
                for (String produto : idProduto) {
                    id = Integer.parseInt(produto);
                    ProdutoPromocao prodPromo = new ProdutoPromocao(id, idPromocao);
                    dao.salvar(prodPromo);
                }

                rd = request.getRequestDispatcher("/index.html");
            } else if (cmd.equalsIgnoreCase("update")) {
                Integer idPromocao = Integer.parseInt(request.getParameter("id"));
                ProdutoPromocaoDAO dao1 = new ProdutoPromocaoDAO();
                List produtoList = dao1.buscaProdutosDeUmaPromocao(idPromocao);
                request.setAttribute("produtoList", produtoList);
                request.setAttribute("idPromocao", idPromocao);
                getServletContext().getRequestDispatcher("/AlteraProdutoPromocao.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("del")) {
                Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
                Integer idPromocao = Integer.parseInt(request.getParameter("idPromocao"));
                ProdutoPromocaoDAO dao1 = new ProdutoPromocaoDAO();
                dao1.delete(idProduto, idPromocao);
                getServletContext().getRequestDispatcher("/produtoPromocao?cmd=update&id="+idPromocao).forward(request, response);

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
