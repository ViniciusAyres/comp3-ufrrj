package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public  static  ResultSet buscarPorChave(String tabela, String chave, String valor) throws SQLException {

        String sql = "SELECT * FROM " + tabela + " WHERE " + chave +  "=? ";

        PreparedStatement statement;
        statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);
        statement.setString(1, valor);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet;

    }

    public  static  boolean excluirPorChave(String tabela, String chave, String valor) throws SQLException {

        String sql = "DELETE FROM " + tabela + " WHERE " + chave +  "=? ";

        PreparedStatement statement;
        statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);
        statement.setString(1, valor);

        return statement.execute();
    }


    public static ResultSet buscarPorMatricula(String matricula, String nomeTabela) throws SQLException {

        String sql = "SELECT * FROM " + nomeTabela + " WHERE MATRICULA = ? ";

        PreparedStatement statement;

        statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, matricula);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet;
    }

}
