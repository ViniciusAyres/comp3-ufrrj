package dominio;

import dados.datamappers.DataMapper;
import dados.datamappers.LocalDataMapper;

import java.sql.ResultSet;
import java.util.ArrayList;

public class LocalCompeticaoMD {

    private ResultSet resultSet;

    public LocalCompeticaoMD(ResultSet resultSet){
        this.resultSet = resultSet;
    }

    public String getEnderecoByLocal(String nomeLocal) {
        try{
            resultSet.beforeFirst();
            while(resultSet.next()){
                String nomeLocalAux = resultSet.getString("LOCALNOME");
                if(nomeLocalAux.equals(nomeLocal)) {
                    String endereco = resultSet.getString("ENDERECO");
                    return  endereco;
                }
            }
            return  null;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return  null;
        }
    }


    public  String getTamanhoPiscinaByLocal(String nomeLocal) {
        try {
            resultSet.beforeFirst();
            while(resultSet.next()){
                String nomeLocalAux = resultSet.getString("LOCALNOME");
                if(nomeLocalAux.equals(nomeLocal)) {
                    int tamanho = resultSet.getInt("TAMANHO");
                    String  tamahoSTR = Integer.toString(tamanho) + " " + "metros";
                    return tamahoSTR;
                }
            }
            return  null;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  null;
        }
    }

    public  ArrayList<String> getLocais()
    {
        ArrayList<String> locais = null;
        try {
            locais = new ArrayList<String>();
            resultSet.beforeFirst();
            while (resultSet.next()){
                //LocalDataMapper local = LocalDataMapper();
                String local = this.resultSet.getString("LOCALNOME");
                locais.add(local);
            }
            return locais;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return locais;
        }

    }

}
