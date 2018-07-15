package dominio;

import dominio.excecoes.RegistroInvalido;
import org.junit.Assert;
import org.junit.Test;
import utils.RecordSet;
import utils.Row;

public class LocalCompeticaoMTTest {


    @Test(expected = RegistroInvalido.class)
    public void testRegistroInvalido() throws RegistroInvalido {
        RecordSet recordSet = new RecordSet();
        Row row = new Row();
        recordSet.add(row);

        new LocalCompeticaoMT(recordSet);
    }

    @Test(expected = RegistroInvalido.class)
    public void testRegistroInvalidoSemNome() throws RegistroInvalido {
        RecordSet recordSet = new RecordSet();
        Row row = new Row();
        row.put("tamanhoPiscina", 3);
        row.put("endereco", "teste");
        recordSet.add(row);

        new LocalCompeticaoMT(recordSet);
    }

    @Test(expected = RegistroInvalido.class)
    public void testRegistroInvalidoSemEndereco() throws RegistroInvalido {
        RecordSet recordSet = new RecordSet();
        Row row = new Row();
        row.put("tamanhoPiscina", 3);
        row.put("nome", "nome");
        recordSet.add(row);
        new LocalCompeticaoMT(recordSet);
    }

    @Test
    public void  testRegistroValido() throws RegistroInvalido {   RecordSet recordSet = new RecordSet();
        Row row = new Row();
        row.put("tamanhoPiscina", 3);
        row.put("nome", "nome");
        row.put("endereco", "teste");
        recordSet.add(row);
        new LocalCompeticaoMT(recordSet);

        Assert.assertNotNull(recordSet.get(0));
    }

}
