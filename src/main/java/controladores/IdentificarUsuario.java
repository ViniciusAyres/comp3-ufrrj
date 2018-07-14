package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dominio.Perfil;
import dominio.PessoaMT;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "IdentificarUsuario", urlPatterns = "/identificarUsuario")
public class IdentificarUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/identificarUsuario.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");

        try {
            PessoaMT.autenticar(matricula, senha);
            System.out.println();
            response.sendRedirect((String) request.getSession().getAttribute("proximaPagina"));

        } catch (UsuarioNaoAutenticadoException ex) {
            request.setAttribute("mensagemErro", "Erro ao identificar a Conta. Favor, tente novamente mais tarde");
            request.getRequestDispatcher("/identificarUsuario.jsp").forward(request, response);
        }
    }

}
