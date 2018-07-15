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

            if(row.getString("dataAssociacao") == null)
                throw new RegistroInvalido("Data de entrada inválida.");

            if(row.getString("matriculaAssociacao") == null ||  row.getString("matriculaAssociacao").isEmpty())
                throw new RegistroInvalido("Matricula da associação inválida.");

            if(row.getString("numeroComprovante") == null ||  row.getString("numeroComprovante").isEmpty())
                throw new RegistroInvalido("Comprovante de pagamento inválido.");

        }
    }
}
