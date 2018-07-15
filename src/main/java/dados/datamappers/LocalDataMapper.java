package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.RecordSet;
import utils.Row;
import utils.SQL;
import utils.Utils;

import java.nio.FloatBuffer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalDataMapper {


    public static RecordSet buscarPorNome(String nome) throws SQLException {

        String sql = "SELECT * FROM LOCAL WHERE ID = ? ";

        PreparedStatement statement = SQL.getPreparedStatement(sql);
        statement.setString(1, nome);

        ResultSet resultSet =  statement.executeQuery();

        return resultSetToRecordSetMatricula(resultSet);

    }


    public static RecordSet buscarTodos() throws SQLException {

        String sql = "SELECT * FROM LOCAL";
        PreparedStatement statement = SQL.getPreparedStatement(sql);

        ResultSet resultSet =  statement.executeQuery();

        return  LocalDataMapper.resultSetToRecordSetMatricula(resultSet);
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

    public static boolean atualizar(int id, String nome, int idTamanhoPiscina, int idEndereco) throws SQLException {
        String sql = "UPDATE LOCAL " +
                "SET NOME = ?, ID_TAMANHO_PISCINA = ?, ID_ENDERECO = ? " +
                "WHERE ID = ?";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, nome);
        statement.setInt(2, idTamanhoPiscina);
        statement.setInt(3, idEndereco);
        statement.setInt(4, id);

        return statement.execute();
    }

    private static RecordSet resultSetToRecordSetMatricula(ResultSet resultSet) throws SQLException {

        resultSet.beforeFirst();
        RecordSet recordSet = new RecordSet();

        while(resultSet.next()) {

                Row row = new Row();

                row.put("nome", resultSet.getString("NOME"));
                row.put("endereco", resultSet.getString("ENDERECO"));
                row.put("tamanhoPiscina", resultSet.getInt("TAMANHO_PISCINA"));

                recordSet.add(row);
            }

        return recordSet;
    }


}
