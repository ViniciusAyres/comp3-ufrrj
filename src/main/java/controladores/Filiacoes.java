package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.FiliacaoDataMapper;
import dominio.AssociacaoMD;
import dominio.FiliacaoMT;
import dominio.Perfil;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "Filiacoes", urlPatterns = "/filiacoes")
public class Filiacoes {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            //String matriculaAssociacao = request.getRequestURL().toString().split("=")[1];
            System.out.println(request.getContextPath());
            //request.setAttribute("matriculaAssociacao", matriculaAssociacao);
            ArrayList<Integer> perfisAutorizados = new ArrayList<Integer>();
            perfisAutorizados.add(Perfil.SECRETARIO.getId());
            //ResultSet resultSet = new FiliacaoDataMapper().buscarPorMatricula(matriculaAssociacao);
            //FiliacaoMT filiacaoMT = new FiliacaoMT(resultSet);
            //request.setAttribute("filiacaoMT", filiacaoMT);
            Utils.autenticar(request, perfisAutorizados);
            request.getRequestDispatcher("/filiacoes.jsp").forward(request, response);
        } catch (UsuarioNaoAutenticadoException e) {
            ArrayList<Integer> perfisAutorizados = new ArrayList<Integer>();
            perfisAutorizados.add(Perfil.SECRETARIO.getId());

            request.getSession().setAttribute("proximaPagina", "/filiacoes");
            request.setAttribute("perfisAutorizados", perfisAutorizados);
            response.sendRedirect("/identificarUsuario");
            //request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        }
    }
}
