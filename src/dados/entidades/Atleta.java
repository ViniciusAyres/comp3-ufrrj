package dados.entidades;

import java.util.Date;

public class Atleta {
    public String nome;
    public String matricula;
    public Date dataNascimento;
    public String categoria;

    public Atleta(String nome, String matricula, Date dataNascimento, String categoria) {

        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
