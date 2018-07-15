package dominio;

import dados.bancos.derbyDB.ConnectionSingleton;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AssociacaoMDTest {
    @Before
    public void setUp() throws Exception {
        String insert_1 = "INSERT INTO ASSOCIACAO (Nome, MATRICULA, TELEFONE) VALUES ('A', '1', '1')";
        String insert_2 = "INSERT INTO ASSOCIACAO (Nome, MATRICULA, TELEFONE) VALUES ('B', '2', '1')";
        String insert_3 = "INSERT INTO ASSOCIACAO (Nome, MATRICULA, TELEFONE) VALUES ('C','3', '1')";
        String insert_4 = "INSERT INTO ASSOCIACAO (Nome, MATRICULA, TELEFONE) VALUES ('D','4', '1')";

        SQL.getPreparedStatement(insert_1).execute();
        SQL.getPreparedStatement(insert_2).execute();
        SQL.getPreparedStatement(insert_3).execute();
        SQL.getPreparedStatement(insert_4).execute();

    }

    @After
    public void tearDown() throws Exception {
        String delete = "DELETE FROM ASSOCIACAO WHERE TELEFONE = '1'";
        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(delete);

        statement.execute();
    }

    @Test
    public void testGetMatriculas() throws SQLException {
        ArrayList<String> matriculas = new ArrayList<String>();
        matriculas.add("1");
        matriculas.add("2");
        matriculas.add("3");
        matriculas.add("4");


        String query = "SELECT * FROM ASSOCIACAO";
        PreparedStatement preparedStatement = SQL.getPreparedStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        //AssociacaoMT associacaoMD = new AssociacaoMT(resultSet);
        //assertEquals(matriculas, associacaoMD.getMatriculas());

    }
}