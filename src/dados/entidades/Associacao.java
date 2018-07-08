package dados.entidades;


public class Associacao {

  private String telefone;
  private String sigla;
  private String nome;
  private String matricula;
  private long idEndereco;


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


  public long getIdEndereco() {
    return idEndereco;
  }

  public void setIdEndereco(long idEndereco) {
    this.idEndereco = idEndereco;
  }

}
