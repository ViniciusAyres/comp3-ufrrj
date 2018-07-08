package dados.entidades;


public class Inscricao {

  private String matriculaAssociacao;
  private java.sql.Date dataEntrada;
  private String numeroPagamento;
  private String numeroOficio;
  private java.sql.Date dataOficio;
  private String matriculaAtleta;


  public String getMatriculaAssociacao() {
    return matriculaAssociacao;
  }

  public void setMatriculaAssociacao(String matriculaAssociacao) {
    this.matriculaAssociacao = matriculaAssociacao;
  }


  public java.sql.Date getDataEntrada() {
    return dataEntrada;
  }

  public void setDataEntrada(java.sql.Date dataEntrada) {
    this.dataEntrada = dataEntrada;
  }


  public String getNumeroPagamento() {
    return numeroPagamento;
  }

  public void setNumeroPagamento(String numeroPagamento) {
    this.numeroPagamento = numeroPagamento;
  }


  public String getNumeroOficio() {
    return numeroOficio;
  }

  public void setNumeroOficio(String numeroOficio) {
    this.numeroOficio = numeroOficio;
  }


  public java.sql.Date getDataOficio() {
    return dataOficio;
  }

  public void setDataOficio(java.sql.Date dataOficio) {
    this.dataOficio = dataOficio;
  }


  public String getMatriculaAtleta() {
    return matriculaAtleta;
  }

  public void setMatriculaAtleta(String matriculaAtleta) {
    this.matriculaAtleta = matriculaAtleta;
  }

}
