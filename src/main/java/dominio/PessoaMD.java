package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontrado;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaMD {
    ResultSet resultSet;

    public PessoaMD(ResultSet resultSet){
        this.resultSet = resultSet;
    }

    public String getSenha(String matricula) throws SQLException, RegistroNaoEncontrado {
        this.resultSet.beforeFirst();
        while (resultSet.next()){
            if(resultSet.getString("MATRICULA") == matricula){
                return resultSet.getString("SENHA");
            }
        }

        throw new RegistroNaoEncontrado("Pessoa não encontrada", "PESSOA");
    }

    public int getPerfil(String matricula) throws SQLException, RegistroNaoEncontrado {
        this.resultSet.beforeFirst();
        while (resultSet.next()){
            if(resultSet.getString("MATRICULA") == matricula){
                return resultSet.getInt("ID_PERFIL");
            }
        }

        throw new RegistroNaoEncontrado("Pessoa não encontrada", "PESSOA");

    }

    public String getMatriculaAssociacao(String matricula) throws SQLException, RegistroNaoEncontrado {
        this.resultSet.beforeFirst();
        while (resultSet.next()){
            if(resultSet.getString("MATRICULA") == matricula){
                return resultSet.getString("MATRICULA_ASSOCIACAO");
            }
        }

        throw new RegistroNaoEncontrado("Pessoa não encontrada", "PESSOA");

    }

}
