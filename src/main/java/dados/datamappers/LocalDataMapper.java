package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.RecordSet;
import utils.Row;

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

    public void  criar(RecordSet recordSet) throws SQLException {
        String sql = "INSERT INTO LOCAL (NOME, TAMANHO_PISCINA, ENDERECO) " +
                "VALUES (?, ?, ?)";

        int linhasAfetadas = 0;
        for(Row row : recordSet) {

            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, row.getString("nome"));
            statement.setInt(2, row.getInt("tamanhoPiscina"));
            statement.setString(3, row.getString("endereco"));

            linhasAfetadas += statement.executeUpdate();
        }
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
