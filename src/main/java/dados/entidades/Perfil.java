package dados.entidades;


public class Perfil {

  private String nome;
  private long id;

  public Perfil(long id, String nome) {
    this.nome = nome;
    this.id = id;
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
