package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipacaoDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "PARTICIPACAO");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }
    //TODO: Conferir horario
    public boolean criar(int idCompeticao, int idProva, int idResultado, String matriculaAtleta,
                         Date horario, int idEquipe){
        String sql = "INSERT INTO PARTICIPACAO (ID_COMPETICAO, ID_PROVA, ID_RESULTADO, MATRICULA_ATLETA, HORARIO, ID_EQUIPE) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setInt(1, idCompeticao);
            statement.setInt(2, idProva);
            statement.setInt(3, idResultado);
            statement.setString(4, matriculaAtleta);
            statement.setDate(5, horario);
            statement.setInt(6, idEquipe);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizar(int id, int idCompeticao, int idProva, int idResultado,
                             String matriculaAtleta, Date horario, int idEquipe){
        String sql = "UPDATE PARTICIPACAO " +
                "SET ID_COMPETICAO = ?, ID_PROVA = ?, ID_RESULTADO = ?," +
                "MATRICULA_ATLETA = ?, HORARIO = ?, ID_EQUIPE = ? " +
                "WHERE ID = ?";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setInt(1, idCompeticao);
            statement.setInt(2, idProva);
            statement.setInt(3, idResultado);
            statement.setString(4, matriculaAtleta);
            statement.setDate(2, horario);
            statement.setInt(3, idEquipe);
            statement.setInt(7, id);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
