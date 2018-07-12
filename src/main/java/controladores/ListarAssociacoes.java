package controladores;

import dados.datamappers.AssociacaoDataMapper;
import dominio.AssociacaoMD;
import dominio.Perfil;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "ListarAssociacoes", urlPatterns = "/listarAssociacoes")
public class ListarAssociacoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("listar associacoes get");
        if(Utils.autenticar(request, response, "/listarAssociacoes.jsp", Perfil.SECRETARIO.getId())){
            ResultSet resultSet = new AssociacaoDataMapper().buscar();
            AssociacaoMD associacaoMD = new AssociacaoMD(resultSet);

            ArrayList<String> matriculas = associacaoMD.getMatriculas();
            System.out.println(matriculas.get(0));
            System.out.println(matriculas.get(1));
            request.setAttribute("associacaoMD", associacaoMD);
            request.setAttribute("msg", "uma mensagem");
        };

    }

}
