package dados.datamappers;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PerfilDataMapperTest {

    @Test
    public void testBuscarPerfil() throws SQLException {

        PerfilDataMapper perfildatamapper = new PerfilDataMapper();

        ResultSet resultSet = perfildatamapper.buscarPorId(1);
        assertEquals(1, resultSet.getInt("ID"));
        assertEquals("Secretário", resultSet.getString("NOME"));

     }

}
