package dados.entidades;


public class Resultado {

  private long id;
  private java.sql.Time tempo;
  private Colocacao colocacao;

  public Colocacao getColocacao() {
    return colocacao;
  }

  public void setColocacao(Colocacao colocacao) {
    this.colocacao = colocacao;
  }

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


}
