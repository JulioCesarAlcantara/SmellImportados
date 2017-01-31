/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import cdc.model.Compra;
import cdc.model.CompraDAO;
import cdc.model.ItemCompra;
import cdc.model.ItemCompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String cmd = request.getParameter("cmd");

        if (cmd == null) {
            cmd = "listar";
        }

        try {

            String idUsuario = session.getAttribute("idUsuarioLogin").toString();

            if (!idUsuario.isEmpty() && !cmd.equalsIgnoreCase("del") && !cmd.equalsIgnoreCase("fin")) {

                List<ItemCompra> listaDeProdutosDoCarrinho = new ArrayList<ItemCompra>();
                ItemCompraDAO ic = new ItemCompraDAO();
                listaDeProdutosDoCarrinho = ic.listaIntemDoCarrinho(idUsuario);
                float precoTotal = 0;
                for (ItemCompra item : listaDeProdutosDoCarrinho) {
                    precoTotal += item.getPrecoProduto();
                }

                //List precoTotal = ic.somaPrecoItensCarrinho(idUsuario);
                request.setAttribute("precoTotal", precoTotal);
                request.setAttribute("listaDeProdutosDoCarrinho", listaDeProdutosDoCarrinho);
                request.getRequestDispatcher("/ItemCompra.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("del")) {
                String id = request.getParameter("idProduto");
                ItemCompraDAO carrinho = new ItemCompraDAO();
                carrinho.excluirDocarrinho(id);
                response.sendRedirect("Carrinho?");
            } else if (cmd.equalsIgnoreCase("fin")) {
                CompraDAO compraDAO = new CompraDAO();
                Compra compra = new Compra();
                Integer id = Integer.parseInt(request.getParameter("idUsuario"));
                Float valor = Float.parseFloat(request.getParameter("valorCompra"));
                compra.setIdUsuarioCompra(id);
                compra.setPrecoCompra(valor);
                compra.setFreteCompra(4);
                compraDAO.salvar(compra);
                 
                //request.getRequestDispatcher("/TelaPrincipal.jsp").forward(request, response);
            } else {
                System.out.println("deu ruim");
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
            Logger.getLogger(ServletTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
