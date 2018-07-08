package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.interfaces.DataMapper;
import dados.datamappers.interfaces.IntDataMapper;
import dados.entidades.Perfil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PerfilDataMapper implements IntDataMapper,DataMapper {

    @Override
    public boolean criar(Object object) {
        Perfil perfil = (Perfil) object;
        if (perfil == null){
            return true;
        }

        String sql = "INSERT INTO PERFIL (NOME) " +
                "VALUES (?)";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance().prepareStatement(sql);

            statement.setString(1, perfil.getNome());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Perfil buscarPorId(int id){
        String sql = "SELECT * FROM PERFIL WHERE ID = ?";

        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Perfil perfil = null;

            if(resultSet.next()){
                perfil = new Perfil(resultSet.getLong("ID"),resultSet.getString("NOME"));
            }

            statement.close();
            resultSet.close();
            return perfil;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean atualizar(Object object){
        Perfil perfil = (Perfil) object;
        if (perfil == null){
            return true;
        }

        String sql = "UPDATE PERFIL " +
                "SET NOME = ? " +
                "WHERE ID = ?";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, perfil.getNome());
            statement.setLong(2, perfil.getId());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
