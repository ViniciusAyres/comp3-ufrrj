package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class PessoaDataMapperTest {
    @Before
    public void setUp() throws Exception {
        String insert = "INSERT INTO PESSOA (SENHA, NOME, ID_PERFIL, MATRICULA)\n" +
                "    VALUES ('senha', 'usuario-teste', 1, 'matricula')";

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
    public void testBuscarPorMatricula() throws SQLException {
        ResultSet resultSet = new PessoaDataMapper().buscarPorMatricula("matricula");

        resultSet.next();

        assertEquals("matricula", resultSet.getString("MATRICULA"));
        assertEquals("usuario-teste", resultSet.getString("NOME"));
        assertEquals("senha", resultSet.getString("SENHA"));
        assertEquals(1, resultSet.getInt("ID_PERFIL"));

    }


    @Test
    public void testCriarPessoa() throws SQLException {

        PessoaDataMapper pessoaDataMapper = new PessoaDataMapper();

        Assert.assertEquals(true, pessoaDataMapper.criar("usuario-teste", "senha",
                1, "teste-criacao", null));


    }
}
