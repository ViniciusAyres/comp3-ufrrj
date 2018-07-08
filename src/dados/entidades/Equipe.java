package dados.entidades;


import java.util.List;

public class Equipe {

  private long id;
  private String nome;
  private List<Atleta> atletas;

  public List<Atleta> getAtletas() {
    return atletas;
  }

  public void setAtletas(List<Atleta> atletas) {
    this.atletas = atletas;
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
