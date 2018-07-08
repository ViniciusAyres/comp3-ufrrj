package dados.entidades;

public class Recorde {

  private long id;
  private String nome;
  private long pontuacao;


  public Recorde(long id, String nome, long pontuacao) {
    this.id = id;
    this.nome = nome;
    this.pontuacao = pontuacao;
  }

  public long getPontuacao() {
    return pontuacao;
  }

  public void setPontuacao(long pontuacao) {
    this.pontuacao = pontuacao;
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
