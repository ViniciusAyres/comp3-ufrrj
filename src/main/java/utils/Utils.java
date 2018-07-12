package utils;

import controladores.exceptions.UsuarioNaoAutenticadoException;
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

    public static boolean autenticar(HttpServletRequest request, int perfilExigido) throws ServletException, IOException, UsuarioNaoAutenticadoException {
        if(!Utils.isAutenticado(request, perfilExigido)){
            throw new UsuarioNaoAutenticadoException();
        }else if (!Utils.hasAutorizacao((String) request.getSession().getAttribute("matricula"), perfilExigido)){
            throw new UsuarioNaoAutenticadoException();
        }else {
            return true;
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

