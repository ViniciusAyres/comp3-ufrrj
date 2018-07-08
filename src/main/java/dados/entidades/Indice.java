package dados.entidades;

public class Indice {

  private String categoria;
  private java.sql.Time tempo;
  private long id;
  private Nado nado;
  private TamanhoPiscina tamanhoPiscina;
  private Classe classe;

    public Nado getNado() {
        return nado;
    }

    public void setNado(Nado nado) {
        this.nado = nado;
    }

    public TamanhoPiscina getTamanhoPiscina() {
        return tamanhoPiscina;
    }

    public void setTamanhoPiscina(TamanhoPiscina tamanhoPiscina) {
        this.tamanhoPiscina = tamanhoPiscina;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
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
