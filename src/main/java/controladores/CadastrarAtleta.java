package controladores;

import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.AtletaInscricaoDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.AtletaMT;
import dominio.InscricaoMT;
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

@WebServlet(name = "CadastrarAtleta", urlPatterns = "/cadastrarAtleta")
public class CadastrarAtleta extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getSession().setAttribute("proximaPagina", "/cadastrarAtleta.jsp");
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro","Ocorreu um erro inesperado");
            response.sendRedirect("/index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            RecordSet recordSet = new RecordSet();
            Row row = new Row();

            //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            row.put("numeroOficio", request.getParameter("numeroOficio"));
            row.put("dataOficio", request.getParameter("dataOficio"));
            row.put("dataAssociacao", request.getParameter("dataAssociacao"));
            row.put("matriculaAssociacao", request.getParameter("matriculaAssociacao"));
            row.put("numeroComprovante", request.getParameter("numeroComprovante"));


            row.put("nome", request.getParameter("nome"));
            row.put("dataNascimento", request.getParameter("dataNascimento"));
            row.put("categoria", request.getParameter("categoria"));
            recordSet.add(row);

            AtletaMT atletaMT = new AtletaMT(recordSet);
            InscricaoMT inscricaoMT = new InscricaoMT(recordSet);

            new AssociacaoDataMapper().buscarPorMatricula(request.getParameter("matriculaAssociacao"));
            AtletaInscricaoDataMapper atletaInscricaoDataMapper = new AtletaInscricaoDataMapper();
            atletaInscricaoDataMapper.criar(recordSet);
            request.getSession().setAttribute("mensagemSucesso","Atleta cadastrado com sucesso");
            response.sendRedirect("/index.jsp");
        } catch (RegistroInvalido registroInvalido) {
            registroInvalido.printStackTrace();
            request.getSession().setAttribute("mensagemErro", "Esse registro não é valido.");
            request.getRequestDispatcher("/cadastrarAtleta.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.getSession().setAttribute("mensagemErro","Esses dados são invlálidos");
            request.getRequestDispatcher("/cadastrarAtleta.jsp").forward(request,response);
        } catch (RegistroNaoEncontradoException e) {
            e.printStackTrace();
            request.getSession().setAttribute("mensagemErro", "Erro ao buscar a matrícula.");
            request.getRequestDispatcher("/cadastrarAtleta.jsp").forward(request,response);
        } catch (ParseException e) {
            e.printStackTrace();
            request.getSession().setAttribute("mensagemErro", "Formato de data inválido");
            request.getRequestDispatcher("/cadastrarAtleta.jsp").forward(request,response);
        }
    }
}


