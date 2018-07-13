package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoCompeticaoMapper {


    public boolean criar(String Nome, String logradouro, int numero, String complemento, String cep,
                         String bairro, String cidade, String Uf){
        String sql = "INSERT INTO ENDERECO (LOGRADOURO, NUMERO, COMPLEMENTO, CEP, " +
                "BAIRRO, CIDADE, UF) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement;

            statement =  ConnectionSingleton.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, logradouro);
            statement.setInt(2, numero);
            statement.setString(3, complemento);
            statement.setString(4, cep);
            statement.setString(5, bairro);
            statement.setString(6, cidade);
            statement.setString(7, Uf);

            statement.executeUpdate();

            int idEndereco = 0;

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                idEndereco = resultSet.getInt(1);
            }

            String sqlLocal = "INSERT INTO LOCAL ( NOME, ID_TAMANHO_PISCINA, IDENDERECO) " +
                    "VALUES (?, ?, ?)";

            statement = SQL.getPreparedStatement(sqlLocal);

            statement.setString(1, Nome);
            statement.setInt(2, 1);
            statement.setInt(3, idEndereco);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
