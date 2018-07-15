package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtletaEquipeDataMapper {
    public static ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "ATLETA_EQUIPE");
    }

    public static boolean criar(String matriculaAtleta, int idEquipe) throws SQLException {
        String sql = "INSERT INTO ATLETA_EQUIPE (MATRICULA_ATLETA, ID_EQUIPE) " +
                "VALUES (?, ?)";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, matriculaAtleta);
        statement.setInt(2, idEquipe);
        return statement.execute();

    }

    public static boolean atualizar(int id, String matriculaAtleta, int idEquipe) throws SQLException {
        String sql = "UPDATE ATLETA_EQUIPE " +
                "SET MATRICULA_ATLETA = ?, ID_EQUIPE = ? " +
                "WHERE ID = ?";


        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, matriculaAtleta);
        statement.setInt(2, idEquipe);
        statement.setInt(3, id);

        return statement.execute();
    }
}
