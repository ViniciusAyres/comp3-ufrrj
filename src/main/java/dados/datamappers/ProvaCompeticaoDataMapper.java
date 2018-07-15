package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvaCompeticaoDataMapper {
    public static ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "PROVA_COMPETICAO");
    }

    public static boolean criar(int idProva, int idCompeticao) throws SQLException {
        String sql = "INSERT INTO PROVA_COMPETICAO (ID_PROVA, ID_COMPETICAO) " +
                "VALUES (?, ?)";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setInt(1, idProva);
        statement.setInt(2, idCompeticao);

        return statement.execute();

    }
}
