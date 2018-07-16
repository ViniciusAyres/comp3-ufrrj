package dados.bancos.derbyDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static String dbURL = "jdbc:derby://localhost:1527/C:/Users/Leonardo/Desktop/PROD/bin/NatacaoDB;create=true";
    private static Connection connection = null;

    protected ConnectionSingleton(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            this.connection = DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if(connection == null){
            new ConnectionSingleton();
        }

        return connection;
    }
}
