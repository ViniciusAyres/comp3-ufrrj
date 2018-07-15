package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import org.apache.derby.shared.common.reference.SQLState;
import utils.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalCompeticaoDataMapper {

    public static ResultSet buscar() throws SQLException {

        String sql = "SELECT  L.NOME LOCALNOME,  E.LOGRADOURO ENDERECO, PISCINA.TAMANHO TAMANHO \n" +
                "  FROM COMPETICAO AS CP\n" +
                "  JOIN  LOCAL L on CP.ID_LOCAL = L.ID\n" +
                "  JOIN  TAMANHO_PISCINA PISCINA on L.ID_TAMANHO_PISCINA = PISCINA.ID" + "\n"
                + "join  ENDERECO E on L.IDENDERECO = E.ID\n";

        PreparedStatement statement1 = SQL.getPreparedStatement(sql);
        ResultSet result = statement1.executeQuery();
        return  result;
    }
}
