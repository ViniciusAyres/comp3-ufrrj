package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Criptografia {

    public static String gerarMatricula(int n){
        Date data = new Date();
        String matricula = new SimpleDateFormat("yyyyMMdd").format(data);
        matricula += Integer.toString(n);
        return matricula;
    }
}
