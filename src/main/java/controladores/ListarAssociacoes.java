package controladores;

import dados.datamappers.AssociacaoDataMapper;
import utils.RecordSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListarAssociacoes", urlPatterns = "/listarAssociacoes")
public class ListarAssociacoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RecordSet recordSet = new AssociacaoDataMapper().buscar();
            request.getSession().setAttribute("dados", recordSet);
            request.getSession().setAttribute("proximaPagina", "/listarAssociacoes.jsp");
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Ocorreu um erro inesperado");
            response.sendRedirect("/index.jsp");

        }
    }
}
