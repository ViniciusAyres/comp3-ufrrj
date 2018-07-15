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
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LocalDataMapperTest {

    @Before
    public void setUp() throws Exception {
        String insert_1 = "INSERT INTO LOCAL (NOME, ENDERECO, TAMANHO_PISCINA)" +
                " VALUES ('LOCAL_TEST', 'ENDERECO_TEST', 1)";

        SQL.getPreparedStatement(insert_1).executeUpdate();
    }

    @After
    public void tearDown() throws Exception {
        String sql = "DELETE FROM LOCAL\n" +
                "WHERE NOME = 'LOCAL_TEST'";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.executeUpdate();
    }

    @Test
    public void testBuscarTodos() throws SQLException, RegistroNaoEncontradoException {

        RecordSet recordSet = LocalDataMapper.buscarTodos();
        Row row = recordSet.get(0);

        assertEquals("LOCAL_TEST", row.getString("nome"));
        assertEquals("ENDERECO_TEST", row.getString("endereco"));
        assertEquals(1, row.getInt("tamanhoPiscina"));

    }

    @Test
    public void testCriar() throws SQLException {

        RecordSet recordSet = new RecordSet();
        LocalDataMapper localDataMapper = new LocalDataMapper();
        Row row = new Row();

        String dadoNome = "CRIAR_NOME_TEST";
        String dadoEndereco = "CRIAR_ENDERECO_TEST";
        int    dadoTamanhoPiscina = 3;

        row.put("nome", dadoNome);
        row.put("endereco",dadoEndereco);
        row.put("tamanhoPiscina", dadoTamanhoPiscina);

        recordSet.add(row);

        localDataMapper.criar(recordSet);
        RecordSet recordSetTodos = LocalDataMapper.buscarTodos();
        Row row1 = recordSet.get(0);

        assertEquals(dadoNome, row.getString("nome"));
        assertEquals(dadoEndereco, row.getString("endereco"));
        assertEquals(dadoTamanhoPiscina, row.getInt("tamanhoPiscina"));

        String sql = "DELETE FROM LOCAL\n" +
                "WHERE NOME = 'CRIAR_NOME_TEST' and  " +
                "ENDERECO = 'CRIAR_ENDERECO_TEST'";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.executeUpdate();

    }

}
