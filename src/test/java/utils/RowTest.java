package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class RowTest {

    @Test
    public void testGetInt() {
        Row row = new Row();
        row.put("idade", 18);

        assertEquals(18, row.getInt("idade"));
    }

    @Test(expected = NullPointerException.class)
    public void testColumnNotFound(){
        Row row = new Row();
        row.getInt("idade");
    }

    @Test
    public void testGetBoolean() {
        Row row = new Row();
        row.put("isAtivo", true);

        assertEquals(true, row.getBoolean("isAtivo"));
    }

    @Test
    public void testGetString() {
        Row row = new Row();
        row.put("mensagem", "Bem vindo");

        assertEquals("Bem vindo", row.getString("mensagem"));
    }
}