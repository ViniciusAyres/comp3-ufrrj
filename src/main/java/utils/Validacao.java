package utils;

public class Validacao {

    private static void EhBrancoNull(String nomeCampo, String valorCampo) throws Exception {
        if(valorCampo == null)
            throw new Exception("O " + nomeCampo + "eh null");
        if(valorCampo.isEmpty())
            throw new Exception("O " + nomeCampo + "eh vazio");
    }


}
