package dados.datamappers;

import java.sql.ResultSet;

public class UFDataMapper {
    public ResultSet buscarPorId(int id) {
        try {
            return DataMapper.buscarPorId(id, "UF");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
