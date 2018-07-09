package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class ResultadoDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "RESULTADO");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public boolean criar(Time tempo, int id_colocacao){
        String sql = "INSERT INTO RESULTADO(TEMPO, ID_COLOCACAO) " +
                "VALUES (?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setTime(1, tempo);
            statement.setInt(2, id_colocacao);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizar(Time tempo, int id_colocacao, int id){
        String sql = "UPDATE RESULTADO " +
                "SET TEMPO = ?, ID_COLOCACAO = ? " +
                "WHERE ID = ?";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setTime(1, tempo);
            statement.setInt(2, id_colocacao);
            statement.setInt(3, id);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
