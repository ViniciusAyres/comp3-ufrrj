package dados.datamappers;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ProvaDataMapperTest {

    @Test
    public void testCriarProva() throws SQLException {

        Date data = new Date(1995, 6, 4);

        Assert.assertEquals(true,
                ProvaDataMapper.criar("Borboleta", data,
                        "Masculino", 4,
                        1, 2));
    }
}
