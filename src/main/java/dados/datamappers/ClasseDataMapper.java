package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.interfaces.DataMapper;
import dados.datamappers.interfaces.IntDataMapper;
import dados.entidades.Classe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClasseDataMapper implements IntDataMapper, DataMapper {

    @Override
    public boolean criar(Object object) {
        Classe classe= (Classe) object;
        if (classe == null){
            return true;
        }

        String sql = "INSERT INTO CLASSE (NOME, IDADE_MINIMA, IDADE_MAXIMA) " +
                "VALUES (?, ?, ?)";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance().prepareStatement(sql);

            statement.setString(1, classe.getNome());
            statement.setInt(2, classe.getIdadeMinima());
            statement.setInt(3, classe.getIdadeMaxima());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Classe buscarPorId(int id){
        String sql = "SELECT * FROM CLASSE WHERE ID = ?";

        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Classe classe = null;

            if(resultSet.next()){
                classe = new Classe(resultSet.getString("NOME"), resultSet.getInt("IDADE_MINIMA"),
                        resultSet.getInt("IDADE_MAXIMA"));
            }

            statement.close();
            resultSet.close();
            return classe;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean atualizar(Object object){
        Classe classe = (Classe) object;
        if (classe == null){
            return true;
        }

        String sql = "UPDATE CLASSE " +
                "SET NOME = ? , IDADE_MINIMA = ?, IDADE_MAXIMA = ? " +
                "WHERE ID = ?";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, classe.getNome());
            statement.setInt(2, classe.getIdadeMinima());
            statement.setInt(3, classe.getIdadeMaxima());
            statement.setLong(4, classe.getId());
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
