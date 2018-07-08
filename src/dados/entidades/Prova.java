package dados.entidades;


public class Prova {

  private long limiteParticipantes;
  private String data;
  private String nome;
  private String categoria;
  private long id;
  private TipoProva tipoProva;
  private Classe classe;


  public long getLimiteParticipantes() {
    return limiteParticipantes;
  }

  public void setLimiteParticipantes(long limiteParticipantes) {
    this.limiteParticipantes = limiteParticipantes;
  }


  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


}
