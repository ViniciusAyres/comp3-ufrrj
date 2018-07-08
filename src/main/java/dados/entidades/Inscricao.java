package dados.entidades;


public class Inscricao {

  private java.sql.Date dataEntrada;
  private String numeroPagamento;
  private String numeroOficio;
  private java.sql.Date dataOficio;
  private long idAtleta;
  private long idAssociacao;

    public long getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(long idAtleta) {
        this.idAtleta = idAtleta;
    }

    public long getIdAssociacao() {
        return idAssociacao;
    }

    public void setIdAssociacao(long idAssociacao) {
        this.idAssociacao = idAssociacao;
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

}
