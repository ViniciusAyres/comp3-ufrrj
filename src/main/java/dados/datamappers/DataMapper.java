package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DataMapper {


    public static ResultSet buscarPorId(int id, String nomeTabela) throws SQLException {

        String sql = "SELECT * FROM " + nomeTabela + " WHERE ID = ? ";

        PreparedStatement statement;

        statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet;
    }

    public static ResultSet buscarPorMatricula(String matricula, String nomeTabela) throws SQLException {

        String sql = "SELECT * FROM " + nomeTabela + " WHERE ID = ? ";

        PreparedStatement statement;

        statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, matricula);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet;
    }
}
