package dados.datamappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClasseDataMapper {
    public static ResultSet buscar() throws SQLException {
        return DataMapper.buscar("CLASSE");
    }

    public static ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "CLASSE");
    }
}
