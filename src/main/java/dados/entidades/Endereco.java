package dados.entidades;


public class Endereco {

  private String complemento;
  private long numero;
  private String cidade;
  private String bairro;
  private String logradouro;
  private String cep;
  private long id;
  private long idUf;

    public long getIdUf() {
        return idUf;
    }

    public void setIdUf(long idUf) {
        this.idUf = idUf;
    }

    public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }


  public long getNumero() {
    return numero;
  }

  public void setNumero(long numero) {
    this.numero = numero;
  }


  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }


  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }


  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }


  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
