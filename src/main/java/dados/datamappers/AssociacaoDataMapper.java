package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import utils.Criptografia;

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

    public boolean verficarAssociacaoPorMatricula(String matricula) {
        try {
            ResultSet resultSet = DataMapper.buscarPorMatricula(matricula, "ASSOCIACAO");
            return  resultSet.next();

        } catch (Exception ex) {
            ex.printStackTrace();
            return  false;
        }
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

    public String gerarMatricula() throws SQLException {

        String matricula = null;
        boolean  existMatriculaBD;

        do {
            int quantidadeAssociacoes =  this.buscarQuantidadesAssociados();
            quantidadeAssociacoes =  quantidadeAssociacoes == 0  ? quantidadeAssociacoes + 1 : quantidadeAssociacoes;
            String quantidadeAssociacoesStr = Integer.toString(quantidadeAssociacoes);
            matricula = Criptografia.gerarMatricula(quantidadeAssociacoes);
            existMatriculaBD = this.verficarAssociacaoPorMatricula(matricula);
        }while (existMatriculaBD);

        return  matricula;
    }

    public int buscarQuantidadesAssociados() throws SQLException {

        int quantidade = 0;
        String sql = "SELECT COUNT(*) AS TOTAL FROM ASSOCIACAO";
        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            quantidade = result.getInt(1);
        }

        return quantidade;

    }


}

