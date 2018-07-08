package adaptadores.interfaces;

import dados.datamappers.interfaces.DataMapper;

import java.sql.ResultSet;

public interface IntDataMapperAdaptador extends DataMapper {
    ResultSet buscarPorId(int id);
}
