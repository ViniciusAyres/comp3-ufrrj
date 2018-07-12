package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.SQL;

import java.sql.*;

public class AssociacaoFiliacaoEnderecoDataMapper {

    public boolean criar(String nome, String sigla, String telefone,
                           String logradouro, int numeroLogradouro, String cidade, String bairro, String cep, int idUF,
                           String numeroOficio, Date dataOficio, String numeroComprovante){

        try {
            PreparedStatement preparedStatement;
            String insertEndereco = "INSERT INTO ENDERECO (LOGRADOURO, NUMERO, CIDADE, BAIRRO, CEP, ID_UF) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = ConnectionSingleton.getInstance().prepareStatement(insertEndereco, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, logradouro);
            preparedStatement.setInt(2, numeroLogradouro);
            preparedStatement.setString(3, cidade);
            preparedStatement.setString(4, bairro);
            preparedStatement.setString(5, cep);
            preparedStatement.setInt(6, idUF);
            preparedStatement.executeUpdate();


            int idEndereco = 0;
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                idEndereco = resultSet.getInt(1);
            }


            String matricula = new AssociacaoDataMapper().gerarMatricula();

            String insertAssociacao = "INSERT INTO ASSOCIACAO (MATRICULA, NOME, SIGLA, TELEFONE, ID_ENDERECO) " +
                    "VALUES(?, ?, ?, ?, ?)";

            preparedStatement = SQL.getPreparedStatement(insertAssociacao);
            preparedStatement.setString(1, matricula);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, sigla);
            preparedStatement.setString(4, telefone);
            preparedStatement.setInt(5, idEndereco);
            preparedStatement.execute();


            String insertFiliacao = "INSERT INTO FILIACAO (NUMERO_OFICIO, DATA_OFICIO, NUMERO_PAGAMENTO) " +
                    "VALUES (?, ?, ?)";

            preparedStatement = SQL.getPreparedStatement(insertFiliacao);
            preparedStatement.setString(1, numeroOficio);
            preparedStatement.setDate(2, dataOficio);
            preparedStatement.setString(3, numeroComprovante);
            preparedStatement.execute();

            System.out.println("MATRICULA GERADA: " + matricula);

        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }

        return true;
    }
}
