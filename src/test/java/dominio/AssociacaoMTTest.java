package dominio;

import dominio.excecoes.RegistroInvalido;
import org.junit.Test;
import utils.RecordSet;
import utils.Row;


public class AssociacaoMTTest {

    @Test(expected = RegistroInvalido.class)
    public void testRegistroInvalido() throws RegistroInvalido {
        RecordSet recordSet = new RecordSet();
        Row row = new Row();
        recordSet.add(row);

        new AssociacaoMT(recordSet);
    }

}