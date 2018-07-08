package dados.entidades;


public class Competicao {

  private String categoria;
  private java.sql.Date data;
  private String nome;
  private long id;
  private long idTipoCompeticao;


  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }


  public java.sql.Date getData() {
    return data;
  }

  public void setData(java.sql.Date data) {
    this.data = data;
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


  public long getIdTipoCompeticao() {
    return idTipoCompeticao;
  }

  public void setIdTipoCompeticao(long idTipoCompeticao) {
    this.idTipoCompeticao = idTipoCompeticao;
  }

}
