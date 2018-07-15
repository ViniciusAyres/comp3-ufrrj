package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListarCompeticoes", urlPatterns = "/listarCompeticoes")
public class ListarCompeticoes extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Integer> perfisAutorizados = new ArrayList<Integer>();
        //perfisAutorizados.add(Perfil.DIRETOR_TECNICO.getId());

        //Utils.autenticar(request, perfisAutorizados);
        request.getRequestDispatcher("/listarCompeticoes.jsp").forward(request, response);
    }
}
