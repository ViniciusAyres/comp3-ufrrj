package dados.entidades;


public class Classe {

  private long id;
  private String nome;
  private int idadeMinima;
  private int idadeMaxima;

  public Classe(long id, String nome, int idadeMinima, int idadeMaxima) {
      this.id = id;
      this.nome = nome;
      this.idadeMinima = idadeMinima;
      this.idadeMaxima = idadeMaxima;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  public int getIdadeMinima() {
    return idadeMinima;
  }

  public void setIdadeMinima(int idadeMinima) {
    this.idadeMinima = idadeMinima;
  }


  public int getIdadeMaxima() {
    return idadeMaxima;
  }

  public void setIdadeMaxima(int idadeMaxima) {
    this.idadeMaxima = idadeMaxima;
  }

}
