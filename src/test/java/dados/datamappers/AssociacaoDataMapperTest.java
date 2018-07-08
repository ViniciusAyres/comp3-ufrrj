package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class AssociacaoDataMapperTest {
    @Before
    public void setUp() throws Exception {
        String sql = "INSERT INTO ASSOCIACAO (TELEFONE, SIGLA, NOME, MATRICULA, ID_ENDERECO)\n" +
                "VALUES ('27567580', 'CBF', 'CONFEDERACAO', 'MAT123', 2)";


        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.execute();
    }

    @After
    public void tearDown() throws Exception {
        String sql = "DELETE FROM ASSOCIACAO\n" +
                "WHERE MATRICULA = 'MAT123'";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.execute();

    }

    @Test
    public void testBuscarPorMatricula() throws SQLException {
        ResultSet resultSet = new AssociacaoDataMapper().buscarPorMatricula("MAT123");

        assertEquals("MAT123", resultSet.getString("MATRICULA"));
        assertEquals("CBF", resultSet.getString("SIGLA"));
        assertEquals("CONFEDERACAO", resultSet.getString("NOME"));
        assertEquals("2", resultSet.getString("ID_ENDERECO"));
        assertEquals("27567580", resultSet.getString("TELEFONE"));

        }
}

