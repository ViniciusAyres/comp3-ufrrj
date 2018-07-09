package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompeticaoDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "COMPETICAO");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public boolean criar(int id, String nome, String categoria, Date data, int idTipoCompeticao, int idLocal){
        String sql = "INSERT INTO COMPETICAO (ID, NOME, DATA, CATEGORIA, ID_TIPO_COMPETICAO, ID_LOCAL) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setInt(1, id);
            statement.setString(2, nome);
            statement.setString(3, categoria);
            statement.setDate(4, data);
            statement.setInt(5, idTipoCompeticao);
            statement.setInt(6, idLocal);
            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizar(int id, String nome, String categoria, Date data, int idTipoCompeticao, int idLocal){
        String sql = "UPDATE COMPETICAO " +
                "SET NOME = ?, CATEGORIA = ?, DATA = ?, ID_TIPO_COMPETICAO = ?, ID_LOCAL = ? " +
                "WHERE ID = ?";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, nome);
            statement.setString(2, categoria);
            statement.setDate(3, data);
            statement.setInt(4, idTipoCompeticao);
            statement.setInt(5, idLocal);
            statement.setInt(6, id);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}