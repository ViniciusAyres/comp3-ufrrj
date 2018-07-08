package dados.datamappers;

import dados.entidades.Classe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClasseDataMapperTest {

    @Test
    public void testBuscarClasse1(){

        ClasseDataMapper classedatamapper = new ClasseDataMapper();
        Classe classe = classedatamapper.buscarPorId(1);

        assertEquals(1, classe.getId());
        assertEquals("MIRIM", classe.getNome());
        assertEquals(7, classe.getIdadeMinima());
        assertEquals(8, classe.getIdadeMaxima());
    }

    @Test
    public void testBuscarClasse2(){

        ClasseDataMapper classedatamapper = new ClasseDataMapper();
        Classe classe = classedatamapper.buscarPorId(2);

        assertEquals(2, classe.getId());
        assertEquals("MIRIM I/II", classe.getNome());
        assertEquals(9, classe.getIdadeMinima());
        assertEquals(10, classe.getIdadeMaxima());
    }

}
