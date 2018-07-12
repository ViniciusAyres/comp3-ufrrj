package utils;

import dados.datamappers.PessoaDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.PessoaMD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Utils {
    private static String INDEX = "index.jsp";

    public static boolean isValido(String matricula, String senha) {
        PessoaMD pessoaMD = new PessoaMD(new PessoaDataMapper().buscarPorMatricula(matricula));
        try {
            return pessoaMD.getSenha(matricula).equals(senha);
        }catch (RegistroNaoEncontradoException e) {
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void autenticar(HttpServletRequest request, HttpServletResponse response, String url, int perfilExigido) throws ServletException, IOException {
        if(!Utils.isAutenticado(request, perfilExigido)){
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        }else if (!Utils.hasAutorizacao((String) request.getSession().getAttribute("matricula"), perfilExigido)){
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        }else {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private static boolean hasAutorizacao(String matricula, int perfilExigido) {
        PessoaMD pessoaMD = new PessoaMD(new PessoaDataMapper().buscarPorMatricula(matricula));

        try {
            return pessoaMD.getPerfil(matricula) == perfilExigido;
        } catch (SQLException e) {
            return false;
        } catch (RegistroNaoEncontradoException e) {
            return false;
        }
    }

    public static boolean isAutenticado(HttpServletRequest request, int perfilExigido){
        String matricula = (String) request.getSession().getAttribute("matricula");
        System.out.println("MATRICULA: " + matricula);

        if(matricula == null){
            return false;
        }

        return true;
    }
}

