package dados.entidades;


public class Colocacao {

  private long pontuacao;
  private long id;
  private long posicao;

    public Colocacao(long id, long pontuacao, long posicao) {
        this.id = id;
        this.pontuacao = pontuacao;
        this.posicao = posicao;
    }

    public long getPontuacao() {
    return pontuacao;
  }

  public void setPontuacao(long pontuacao) {
    this.pontuacao = pontuacao;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPosicao() {
    return posicao;
  }

  public void setPosicao(long posicao) {
    this.posicao = posicao;
  }

}
