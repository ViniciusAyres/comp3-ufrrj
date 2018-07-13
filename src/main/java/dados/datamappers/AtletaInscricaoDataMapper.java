package dados.datamappers;

import utils.SQL;
import utils.Utils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtletaInscricaoDataMapper {
    public boolean criar(String nome, Date dataNascimento, String categoria,
                         String matriculaAssociacao, Date dataEntrada, String numeroPagamento, String numeroOficio, Date dataOficio ) throws SQLException {

        String insertAtleta = "INSERT INTO ATLETA (MATRICULA, NOME, DATA_NASCIMENTO, CATEGORIA) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement statement = SQL.getPreparedStatement(insertAtleta);
        String matriculaAtleta = new AssociacaoDataMapper().gerarMatricula();
        statement.setString(1, matriculaAtleta);
        statement.setString(2, nome);
        statement.setDate(3, dataNascimento);
        statement.setString(4, categoria);
        statement.execute();

        String insertInscricao = "INSERT INTO INSCRICAO (MATRICULA_ASSOCIACAO, DATA_ENTRADA, NUMERO_PAGAMENTO, NUMERO_OFICIO, DATA_OFICIO, MATRICULA_ATLETA) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        statement = SQL.getPreparedStatement(insertInscricao);
        statement.setString(1, matriculaAssociacao);
        statement.setDate(2, dataEntrada);
        statement.setString(3, numeroPagamento);
        statement.setString(4, numeroOficio);
        statement.setDate(5, dataOficio);
        statement.setString(6, matriculaAtleta);
        statement.execute();
        System.out.println("grava inscricao");
        return true;
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
