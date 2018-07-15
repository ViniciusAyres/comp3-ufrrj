package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.RecordSet;
import utils.Row;
import utils.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class AssociacaoDataMapperTest {

    private int idEndereco;

    @Before
    public void setUp() throws Exception {
        String insert_1 = "INSERT INTO ASSOCIACAO (NOME, MATRICULA, TELEFONE, SIGLA, ENDERECO)" +
                " VALUES ('ASSOCIACAO-TEST', '1', '1', 'TEST', 'Rua marques, 150')";

        SQL.getPreparedStatement(insert_1).executeUpdate();
    }

    @After
    public void tearDown() throws Exception {
        String sql = "DELETE FROM ASSOCIACAO\n" +
                "WHERE SIGLA = 'TEST'";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.executeUpdate();
    }

    @Test
    public void testBuscarPorMatricula() throws SQLException, RegistroNaoEncontradoException {
        RecordSet recordSet = AssociacaoDataMapper.buscarPorMatricula("1");
        Row row = recordSet.get(0);

        assertEquals("ASSOCIACAO-TEST", row.getString("nome"));
        assertEquals("1", row.getString("matricula"));
        assertEquals("1", row.getString("telefone"));
        assertEquals("TEST", row.getString("sigla"));
        assertEquals("Rua marques, 150", row.getString("endereco"));

    }

    @Test(expected = RegistroNaoEncontradoException.class)
    public void testRegistroNaoEncontradoException() throws RegistroNaoEncontradoException, SQLException {
        RecordSet recordSet = AssociacaoDataMapper.buscarPorMatricula("-1");
    }

    @Test
    public void testBuscar() throws RegistroNaoEncontradoException, SQLException {
        RecordSet recordSet = AssociacaoDataMapper.buscarPorMatricula("1");
        Row row = recordSet.get(0);
        assertNotNull(row);
    }

    @Test
    public void testAtualizar() throws SQLException {
        RecordSet recordSet = new RecordSet();
        Row row = new Row();

        row.put("matricula", "1");
        row.put("nome", "ASSOCIACAO-MODIFICADA");
        row.put("sigla", "TEST");
        row.put("telefone", "1");
        row.put("endereco", "Rua marrocos, 150");
        recordSet.add(row);

        AssociacaoDataMapper.atualizar(recordSet);

        assertEquals("ASSOCIACAO-MODIFICADA", row.getString("nome"));
        assertEquals("1", row.getString("matricula"));
        assertEquals("1", row.getString("telefone"));
        assertEquals("TEST", row.getString("sigla"));
        assertEquals("Rua marrocos, 150", row.getString("endereco"));

    }
}

