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

    public InscricaoMT(){

    }

    private void validar(RecordSet recordSet) throws RegistroInvalido {
        for(Row row : recordSet) {

            if(row.getString("dataAssociacao") == null || row.getString("dataAssociacao") == "")
                row.put("dataAssociacao", "1900-01-01");

            if(row.getString("matriculaAssociacao") == null ||  row.getString("matriculaAssociacao").isEmpty())
                throw new RegistroInvalido("Matricula da associação inválida.");

            if(row.getString("numeroComprovante") == null ||  row.getString("numeroComprovante").isEmpty())
                throw new RegistroInvalido("Comprovante de pagamento inválido.");

            if(row.getString("dataOficio") == null || row.getString("dataOficio") == "")
                row.put("dataOficio", "1900-01-01");
        }
    }

    public void validarEdicao(RecordSet recordSet) throws RegistroInvalido {
        for(Row row : recordSet) {

            if(row.getString("dataAssociacao") == null || row.getString("dataAssociacao") == "")
                row.put("dataAssociacao", "1900-01-01");

            if(row.getString("numero_oficio") == null ||  row.getString("numero_oficio").isEmpty())
                throw new RegistroInvalido("Número de Ofício inválido.");

            if(row.getString("dataOficio") == null || row.getString("dataOficio") == "")
                row.put("dataOficio", "1900-01-01");
        }
    }
}
