package dados.datamappers;

import java.sql.ResultSet;

public class TipoCompeticaoMapper {

    public ResultSet buscarPorId(int id){

        try{

            return  DataMapper.buscarPorId(id, "TIPO_COMPETICAO");

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }

}


