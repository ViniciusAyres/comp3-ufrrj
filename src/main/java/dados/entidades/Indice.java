package dados.entidades;

public class Indice {

  private String categoria;
  private java.sql.Time tempo;
  private long id;
  private long idNado;
  private long idTamanhoPiscina;
  private long idClasse;

    public long getIdNado() {
        return idNado;
    }

    public void setIdNado(long idNado) {
        this.idNado = idNado;
    }

    public long getIdTamanhoPiscina() {
        return idTamanhoPiscina;
    }

    public void setIdTamanhoPiscina(long idTamanhoPiscina) {
        this.idTamanhoPiscina = idTamanhoPiscina;
    }

    public long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(long idClasse) {
        this.idClasse = idClasse;
    }

    public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }


  public java.sql.Time getTempo() {
    return tempo;
  }

  public void setTempo(java.sql.Time tempo) {
    this.tempo = tempo;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
