package dados.datamappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordeDataMapper{
    public ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "RECORDE");
    }
}
