package dominio;

import dados.datamappers.excecoes.RegistroNaoEncontradoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompeticaoMD {
    private ResultSet resultSet;

    public CompeticaoMD(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ArrayList<String> getCompeticoes(){
        ArrayList<String> competicoes = new ArrayList<String>();

        try {
            resultSet.beforeFirst();
            while (resultSet.next()){
                String competicao = resultSet.getString("NOME");
                competicoes.add(competicao);
            }

            return competicoes;

        } catch (SQLException e) {
            return null;
        }
    }

    public String getNome(String idstr) throws SQLException, RegistroNaoEncontradoException {

        resultSet.beforeFirst();
        int id = Integer.parseInt(idstr);

        while (resultSet.next()){
            if(resultSet.getInt("ID") == id){
                return resultSet.getString("NOME");
            }
        }
        throw new RegistroNaoEncontradoException("Competição não encontrada", "Competicao");
    }

}
