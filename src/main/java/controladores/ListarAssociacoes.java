package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.AssociacaoDataMapper;
import dominio.AssociacaoMT;
import dominio.Perfil;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.ResultSet;

@WebServlet(name = "ListarAssociacoes", urlPatterns = "/listarAssociacoes")
public class ListarAssociacoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.getSession().setAttribute("proximaPagina", "/listarAssociacoes.jsp");
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro","Ocorreu um erro inesperado");
            response.sendRedirect("/index.jsp");
        }

//        try {
//
//            Utils.autenticar(request, perfisAutorizados);
//            System.out.println("dd");
//            ResultSet resultSet = new AssociacaoDataMapper().buscar();
//            AssociacaoMT associacaoMD = new AssociacaoMT(resultSet);
//            request.setAttribute("associacaoMD", associacaoMD);
//            request.getRequestDispatcher("/listarAssociacoes.jsp").forward(request, response);
//        } catch (UsuarioNaoAutenticadoException e) {
//            System.out.println("listar usuario nao autenticado excecao");
//            request.getSession().setAttribute("proximaPagina", "/listarAssociacoes");
//            response.sendRedirect("/identificarUsuario");
////            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
//
//        }

        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    }
