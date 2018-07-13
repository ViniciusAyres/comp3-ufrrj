package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import org.junit.Test;
import utils.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtletaMTTest {
    @Test
    public void testGetMatriculas() throws SQLException, RegistroNaoEncontradoException {
        String sql = "SELECT * FROM ATLETA";
        ResultSet resultSet = SQL.getPreparedStatement(sql).executeQuery();

        AtletaMT atletaMT = new AtletaMT(resultSet);
        ArrayList<String> matriculas = atletaMT.getMatriculas();

        for(String matricula : matriculas){
            assertNotNull(matricula);
        }
    }
}