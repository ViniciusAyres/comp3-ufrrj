package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.AtletaInscricaoDataMapper;
import dados.datamappers.ClasseDataMapper;
import dados.datamappers.excecoes.ClasseNaoEncontradaException;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.AssociacaoMD;
import dominio.ClasseMT;
import dominio.Perfil;
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

@WebServlet(name = "CadastrarAtleta", urlPatterns = "/cadastrarAtleta")
public class CadastrarAtleta extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Integer> perfisAutorizados = new ArrayList<Integer>();
            perfisAutorizados.add(Perfil.SECRETARIO.getId());
            perfisAutorizados.add(Perfil.DIRETOR_TECNICO.getId());

            Utils.autenticar(request, perfisAutorizados);
            request.getRequestDispatcher("/cadastrarAtleta.jsp").forward(request, response);
        } catch (UsuarioNaoAutenticadoException e) {

            request.getSession().setAttribute("proximaPagina", "/cadastrarAtleta");
            response.sendRedirect("/identificarUsuario");
            //request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numeroOficio = request.getParameter("numeroOficio");
        Date dataOficio = Date.valueOf(request.getParameter("dataOficio"));

        String nome = request.getParameter("nome");
        Date dataNascimento = Date.valueOf(request.getParameter("dataNascimento"));
        Date dataAssociacao = Date.valueOf(request.getParameter("dataAssociacao"));
        String matriculaAssociacao = request.getParameter("matriculaAssociacao");
        String numeroComprovante = request.getParameter("numeroComprovante");
        String categoria = request.getParameter("categoria");
        try {
            AssociacaoDataMapper associacaoDataMapper = new AssociacaoDataMapper();
            AssociacaoMD associacaoMD = new AssociacaoMD(associacaoDataMapper.buscar());
            associacaoMD.existe(matriculaAssociacao);

            AtletaInscricaoDataMapper atletaInscricaoDataMapper = new AtletaInscricaoDataMapper();
            atletaInscricaoDataMapper.criar(nome, dataNascimento, categoria,
                                               matriculaAssociacao, dataAssociacao, numeroComprovante, numeroOficio, dataOficio);

        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/cadastrarAtleta");
        } catch (RegistroNaoEncontradoException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/cadastrarAtleta");
        }
        response.sendRedirect("/index.jsp");

    }
}


