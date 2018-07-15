package dados.datamappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoCompeticaoDataMapper {

    public static ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "TIPO_COMPETICAO");
    }

}


