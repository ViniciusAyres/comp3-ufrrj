package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.AtletaInscricaoDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.AssociacaoMT;
import dominio.AtletaMT;
import dominio.InscricaoMT;
import dominio.Perfil;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

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
        RecordSet recordSet = new RecordSet();
        Row row = new Row();

        row.put("numeroOficio", request.getParameter("numeroOficio"));
        row.put("dataOficio", Date.valueOf(request.getParameter("dataOficio")));
        row.put("dataAssociacao", Date.valueOf(request.getParameter("dataAssociacao")));
        row.put("matriculaAssociacao", request.getParameter("matriculaAssociacao"));
        row.put("numeroComprovante", request.getParameter("numeroComprovante"));


        row.put("nome", request.getParameter("nome"));
        row.put("dataNascimento", Date.valueOf(request.getParameter("dataNascimento")));
        row.put("categoria", request.getParameter("categoria"));
        recordSet.add(row);

        try {
            AtletaMT atletaMT = new AtletaMT(recordSet);
            InscricaoMT inscricaoMT = new InscricaoMT(recordSet);

            new AssociacaoDataMapper().buscarPorMatricula(request.getParameter("matriculaAssociacao"));
            AtletaInscricaoDataMapper atletaInscricaoDataMapper = new AtletaInscricaoDataMapper();
            atletaInscricaoDataMapper.criar(recordSet);
        } catch (RegistroInvalido registroInvalido) {
            registroInvalido.printStackTrace();
            request.getSession().setAttribute("mensagemErro", registroInvalido.getMessage());
            request.getRequestDispatcher("/cadastrarAtleta.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.getSession().setAttribute("mensagemErro",e.getMessage());
            request.getRequestDispatcher("/cadastrarAtleta.jsp").forward(request,response);
        } catch (RegistroNaoEncontradoException e) {
            e.printStackTrace();
            request.getSession().setAttribute("mensagemErro", e.getMessage());
            request.getRequestDispatcher("/cadastrarAtleta.jsp").forward(request,response);
        }

    }
}


