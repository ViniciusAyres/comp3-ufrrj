package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.interfaces.StringDataMapper;
import dados.entidades.Atleta;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtletaDataMapper implements StringDataMapper {
    public boolean criar(Atleta atleta){
        if (atleta == null){
            return true;
        }

        String sql = "INSERT INTO ATLETA (NOME, MATRICULA, DATA_NASCIMENTO, CATEGORIA) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, atleta.getNome());
            statement.setString(2, atleta.getMatricula());
            statement.setDate(3, (Date) atleta.getDataNascimento());
            statement.setString(4, atleta.getCategoria());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Atleta buscarPorMatricula(String matricula){
        String sql = "SELECT * FROM TABELA WHERE MATRICULA = ?";

        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, matricula);
            ResultSet resultSet = statement.executeQuery();
            Atleta atleta = null;

            if(resultSet.next()){
                atleta = new Atleta(resultSet.getString("NOME"),
                        resultSet.getString("MATRICULA"),
                        resultSet.getDate("DATA_NASCIMENTO"),
                        resultSet.getString("CATEGORIA"));

            }

            statement.close();
            resultSet.close();
            return atleta;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean atualizar(Atleta atleta){
        if (atleta == null){
            return true;
        }

        String sql = "UPDATE ATLETA " +
                "SET NOME = ?, MATRICULA = ?, DATA_NASCIMENTO = ?, CATEGORIA = ? " +
                "WHERE MATRICULA = ?";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, atleta.getNome());
            statement.setString(2, atleta.getMatricula());
            statement.setDate(3, (Date) atleta.getDataNascimento());
            statement.setString(4, atleta.getCategoria());
            statement.setString(5, atleta.getMatricula());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
