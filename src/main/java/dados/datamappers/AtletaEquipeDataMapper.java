package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtletaEquipeDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "ATLETA_EQUIPE");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public boolean criar(String matriculaAtleta, int idEquipe){
        String sql = "INSERT INTO ATLETA_EQUIPE (MATRICULA_ATLETA, ID_EQUIPE) " +
                "VALUES (?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, matriculaAtleta);
            statement.setInt(2, idEquipe);
            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizar(int id, String matriculaAtleta, int idEquipe){
        String sql = "UPDATE ATLETA_EQUIPE " +
                "SET MATRICULA_ATLETA = ?, ID_EQUIPE = ? " +
                "WHERE ID = ?";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, matriculaAtleta);
            statement.setInt(2, idEquipe);
            statement.setInt(3, id);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
