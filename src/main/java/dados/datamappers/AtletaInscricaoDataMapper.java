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
}
