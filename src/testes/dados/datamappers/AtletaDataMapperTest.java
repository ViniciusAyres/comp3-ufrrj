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
import java.util.Date;

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
        Atleta atleta = new Atleta("Vinicius", "2015780481", new Date(), "MASCULINO");
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
        Atleta atleta = new Atleta("Vinicius", "2015780481", new Date(), "MASCULINO");
        AtletaDataMapper atletaDataMapper = new AtletaDataMapper();

        atletaDataMapper.criar(atleta);
        Atleta atletaBuscado = atletaDataMapper.buscarPorMatricula("2015780481");

        assertEquals(atleta.getMatricula(), atletaBuscado.getMatricula());
        assertEquals(atleta.getNome(), atletaBuscado.getNome());
        assertEquals(atleta.getDataNascimento(), atletaBuscado.getDataNascimento());
        assertEquals(atleta.getCategoria(), atletaBuscado.getCategoria());
    }

    @Test
    public void testAtualizarAtleta(){
        Atleta atleta = new Atleta("Vinicius", "2015780481", new Date(), "MASCULINO");
        AtletaDataMapper atletaDataMapper = new AtletaDataMapper();

        atletaDataMapper.criar(atleta);
        Atleta novoAtleta = new Atleta("Jorge", "2015780481", new Date(), "FEMININO");
        atletaDataMapper.atualizar(novoAtleta);

        Atleta atletaBuscado = atletaDataMapper.buscarPorMatricula("2015780481");

        assertEquals(novoAtleta.getMatricula(), atletaBuscado.getMatricula());
        assertEquals(novoAtleta.getNome(), atletaBuscado.getNome());
        assertEquals(novoAtleta.getDataNascimento(), atletaBuscado.getDataNascimento());
        assertEquals(novoAtleta.getCategoria(), atletaBuscado.getCategoria());
    }

}
