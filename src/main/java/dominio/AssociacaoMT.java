package dominio;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AssociacaoMT{

    private RecordSet recordSetSet;

    public AssociacaoMT(RecordSet recordSet) throws RegistroInvalido {
        validar(recordSet);
        this.recordSetSet = recordSet;
    }

    public AssociacaoMT(){

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

    public void validarTransferencia(RecordSet recordSet) throws RegistroInvalido {

        for(Row row : recordSet){

            if(row.getString("dataOficio") == null || row.getString("dataNascimento") == "")
                throw new RegistroInvalido("Data de Ofício inválida.");

            if(row.getString("dataAssociacao") == null || row.getString("dataAssociacao") == "")
                throw new RegistroInvalido("Data da Associação inválida.");

            if(row.getString("matriculaAssociacao") == null || row.getString("matriculaAssociacao").isEmpty())
                throw new RegistroInvalido("Matrícula da Associação inválida.");

            if(row.getString("numeroOficio") == null || row.getString("numeroOficio").isEmpty())
                throw new RegistroInvalido("Número do Ofício inválido.");

            if(row.getString("numeroComprovante") == null || row.getString("numeroComprovante").isEmpty())
                throw new RegistroInvalido("Número de Comprovante inválido.");
        }
    }

    public static String gerarMatricula() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }

    public static String gerarSenha(){
        return "123456";
    }

    public static void autenticar(String matricula, String senha) throws UsuarioNaoAutenticadoException, RegistroNaoEncontradoException, SQLException {
        if ((!"ADMIN".equals(matricula)) || (!"ADMIN".equals(senha))){
            ResultSet resultSet = AssociacaoDataMapper.buscarPorMatriculaESenha(matricula, senha);
        }
    }


}
