package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PessoaDataMapper {

    public ResultSet buscarPorMatricula(String matricula){
        try{
            return  DataMapper.buscarPorMatricula(matricula, "PESSOA");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }


    public boolean criar(String nome, String senha, int idPerfil,
                         String matricula, String matricula_associacao) {
        try{

            String sql = "INSERT INTO PESSOA (NOME, SENHA,ID_PERFIL, MATRICULA, MATRICULA_ASSOCIACAO)" +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, nome);
            statement.setString(2, senha);
            statement.setInt(3, idPerfil);
            statement.setString(4, matricula);
            statement.setString(5, matricula_associacao);

            statement.execute();
            return  true;
        }

        catch (Exception ex) {
            ex.printStackTrace();
            return  false;
        }
    }
}
