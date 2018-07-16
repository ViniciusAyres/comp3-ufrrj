package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecordSetTest {

    @Test
    public  void TestFind()
    {
        RecordSet recordSet = new RecordSet();
        Row row = new Row();
        row.put("Teste", "teste");
        recordSet.add(row);

        int ret1 = recordSet.find("Teste", "teste");
        int ret2= recordSet.find("aleatorio", "aleatorio");

        assertEquals(0, ret1);
        assertEquals(-1, ret2);

    }

    @Test
    public void  TestContains()
    {
        RecordSet recordSet = new RecordSet();
        Row row = new Row();
        row.put("Teste", "teste");
        recordSet.add(row);

        boolean ret1 = recordSet.contains("Teste", "teste");
        boolean ret2 = recordSet.contains("aleatorio", "aleatorio");

        assertTrue(ret1);
        assertFalse(ret2);
    }
}
