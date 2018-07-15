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
