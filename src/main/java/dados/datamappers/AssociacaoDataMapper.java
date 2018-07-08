package dados.datamappers;

import java.sql.ResultSet;

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
}

