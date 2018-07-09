package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class AssociacaoDataMapperTest {

    private int idEndereco;

    @Before
    public void setUp() throws Exception {
        String sql2 = "INSERT INTO ENDERECO (COMPLEMENTO, NUMERO, CIDADE, BAIRRO, LOGRADOURO, CEP, ID_UF)\n" +
                "VALUES('CASA', 1591, 'SJM' ,'FAVELA', 'RUA DA LINHA', '25558-471', 1)";


        Statement statement2 = (Statement) ConnectionSingleton.getInstance().createStatement();

        statement2.executeUpdate(sql2, Statement.RETURN_GENERATED_KEYS);


        ResultSet rs = statement2.getGeneratedKeys();
        if (rs.next()){
            idEndereco = rs.getInt(1);
        }


        String sql = "INSERT INTO ASSOCIACAO (TELEFONE, SIGLA, NOME, MATRICULA, ID_ENDERECO)\n" +
                "VALUES ('27567580', 'CBF', 'CONFEDERACAO', 'MAT123',"+Integer.toString(idEndereco)+" )";


        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.execute();


    }

    @After
    public void tearDown() throws Exception {
        String sql = "DELETE FROM ASSOCIACAO\n" +
                "WHERE MATRICULA = 'MAT123'";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.execute();

        String sql2 = "DELETE FROM ENDERECO\n" +
                "WHERE ID = " + Integer.toString(idEndereco);

        PreparedStatement statement2 = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql2);

        statement2.execute();

    }


    @Test
    public void testBuscarPorMatricula() throws SQLException {
        ResultSet resultSet = new AssociacaoDataMapper().buscarPorMatricula("MAT123");

        assertEquals("MAT123", resultSet.getString("MATRICULA"));
        assertEquals("CBF", resultSet.getString("SIGLA"));
        assertEquals("CONFEDERACAO", resultSet.getString("NOME"));
        assertEquals(Integer.toString(idEndereco), resultSet.getString("ID_ENDERECO"));
        assertEquals("27567580", resultSet.getString("TELEFONE"));

        }
}

