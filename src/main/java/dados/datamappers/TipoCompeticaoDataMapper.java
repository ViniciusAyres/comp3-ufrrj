package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.interfaces.DataMapper;
import dados.datamappers.interfaces.IntDataMapper;
import dados.entidades.Perfil;
import dados.entidades.TipoCompeticao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoCompeticaoDataMapper implements DataMapper, IntDataMapper {
    @Override
    public boolean criar(Object object) {
        TipoCompeticao tipocompeticao = (TipoCompeticao) object;
        if (tipocompeticao == null){
            return true;
        }

        String sql = "INSERT INTO TIPO_COMPETICAO (NOME) " +
                "VALUES (?)";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance().prepareStatement(sql);
            statement.setString(1, tipocompeticao.getNome());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public TipoCompeticao buscarPorId(int id){
        String sql = "SELECT * FROM TIPO_COMPETICAO WHERE ID = ?";

        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            TipoCompeticao tipocompeticao = null;

            if(resultSet.next()){
                tipocompeticao = new TipoCompeticao(resultSet.getLong("ID"), resultSet.getString("NOME"));
            }

            statement.close();
            resultSet.close();
            return tipocompeticao;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean atualizar(Object object){
        TipoCompeticao tipocompeticao = (TipoCompeticao) object;
        if (tipocompeticao == null){
            return true;
        }

        String sql = "UPDATE TIPO_COMPETICAO " +
                "SET NOME = ? " +
                "WHERE ID = ?";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, tipocompeticao.getNome());
            statement.setLong(2, tipocompeticao.getId());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
