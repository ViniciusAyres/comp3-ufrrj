package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.LocalCompeticaoDataMapper;
import dominio.LocalCompeticaoMT;
import dominio.Perfil;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ListarLocaisCompeticao", urlPatterns = {"/listarLocaisCompeticao"})
public class ListarLocaisCompeticao extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      try {

          RecordSet recordSet = new RecordSet();

          LocalCompeticaoMT localCompeticaoMD = new LocalCompeticaoMT(recordSet);
       //   ArrayList<String> lst = localCompeticaoMD.getLocais();

          request.setAttribute("localCompeticaoMD", localCompeticaoMD);
          request.getRequestDispatcher("/listarLocaisCompeticao.jsp").forward(request, response);

      //  } catch (UsuarioNaoAutenticadoException e) {
            request.getSession().setAttribute("proximaPagina", "/listarLocaisCompeticao");
            response.sendRedirect("/identificarUsuario");

      //  } catch (SQLException e) {
        //    e.printStackTrace();

         } catch (RegistroInvalido registroInvalido) {
          registroInvalido.printStackTrace();
      }
    }
}
