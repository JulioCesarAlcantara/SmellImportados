/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.ItemCompra;
import cdc.model.ItemCompraDAO;
import cdc.model.ListaImagemProduto;
import cdc.model.ProdutoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletItemCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        try {

            String idProduto = request.getParameter("idPro");
            String idUsuario = session.getAttribute("idUsuarioLogin").toString();
            System.out.println("ID PRODUTO: " + idProduto);
            System.out.println("ID USUARIO: " + idUsuario);
            

            if (!idUsuario.isEmpty()) {
                ItemCompraDAO itemCompra = new ItemCompraDAO();
                itemCompra.salvarProdutoNoCarrinho(idProduto, idUsuario);

                List<ItemCompra> listaDeProdutosDoCarrinho = new ArrayList<ItemCompra>();
                ItemCompraDAO ic = new ItemCompraDAO();

                listaDeProdutosDoCarrinho = ic.listaIntemDoCarrinho(idUsuario);
                request.setAttribute("listaDeProdutosDoCarrinho", listaDeProdutosDoCarrinho);
                request.getRequestDispatcher("/ItemCompra.jsp").forward(request, response);

                request.getRequestDispatcher("/TelaPrincipal.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
            Logger.getLogger(ServletTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
