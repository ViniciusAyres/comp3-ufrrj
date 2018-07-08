package dados.datamappers;

import java.sql.ResultSet;

public class TamanhoPiscinaDataMapper {

    public ResultSet buscarPorId(int id){

        try{
            return  DataMapper.buscarPorId(id, "TAMANHO_PISCINA");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }
}
