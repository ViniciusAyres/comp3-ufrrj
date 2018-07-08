package dados.entidades;


public class Resultado {

  private long id;
  private java.sql.Time tempo;
  private long idColocacao;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Time getTempo() {
    return tempo;
  }

  public void setTempo(java.sql.Time tempo) {
    this.tempo = tempo;
  }


  public long getIdColocacao() {
    return idColocacao;
  }

  public void setIdColocacao(long idColocacao) {
    this.idColocacao = idColocacao;
  }

}
