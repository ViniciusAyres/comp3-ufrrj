package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dominio.AssociacaoMT;
import utils.Criptografia;
import utils.RecordSet;
import utils.Row;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class AssociacaoDataMapper {

    public ResultSet buscarPorMatricula(String matricula) throws SQLException {
        return DataMapper.buscarPorMatricula(matricula, "ASSOCIACAO");
    }

    public ResultSet buscar() throws SQLException {
        return  DataMapper.buscar("ASSOCIACAO");
    }


    public void criar(RecordSet recordSet) throws SQLException {

        int linhasAfetadas = 0;
        for(Row row : recordSet)
        {
            String sql = "INSERT INTO ASSOCIACAO (MATRICULA, NOME, SIGLA, TELEFONE, ENDERECO) " +
                    "VALUES (?, ?, ?, ?, ?)";

            try {
                PreparedStatement statement = ConnectionSingleton.getInstance()
                        .prepareStatement(sql);
                row.put("matricula", AssociacaoMT.gerarMatricula());
                statement.setString(1, row.getString("matricula"));
                statement.setString(2, row.getString("nome"));
                statement.setString(3, row.getString("sigla"));
                statement.setString(4, row.getString("telefone"));
                statement.setString(5, row.getString("endereco"));

                linhasAfetadas += statement.executeUpdate();
            }catch (Exception e){
                String message = e.getMessage();
            }


        }
    }

    public int atualizar(String matricula, String nome, String sigla, String telefone, String endereco) throws SQLException {
        String sql = "UPDATE ASSOCIACAO " +
                "SET NOME = ?, SIGLA = ?, TELEFONE = ?, ENDERECO = ? " +
                "WHERE MATRICULA = ?";


        PreparedStatement statement = (PreparedStatement) ConnectionSingleton.getInstance()
                .prepareStatement(sql);

        statement.setString(1, nome);
        statement.setString(2, sigla);
        statement.setString(3, telefone);
        statement.setString(4, endereco);
        statement.setString(5, matricula);

        return statement.executeUpdate();
    }

}

