package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.interfaces.IntDataMapper;
import dados.entidades.Colocacao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ColocacaoDataMapper implements IntDataMapper {
    @Override
    public Object buscarPorId(int id) {
        String sql = "SELECT * FROM COLOCACAO WHERE ID = ?";

        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Colocacao colocacao = null;

            if(resultSet.next()){
                colocacao = new Colocacao(resultSet.getLong("ID"),
                        resultSet.getLong("PONTUACAO"),
                        resultSet.getLong("POSICAO"));

            }

            statement.close();
            resultSet.close();
            return colocacao;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean criar(Object object) {

        Colocacao colocacao = (Colocacao) object;
        if (colocacao == null){
            return true;
        }

        String sql = "INSERT INTO COLOCACAO (PONTUACAO, POSICAO) " +
                "VALUES (?, ?)";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setLong(1, colocacao.getPontuacao());
            statement.setLong(2, colocacao.getPosicao());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Object object) {
        Colocacao colocacao = (Colocacao) object;
        if (colocacao == null){
            return true;
        }

        String sql = "UPDATE COLOCACAO " +
                "SET PONTUACAO = ?, POSICAO = ? " +
                "WHERE ID = ?";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setLong(1, colocacao.getPontuacao());
            statement.setLong(2, colocacao.getPosicao());
            statement.setLong(5, colocacao.getId());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
