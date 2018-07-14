package dominio;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import utils.RecordSet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaMT {
    private RecordSet recordSet;

    public PessoaMT(RecordSet recordSet) {
        this.recordSet = recordSet;
    }

    public static void autenticar(String matricula, String senha) throws UsuarioNaoAutenticadoException {

        if (!"ADMIN".equals(matricula)) throw new UsuarioNaoAutenticadoException();
        if (!"ADMIN".equals(senha)) throw new UsuarioNaoAutenticadoException();
    }
}
