package dominio;

import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;

public class InscricaoMT {
    private RecordSet recordSet;

    public InscricaoMT(RecordSet recordSet) throws RegistroInvalido {
        this.validar(recordSet);
        this.recordSet = recordSet;
    }

    private void validar(RecordSet recordSet) throws RegistroInvalido {
        for(Row row : recordSet) {
            if(row.getString("nome") == null ||  row.getString("nome").isEmpty())
                throw new RegistroInvalido("Nome inválido.");

            if(row.getString("dataNascimento") == null)
                throw new RegistroInvalido("Data de nascimento inválida.");

            if(row.getString("dataAssociacao") == null)
                throw new RegistroInvalido("Data de entrada inválida.");

            if(row.getString("matriculaAssociacao") == null ||  row.getString("matriculaAssociacao").isEmpty())
                throw new RegistroInvalido("Matricula da associação inválida.");
        }
    }
}
