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
import java.util.ArrayList;

@WebServlet(name = "ListarPontuacaoCompeticao", urlPatterns = {"/listarPontuacaoCompeticao"})
public class ListarPontuacaoCompeticao extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Integer> perfisAutorizados = new ArrayList<Integer>();
            perfisAutorizados.add(Perfil.SECRETARIO.getId());
            perfisAutorizados.add(Perfil.DIRETOR_TECNICO.getId());
            perfisAutorizados.add(Perfil.TECNICO_ASSOSSIACAO.getId());

            Utils.autenticar(request, perfisAutorizados);
            request.getRequestDispatcher("/listarPontuacaoCompeticao.jsp").forward(request, response);
        } catch (UsuarioNaoAutenticadoException e) {
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        }
    }
}
