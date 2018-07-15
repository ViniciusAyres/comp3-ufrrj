package controladores;


import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.AssociacaoFiliacaoDataMapper;
import utils.RecordSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterarFiliacaoAssociacao", urlPatterns = "/alterarFiliacaoAssociacao")
public class AlterarFiliacaoAssociacao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RecordSet recordSet;
            if (request.getParameter("matricula") == null) {
                recordSet = new AssociacaoDataMapper().buscar();
                //criar orderby do recordSet pelo nome
                request.getSession().setAttribute("dados", recordSet);
                request.getSession().setAttribute("proximaPagina", "/alterarFiliacaoAssociacao.jsp");
                request.getRequestDispatcher("/identificarUsuario").forward(request, response);
            }
            else{
                recordSet = AssociacaoFiliacaoDataMapper.buscarPorMatricula(request.getParameter("matricula"));
                request.getSession().setAttribute("dados", recordSet);
                request.getRequestDispatcher("/alterarFiliacao.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("mensagemErro", "Ocorreu um erro inesperado");
            response.sendRedirect("/index.jsp");
        }
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


