package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InscricaoDataMapper {



    public  ResultSet buscarPorNumeroOficio(String numeroOficio){

        try {

            return DataMapper.buscarPorChave("INSCRICAO", "NUMERO_OFICIO",
                    numeroOficio);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public boolean criar(String numeroOficio, Date dataEntrada,
                         String numeroPagamento, String matriculaAssociado, String matriculaAtleta) throws SQLException {

        try {

            String sql = "INSERT INTO INSCRICAO (NUMERO_OFICIO, DATA_ENTRADA, NUMERO_PAGAMENTO," +
                    " MATRICULA_ASSOCIACAO, MATRICULA_ATLETA)" +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, numeroOficio);
            statement.setDate(2, dataEntrada);
            statement.setString(3, numeroPagamento);
            statement.setString(4, matriculaAssociado);
            statement.setString(5, matriculaAtleta);

            statement.execute();

            return true;
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
            return  false;
        }
    }

    public  boolean excluir(String numeroOficio) throws SQLException {

        try {
            return  DataMapper.excluirPorChave("INSCRICAO", "NUMERO_OFICIO", numeroOficio);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return  false;
        }

    }
}
