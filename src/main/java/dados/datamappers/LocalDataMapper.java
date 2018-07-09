package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "LOCAL");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public boolean criar(int id, String nome, int idTamanhoPiscina, int idEndereco){
        String sql = "INSERT INTO LOCAL (ID, NOME, ID_TAMANHO_PISCINA, ID_ENDERECO) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setInt(1, id);
            statement.setString(2, nome);
            statement.setInt(3, idTamanhoPiscina);
            statement.setInt(4, idEndereco);
            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizar(int id, String nome, int idTamanhoPiscina, int idEndereco){
        String sql = "UPDATE LOCAL " +
                "SET NOME = ?, ID_TAMANHO_PISCINA = ?, ID_ENDERECO = ? " +
                "WHERE ID = ?";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, nome);
            statement.setInt(2, idTamanhoPiscina);
            statement.setInt(3, idEndereco);
            statement.setInt(4, id);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
