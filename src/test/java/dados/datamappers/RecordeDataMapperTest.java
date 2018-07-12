package dados.datamappers;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class RecordeDataMapperTest {
    @Test
    public void testBuscarPorId() throws SQLException {
        ResultSet resultSet = new RecordeDataMapper().buscarPorId(1);
        resultSet.next();

        assertEquals(1, resultSet.getInt("ID"));
        assertEquals(7, resultSet.getInt("PONTUACAO"));
        assertEquals("RECORDE DE CIRCUITO", resultSet.getString("NOME"));
    }
}
