package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FiliacaoMT{
        private ResultSet resultSet;

        public FiliacaoMT(ResultSet resultSet) {
            this.resultSet = resultSet;
        }


        public ArrayList<String> getAtributo(String atributo){

            ArrayList<String> filiacoes = new ArrayList<String>();

            try {

                resultSet.beforeFirst();
                while (resultSet.next()){
                    String filiacao = resultSet.getString(atributo.toString());
                    filiacoes.add(filiacao);
                }

                return filiacoes;

            } catch (SQLException e) {
                return null;
            }
        }

}
