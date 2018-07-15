package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvaDataMapper {


    public static boolean criar(String nome, Date data, String categoria,
                              int limiteParticipantes, int idTipoProva, int idClasse) throws SQLException {

        String sql = "INSERT INTO PROVA (NOME, DATA, LIMITE_PARTICIPANTES, CATEGORIA, " +
                " ID_TIPO_PROVA, ID_CLASSE) " + "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, nome);
        statement.setDate(2, data);
        statement.setInt(3, limiteParticipantes);
        statement.setString(4, categoria);
        statement.setInt(5, idTipoProva);
        statement.setInt(6, idClasse);
        statement.execute();

        return true;

    }

    private static ResultSet buscarPorId (int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "PROVA");
    }

    private static boolean excluirAtletaPorId(int id) throws SQLException {
        return  DataMapper.excluirPorId( "PROVA", id);
    }

}
