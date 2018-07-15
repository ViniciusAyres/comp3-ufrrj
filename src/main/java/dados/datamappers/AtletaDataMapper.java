package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import utils.RecordSet;
import utils.Row;
import utils.SQL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtletaDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "ATLETA");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public void criar(RecordSet recordSet) throws SQLException{

        int linhasAfetadas = 0;
        for(Row row : recordSet) {
            String sql = "INSERT INTO ATLETA (MATRICULA, NOME, CATEGORIA, DATA_NASCIMENTO) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, row.getString("matricula"));
            statement.setString(2, row.getString("nome"));
            statement.setString(3, row.getString("categoria"));
            statement.setDate(4, row.getDate("dataNascimento"));

            linhasAfetadas += statement.executeUpdate();
        }
    }

    public boolean atualizar(String matricula, String nome, String categoria, Date dataNascimento){
        String sql = "UPDATE ATLETA " +
                "SET NOME = ?, CATEGORIA = ?, DATA_NASCIMENTO = ? " +
                "WHERE MATRICULA = ?";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, nome);
            statement.setString(2, categoria);
            statement.setDate(3, dataNascimento);
            statement.setString(4, matricula);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ResultSet buscar() {
        try{
            return  DataMapper.buscar("ATLETA");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public static RecordSet buscarPorMatricula(String matricula, String nomeTabela) throws SQLException,RegistroNaoEncontradoException {

        String sql = "SELECT * FROM ATLETA WHERE MATRICULA = ? ";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);


        statement.setString(1, matricula);

        ResultSet rs = statement.getResultSet();

        if(!rs.next())
            throw new RegistroNaoEncontradoException("Matrícula não encontrada","ATLETA");

        Row row = new Row();
        RecordSet dataset = new RecordSet();
        while (rs.next()) {

            row.put("matricula", rs.getString("matricula"));
            row.put("nome", rs.getString("nome"));
            row.put("categoria", rs.getString("categoria"));
            row.put("dataNascimento", rs.getString("dataNascimento"));
            dataset.add(row);
        }

        return dataset;
    }
}
