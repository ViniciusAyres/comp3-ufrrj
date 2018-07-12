package utils;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UtilsTest {
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
    public void testAutenticarIdMesmoPerfil() throws RegistroNaoEncontradoException, SQLException {
        String matricula = "2015";
        String senha = "123456";
        int perfilExigido = 1;

        assertTrue(Utils.isValido(matricula, senha, perfilExigido));
    }


}