package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.excecoes.RegistroNaoEncontradoException;
import dominio.AssociacaoMT;
import dominio.PessoaMT;
import utils.RecordSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "IdentificarUsuario", urlPatterns = "/identificarUsuario")
public class IdentificarUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/identificarUsuario.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");

        try {
            AssociacaoMT.autenticar(matricula, senha);
            String proximaPagina = (String) request.getSession().getAttribute("proximaPagina");
            RecordSet recordSet = (RecordSet) request.getSession().getAttribute("dados");
            request.getSession().invalidate();
            request.getSession().setAttribute("dados", recordSet);
            response.sendRedirect(proximaPagina);
        } catch (UsuarioNaoAutenticadoException ex) {
            request.getSession().setAttribute("mensagemErro", "Erro ao identificar a Conta. Favor, tente novamente mais tarde");
            request.getRequestDispatcher("/identificarUsuario.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RegistroNaoEncontradoException e) {
            request.getSession().setAttribute("mensagemErro", "Usuário ou senha não existe");
            request.getRequestDispatcher("/identificarUsuario.jsp").forward(request, response);
        }
    }

}
