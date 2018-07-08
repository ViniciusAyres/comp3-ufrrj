package dados.datamappers;

import java.sql.ResultSet;

public class TipoProvaDataMapper {

    public ResultSet buscarPorId(int id){

        try{

            return  DataMapper.buscarPorId(id, "TIPO_PROVA");

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }
}
