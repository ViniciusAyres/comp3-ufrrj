package dados.datamappers;

import java.sql.ResultSet;


public class IndiceDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "INDICE");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }
}
