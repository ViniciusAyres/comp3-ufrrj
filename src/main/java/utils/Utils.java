package utils;

import dados.datamappers.PessoaDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontrado;
import dominio.PessoaMD;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class Utils {
    private static String INDEX = "index.jsp";

    public static boolean isValido(String matricula, String senha) throws SQLException, RegistroNaoEncontrado {
        PessoaMD pessoaMD = new PessoaMD(new PessoaDataMapper().buscar());

        return pessoaMD.getSenha(matricula).equals(senha);
    }

    public static boolean isAutenticado(HttpServletRequest request){
        String matricula = (String) request.getSession().getAttribute("matricula");
        System.out.println("MATRICULA: " + matricula);

        if(matricula == null){
            return false;
        }

        return true;
    }

}

