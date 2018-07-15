package dados.datamappers;

import utils.RecordSet;

import java.sql.*;
import java.text.ParseException;

public class AssociacaoFiliacaoDataMapper {

    public static void criar(RecordSet recordSet) throws SQLException, ParseException {

        AssociacaoDataMapper associacaoDataMapper = new AssociacaoDataMapper();
        FiliacaoDataMapper  filiacaoDataMapper =  new FiliacaoDataMapper();

        associacaoDataMapper.criar(recordSet);
        filiacaoDataMapper.criar(recordSet);
    }
}
