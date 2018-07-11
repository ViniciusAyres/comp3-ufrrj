package utils;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {
    public static PreparedStatement getPreparedStatement(String query) throws SQLException {
        return (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
}
