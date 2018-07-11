import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDerbySingleton {
    private static String dbURL = "jdbc:derby:/home/vinicius/Documentos/Faculdade/COMP3/Trab/comp3-ufrrj/teste;create=true";
    private static Connection connection = null;

    protected ConnectionDerbySingleton(){
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            Connection conn = DriverManager.getConnection(dbURL);
            //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            //DriverManager.registerDriver/();
            //conn = DriverManager.getConnection(URL, USER, PASSWORD);
            this.connection = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if(connection == null){
            new ConnectionDerbySingleton();
        }

        return connection;
    }

    public static void main(String[] args) {
        ConnectionDerbySingleton connectionDerbySingleton = new ConnectionDerbySingleton();
    }
}
