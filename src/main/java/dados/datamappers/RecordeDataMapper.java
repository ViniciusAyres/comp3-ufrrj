package dados.datamappers;

import java.sql.ResultSet;

public class RecordeDataMapper extends DataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "RECORDE");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }
}
