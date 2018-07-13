package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AtletaMT {
    private ResultSet resultSet;

    public AtletaMT(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ArrayList<String> getMatriculas() throws SQLException {
        ArrayList<String> matriculas = new ArrayList<String>();
        resultSet.beforeFirst();
        while(resultSet.next()){
            String matricula = resultSet.getString("MATRICULA");
            matriculas.add(matricula);
        }

        return matriculas;
    }

    public String getNome(String matricula) throws RegistroNaoEncontradoException, SQLException {
        resultSet.beforeFirst();
        while(resultSet.next()){
            if ( resultSet.getString("MATRICULA").equals(matricula) ) {
                return resultSet.getString("NOME");
            }
        }

        throw new RegistroNaoEncontradoException("Atleta não encontrado", "ATLETA");
    }
}
