package dados.datamappers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InscricaoDataMapperTest {

    @Before
    public void setUp() throws Exception {
//        InscricaoDataMapper inscricacaoDataMapper =
//                new InscricaoDataMapper();
//
//        Date date = new Date(1995, 6, 4);
//
//        Assert.assertEquals(true,
//                inscricacaoDataMapper.criar("111111", date,
//                        "2222", null, null ));
    }

    @Test
    public void testBuscarPorNumeroOficio() throws SQLException {

//        InscricaoDataMapper inscricacaoDataMapper =
//                new InscricaoDataMapper();
//
//        ResultSet resultSet = inscricacaoDataMapper.buscarPorNumeroOficio("111111");
//        resultSet.next();
//
//        Assert.assertEquals("111111", resultSet.getString("NUMERO_OFICIO"));
//        Assert.assertEquals("2222", resultSet.getString("NUMERO_PAGAMENTO"));

    }

    @Test
    public void  testCriarInscricao() throws SQLException {
//
//        InscricaoDataMapper inscricacaoDataMapper =
//                new InscricaoDataMapper();
//
//        Date date = new Date(1995, 6, 4);
//
//        Assert.assertEquals(true,
//                inscricacaoDataMapper.criar("Teste", date,
//                "Teste", null, null ));
//
//        inscricacaoDataMapper.excluir("Teste");

    }

    @After
    public void tearDown() throws Exception {

        InscricaoDataMapper inscricacaoDataMapper =
                new InscricaoDataMapper();
    }

}
