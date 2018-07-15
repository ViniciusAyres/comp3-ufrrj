package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.AtletaDataMapper;
import dados.datamappers.AtletaInscricaoDataMapper;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.AssociacaoMT;
import dominio.AtletaMT;
import dominio.Perfil;
import utils.RecordSet;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AlterarCadastroAtleta", urlPatterns = "/alterarCadastroAtleta")
public class AlterarCadastroAtleta extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if(request.getParameter("matriculaAtleta") != null ) {
                System.out.println("MATRICULA DO ATLETA GET" + request.getParameter("matriculaAtleta"));
                request.getRequestDispatcher("/alterarAtleta.jsp").forward(request, response);
            }else {
                //lista todas as associacoes
                RecordSet recordSet = new AssociacaoDataMapper().buscar();
                request.getSession().setAttribute("dados", recordSet);
                request.getSession().setAttribute("proximaPagina", "/alterarCadastroAtleta.jsp");
                request.getRequestDispatcher("/identificarUsuario").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro","Ocorreu um erro inesperado");
            response.sendRedirect("/index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MATRICULA DO ATLETA" + request.getParameter("matriculaAtleta"));
//        String matriculaAtleta = (String) request.getSession().getAttribute("matriculaAtleta");
//        System.out.println("sss matricula atleta: " + matriculaAtleta);
//
//        String numeroOficio = request.getParameter("numeroOficio");
//        Date dataOficio = Date.valueOf(request.getParameter("dataOficio"));
//
//        String nome = request.getParameter("nome");
//        Date dataNascimento = Date.valueOf(request.getParameter("dataNascimento"));
//        Date dataAssociacao = Date.valueOf(request.getParameter("dataAssociacao"));
//        String matriculaAssociacao = request.getParameter("matriculaAssociacao");
//        String numeroComprovante = request.getParameter("numeroComprovante");
//        String categoria = request.getParameter("categoria");
//        try {
//            AssociacaoDataMapper associacaoDataMapper = new AssociacaoDataMapper();
//            AssociacaoMT associacaoMD = new AssociacaoMT(associacaoDataMapper.buscar());
//            associacaoMD.existe(matriculaAssociacao);
//            System.out.println("aqui");
//            AtletaInscricaoDataMapper atletaInscricaoDataMapper = new AtletaInscricaoDataMapper();
//            atletaInscricaoDataMapper.atualizar(matriculaAtleta, nome, dataNascimento, categoria,
//                    matriculaAssociacao, dataAssociacao, numeroComprovante, numeroOficio, dataOficio);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            request.getRequestDispatcher("/alterarCadastroAtleta");
//        } catch (RegistroNaoEncontradoException e) {
//            e.printStackTrace();
//            request.getRequestDispatcher("/alterarCadastroAtleta");
//        }
        response.sendRedirect("/index.jsp");
    }

}
