package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import static org.junit.Assert.assertEquals;

public class ResultadoDataMapperTest {
    int idResultado;
    Time tempo = new Time(15,9,2);
    Time novoTempo = new Time(12,9,5);

    @Before
    public void setUp() throws Exception{
        String sql = "INSERT INTO RESULTADO (TEMPO, ID_COLOCACAO)\n"+
                "VALUES('15:09:02', 3)";

        Statement statement = (Statement) ConnectionSingleton.getInstance().createStatement();

        statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()){
            idResultado = rs.getInt(1);
        }
    }
    @After
    public void tearDown() throws Exception {
        String sql = "DELETE FROM RESULTADO\n" +
                "WHERE ID =" + Integer.toString(idResultado);

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.execute();
    }

    @Test
    public void testBuscarPorMatricula() throws SQLException {
        ResultSet resultSet = new ResultadoDataMapper().buscarPorId(idResultado);
        assertEquals(idResultado, resultSet.getInt("ID"));
        assertEquals( tempo, resultSet.getTime("TEMPO"));
        assertEquals(3, resultSet.getInt("ID_COLOCACAO"));
    }

    @Test
    public void testcriar() throws SQLException {
        boolean criado = new ResultadoDataMapper().criar(tempo, 8);

        ResultSet resultSet = new ResultadoDataMapper().buscarPorId(idResultado+1);
        assertEquals(idResultado+1, resultSet.getInt("ID"));
        assertEquals( tempo, resultSet.getTime("TEMPO"));
        assertEquals(8, resultSet.getInt("ID_COLOCACAO"));

        boolean alterado = new ResultadoDataMapper().atualizar(novoTempo, 1,idResultado+1);
        resultSet = new ResultadoDataMapper().buscarPorId(idResultado+1);
        assertEquals(idResultado+1, resultSet.getInt("ID"));
        assertEquals( novoTempo, resultSet.getTime("TEMPO"));
        assertEquals(1, resultSet.getInt("ID_COLOCACAO"));
    }


}
