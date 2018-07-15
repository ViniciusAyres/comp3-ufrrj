package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.RecordSet;
import utils.Row;
import utils.SQL;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InscricaoDataMapper {

    public static ResultSet buscarPorNumeroOficio(String numeroOficio) throws SQLException {
        return DataMapper.buscarPorChave("INSCRICAO", "NUMERO_OFICIO", numeroOficio);
    }

    public static void criar(RecordSet recordSet) throws SQLException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int linhasAfetadas = 0;
        for(Row row : recordSet) {
            String sql = "INSERT INTO INSCRICAO (NUMERO_OFICIO, DATA_OFICIO, DATA_ENTRADA, NUMERO_PAGAMENTO," +
                    " MATRICULA_ASSOCIACAO, MATRICULA_ATLETA)" +
                    "VALUES (?,?,?,?,?,?)";

            PreparedStatement statement = SQL.getPreparedStatement(sql);

            Timestamp dataOficio = new Timestamp(simpleDateFormat.parse(row.getString("dataOficio")).getTime());
            Timestamp dataEntrada = new Timestamp(simpleDateFormat.parse(row.getString("dataAssociacao")).getTime());

            statement.setString(1, row.getString("numeroOficio"));
            statement.setTimestamp(2, dataOficio);
            statement.setTimestamp(3, dataEntrada);
            statement.setString(4, row.getString("numeroComprovante"));
            statement.setString(5, row.getString("matriculaAssociacao"));
            statement.setString(6,(row.getString(("matricula"))));

            linhasAfetadas += statement.executeUpdate();
        }
    }

    public static void atualizar(RecordSet recordSet) throws SQLException, ParseException {
        int linhasAfetadas = 0;
        for(Row row : recordSet)
        {
            String sql = "UPDATE INSCRICAO " +
                "SET DATA_OFICIO = ?, NUMERO_OFICIO = ?, DATA_ENTRADA = ? " +
                "WHERE MATRICULA_ATLETA = ?";

            PreparedStatement statement = ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Timestamp dataOficio = new Timestamp(simpleDateFormat.parse(row.getString("dataOficio")).getTime());
            Timestamp dataEntrada = new Timestamp(simpleDateFormat.parse(row.getString("dataAssociacao")).getTime());

            statement.setTimestamp(1, dataOficio);
            statement.setString(2, row.getString("numero_oficio"));
            statement.setTimestamp(3, dataEntrada);
            statement.setString(4, row.getString("matricula"));

            linhasAfetadas += statement.executeUpdate();
        }
    }
}
