package utils;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.PessoaDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.PessoaMT;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class Utils {
    

    public static int getTamanhoPiscinaId(String rd1, String rd2) {
        if (rd1 == null && rd2 == null)
            return 0;
        else if (rd1 != null && rd2 == null)
            return 1;
        else if (rd1 == null && rd2 != null)
            return 2;
        else
            return 3;
    }

    public static String piscinaToString(int idTamanhoPiscina) {
        String tamanho = null;

        if (idTamanhoPiscina == 1)
            tamanho = "25 metros";
        else if (idTamanhoPiscina == 2)
            tamanho = "50 metros";
        else
            tamanho = "25 e 50 metros";

        return  tamanho;
    }

}

