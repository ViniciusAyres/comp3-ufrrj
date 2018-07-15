package controladores;

import dados.datamappers.AssociacaoFiliacaoDataMapper;
import dominio.AssociacaoMT;
import dominio.FiliacaoMT;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "FiliarAssociacao", urlPatterns = "/filiarAssociacao")
public class FiliarAssociacao extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.getSession().setAttribute("proximaPagina", "/filiarAssociacao.jsp");
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro","Ocorreu um erro inesperado");
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
        } catch (RegistroInvalido registroInvalido) {
            registroInvalido.printStackTrace();
            request.getSession().setAttribute("mensagemErro",registroInvalido.getMessage());
            request.getRequestDispatcher("/filiarAssociacao.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
