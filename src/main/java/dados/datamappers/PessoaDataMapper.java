package dados.datamappers;

import java.sql.ResultSet;

public class PessoaDataMapper {
    public ResultSet buscarPorMatricula(String matricula){
        try{
            return  DataMapper.buscarPorMatricula(matricula, "PESSOA");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return  null;
    }
}
