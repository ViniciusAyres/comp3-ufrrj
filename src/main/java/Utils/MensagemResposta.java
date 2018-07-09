package Utils;

public class MensagemResposta{
    private int id;
    private String resposta;

    public MensagemResposta(int id, String resposta) {
        this.id = id;
        this.resposta = resposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}


