package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipacaoRecordeDataMapper {
    public static ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "PARTICIPACAO_RECORDE");
    }

    public static boolean criar(int idRecorde, int idParticipacao) throws SQLException {
        String sql = "INSERT INTO PARTICIPACAO_RECORDE (ID_RECORDE, ID_PARTICIPACAO) " +
                "VALUES (?, ?)";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setInt(1, idRecorde);
        statement.setInt(2, idParticipacao);

        return statement.execute();

    }
}
