package dados.entidades;


import java.util.List;

public class Equipe {

  private long id;
  private String nome;
  private List<Long> idAtletas;

    public List<Long> getIdAtletas() {
        return idAtletas;
    }

    public void setIdAtletas(List<Long> idAtletas) {
        this.idAtletas = idAtletas;
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
