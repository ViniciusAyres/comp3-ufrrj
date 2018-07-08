package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.interfaces.DataMapper;
import dados.datamappers.interfaces.StringDataMapper;
import dados.entidades.Associacao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssociacaoDataMapper implements StringDataMapper,DataMapper {
    @Override
    public boolean criar(Object object){
        Associacao associacao = (Associacao) object;
        if (associacao == null){
            return true;
        }

        String sql = "INSERT INTO ASSOCIACAO (TELEFONE,SIGLA,NOME,MATRICULA,ID_ENDERECO) " +
                "VALUES (?, ?, ?, ?,?)";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, associacao.getTelefone());
            statement.setString(2, associacao.getSigla());
            statement.setString(3, associacao.getNome());
            statement.setString(4, associacao.getMatricula());
            statement.setLong(4, associacao.getEnderecoId());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Associacao buscarPorMatricula(String matricula){
        String sql = "SELECT * FROM ASSOCIACAO WHERE MATRICULA = ?";

        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, matricula);
            ResultSet resultSet = statement.executeQuery();
            Associacao associacao = null;

            if(resultSet.next()){
                associacao = new Associacao(resultSet.getString("TELEFONE"),
                        resultSet.getString("SIGLA"),
                        resultSet.getString("NOME"),
                        resultSet.getString("MATRICULA"),
                        resultSet.getLong("ID_ENDERECO"));
            }

            statement.close();
            resultSet.close();
            return associacao;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean atualizar(Object object){
        Associacao associacao = (Associacao) object;
        if (associacao == null){
            return true;
        }

        String sql = "UPDATE ASSOCIACAO " +
                "SET TELEFONE = ?, SIGLA = ?, NOME = ?, MATRICULA = ? , ID_ENDERECO = ?" +
                "WHERE MATRICULA = ?";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, associacao.getTelefone());
            statement.setString(2, associacao.getSigla());
            statement.setString(3, associacao.getNome());
            statement.setString(4, associacao.getMatricula());
            statement.setLong(5, associacao.getEnderecoId());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
