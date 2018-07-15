package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.AssociacaoMT;
import dominio.AtletaMT;
import utils.RecordSet;
import utils.Row;
import utils.SQL;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AtletaDataMapper {
    public static ResultSet buscarPorId(int id) throws SQLException {
        return  DataMapper.buscarPorId(id, "ATLETA");

    }

    public static void criar(RecordSet recordSet) throws SQLException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int linhasAfetadas = 0;
        for(Row row : recordSet) {
            String sql = "INSERT INTO ATLETA (MATRICULA, NOME, CATEGORIA, DATA_NASCIMENTO) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = SQL.getPreparedStatement(sql);

            row.put("matricula", AtletaMT.gerarMatricula());
            statement.setString(1, row.getString("matricula"));
            statement.setString(2, row.getString("nome"));
            statement.setString(3, row.getString("categoria"));
            Timestamp dataNascimento = new Timestamp(simpleDateFormat.parse(row.getString("dataNascimento")).getTime());
            statement.setTimestamp(4, dataNascimento);

            linhasAfetadas += statement.executeUpdate();
        }
    }

    public static void atualizar(RecordSet recordSet) throws SQLException, ParseException {
        int linhasAfetadas = 0;
        for(Row row : recordSet)
        {
            String sql = "UPDATE ATLETA " +
                    "SET NOME = ?" +
                    "WHERE MATRICULA = ?";

            PreparedStatement statement = ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, row.getString("nome"));
            statement.setString(2, row.getString("matricula"));

            linhasAfetadas += statement.executeUpdate();
        }
    }

    public static RecordSet buscarPorMatricula(String matricula, String nomeTabela) throws SQLException,RegistroNaoEncontradoException {

        String sql = "SELECT * FROM ATLETA WHERE MATRICULA = ? ";

        PreparedStatement statement = SQL.getPreparedStatement(sql);

        statement.setString(1, matricula);

        ResultSet rs = statement.executeQuery();

        if(!rs.next())
            throw new RegistroNaoEncontradoException("Matrícula não encontrada","ATLETA");

        Row row = new Row();
        RecordSet dataset = new RecordSet();
        rs.beforeFirst();
        while (rs.next()) {

            row.put("matricula", rs.getString("matricula"));
            row.put("nome", rs.getString("nome"));
            row.put("categoria", rs.getString("categoria"));
            row.put("dataNascimento", rs.getString("dataNascimento"));
            dataset.add(row);
        }

        return dataset;
    }

    public static RecordSet buscar() throws SQLException {

        String sql = "SELECT * FROM ATLETA ORDER BY NOME";

        PreparedStatement statement = SQL.getPreparedStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        RecordSet recordSet = new RecordSet();

        while(resultSet.next()){
            Row row = new Row();
            row.put("matricula", resultSet.getString("MATRICULA"));
            row.put("nome", resultSet.getString("NOME"));

            recordSet.add(row);
        }

        return recordSet;
    }
}
