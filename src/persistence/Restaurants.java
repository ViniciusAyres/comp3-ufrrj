package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class Restaurants
{
    private static String dbURL = "jdbc:derby://ruralcomp3.dlinkddns.com:1527/NatacaoDB;create=true;";
    private static String tableName = "RESTAURANTS";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(String[] args)
    {
        createConnection();
        //createTable();
        //insertPessoa(1, "João", "Pedro");
        shutdown();
    }

    private static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }

    private static void insertRestaurants(int id, String restName, String cityName)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values (" +
                    id + ",'" + restName + "','" + cityName +"')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

    private static void selectRestaurants()
    {
        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                int id = results.getInt(1);
                String restName = results.getString(2);
                String cityName = results.getString(3);
                System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

    private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        }
        catch (SQLException sqlExcept)
        {

        }

    }

    public static void createTable(){
        String sql = "create table PEIDINHO ( ID INTEGER, RESTNAME VARCHAR(50), CITYNAME VARCHAR(50) )";

        try
        {
            stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

    public static void insertPeido(int id, String firstName, String lastName){
        try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into PESSOA values (" +
                    id + ",'" + firstName + "','" + lastName +"')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
}