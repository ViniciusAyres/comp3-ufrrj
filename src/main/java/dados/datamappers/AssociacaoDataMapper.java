package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssociacaoDataMapper {
    public ResultSet buscarPorMatricula(String matricula){
        try{
            return  DataMapper.buscarPorMatricula(matricula, "ASSOCIACAO");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

    public boolean criar(String matricula, String nome, String sigla, String telefone, int idEndereco){
        String sql = "INSERT INTO ASSOCIACAO (MATRICULA, NOME, SIGLA, TELEFONE, ID_ENDERECO) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, matricula);
            statement.setString(2, nome);
            statement.setString(3, sigla);
            statement.setString(4, telefone);
            statement.setInt(5, idEndereco);
            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizar(String matricula, String nome, String sigla, String telefone, int idEndereco){
        String sql = "UPDATE ASSOCIACAO " +
                "SET NOME = ?, SIGLA = ?, TELEFONE = ?, ID_ENDERECO = ? " +
                "WHERE MATRICULA = ?";

        try {
            PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, nome);
            statement.setString(2, sigla);
            statement.setString(3, telefone);
            statement.setInt(4, idEndereco);
            statement.setString(5, matricula);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

