package controladores;


import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.AssociacaoFiliacaoDataMapper;
import dominio.AssociacaoMT;
import dominio.FiliacaoMT;
import utils.RecordSet;
import utils.Row;

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
         RecordSet recordSet = new RecordSet();
         Row row = new Row();

         row.put("numeroOficio", request.getParameter("numeroOficio"));
         row.put("dataOficio", request.getParameter("dataOficio"));
         row.put("numeroComprovante", request.getParameter("numeroComprovante"));

         row.put("nome", request.getParameter("nome"));
         row.put("sigla", request.getParameter("sigla"));
         row.put("telefone", request.getParameter("telefone"));
         row.put("endereco", request.getParameter("endereco"));

         recordSet.add(row);
         try {
             AssociacaoMT associacaoMT = new AssociacaoMT(recordSet);
             FiliacaoMT filiacaoMT = new FiliacaoMT(recordSet);


             AssociacaoFiliacaoDataMapper.criar(recordSet);
             request.getSession().setAttribute("mensagemSucesso","Associação filiada com sucesso!");
             response.sendRedirect("/index.jsp");
     } catch (Exception e) {
        e.printStackTrace();
        request.getSession().setAttribute("mensagemErro", "Ocorreu um erro inesperado");
        response.sendRedirect("/index.jsp");
    }
    }
}


