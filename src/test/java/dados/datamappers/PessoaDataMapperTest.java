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
    public void testBuscarPorMatricula() throws SQLException {
        ResultSet resultSet = new PessoaDataMapper().buscarPorMatricula("2015");

        resultSet.next();

        assertEquals("2015", resultSet.getString("MATRICULA"));
        assertEquals("usuario-teste", resultSet.getString("NOME"));
        assertEquals("123456", resultSet.getString("SENHA"));
        assertEquals(1, resultSet.getInt("ID_PERFIL"));

    }


    @Test
    public void criarPessoa() throws SQLException {

        PessoaDataMapper pessoaDataMapper = new PessoaDataMapper();

        Assert.assertEquals(true, pessoaDataMapper.criar("usuario-teste", "senha",
                1, "matricula", null));


    }
}
