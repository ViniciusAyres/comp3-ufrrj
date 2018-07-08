package dados.entidades;

public class Local {

  private String nome;
  private long id;
  private long idTamanhoPiscina;


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getIdTamanhoPiscina() {
    return idTamanhoPiscina;
  }

  public void setIdTamanhoPiscina(long idTamanhoPiscina) {
    this.idTamanhoPiscina = idTamanhoPiscina;
  }

}
