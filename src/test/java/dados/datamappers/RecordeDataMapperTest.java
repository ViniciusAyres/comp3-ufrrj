package dados.datamappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class RecordeDataMapperTest {
    public void testBuscarPorId() throws SQLException {
        ResultSet resultSet = new RecordeDataMapper().buscarPorId(1);

        assertEquals(1, resultSet.getInt("ID"));
        assertEquals(7, resultSet.getInt("PONTUACAO"));
        assertEquals("RECORDE DE CIRCUITO", resultSet.getString(""));
    }
}
