package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvaCompeticaoDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "PROVA_COMPETICAO");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public boolean criar(int idProva, int idCompeticao){
        String sql = "INSERT INTO PROVA_COMPETICAO (ID_PROVA, ID_COMPETICAO) " +
                "VALUES (?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setInt(1, idProva);
            statement.setInt(2, idCompeticao);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
