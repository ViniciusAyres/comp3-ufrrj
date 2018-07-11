package dominio;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class PessoaMDTest {
    @Before
    public void setUp() throws Exception {
        String insert = "INSERT INTO PESSOA (SENHA, NOME, ID_PERFIL, MATRICULA)\n" +
            "    VALUES ('123456', 'usuario-teste', 1, '2015')";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(insert);

        statement.execute();
    }

    @After
    public void tearDown() throws Exception {
        String delete = "DELETE FROM PESSOA WHERE NOME = 'usuario-teste'";
        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(delete);

        statement.execute();
    }

    @Test
    public void testBuscarPessoa() throws SQLException, RegistroNaoEncontradoException {
        String query = "SELECT * FROM PESSOA";
        ResultSet resultSet = ConnectionSingleton.getInstance()
                                .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)
                                .executeQuery(query);

        PessoaMD pessoaMD = new PessoaMD(resultSet);

        assertEquals("usuario-teste", pessoaMD.getNome("2015"));
        assertEquals("123456", pessoaMD.getSenha("2015"));
        assertEquals(1, pessoaMD.getPerfil("2015"));
        assertNull(pessoaMD.getMatriculaAssociacao("2015"));

    }

    @Test(expected = RegistroNaoEncontradoException.class)
    public void testRegistroNaoEncontradoException() throws SQLException, RegistroNaoEncontradoException {
        String query = "SELECT * FROM PESSOA";
        ResultSet resultSet = ConnectionSingleton.getInstance()
                .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)
                .executeQuery(query);

        PessoaMD pessoaMD = new PessoaMD(resultSet);

        assertEquals("usuario-teste", pessoaMD.getNome("matriculaNaoExistente"));
    }
}