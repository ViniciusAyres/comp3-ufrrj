package dados.datamappers;


import dados.bancos.derbyDB.ConnectionSingleton;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TamanhoPiscinaMapperTest {

    @Test
    public void testBuscarPorId() throws SQLException {
        ResultSet resultSet = new TamanhoPiscinaDataMapper().buscarPorId(1);
        resultSet.next();

        assertEquals(1, resultSet.getInt("ID"));
        assertEquals(25, resultSet.getInt("TAMANHO"));
    }
}
