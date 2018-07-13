package controladores;

import dominio.Perfil;
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

        if(Utils.isValido(matricula, senha)){
            request.getSession().setAttribute("matricula", matricula);
            request.setAttribute("mensagemSucesso", "Conta autenticada com sucesso.");
            response.sendRedirect((String) request.getSession().getAttribute("proximaPagina"));
        }else{
            request.setAttribute("mensagemErro", "Erro ao identificar a Conta. Favor, tente novamente mais tarde");
            request.getRequestDispatcher("/identificarUsuario.jsp").forward(request, response);
        }

    }

}
