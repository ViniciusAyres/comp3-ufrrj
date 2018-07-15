package dominio;

import dados.datamappers.DataMapper;
import dados.datamappers.LocalDataMapper;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;

import java.sql.ResultSet;
import java.util.ArrayList;

public class LocalCompeticaoMT {

    private RecordSet recordSet;

    public LocalCompeticaoMT(RecordSet recordSet) throws RegistroInvalido {
        this.validar(recordSet);
        this.recordSet = recordSet;
    }

    public String getEnderecoByLocal(String nomeLocal) {
//        try{
//            resultSet.beforeFirst();
//            while(resultSet.next()){
//                String nomeLocalAux = resultSet.getString("LOCALNOME");
//                if(nomeLocalAux.equals(nomeLocal)) {
//                    String endereco = resultSet.getString("ENDERECO");
//                    return  endereco;
//                }
//            }
//            return  null;
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
            return  null;
//        }
    }


    public  String getTamanhoPiscinaByLocal(String nomeLocal) {
//        try {
//            resultSet.beforeFirst();
//            while(resultSet.next()){
//                String nomeLocalAux = resultSet.getString("LOCALNOME");
//                if(nomeLocalAux.equals(nomeLocal)) {
//                    int tamanho = resultSet.getInt("TAMANHO");
//                    String  tamahoSTR = Integer.toString(tamanho) + " " + "metros";
//                    return tamahoSTR;
//                }
//            }
            return  null;
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//            return  null;
//        }
    }
//
//    public  ArrayList<String> getLocais()
//    {
////        ArrayList<String> locais = null;
////        try {
////            locais = new ArrayList<String>();
////            resultSet.beforeFirst();
////            while (resultSet.next()){
////                //LocalDataMapper local = LocalDataMapper();
////                String local = this.resultSet.getString("LOCALNOME");
////                locais.add(local);
////            }
////            return locais;
////        }
////        catch (Exception ex) {
////            ex.printStackTrace();
//            return locais;
////        }
//
//    }


    private void validar(RecordSet recordSet)  throws RegistroInvalido {
        for (Row row : recordSet) {

            if (row.getString("nome") == null || row.getString("nome").isEmpty())
                throw new RegistroInvalido("Nome inválido.");

            if (row.getString("endereco") == null || row.getString("endereco").isEmpty())
                throw new RegistroInvalido("Endereco inválido.");
            if(row.getInt("tamanhoPiscina") == 0)
                throw new RegistroInvalido("Selecione um tamanho de piscina");
        }
    }
}
