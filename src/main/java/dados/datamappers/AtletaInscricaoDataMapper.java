package dados.datamappers;

import utils.RecordSet;
import utils.SQL;
import utils.Utils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtletaInscricaoDataMapper {
    public static void criar(RecordSet recordSet) throws SQLException {

        AtletaDataMapper at = new AtletaDataMapper();
        InscricaoDataMapper is = new InscricaoDataMapper();

        at.criar(recordSet);
        is.criar(recordSet);
    }

    public boolean atualizar(String matriculaAtleta, String nome, Date dataNascimento, String categoria,
                             String matriculaAssociacao, Date dataEntrada, String numeroPagamento, String numeroOficio, Date dataOficio ) throws SQLException {

        String atualizarAtleta = "UPDATE ATLETA " +
                                    "SET NOME = ?, DATA_NASCIMENTO = ?, CATEGORIA = ? " +
                                    " WHERE MATRICULA = ?";

        PreparedStatement statement = SQL.getPreparedStatement(atualizarAtleta);
        statement.setString(1, nome);
        statement.setDate(2, dataNascimento);
        statement.setString(3, categoria);
        statement.setString(4, matriculaAtleta);
        statement.executeUpdate();

        String insertInscricao = "INSERT INTO INSCRICAO (MATRICULA_ASSOCIACAO, DATA_ENTRADA, NUMERO_PAGAMENTO, NUMERO_OFICIO, DATA_OFICIO, MATRICULA_ATLETA) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        String atualizarInscricao = "UPDATE INSCRICAO " +
                                        "SET DATA_ENTRADA = ?, NUMERO_PAGAMENTO = ?, NUMERO_OFICIO = ?, DATA_OFICIO = ? " +
                                            "WHERE MATRICULA_ASSOCIACAO = ? AND MATRICULA_ATLETA = ? ";

        statement = SQL.getPreparedStatement(atualizarInscricao);
        statement.setDate(1, dataEntrada);
        statement.setString(2, numeroPagamento);
        statement.setString(3, numeroOficio);
        statement.setDate(4, dataOficio);
        statement.setString(5, matriculaAssociacao);
        statement.setString(6, matriculaAtleta);
        statement.executeUpdate();

        return true;

    }
}
