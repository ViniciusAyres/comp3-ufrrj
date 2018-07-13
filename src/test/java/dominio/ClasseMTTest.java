package dominio;

import dados.datamappers.excecoes.ClasseNaoEncontradaException;
import org.junit.Test;
import utils.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ClasseMTTest {
    @Test
    public void testGetClasse() throws SQLException, ClasseNaoEncontradaException {
        String sql = "SELECT * FROM CLASSE";
        ResultSet resultSet = SQL.getPreparedStatement(sql).executeQuery();

        ClasseMT classeMT = new ClasseMT(resultSet);
        assertEquals("JUVENIL I-II", classeMT.getClasse(18));
    }
}