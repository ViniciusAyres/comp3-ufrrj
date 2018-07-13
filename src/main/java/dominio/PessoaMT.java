package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaMT {
    ResultSet resultSet;

    public PessoaMT(ResultSet resultSet){
        this.resultSet = resultSet;
    }

    public String getSenha(String matricula) throws SQLException, RegistroNaoEncontradoException {
        this.resultSet.beforeFirst();
        while (resultSet.next()){
            if(resultSet.getString("MATRICULA").equals(matricula)){
                return resultSet.getString("SENHA");
            }
        }

        throw new RegistroNaoEncontradoException("Pessoa não encontrada", "PESSOA");
    }

    public String getNome(String matricula) throws SQLException, RegistroNaoEncontradoException {
        this.resultSet.beforeFirst();
        while (resultSet.next()){
            if(resultSet.getString("MATRICULA").equals(matricula)){
                return resultSet.getString("NOME");
            }
        }

        throw new RegistroNaoEncontradoException("Pessoa não encontrada", "PESSOA");
    }

    public int getPerfil(String matricula) throws SQLException, RegistroNaoEncontradoException {
        this.resultSet.beforeFirst();
        while (resultSet.next()){
            if(resultSet.getString("MATRICULA").equals(matricula)){
                return resultSet.getInt("ID_PERFIL");
            }
        }

        throw new RegistroNaoEncontradoException("Pessoa não encontrada", "PESSOA");

    }

    public String getMatriculaAssociacao(String matricula) throws SQLException, RegistroNaoEncontradoException {
        this.resultSet.beforeFirst();
        while (resultSet.next()){
            if(resultSet.getString("MATRICULA").equals(matricula)){
                return resultSet.getString("MATRICULA_ASSOCIACAO");
            }
        }

        throw new RegistroNaoEncontradoException("Pessoa não encontrada", "PESSOA");

    }

}
