package dados.entidades;

import java.sql.Date;

public class Atleta {

  private String matricula;
  private String nome;
  private java.sql.Date dataNascimento;
  private Equipe equipe;
  private String categoria;

  public Atleta(String nome, String matricula, Date dataNascimento, String categoria) {
    this.matricula = matricula;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.categoria = categoria;
  }

  public Equipe getEquipe() {
    return equipe;
  }

  public void setEquipe(Equipe equipe) {
    this.equipe = equipe;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  public java.sql.Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(java.sql.Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }




}
