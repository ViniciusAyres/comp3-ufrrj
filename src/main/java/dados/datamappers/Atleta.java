package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Atleta {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "ATLETA");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public boolean criar(String matricula, String nome, String categoria, Date dataNascimento){
        String sql = "INSERT INTO ATLETA (MATRICULA, NOME, CATEGORIA, DATA_NASCIMENTO) " +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, matricula);
            statement.setString(2, nome);
            statement.setString(3, categoria);
            statement.setDate(4, dataNascimento);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
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
}
