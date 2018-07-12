package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
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

@WebServlet(name = "ListarAssociacoes", urlPatterns = "/listarAssociacoes")
public class ListarAssociacoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            if(Utils.autenticar(request, Perfil.SECRETARIO.getId())){
                ResultSet resultSet = new AssociacaoDataMapper().buscar();
                AssociacaoMD associacaoMD = new AssociacaoMD(resultSet);

                request.setAttribute("msg", "outra ");
                request.setAttribute("associacaoMD", associacaoMD);
                request.getRequestDispatcher("/listarAssociacoes.jsp").forward(request, response);
            }
        } catch (UsuarioNaoAutenticadoException e) {
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        }

    }

}
