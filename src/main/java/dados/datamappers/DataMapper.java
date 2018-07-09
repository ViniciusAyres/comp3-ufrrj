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

    public static boolean criar(String tabela, String paramentros, String valores) throws SQLException{

        String sql = "INSERT INTO" + tabela + "(" + paramentros + ")" + "VALUES (" +  valores + ")";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.execute();

        return  true;
    }

    public static ResultSet buscarPorNumeroOficio(String numero_oficio, String nomeTabela) throws SQLException {

        String sql = "SELECT * FROM " + nomeTabela + " WHERE NUMERO_OFICIO = ? ";

        PreparedStatement statement;

        statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, numero_oficio);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet;
    }
}
