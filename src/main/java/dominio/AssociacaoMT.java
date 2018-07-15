package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AssociacaoMT{

    private RecordSet recordSetSet;

    public AssociacaoMT(RecordSet recordSet) throws RegistroInvalido {
        validar(recordSet);
        this.recordSetSet = recordSet;
    }

    public ArrayList<String> getMatriculas() throws SQLException {

        ArrayList<String> matriculas = new ArrayList<String>();

//        resultSet.beforeFirst();
//        while (resultSet.next()){
//            String matricula = resultSet.getString("MATRICULA");
//            matriculas.add(matricula);
//        }

        return matriculas;

    }


    private void validar(RecordSet recordSet) throws RegistroInvalido {

        for(Row row : recordSet){

            if(row.getString("nome") == null ||  row.getString("nome").isEmpty())
                throw new RegistroInvalido("Nome inválido.");

            if(row.getString("sigla") == null ||  row.getString("sigla").isEmpty())
                throw new RegistroInvalido("Sigla inválido.");

            if(row.getString("telefone") == null ||  row.getString("telefone").isEmpty())
                throw new RegistroInvalido("Telefone inválido.");

            if(row.getString("endereco") == null ||  row.getString("endereco").isEmpty())
                throw new RegistroInvalido("Endereço inválido.");
        }
    }

    public static String gerarMatricula() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }


  //  public boolean existe(String matricula) throws SQLException, RegistroNaoEncontradoException {
//        resultSet.beforeFirst();
//        while (resultSet.next()){
//            if(resultSet.getString("MATRICULA").equals(matricula)){
    //            return true;
//            }
//        }

        //throw new RegistroNaoEncontradoException("Associação não encontrada", "ASSOCIAÇÃO");
    //}

    //public String getNome(String matricula) throws SQLException, RegistroNaoEncontradoException {
//        resultSet.beforeFirst();
//        while (resultSet.next()){
//            if(resultSet.getString("MATRICULA").equals(matricula)){
                //return resultSet.getString("NOME");
        //    }
        //}
      //  return  null;
        //throw new RegistroNaoEncontradoException("Associação não encontrada", "ASSOCIAÇÃO");
    //}


}
