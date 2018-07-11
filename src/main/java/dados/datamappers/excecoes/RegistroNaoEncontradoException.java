package dados.datamappers.excecoes;

public class RegistroNaoEncontradoException extends Exception {
    private String tabelaRegistro;

    public RegistroNaoEncontradoException(String message, String tabelaRegistro){
        super(message);
        this.tabelaRegistro = tabelaRegistro;
    }

    public String getTabelaRegistro(){
        return tabelaRegistro;
    }
}
