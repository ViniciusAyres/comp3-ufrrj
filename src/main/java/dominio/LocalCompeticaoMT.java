package dominio;

import dados.datamappers.DataMapper;
import dados.datamappers.LocalDataMapper;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;
import utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalCompeticaoMT {

    private RecordSet recordSet;

    public LocalCompeticaoMT(RecordSet recordSet) throws RegistroInvalido {
        this.validar(recordSet);
        this.recordSet = recordSet;
    }

    public String getEnderecoByLocal(String nomeLocal) throws SQLException {

        LocalDataMapper localDataMapper = new LocalDataMapper();
           RecordSet recordSet = localDataMapper.buscarPorNome(nomeLocal);

           for (Row row : recordSet) {
               String nomeLocalBD = row.getString("nome");
               if(nomeLocalBD == nomeLocalBD)
                   return row.getString("endereco");
           }
           return "";
    }

    public  String getTamanhoPiscinaByLocal(String nomeLocal) throws SQLException {

        LocalDataMapper localDataMapper = new LocalDataMapper();
        RecordSet recordSet = localDataMapper.buscarPorNome(nomeLocal);

        for (Row row : recordSet) {
            String nomeLocalBD = row.getString("nome");
            if(nomeLocalBD == nomeLocalBD)
                return Utils.piscinaToString(row.getInt("tamanhoPiscina"));
        }
        return "";
    }

    public  ArrayList<String> getLocais(RecordSet recordSet) throws SQLException {

        ArrayList<String> nomesLocais = new ArrayList<String>();

        for(Row row : recordSet)
        {
            String nomeLocal = row.getString("nome");
            nomesLocais.add(nomeLocal);
        }
        return nomesLocais;
    }


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
