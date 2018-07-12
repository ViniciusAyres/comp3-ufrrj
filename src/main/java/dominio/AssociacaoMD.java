package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssociacaoMD {

    private ResultSet resultSet;

    public AssociacaoMD(ResultSet resultSet) {
        this.resultSet = resultSet;
    }


    public ArrayList<String> getMatriculas(){

        ArrayList<String> matriculas = new ArrayList<String>();

        try {

            resultSet.beforeFirst();
            while (resultSet.next()){
                String matricula = resultSet.getString("MATRICULA");
                matriculas.add(matricula);
            }

            return matriculas;

        } catch (SQLException e) {
            return null;
        }
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

    public String test(){
        return "LEO";
    }
}
