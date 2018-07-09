package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.*;

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

    public boolean criar(String numero_oficio, SQLData dataoficio, String numeropagamento,SQLData dataentrada, String matriculaassociacao){
        String sql = "INSERT INTO FILIACAO(NUMERO_OFICIO, DATA_OFICIO, NUMERO_PAGAMENTO, DATA_ENTRADA, MATRICULA_ASSOCIACAO) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, numero_oficio);
            statement.setDate(2, (Date) dataoficio);
            statement.setString(3, numeropagamento);
            statement.setDate(4, (Date) dataentrada);
            statement.setString(5, matriculaassociacao);
            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizar(String numero_oficio, SQLData dataoficio, String numeropagamento,SQLData dataentrada, String matriculaassociacao){
        String sql = "UPDATE ASSOCIACAO " +
                "SET DATA_OFICIO = ?, NUMERO_PAGAMENTO = ?, DATA_ENTRADA = ?, MATRICULA_ASSOCIACAO = ? " +
                "WHERE NUMERO_OFICIO = ?";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setDate(1, (Date) dataoficio);
            statement.setString(2, numeropagamento);
            statement.setDate(3, (Date) dataentrada);
            statement.setString(4, matriculaassociacao);
            statement.setString(5, numero_oficio);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}
