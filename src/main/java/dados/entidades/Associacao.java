package dados.entidades;


public class Associacao {

  private String telefone;
  private String sigla;
  private String nome;
  private String matricula;
  private long id_endereco;

  public Associacao(String telefone, String sigla, String nome, String matricula, long id_endereco) {
    this.telefone = telefone;
    this.sigla = sigla;
    this.nome = nome;
    this.matricula = matricula;
    this.id_endereco = id_endereco;
  }


  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }


  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }


  public long getEnderecoId() {
    return id_endereco;
  }

  public void setEnderecoId(int id_endereco) {
    this.id_endereco = id_endereco;
  }

}
