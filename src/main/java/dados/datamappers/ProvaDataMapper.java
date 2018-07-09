package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProvaDataMapper {


    public boolean criar(String nome, Date data, String categoria,
                              int limiteParticipantes, int idTipoProva, int idClasse) {

        String sql = "INSERT INTO PROVA (NOME, DATA, LIMITE_PARTICIPANTES, CATEGORIA, " +
                " ID_TIPO_PROVA, ID_CLASSE) " + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, nome);
            statement.setDate(2, data);
            statement.setInt(3, limiteParticipantes);
            statement.setString(4, categoria);
            statement.setInt(5, idTipoProva);
            statement.setInt(6, idClasse);
            statement.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private ResultSet buscarPorId (int id){

        try {
            return  DataMapper.buscarPorId(id, "PROVA");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  null;
        }
    }

    private boolean excluirAtletaPorId(int id){
        try {
            return  DataMapper.excluirPorId( "PROVA", id);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  false;
        }
    }

}
