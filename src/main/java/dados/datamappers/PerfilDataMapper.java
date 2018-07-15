package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PerfilDataMapper   {

    public static ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "PERFIL");
    }

}
