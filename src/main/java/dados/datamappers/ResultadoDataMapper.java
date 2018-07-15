package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class ResultadoDataMapper {
    public static ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "RESULTADO");
    }

    public static boolean criar(Time tempo, int id_colocacao) throws SQLException {
        String sql = "INSERT INTO RESULTADO(TEMPO, ID_COLOCACAO) " +
                "VALUES (?, ?)";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setTime(1, tempo);
        statement.setInt(2, id_colocacao);

        return statement.execute();
    }

    public static boolean atualizar(Time tempo, int id_colocacao, int id) throws SQLException {
        String sql = "UPDATE RESULTADO " +
                "SET TEMPO = ?, ID_COLOCACAO = ? " +
                "WHERE ID = ?";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setTime(1, tempo);
        statement.setInt(2, id_colocacao);
        statement.setInt(3, id);

        return statement.execute();
    }
}
