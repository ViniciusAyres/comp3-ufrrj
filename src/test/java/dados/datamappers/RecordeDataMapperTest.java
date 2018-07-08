package dados.datamappers;
import dados.entidades.Recorde;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class RecordeDataMapperTest {
    @Test
    public void testBuscarPorId() {
        RecordeDataMapper recordeDataMapper = new RecordeDataMapper();
        Recorde recorde = (Recorde) recordeDataMapper.buscarPorId(1);

        assertNotNull(recorde);
    }
}
