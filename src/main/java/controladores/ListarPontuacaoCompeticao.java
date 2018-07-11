package controladores;

import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListarPontuacaoCompeticao", urlPatterns = {"/listarPontuacaoCompeticao"})
public class ListarPontuacaoCompeticao extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utils.autenticar(request, response, "listarPontuacaoCompeticao.jsp");
    }
}
