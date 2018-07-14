package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.Criptografia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class AssociacaoDataMapper {

    public ResultSet buscarPorMatricula(String matricula) throws SQLException {
        return DataMapper.buscarPorMatricula(matricula, "ASSOCIACAO");
    }

    public ResultSet buscar() throws SQLException {
        return  DataMapper.buscar("ASSOCIACAO");
    }


    public int criar(String matricula, String nome, String sigla, String telefone, String endereco) throws SQLException {
        String sql = "INSERT INTO ASSOCIACAO (MATRICULA, NOME, SIGLA, TELEFONE, ENDERECO) " +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, matricula);
        statement.setString(2, nome);
        statement.setString(3, sigla);
        statement.setString(4, telefone);
        statement.setString(5, endereco);
        return statement.executeUpdate();

    }

    public int atualizar(String matricula, String nome, String sigla, String telefone, String endereco) throws SQLException {
        String sql = "UPDATE ASSOCIACAO " +
                "SET NOME = ?, SIGLA = ?, TELEFONE = ?, ENDERECO = ? " +
                "WHERE MATRICULA = ?";


        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, nome);
        statement.setString(2, sigla);
        statement.setString(3, telefone);
        statement.setString(4, endereco);
        statement.setString(5, matricula);

        return statement.executeUpdate();
    }

}

