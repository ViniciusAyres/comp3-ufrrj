package dados.datamappers;

import java.sql.ResultSet;

public class ClasseDataMapper {
    public ResultSet buscarPorId(int id){
        try{
            return  DataMapper.buscarPorId(id, "CLASSE");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }
}
