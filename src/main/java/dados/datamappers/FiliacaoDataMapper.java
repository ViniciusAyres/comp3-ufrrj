package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.RecordSet;
import utils.Row;

import java.sql.*;
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
            preparedStatement.setString(2, row.getString("dataOficio"));
            preparedStatement.setString(3, row.getString("numeroComprovante"));
            preparedStatement.setString(4, row.getString("matricula"));


            linhasAfetadas += preparedStatement.executeUpdate();
        }
    }



}
