package dados.datamappers;

import dados.entidades.TipoCompeticao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TipoCompeticaoDataMapperTest {
    @Test
    public void testBuscarTipoCompeticao(){

        TipoCompeticaoDataMapper tipocompeticaodatamapper = new TipoCompeticaoDataMapper();
        TipoCompeticao perfil = tipocompeticaodatamapper.buscarPorId(1);

        assertEquals(1, perfil.getId());
        assertEquals("Festival", perfil.getNome());
    }

    @Test
    public void testBuscarTipoCompeticao2(){

        TipoCompeticaoDataMapper tipocompeticaodatamapper = new TipoCompeticaoDataMapper();
        TipoCompeticao perfil = tipocompeticaodatamapper.buscarPorId(2);

        assertEquals(2, perfil.getId());
        assertEquals("Grand Prix", perfil.getNome());
    }
}
