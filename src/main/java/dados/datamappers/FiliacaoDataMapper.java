package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.RecordSet;
import utils.Row;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FiliacaoDataMapper {

    public ResultSet buscarPorNumeroOficio(String numero_oficio){
        try{
            return  DataMapper.buscarPorNumeroOficio(numero_oficio, "FILIACAO");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public void criar(RecordSet recordSet) throws SQLException {

        PreparedStatement preparedStatement;
        int linhasAfetadas = 0;
        for(Row row : recordSet)
        {
            String sql = "INSERT INTO FILIACAO(NUMERO_OFICIO, DATA_OFICIO, NUMERO_PAGAMENTO,  MATRICULA_ASSOCIACAO) " +
            "VALUES (?, ?, ?, ?)";

            preparedStatement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            preparedStatement.setString(1, row.getString("numeroOficio"));
            preparedStatement.setTimestamp(2, row.getTimestamp("dataOficio"));
            System.out.println(row.getTimestamp("dataOficio"));
            preparedStatement.setString(3, row.getString("numeroComprovante"));
            preparedStatement.setString(4, row.getString("matricula"));


            linhasAfetadas += preparedStatement.executeUpdate();
        }
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        RecordSet recordSet = new RecordSet();
        Row row = new Row();
        Date date = new Date(1995, 3, 3);
        String data = "1995-03-05";
//        System.out.println(date);
        row.put("data", data);
//        System.out.println(row);
//        System.out.println(row.getDate("data"));

        System.out.println(row);
        System.out.println(simpleDateFormat.parse(row.getString("data")));
        //    Timestamp t1 = new Timestamp(simpleDateFormat.parse(data).getTime());
    }



}
