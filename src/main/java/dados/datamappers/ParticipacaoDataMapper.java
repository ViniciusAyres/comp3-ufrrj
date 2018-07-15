package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.*;

public class ParticipacaoDataMapper {
    public static ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "PARTICIPACAO");
    }
    public static boolean criar(int idCompeticao, int idProva, int idResultado, String matriculaAtleta,
                         Time horario, int idEquipe) throws SQLException {
    String sql = "INSERT INTO PARTICIPACAO (ID_COMPETICAO, ID_PROVA, ID_RESULTADO, MATRICULA_ATLETA, HORARIO, ID_EQUIPE) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setInt(1, idCompeticao);
        statement.setInt(2, idProva);
        statement.setInt(3, idResultado);
        statement.setString(4, matriculaAtleta);
        statement.setTime(5, horario);
        statement.setInt(6, idEquipe);

        return statement.execute();

    }

    public static boolean atualizar(int id, int idCompeticao, int idProva, int idResultado,
                             String matriculaAtleta, Time horario, int idEquipe) throws SQLException {
        String sql = "UPDATE PARTICIPACAO " +
                "SET ID_COMPETICAO = ?, ID_PROVA = ?, ID_RESULTADO = ?," +
                "MATRICULA_ATLETA = ?, HORARIO = ?, ID_EQUIPE = ? " +
                "WHERE ID = ?";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setInt(1, idCompeticao);
        statement.setInt(2, idProva);
        statement.setInt(3, idResultado);
        statement.setString(4, matriculaAtleta);
        statement.setTime(2, horario);
        statement.setInt(3, idEquipe);
        statement.setInt(7, id);

        return statement.execute();
    }
}
