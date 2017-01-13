package cdc.controller;

import cdc.model.ImagemProduto;
import cdc.model.PalavrasChave;
import cdc.model.Produto;
import cdc.model.ProdutoDAO;
import cdc.util.DAO;
import java.io.IOException;         
import java.util.logging.Level;
import java.util.logging.Logger;
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
            ProdutoDAO pd = new ProdutoDAO(); 
            RequestDispatcher rd = null; //setando o objeto "despachador"
            if (cmd.equalsIgnoreCase("saveAdd")) {
                String nomeProduto = request.getParameter("nomeProduto");
                String precoProduto = request.getParameter("precoProduto");
                System.out.println("chegou aqui !!");
                //converter String para float; 
                float preco = Float.parseFloat(precoProduto);                
                
                String descricaoProduto = request.getParameter("descricaoProduto");
                String imagemProduto1 = request.getParameter("imagemProduto1");
                String imagemProduto2 = request.getParameter("imagemProduto2");
                String imagemProduto3 = request.getParameter("imagemProduto3");
                
                //converter a imagem para base 64; 
                byte[] imagemByte1 = imagemProduto1.getBytes(); // a variavel imagem é o caminho aonde o arquivo está salvo (D:/Downloads/imagem.jpg)
                SerialBlob blob1 = new SerialBlob(imagemByte1);
                System.out.println("imagem1: " + blob1);
                
                byte[] imagemByte2 = imagemProduto2.getBytes(); // a variavel imagem é o caminho aonde o arquivo está salvo (D:/Downloads/imagem.jpg)
                SerialBlob blob2 = new SerialBlob(imagemByte2);
                
                byte[] imagemByte3 = imagemProduto3.getBytes(); // a variavel imagem é o caminho aonde o arquivo está salvo (D:/Downloads/imagem.jpg)
                SerialBlob blob3 = new SerialBlob(imagemByte3);
                
                String palavra1 = request.getParameter("palavra1");
                String palavra2 = request.getParameter("palavra2");
                String palavra3 = request.getParameter("palavra3");
                String categoria = request.getParameter("categoria");
                
                Produto produtoMontado = new Produto(nomeProduto, preco, descricaoProduto, categoria);
                dao.salvar(produtoMontado);
                int id = pd.buscaIdPeloNome(nomeProduto);
                
                
                ImagemProduto ip = new ImagemProduto(blob1, blob2, blob3); 
                pd.salvarImagem(ip);
                
                PalavrasChave pc = new PalavrasChave(palavra1, palavra2, palavra3, id);
                pd.salvarPalvras(pc);
                
                
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletProduto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletProduto.class.getName()).log(Level.SEVERE, null, ex);
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
