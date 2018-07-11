package controladores;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IdentificarUsuario", urlPatterns = "/identificarUsuario")
public class IdentificarUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("/identificarUsuario.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");

        request.getSession().setAttribute("matricula", matricula);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
