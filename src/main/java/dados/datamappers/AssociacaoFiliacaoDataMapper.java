package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;
import dominio.AssociacaoMT;
import dominio.Perfil;
import utils.RecordSet;
import utils.Row;
import utils.SQL;

import java.sql.*;

public class AssociacaoFiliacaoDataMapper {

    public static void criar(RecordSet recordSet) throws SQLException {

        AssociacaoDataMapper associacaoDataMapper = new AssociacaoDataMapper();
        FiliacaoDataMapper  filiacaoDataMapper =  new FiliacaoDataMapper();

        associacaoDataMapper.criar(recordSet);
        filiacaoDataMapper.criar(recordSet);
    }
}
