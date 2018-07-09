package dados.datamappers;

import java.sql.ResultSet;

public class ColocacaoDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "COLOCACAO");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }
}
