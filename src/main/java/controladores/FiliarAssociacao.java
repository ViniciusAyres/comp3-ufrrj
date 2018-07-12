package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dominio.Perfil;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FiliarAssociacao", urlPatterns = "/filiarAssociacao")
public class FiliarAssociacao extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Utils.autenticar(request, Perfil.SECRETARIO.getId());
            request.getRequestDispatcher("/filiarAssociacao.jsp").forward(request, response);
        } catch (UsuarioNaoAutenticadoException e) {
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
