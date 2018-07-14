package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssociacaoMT {

    private ResultSet resultSet;

    public AssociacaoMT(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ArrayList<String> getMatriculas() throws SQLException {

        ArrayList<String> matriculas = new ArrayList<String>();

        resultSet.beforeFirst();
        while (resultSet.next()){
            String matricula = resultSet.getString("MATRICULA");
            matriculas.add(matricula);
        }

        return matriculas;

    }

    public boolean existe(String matricula) throws SQLException, RegistroNaoEncontradoException {
        resultSet.beforeFirst();
        while (resultSet.next()){
            if(resultSet.getString("MATRICULA").equals(matricula)){
                return true;
            }
        }

        throw new RegistroNaoEncontradoException("Associação não encontrada", "ASSOCIAÇÃO");
    }

    public String getNome(String matricula) throws SQLException, RegistroNaoEncontradoException {
        resultSet.beforeFirst();
        while (resultSet.next()){
            if(resultSet.getString("MATRICULA").equals(matricula)){
                return resultSet.getString("NOME");
            }
        }

        throw new RegistroNaoEncontradoException("Associação não encontrada", "ASSOCIAÇÃO");
    }
}
