package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.RecordSet;
import utils.Row;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FiliacaoDataMapper {

    public static ResultSet buscarPorNumeroOficio(String numero_oficio) throws SQLException {
        return  DataMapper.buscarPorNumeroOficio(numero_oficio, "FILIACAO");
    }

    public static void criar(RecordSet recordSet) throws SQLException, ParseException {

        PreparedStatement preparedStatement;
        int linhasAfetadas = 0;
        for(Row row : recordSet) {
            String sql = "INSERT INTO FILIACAO(NUMERO_OFICIO, DATA_OFICIO, NUMERO_PAGAMENTO,  MATRICULA_ASSOCIACAO) " +
            "VALUES (?, ?, ?, ?)";

            preparedStatement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Timestamp dataOficio = new Timestamp(simpleDateFormat.parse(row.getString("dataOficio")).getTime());


            preparedStatement.setString(1, row.getString("numeroOficio"));
            preparedStatement.setTimestamp(2, dataOficio);
            preparedStatement.setString(3, row.getString("numeroComprovante"));
            preparedStatement.setString(4, row.getString("matricula"));


            linhasAfetadas += preparedStatement.executeUpdate();
        }
    }

}
