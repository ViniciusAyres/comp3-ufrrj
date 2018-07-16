package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.AssociacaoMT;
import utils.Criptografia;
import utils.RecordSet;
import utils.Row;
import utils.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class AssociacaoDataMapper {

    public static RecordSet buscarPorMatricula(String matricula) throws SQLException,RegistroNaoEncontradoException {

        String sql = "SELECT * FROM ASSOCIACAO WHERE MATRICULA = ? ";

        PreparedStatement statement = SQL.getPreparedStatement(sql);

        statement.setString(1, matricula);

        ResultSet rs = statement.executeQuery();

        if(!rs.next())
            throw new RegistroNaoEncontradoException("Matrícula não encontrada","ASSOCIACAO");

        Row row = new Row();
        RecordSet dataset = new RecordSet();
        rs.beforeFirst();
        while (rs.next()) {

            row.put("matricula", rs.getString("matricula"));
            row.put("nome", rs.getString("nome"));
            row.put("sigla", rs.getString("sigla"));
            row.put("telefone", rs.getString("telefone"));
            row.put("endereco", rs.getString("endereco"));
            dataset.add(row);
        }

        return dataset;
    }

    public static ResultSet buscarPorMatriculaESenha(String matricula, String senha) throws SQLException,RegistroNaoEncontradoException {

        String sql = "SELECT * FROM ASSOCIACAO WHERE MATRICULA = ? AND SENHA = ? ";

        PreparedStatement statement = SQL.getPreparedStatement(sql);

        statement.setString(1, matricula);
        statement.setString(2, senha);

        ResultSet rs = statement.executeQuery();

        if(!rs.next())
            throw new RegistroNaoEncontradoException("Matrícula ou senha incorreta.","ASSOCIACAO");

        return rs;
    }

    public RecordSet buscar() throws SQLException {

        String sql = "SELECT * FROM ASSOCIACAO ORDER BY NOME";
        PreparedStatement statement = SQL.getPreparedStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        RecordSet recordSet = new RecordSet();

        while(resultSet.next()){
            Row row = new Row();
            row.put("matricula", resultSet.getString("MATRICULA"));
            row.put("nome", resultSet.getString("NOME"));
            row.put("telefone", resultSet.getString("TELEFONE"));
            row.put("endereco", resultSet.getString("ENDERECO"));

            recordSet.add(row);
        }

        return recordSet;
    }


    public static void criar(RecordSet recordSet) throws SQLException {

        int linhasAfetadas = 0;
        for(Row row : recordSet)
        {
            String sql = "INSERT INTO ASSOCIACAO (MATRICULA, NOME, SIGLA, TELEFONE, ENDERECO) " +
                    "VALUES (?, ?, ?, ?, ?)";

            try {
                PreparedStatement statement = ConnectionSingleton.getInstance()
                        .prepareStatement(sql);
                row.put("matricula", AssociacaoMT.gerarMatricula());
                statement.setString(1, row.getString("matricula"));
                statement.setString(2, row.getString("nome"));
                statement.setString(3, row.getString("sigla"));
                statement.setString(4, row.getString("telefone"));
                statement.setString(5, row.getString("endereco"));

                linhasAfetadas += statement.executeUpdate();
            }catch (Exception e){
                String message = e.getMessage();
            }


        }
    }

    public static void atualizar(RecordSet recordSet) throws SQLException {

        int linhasAfetadas = 0;
        for(Row row : recordSet)
        {
            String sql = "UPDATE ASSOCIACAO " +
                    "SET NOME = ?, SIGLA = ?, TELEFONE = ?, ENDERECO = ? " +
                    "WHERE MATRICULA = ?";

            try {
                PreparedStatement statement = ConnectionSingleton.getInstance()
                        .prepareStatement(sql);

                statement.setString(1, row.getString("nome"));
                statement.setString(2, row.getString("sigla"));
                statement.setString(3, row.getString("telefone"));
                statement.setString(4, row.getString("endereco"));
                statement.setString(5, row.getString("matricula"));

                linhasAfetadas += statement.executeUpdate();
            }catch (Exception e){
                String message = e.getMessage();
            }
        }
    }
}

