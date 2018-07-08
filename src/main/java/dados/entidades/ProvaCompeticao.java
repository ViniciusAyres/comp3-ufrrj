package dados.entidades;

public class ProvaCompeticao {

  private long id;
  private long idProva;
  private long idCompeticao;

    public long getIdProva() {
        return idProva;
    }

    public void setIdProva(long idProva) {
        this.idProva = idProva;
    }

    public long getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(long idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
