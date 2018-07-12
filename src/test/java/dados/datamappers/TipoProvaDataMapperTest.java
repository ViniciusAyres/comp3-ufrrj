package dados.datamappers;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class TipoProvaDataMapperTest {

    @Test
    public void testTipoProva() throws SQLException {

        TipoProvaDataMapper tipoProva = new TipoProvaDataMapper();
        ResultSet resultSet = tipoProva.buscarPorId(1);
        resultSet.next();

        assertEquals("Individual", resultSet.getString("NOME"));
        assertEquals(1, resultSet.getInt("ID"));
    }

}
