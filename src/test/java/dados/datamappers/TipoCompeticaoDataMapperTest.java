package dados.datamappers;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class TipoCompeticaoDataMapperTest {
    @Test
    public void testBuscarTipoCompeticao() throws SQLException {

        TipoCompeticaoDataMapper tipoCompeticaoDataMapper = new TipoCompeticaoDataMapper();
        ResultSet resultSet = tipoCompeticaoDataMapper.buscarPorId(1);

        assertEquals("Festival", resultSet.getString("NOME"));
        assertEquals(1, resultSet.getInt("ID"));
    }
}