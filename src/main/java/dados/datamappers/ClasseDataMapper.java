package dados.datamappers;

import java.sql.ResultSet;

public class ClasseDataMapper {
    public ResultSet buscar(){
        try{
            return DataMapper.buscar("CLASSE");
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

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
