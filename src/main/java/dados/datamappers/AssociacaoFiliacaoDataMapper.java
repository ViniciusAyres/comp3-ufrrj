package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.AssociacaoMT;
import dominio.Perfil;
import utils.RecordSet;
import utils.Row;
import utils.SQL;

import java.sql.*;
import java.text.ParseException;

public class AssociacaoFiliacaoDataMapper {

    public static void criar(RecordSet recordSet) throws SQLException, ParseException {

        AssociacaoDataMapper associacaoDataMapper = new AssociacaoDataMapper();
        FiliacaoDataMapper  filiacaoDataMapper =  new FiliacaoDataMapper();

        associacaoDataMapper.criar(recordSet);
        filiacaoDataMapper.criar(recordSet);
    }

    public static void atualizar(RecordSet recordSet) throws SQLException, ParseException {

        AssociacaoDataMapper associacaoDataMapper = new AssociacaoDataMapper();
        FiliacaoDataMapper  filiacaoDataMapper =  new FiliacaoDataMapper();

//        associacaoDataMapper.atualizar(recordSet);
//        filiacaoDataMapper.atualizar(recordSet);
    }


    public static RecordSet buscarPorMatricula(String matricula) throws SQLException,RegistroNaoEncontradoException {

        String sql = "SELECT * FROM ASSOCIACAO ass join FILIACAO on FILIACAO.MATRICULA_ASSOCIACAO = ass.MATRICULA" +
                " where  ass.MATRICULA = ? ";

        PreparedStatement statement = SQL.getPreparedStatement(sql);

        statement.setString(1, matricula);

        ResultSet rs = statement.executeQuery();

        if(!rs.next())
            throw new RegistroNaoEncontradoException("Matrícula não encontrada","ASSOCIACAO");

        Row row = new Row();
        RecordSet dataset = new RecordSet();
        rs.beforeFirst();
        while (rs.next()) {

            row.put("sigla", rs.getString("sigla"));
            row.put("nome", rs.getString("nome"));
            row.put("matricula", rs.getString("matricula"));
            row.put("telefone", rs.getString("telefone"));
            row.put("endereco", rs.getString("endereco"));
            row.put("numero_pagamento", rs.getString("numero_pagamento"));
            row.put("data_oficio", rs.getString("data_oficio"));
            row.put("matricula_associacao", rs.getString("matricula_associacao"));
            row.put("numero_oficio", rs.getString("numero_oficio"));
            dataset.add(row);
        }

        return dataset;
    }
}
