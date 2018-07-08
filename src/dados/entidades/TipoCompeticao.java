package dados.entidades;


public class TipoCompeticao {

  private String nome;
  private long id;

  public TipoCompeticao(String nome) {
    this.nome = nome;
  }
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

}
