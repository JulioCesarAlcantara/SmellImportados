/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.Produto;
import cdc.model.ProdutoDAO;
import cdc.util.DAO;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author cesar
 */
public class ServletProduto extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        String cmd = request.getParameter("cmd");
        DAO dao;

        request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));
        //setando o valor default do cmd
        if (cmd == null) {
            cmd = "principal";
        }

        try {
            dao = new ProdutoDAO();
            Produto produto = new Produto(); 
            Blob blob;
            RequestDispatcher rd = null; //setando o objeto "despachador"
            if (cmd.equalsIgnoreCase("saveAdd")) {
                String nomeProduto = request.getParameter("nomeProduto");
                String precoProduto = request.getParameter("precoProduto");
                
                //converter String para float; 
                float preco = Float.parseFloat(precoProduto);                
                
                String descricaoProduto = request.getParameter("descricaoProduto");
                String imagemProduto = request.getParameter("imagemProduto");
                
                //converter a imagem para base 64; 
                byte[] imagemByte = imagemProduto.getBytes(); // a variavel imagem é o caminho aonde o arquivo está salvo (D:/Downloads/imagem.jpg)
                blob = new SerialBlob(imagemByte);
                
                
                /*possíveis mudanças no BD 
                    * Unir tabela de categorias com Produtos ; 
                    * Separar imagem de Produto;
                    * nomeclatura da tabela PalavrasChave; 
                    
                */ 
                String palavra1PalavraChave = request.getParameter("palavra1PalavraChave");
                String palavra2PalavraChave = request.getParameter("palavra2PalavraChave");
                String palavra3PalavraChave = request.getParameter("palavra3PalavraChave");
                String categoria = request.getParameter("categoria");
                
                Produto produtoMontado = new Produto(null, nomeProduto,preco, descricaoProduto, blob, null, null);
                dao.salvar(produtoMontado);
                
                rd = request.getRequestDispatcher("/index.html");
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
