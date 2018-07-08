package adaptadores.interfaces;

import java.sql.ResultSet;

public interface StringDataMapperAdaptador {
    ResultSet buscarPorMatricula(String matricula);
}
