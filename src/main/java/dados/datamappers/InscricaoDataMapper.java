package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.RecordSet;
import utils.Row;

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

    public void criar(RecordSet recordSet) throws SQLException{

        int linhasAfetadas = 0;
        for(Row row : recordSet) {
            String sql = "INSERT INTO INSCRICAO (NUMERO_OFICIO, DATA_ENTRADA, NUMERO_PAGAMENTO," +
                    " MATRICULA_ASSOCIACAO, MATRICULA_ATLETA)" +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, row.getString("numeroOficio"));
            statement.setDate(2, row.getDate("dataEntrada"));
            statement.setString(3, row.getString("numeroPagamento"));
            statement.setString(4, row.getString("matriculaAssociado"));
            statement.setString(4, row.getString("matriculaAtleta"));

            linhasAfetadas += statement.executeUpdate();
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
