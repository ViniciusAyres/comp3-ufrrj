package dominio;

public enum Perfil {
    SECRETARIO(1), DIRETOR_TECNICO(2),
    TECNICO_ASSOSSIACAO(3);

    private int id;

    Perfil(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
