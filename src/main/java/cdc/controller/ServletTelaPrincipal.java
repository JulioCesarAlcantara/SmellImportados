/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.ListaImagemProduto;
import cdc.model.Produto;
import cdc.model.ProdutoDAO;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletTelaPrincipal extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String idProduto = request.getParameter("idProduto");
            List<ListaImagemProduto> listaComTudo = new ArrayList<ListaImagemProduto>();
            ProdutoDAO pro = new ProdutoDAO();

            listaComTudo = pro.listaProdutosParaCompra(idProduto);
            request.setAttribute("listaComTudo", listaComTudo);
            request.getRequestDispatcher("/MostraProdutoCompra.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ServletTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
