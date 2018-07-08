package dados.entidades;

import java.util.List;

public class Local {

  private String nome;
  private long id;
  private List<Long> idTamanhosPiscinas;

    public List<Long> getIdTamanhosPiscinas() {
        return idTamanhosPiscinas;
    }

    public void setIdTamanhosPiscinas(List<Long> idTamanhosPiscinas) {
        this.idTamanhosPiscinas = idTamanhosPiscinas;
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
