package dados.entidades;

public class ProvaCompeticao {

  private long id;
  private Prova prova;
  private Competicao competicao;


  public Prova getProva() {
    return prova;
  }

  public void setProva(Prova prova) {
    this.prova = prova;
  }

  public Competicao getCompeticao() {
    return competicao;
  }

  public void setCompeticao(Competicao competicao) {
    this.competicao = competicao;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
