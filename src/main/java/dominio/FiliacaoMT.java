package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class FiliacaoMT{
        private RecordSet recordSet;

        public FiliacaoMT(RecordSet recordSet) throws RegistroInvalido {
            this.validar(recordSet);
            this.recordSet = recordSet;
        }


        public ArrayList<String> getAtributo(String atributo){

//            ArrayList<String> filiacoes = new ArrayList<String>();
//
//            try {
//
//                resultSet.beforeFirst();
//                while (resultSet.next()){
//                    String filiacao = resultSet.getString(atributo.toString());
//                    filiacoes.add(filiacao);
//                }
//
//                return filiacoes;
//
//            } catch (SQLException e) {
                return null;
      //      }
        }


        public void validar(RecordSet recordSet) throws RegistroInvalido{

                for(Row row : recordSet) {
                    if (row.getString("numeroComprovante") == null || row.getString("numeroComprovante").isEmpty())
                        throw new RegistroInvalido("Número do Comprovante obrigatório.");

                    if(row.getString("dataOficio") == null || row.getString("dataOficio") == "")
                        row.put("dataOficio", "1900-01-01");
                }
        }
}
