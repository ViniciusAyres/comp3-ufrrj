package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dominio.AssociacaoMT;
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

    public static void atualizar(RecordSet recordSet) throws SQLException {

        int linhasAfetadas = 0;
        for(Row row : recordSet)
        {
            String sql = "UPDATE FILIACAO " +
                    "SET DATA_OFICIO = ?, NUMERO_OFICIO = ?, NUMERO_PAGAMENTO = ? " +
                    "WHERE MATRICULA_ASSOCIACAO = ?";

            try {
                PreparedStatement statement = ConnectionSingleton.getInstance()
                        .prepareStatement(sql);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Timestamp dataOficio = new Timestamp(simpleDateFormat.parse(row.getString("dataOficio")).getTime());


                statement.setString(1, row.getString("numeroOficio"));
                statement.setTimestamp(2, dataOficio);
                statement.setString(3, row.getString("numeroComprovante"));
                statement.setString(4, row.getString("matricula"));

                linhasAfetadas += statement.executeUpdate();

            }catch (Exception e){
                String message = e.getMessage();
            }
        }
    }
}
