package dados.entidades;


public class Pessoa {

  private String senha;
  private String nome;
  private long matricula;


  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  public long getMatricula() {
    return matricula;
  }

  public void setMatricula(long matricula) {
    this.matricula = matricula;
  }

}
