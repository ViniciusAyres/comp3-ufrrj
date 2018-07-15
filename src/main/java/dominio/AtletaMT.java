package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AtletaMT {
    private RecordSet recordSet;

    public AtletaMT(RecordSet recordSet) throws RegistroInvalido {
        this.validar(recordSet);
        this.recordSet = recordSet;
    }

    public AtletaMT(){

    }

    private void validar(RecordSet recordSet) throws RegistroInvalido {

        for(Row row : recordSet){

            if(row.getString("nome") == null || row.getString("nome").isEmpty())
                throw new RegistroInvalido("Nome inválido.");

            if(row.getString("dataNascimento") == null)
                throw new RegistroInvalido("Data de nascimento inválida.");

            if(row.getString("dataNascimento") == null || row.getString("dataNascimento") == "")
                row.put("dataNascimento", "1900-01-01");

            if(row.getString("categoria") == null || row.getString("categoria").isEmpty())
                throw new RegistroInvalido("Categoria inválida.");

        }
    }

    public void validarEdicao(RecordSet recordSet) throws RegistroInvalido {

        for(Row row : recordSet){

            if(row.getString("nome") == null || row.getString("nome").isEmpty())
                throw new RegistroInvalido("Nome inválido.");
        }
    }

    public static String gerarMatricula() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }

}
