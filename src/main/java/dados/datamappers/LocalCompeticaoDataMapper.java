package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalCompeticaoDataMapper {

    public ResultSet buscar() throws SQLException {

        String sql = "SELECT CP.ID IDCOMPETICAO,P.ID IDPROVA, L.NOME LOCALNOME,  CP.NOME, P.CATEGORIA, P.NOME, PISCINA.TAMANHO TAMANHO, L.ENDERECO\n" +
                "  FROM COMPETICAO AS CP\n" +
                "  JOIN PROVA_COMPETICAO PC on CP.ID = PC.ID_COMPETICAO\n" +
                "  JOIN PROVA P on PC.ID_PROVA = P.ID\n" +
                "  JOIN  LOCAL L on CP.ID_LOCAL = L.ID\n" +
                "  JOIN  TAMANHO_PISCINA PISCINA on L.ID_TAMANHO_PISCINA = PISCINA.ID";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);


        ResultSet result = statement.executeQuery();

        return result;
    }
}
