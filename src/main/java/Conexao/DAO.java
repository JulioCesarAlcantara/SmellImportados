package Conexao;

import java.util.List;

/**
 *
 * @author cesar
 */
public interface DAO {

    void atualizar(Object ob) throws Exception;

    void excluir(Object ob) throws Exception;

    List listaTodos() throws Exception;

    List procura(Object ob) throws Exception;

    void cadastra(Object ob) throws Exception;
}
