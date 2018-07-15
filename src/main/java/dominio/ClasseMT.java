package dominio;

import dados.datamappers.excecoes.ClasseNaoEncontradaException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClasseMT {
    private ResultSet resultSet;

    public ClasseMT(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    protected String getClasse(int idade) throws SQLException, ClasseNaoEncontradaException {
        resultSet.beforeFirst();
        while (resultSet.next()){
            int min = resultSet.getInt("IDADE_MINIMA");
            int max = resultSet.getInt("IDADE_MAXIMA");
            if(min <= idade && idade <= max){
                return resultSet.getString("NOME");
            }
        }

        throw new ClasseNaoEncontradaException();
    }
}
