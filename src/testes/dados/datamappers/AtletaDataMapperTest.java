package testes.dados.datamappers;


import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.AtletaDataMapper;
import dados.entidades.Atleta;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AtletaDataMapperTest {

    @Before
    public void setUp() throws Exception {
        PreparedStatement statement;

        String sql = "DELETE FROM ATLETA";
        try {
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCriarAtleta() {
        Atleta atleta = new Atleta("Vinicius", "2015780481", new Date(1995, 12, 3), "MASCULINO");
        AtletaDataMapper atletaDataMapper = new AtletaDataMapper();

        atletaDataMapper.criar(atleta);

        PreparedStatement statement;

        String sql = "SELECT * FROM ATLETA";
        try {
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            assertNotNull(resultSet);

            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testBuscarAtleta(){
        String sql = "INSERT INTO ATLETA (NOME, MATRICULA, DATA_NASCIMENTO, CATEGORIA) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, "Vinicius");
            statement.setString(2, "2015780481");
            statement.setDate(3, new Date(1995, 12, 03));
            statement.setString(4, "MASCULINO");
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AtletaDataMapper atletaDataMapper = new AtletaDataMapper();
        Atleta atleta = atletaDataMapper.buscarPorMatricula("2015780481");

        assertEquals("2015780481", atleta.getMatricula());
        assertEquals("Vinicius", atleta.getNome());
        assertEquals(new Date(1995, 12, 03), atleta.getDataNascimento());
        assertEquals("MASCULINO", atleta.getCategoria());
    }

    @Test
    public void testAtualizarAtleta(){
        String sql = "INSERT INTO ATLETA (NOME, MATRICULA, DATA_NASCIMENTO, CATEGORIA) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, "Vinicius");
            statement.setString(2, "2015780481");
            statement.setDate(3, new Date(1995, 12, 03));
            statement.setString(4, "MASCULINO");
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Atleta atleta = new Atleta("Julia", "2015780481", new Date(2000, 11, 20), "FEMININO");
        AtletaDataMapper atletaDataMapper = new AtletaDataMapper();
        atletaDataMapper.atualizar(atleta);

        Atleta atletaBuscado = atletaDataMapper.buscarPorMatricula("2015780481");

        assertEquals("2015780481", atletaBuscado.getMatricula());
        assertEquals("Julia", atletaBuscado.getNome());
        assertEquals(new Date(2000, 11, 20), atletaBuscado.getDataNascimento());
        assertEquals("FEMININO", atletaBuscado.getCategoria());
    }

}
