package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.interfaces.IntDataMapper;
import dados.entidades.Recorde;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordeDataMapper implements IntDataMapper {
    @Override
    public Object buscarPorId(int id) {
        String sql = "SELECT * FROM RECORDE WHERE ID = ?";

        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Recorde recorde = null;

            if(resultSet.next()){
                recorde = new Recorde(resultSet.getLong("ID"),
                        resultSet.getString("NOME"),
                        resultSet.getLong("PONTUACAO"));

            }

            statement.close();
            resultSet.close();
            return recorde;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean criar(Object object) {
        return false;
    }

    @Override
    public boolean atualizar(Object object) {
        return false;
    }
}
