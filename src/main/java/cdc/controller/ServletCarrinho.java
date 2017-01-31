/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.controller;

import Model.ClienteModel;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import cdc.model.ClienteDAO;
import cdc.model.Compra;
import cdc.model.CompraDAO;
import cdc.model.ItemCompra;
import cdc.model.ItemCompraDAO;
import cdc.model.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
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
                ClienteDAO a = new ClienteDAO();
                ClienteModel b = new ClienteModel();
                b.setIdCliente(id);
                List<ClienteModel> dadosDoCliente = a.procura(b);
                ClienteModel clienteModel = new ClienteModel();

                for (ClienteModel cliente : dadosDoCliente) {
                    clienteModel.setNomeCliente(cliente.getNomeCliente());
                    clienteModel.setCepCliente(cliente.getCepCliente());
                    clienteModel.setCidadeCliente(cliente.getCidadeCliente());
                    clienteModel.setEstadoCliente(cliente.getEstadoCliente());
                    clienteModel.setEnderecoCliente(cliente.getEnderecoCliente());
                    clienteModel.setCpfCliente(cliente.getCpfCliente());
                }

//                Date date = null;
//                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year = 2017;
                int month = 03;
                int day = 02;

                Datas datas = Datas.novasDatas()
                        .comDocumento(day, month, year)
                        .comProcessamento(day, month, year)
                        .comVencimento(day + 10, month, year);

                Endereco enderecoBeneficiario = Endereco.novoEndereco()
                        .comLogradouro("Smell Importados, 000")
                        .comBairro("Jardim Suiço")
                        .comCep("75400-000")
                        .comCidade("Inhumas")
                        .comUf("GO");

                //Quem emite o boleto
                Beneficiario beneficiario = Beneficiario.novoBeneficiario()
                        .comNomeBeneficiario("Julio Cesar Alcântara Lopes")
                        .comAgencia("0496").comDigitoAgencia("0")
                        .comCodigoBeneficiario("35441")
                        .comDigitoCodigoBeneficiario("4")
                        .comNumeroConvenio("1207113")
                        .comCarteira("18")
                        .comEndereco(enderecoBeneficiario)
                        .comNossoNumero("92606360");

                Endereco enderecoPagador = Endereco.novoEndereco()
                        .comLogradouro(clienteModel.getEnderecoCliente())
                        .comBairro("Bairro")
                        .comCep(clienteModel.getCepCliente())
                        .comCidade(clienteModel.getCidadeCliente())
                        .comUf(clienteModel.getEstadoCliente());

                //Quem paga o boleto
                Pagador pagador = Pagador.novoPagador()
                        .comNome(clienteModel.getNomeCliente())
                        .comDocumento(clienteModel.getCpfCliente())
                        .comEndereco(enderecoPagador);

                Banco banco = new BancoDoBrasil();

                Boleto boleto = Boleto.novoBoleto()
                        .comBanco(banco)
                        .comDatas(datas)
                        .comBeneficiario(beneficiario)
                        .comPagador(pagador)
                        .comValorBoleto(valor)
                        .comNumeroDoDocumento("1234")
                        .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")
                        .comLocaisDePagamento("local 1", "local 2");

                GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

                // Para gerar um boleto em PDF  
                gerador.geraPDF("/home/cesar/Documentos/BancoDoBrasil.pdf");

                // Para gerar um boleto em PNG  
                gerador.geraPNG("/home/cesar/Documentos/BancoDoBrasil.png");

                compra.setIdUsuarioCompra(id);
                compra.setPrecoCompra(valor);
                compra.setFreteCompra(4);
                compraDAO.salvar(compra);
//                 
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
