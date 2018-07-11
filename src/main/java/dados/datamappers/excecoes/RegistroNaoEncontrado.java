package dados.datamappers.excecoes;

public class RegistroNaoEncontrado extends Exception {
    private String tabelaRegistro;

    public RegistroNaoEncontrado(String message, String tabelaRegistro){
        super(message);
        this.tabelaRegistro = tabelaRegistro;
    }

    public String getTabelaRegistro(){
        return tabelaRegistro;
    }
}
