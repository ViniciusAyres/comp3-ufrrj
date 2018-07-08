package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.entidades.Atleta;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtletaDataMapper {
    public int criar(Atleta atleta){
        if (atleta == null){
            return 0;
        }

        String sql = "INSERT INTO ATLETA (NOME, MATRICULA, DATA_NASCIMENTO, CATEGORIA) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement statement;

        try{
            statement = (PreparedStatement) ConnectionSingleton.getInstance()
                    .prepareStatement(sql);

            statement.setString(1, atleta.getNome());
            statement.setString(2, atleta.getMatricula());
            statement.setDate(3, (Date) atleta.getDataNascimento());
            statement.setString(4, atleta.getCategoria());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
