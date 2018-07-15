package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PessoaDataMapper {

    public static ResultSet buscar() throws SQLException {
        return  DataMapper.buscar("PESSOA");

    }

    public static ResultSet buscarPorMatricula(String matricula) throws SQLException {
        return  DataMapper.buscarPorMatricula(matricula, "PESSOA");

    }

    public static boolean criar(String nome, String senha, int idPerfil,
                         String matricula, String matricula_associacao) throws SQLException {

        String sql = "INSERT INTO PESSOA (NOME, SENHA,ID_PERFIL, MATRICULA, MATRICULA_ASSOCIACAO)" +
                "VALUES (?,?,?,?,?)";

        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, nome);
        statement.setString(2, senha);
        statement.setInt(3, idPerfil);
        statement.setString(4, matricula);
        statement.setString(5, matricula_associacao);

        statement.execute();
        return  true;
    }
}
