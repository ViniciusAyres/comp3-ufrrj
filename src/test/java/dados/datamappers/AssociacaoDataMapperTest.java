package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class AssociacaoDataMapperTest {

    private int idEndereco;

    @Before
    public void setUp() throws Exception {
        String sql2 = "INSERT INTO ENDERECO (COMPLEMENTO, NUMERO, CIDADE, BAIRRO, LOGRADOURO, CEP, UF)\n" +
                "VALUES('CASA', 1591, 'SJM' ,'FAVELA', 'RUA DA LINHA', '25558-471', 1)";


        Statement statement2 = (Statement) ConnectionSingleton.getInstance().createStatement();

        statement2.executeUpdate(sql2, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = statement2.getGeneratedKeys();
        if (rs.next()){
            idEndereco = rs.getInt(1);
        }


        String insert_1 = "INSERT INTO ASSOCIACAO (NOME, MATRICULA, TELEFONE, SIGLA, ID_ENDERECO)" +
                " VALUES ('A', '1', '1', 'TEST', " + Integer.toString(idEndereco) + ")";
        String insert_2 = "INSERT INTO ASSOCIACAO (NOME, MATRICULA, TELEFONE, SIGLA, ID_ENDERECO)" +
                " VALUES ('A', '2', '1', 'TEST', " + Integer.toString(idEndereco) + ")";
        String insert_3 = "INSERT INTO ASSOCIACAO (NOME, MATRICULA, TELEFONE, SIGLA, ID_ENDERECO)" +
                " VALUES ('A', '3', '1', 'TEST', " + Integer.toString(idEndereco) + ")";
        String insert_4 = "INSERT INTO ASSOCIACAO (NOME, MATRICULA, TELEFONE, SIGLA, ID_ENDERECO)" +
                " VALUES ('A', '4', '1', 'TEST', " + Integer.toString(idEndereco) + ")";

        SQL.getPreparedStatement(insert_1).execute();
        SQL.getPreparedStatement(insert_2).execute();
        SQL.getPreparedStatement(insert_3).execute();
        SQL.getPreparedStatement(insert_4).execute();

    }

    @After
    public void tearDown() throws Exception {
        String sql = "DELETE FROM ASSOCIACAO\n" +
                "WHERE SIGLA = 'TEST'";

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
    public void testBuscar() throws SQLException {
        ResultSet resultSet = new AssociacaoDataMapper().buscar();
        int cont = 0;

        while(resultSet.next()){
            cont++;
        }

        assertEquals(4, cont);
    }

    @Test
    public void testBuscarPorMatricula() throws SQLException {
//      //  ResultSet resultSet = new AssociacaoDataMapper().buscarPorMatricula("1");
//        resultSet.next();
//
//        assertEquals("1", resultSet.getString("MATRICULA"));
//        assertEquals("TEST", resultSet.getString("SIGLA"));
//        assertEquals("A", resultSet.getString("NOME"));
//        assertEquals(Integer.toString(idEndereco), resultSet.getString("ID_ENDERECO"));
//        assertEquals("1", resultSet.getString("TELEFONE"));

        }

    @Test
    public void testeBuscarQuantidadesAssociados() throws SQLException {

        AssociacaoDataMapper associacaoDataMapper = new AssociacaoDataMapper();
       // int quantidadeAssociado = associacaoDataMapper.buscarQuantidadesAssociados();
       // assertNotEquals(0,  quantidadeAssociado);
    }

}

