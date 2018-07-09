package dados.datamappers;

import java.sql.ResultSet;

public class NadoDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "NADO");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }
}
