package dados.datamappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TamanhoPiscinaDataMapper {

    public ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "TAMANHO_PISCINA");
    }
}
