package cdc.controller;

import cdc.model.ImagemProduto;
import cdc.model.ImagemProdutoDAO;
import cdc.model.ItemCompraDAO;
import cdc.model.Produto;
import cdc.model.ProdutoDAO;
import cdc.model.ProdutoPromocaoDAO;
import cdc.util.DAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            ProdutoDAO pd = new ProdutoDAO();
            ImagemProdutoDAO image = new ImagemProdutoDAO();
            RequestDispatcher rd = null; //setando o objeto "despachador

            if (cmd.equalsIgnoreCase("saveAdd")) {
                String nomeProduto = request.getParameter("nomeProduto");
                String descricaoProduto = request.getParameter("descricaoProduto");
                String precoProduto = request.getParameter("precoProduto");
                System.out.println("chegou aqui !!");
                //converter String para float; 
                float preco = Float.parseFloat(precoProduto);

                //aqui ta ok;
                String categoria = request.getParameter("categoria");
                String qntProduto = request.getParameter("quantidadeProduto");
                String imagem1 = request.getParameter("imagem1");
                String imagem2 = request.getParameter("imagem2");
                String imagem3 = request.getParameter("imagem3");
                //converter o id do produto para int; 
                int quantidadeProduto = Integer.parseInt(qntProduto);

                Produto produtoMontado = new Produto(nomeProduto, preco, descricaoProduto, categoria, quantidadeProduto);
                dao.salvar(produtoMontado);

                //busca o id do produto add, para add imagem; 
                int id = pd.buscaIdPeloNome(nomeProduto);

                ImagemProduto imagemModel = new ImagemProduto(imagem1, imagem2, imagem3, id);
                image.salvar(imagemModel);

                rd = request.getRequestDispatcher("/index.html");
            } else if (cmd.equalsIgnoreCase("listar")) {
                ProdutoDAO dao1 = new ProdutoDAO();
                List produtoList = dao1.pegaProdutos();
                request.setAttribute("produtoList", produtoList); //enviando parametros via request
                //setando o despachador
                getServletContext().getRequestDispatcher("/produtos.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("update")) {
                Integer idProduto = Integer.parseInt(request.getParameter("id"));

                //List produtoList = dao.procura(new Produto(idProduto));
                //request.setAttribute("produtoList", produtoList);
                getServletContext().getRequestDispatcher("/AlteraProduto.jsp").forward(request, response);

            } else if (cmd.equalsIgnoreCase("saveUpdate")) {
                Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
                String nomeProduto = request.getParameter("nomeProduto");
                String descricaoProduto = request.getParameter("descricaoProduto");
                String precoProduto = request.getParameter("precoProduto");
                float preco = Float.parseFloat(precoProduto);
                String categoria = request.getParameter("categoria");
                String qntProduto = request.getParameter("quantidadeProduto");
                // img
                String imagem1 = request.getParameter("imagem1");
                String imagem2 = request.getParameter("imagem2");
                String imagem3 = request.getParameter("imagem3");
                //converter o id do produto para int; 
                int quantidadeProduto = Integer.parseInt(qntProduto);

                Produto produtoMontado = new Produto(nomeProduto, preco, descricaoProduto, categoria, quantidadeProduto);
                dao.atualizar(produtoMontado);

                ImagemProduto imagemModel = new ImagemProduto(imagem1, imagem2, imagem3, idProduto);
                image.atualizar(imagemModel);

                getServletContext().getRequestDispatcher("/produtos?cmd=listar").forward(request, response);

            } else if (cmd.equalsIgnoreCase("add")) {
                getServletContext().getRequestDispatcher("/CadastraProdutos.jsp").forward(request, response);
            } else if (cmd.equalsIgnoreCase("del")) {
                Integer id = Integer.parseInt(request.getParameter("id"));
                Produto prod = new Produto(id);
                
                ProdutoPromocaoDAO prodProm = new ProdutoPromocaoDAO();
                ImagemProdutoDAO prodImg = new ImagemProdutoDAO();
                ItemCompraDAO itemCompra = new ItemCompraDAO();
                
                System.out.println(id);
                prodProm.excluirPromo(id);
                prodImg.excluirPromo(id);
                itemCompra.excluirPromo(id);
                dao.excluir(prod);
                getServletContext().getRequestDispatcher("/produtos?cmd=listar").forward(request, response);
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
        try {
            processRequest(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ServletProduto.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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

        try {
            processRequest(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ServletProduto.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
