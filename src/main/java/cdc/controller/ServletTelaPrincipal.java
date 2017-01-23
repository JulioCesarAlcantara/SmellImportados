/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
@WebServlet("/MontaCompra")
public class ServletTelaPrincipal extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProduto = request.getParameter("idProduto");
        Produto p1 = new Produto();
        p1.setIdProduto(Integer.parseInt(idProduto));
        request.setAttribute("produto1", p1);
        request.getRequestDispatcher("/MostraProdutoCompra.jsp").forward(request, response);
    }
   
}
