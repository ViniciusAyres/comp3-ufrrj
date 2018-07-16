package dados.datamappers;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import utils.RecordSet;
import utils.Row;
import utils.SQL;
import utils.Utils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class AtletaInscricaoDataMapper {
    public static void criar(RecordSet recordSet) throws SQLException, ParseException {

        AtletaDataMapper at = new AtletaDataMapper();
        InscricaoDataMapper is = new InscricaoDataMapper();

        at.criar(recordSet);
        is.criar(recordSet);
    }

    public static void atualizar(RecordSet recordSet) throws SQLException, ParseException {
        AtletaDataMapper.atualizar(recordSet);
        InscricaoDataMapper.atualizar(recordSet);
    }

    public static RecordSet buscarPorMatricula(String matricula) throws SQLException,RegistroNaoEncontradoException {

        String sql = "SELECT * FROM ATLETA atleta join INSCRICAO on INSCRICAO.MATRICULA_ATLETA = atleta.MATRICULA" +
                " WHERE atleta.MATRICULA = ?";

        PreparedStatement statement = SQL.getPreparedStatement(sql);
        statement.setString(1, matricula);
        ResultSet resultSet = statement.executeQuery();
        RecordSet recordSet = new RecordSet();

        while(resultSet.next()){
            Row row = new Row();
            row.put("matricula", resultSet.getString("MATRICULA"));
            row.put("nome", resultSet.getString("NOME"));
            row.put("data_entrada", resultSet.getString("DATA_ENTRADA"));
            row.put("numero_oficio", resultSet.getString("NUMERO_OFICIO"));
            row.put("data_oficio", resultSet.getString("DATA_OFICIO"));

            recordSet.add(row);
        }

        return recordSet;
    }
}
