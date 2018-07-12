package utils;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.PessoaDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.PessoaMD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Utils {

    public static boolean isValido(String matricula, String senha) {
        try {
            PessoaMD pessoaMD = new PessoaMD(new PessoaDataMapper().buscarPorMatricula(matricula));
            return pessoaMD.getSenha(matricula).equals(senha);
        }catch (RegistroNaoEncontradoException e) {
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean autenticar(HttpServletRequest request, ArrayList<Integer> perfisAceitos) throws ServletException, IOException, UsuarioNaoAutenticadoException {
        if(!Utils.isAutenticado(request)){
            throw new UsuarioNaoAutenticadoException();
        }else if (!Utils.hasAutorizacao((String) request.getSession().getAttribute("matricula"), perfisAceitos)){
            throw new UsuarioNaoAutenticadoException();
        }else {
            return true;
        }
    }

    public static boolean hasAutorizacao(String matricula, ArrayList<Integer> perfisAceitos) {
        try {
            PessoaMD pessoaMD = new PessoaMD(new PessoaDataMapper().buscarPorMatricula(matricula));
            return perfisAceitos.contains(pessoaMD.getPerfil(matricula));
        } catch (SQLException e) {
            return false;
        } catch (RegistroNaoEncontradoException e) {
            return false;
        }
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

