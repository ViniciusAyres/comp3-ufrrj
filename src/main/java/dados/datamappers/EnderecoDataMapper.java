package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDataMapper{
        public ResultSet buscarPorId(int id){
            try{
                return  DataMapper.buscarPorId(id, "ENDERECO");
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            return  null;
        }

        public boolean criar(String logradouro, int numero, String complemento, String cep,
                             String bairro, String cidade, int idUf){
            String sql = "INSERT INTO ENDERECO (LOGRADOURO, NUMERO, COMPLEMENTO, CEP, " +
                    "BAIRRO, CIDADE, ID_UF) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                        .prepareStatement(sql);

                statement.setString(1, logradouro);
                statement.setInt(2, numero);
                statement.setString(3, complemento);
                statement.setString(4, cep);
                statement.setString(5, bairro);
                statement.setString(6, cidade);
                statement.setInt(7, idUf);

                return statement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }

        public boolean atualizar(int id, String logradouro, int numero, String complemento, String cep,
                                 String bairro, String cidade, int idUf){
            String sql = "UPDATE ATLETA " +
                    "SET LOGRADOURO = ?, NUMERO = ?, COMPLEMENTO = ?, CEP = ?, " +
                    "BAIRRO = ?, CIDADE = ?, ID_UF = ? " +
                    "WHERE MATRICULA = ?";

            try {
                PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                        .prepareStatement(sql);

                statement.setString(1, logradouro);
                statement.setInt(2, numero);
                statement.setString(3, complemento);
                statement.setString(4, cep);
                statement.setString(5, bairro);
                statement.setString(6, cidade);
                statement.setInt(7, idUf);
                statement.setInt(8, id);

                return statement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }
}
