package dados.entidades;

import java.util.List;

public class Local {

  private String nome;
  private long id;
  private List<TamanhoPiscina> tamanhoPiscina;

  public List<TamanhoPiscina> getTamanhoPiscina() {
    return tamanhoPiscina;
  }

  public void setTamanhoPiscina(List<TamanhoPiscina> tamanhoPiscina) {
    this.tamanhoPiscina = tamanhoPiscina;
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
