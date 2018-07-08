package dados.datamappers;

import dados.bancos.derbyDB.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PerfilDataMapper   {


    public ResultSet buscarPorId(int id){

        try{

            return  DataMapper.buscarPorId(id, "PERFIL");

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }



}
