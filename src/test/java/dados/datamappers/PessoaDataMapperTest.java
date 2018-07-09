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
        String sql = "INSERT INTO PESSOA (SENHA, NOME, MATRICULA , ID_PERFIL)\n" +
                "VALUES ('123123', 'Teste', '1212',  1)";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.execute();
    }

    @After
    public void tearDown() throws Exception {
        String sql = "DELETE FROM PESSOA WHERE MATRICULA = '1212'";
        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.execute();
    }

    @Test
    public void testBuscarPorMatricula() throws SQLException {
        ResultSet resultSet = new PessoaDataMapper().buscarPorMatricula("1212");

        assertEquals("1212", resultSet.getString("MATRICULA"));
        assertEquals("Teste", resultSet.getString("NOME"));
        assertEquals("123123", resultSet.getString("SENHA"));
        assertEquals(1, resultSet.getInt("ID_PERFIL"));

    }


    @Test
    public void criarPessoa() throws SQLException {

        PessoaDataMapper pessoaDataMapper = new PessoaDataMapper();

       Assert.assertEquals(true,  pessoaDataMapper.criar("Lucas", "asa2",
               1, "12312",  null));
    }
}
