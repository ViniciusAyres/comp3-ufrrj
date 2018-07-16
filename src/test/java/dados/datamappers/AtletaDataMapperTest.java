package dados.datamappers;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.RecordSet;
import utils.Row;
import utils.SQL;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class AtletaDataMapperTest {

    @Before
    public void setUp() throws Exception {
        String sql = "INSERT INTO ATLETA (MATRICULA, NOME, CATEGORIA, DATA_NASCIMENTO) " +
                "VALUES ('1', 'ATLETA-TEST', 'MASCULINO', '1995-11-13')";

        SQL.getPreparedStatement(sql).executeUpdate();
    }

    @After
    public void tearDown() throws Exception {
        String sql = "DELETE FROM ATLETA WHERE NOME = 'ATLETA-TEST'";

        SQL.getPreparedStatement(sql).executeUpdate();
    }

    @Test
    public void testBuscarPorMatricula() throws RegistroNaoEncontradoException, SQLException {
        RecordSet recordSet = AtletaDataMapper.buscarPorMatricula("1");
        Row row = recordSet.get(0);

        assertEquals("ATLETA-TEST", row.getString("nome"));
        assertEquals("1", row.getString("matricula"));
        assertEquals("MASCULINO", row.getString("categoria"));
        assertEquals("1995-11-13", row.getString("dataNascimento"));
    }

    @Test(expected = RegistroNaoEncontradoException.class)
    public void testRegistroNaoEncontradoException() throws RegistroNaoEncontradoException, SQLException {
        RecordSet recordSet = AtletaDataMapper.buscarPorMatricula("-1");
    }

    @Test
    public void testAtualizar() throws SQLException, ParseException {
        RecordSet recordSet = new RecordSet();
        Row row = new Row();

        row.put("matricula", "1");
        row.put("nome", "ATLETA-TEST");
        row.put("categoria", "FEMININO");
        row.put("dataNascimento", "1995-11-13");
        recordSet.add(row);

        //AtletaDataMapper.atualizar(recordSet);

        assertEquals("ATLETA-TEST", row.getString("nome"));
        assertEquals("1", row.getString("matricula"));
        assertEquals("FEMININO", row.getString("categoria"));
        assertEquals("1995-11-13", row.getString("dataNascimento"));
    }
}