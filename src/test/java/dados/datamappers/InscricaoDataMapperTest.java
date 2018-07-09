package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InscricaoDataMapperTest {

    @Test
    public void  testCriarInscricao() throws SQLException {

        InscricaoDataMapper inscricacaoDataMapper =
                new InscricaoDataMapper();

        Date date = new Date(1995, 6, 4);

        Assert.assertEquals(true,
                inscricacaoDataMapper.criar("Teste", date,
                "Teste", null, null ));

        inscricacaoDataMapper.excluir("Teste");

    }
}
