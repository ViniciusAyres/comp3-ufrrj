package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dominio.Perfil;
import utils.SQL;

import java.sql.*;

public class AssociacaoFiliacaoEnderecoDataMapper {

    public boolean criar(String nome, String sigla, String telefone,
                           String logradouro, int numeroLogradouro, String cidade, String bairro, String cep, int idUF,
                           String numeroOficio, Date dataOficio, String numeroComprovante){

//        try {
//            PreparedStatement preparedStatement;
//            String insertEndereco = "INSERT INTO ENDERECO (LOGRADOURO, NUMERO, CIDADE, BAIRRO, CEP, UF) " +
//                    "VALUES (?, ?, ?, ?, ?, ?)";
//
//            preparedStatement = ConnectionSingleton.getInstance().prepareStatement(insertEndereco, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, logradouro);
//            preparedStatement.setInt(2, numeroLogradouro);
//            preparedStatement.setString(3, cidade);
//            preparedStatement.setString(4, bairro);
//            preparedStatement.setString(5, cep);
//            preparedStatement.setInt(6, idUF);
//            preparedStatement.executeUpdate();
//
//
//            int idEndereco = 0;
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()){
//                idEndereco = resultSet.getInt(1);
//            }
//
//            String matriculaAssociacao = new AssociacaoDataMapper().gerarMatricula();
//
//            String insertAssociacao = "INSERT INTO ASSOCIACAO (MATRICULA, NOME, SIGLA, TELEFONE, ID_ENDERECO) " +
//                    "VALUES(?, ?, ?, ?, ?)";
//
//            preparedStatement = SQL.getPreparedStatement(insertAssociacao);
//            preparedStatement.setString(1, matriculaAssociacao);
//            preparedStatement.setString(2, nome);
//            preparedStatement.setString(3, sigla);
//            preparedStatement.setString(4, telefone);
//            preparedStatement.setInt(5, idEndereco);
//            preparedStatement.execute();
//
//
//            String insertFiliacao = "INSERT INTO FILIACAO (NUMERO_OFICIO, MATRICULA_ASSOCIACAO, DATA_OFICIO, NUMERO_PAGAMENTO) " +
//                    "VALUES (?, ?, ?, ?)";
//
//            preparedStatement = SQL.getPreparedStatement(insertFiliacao);
//            preparedStatement.setString(1, numeroOficio);
//            preparedStatement.setString(2, matriculaAssociacao);
//            preparedStatement.setDate(3, dataOficio);
//            preparedStatement.setString(4, numeroComprovante);
//            preparedStatement.execute();
//
//            String matriculaTecnico = new AssociacaoDataMapper().gerarMatricula();
//            Perfil perfil = Perfil.TECNICO_ASSOSSIACAO;
//            String senhaTecnico = new AssociacaoDataMapper().gerarSenha();
//
//            String insertTecnico = "INSERT INTO PESSOA (ID_PERFIL, MATRICULA, MATRICULA_ASSOCIACAO, SENHA)" +
//                    "VALUES (?, ?, ?, ?)";
//            preparedStatement = SQL.getPreparedStatement(insertTecnico);
//            preparedStatement.setInt(1, perfil.getId());
//            preparedStatement.setString(2, matriculaTecnico);
//            preparedStatement.setString(3, matriculaAssociacao);
//            preparedStatement.setString(4, senhaTecnico);
//            preparedStatement.execute();
//
//            System.out.println("MATRICULA DA ASSOCIACAO GERADA: " + matriculaAssociacao);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return  false;
//        }

        return true;
    }
}
