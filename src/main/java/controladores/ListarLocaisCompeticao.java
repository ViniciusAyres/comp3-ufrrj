package controladores;

import controladores.exceptions.UsuarioNaoAutenticadoException;
import dados.datamappers.DataMapper;
import dados.datamappers.LocalCompeticaoDataMapper;
import dados.datamappers.LocalDataMapper;
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
            LocalCompeticaoMT localCompeticaoMT = new LocalCompeticaoMT(recordSet);
            LocalDataMapper localDataMapper = new LocalDataMapper();

            RecordSet recordSetAux = localDataMapper.buscarTodos();

            request.getSession().setAttribute("dados", recordSetAux);
            request.getSession().setAttribute("proximaPagina", "/listarLocaisCompeticao.jsp");
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        }
        catch (Exception  ex) {
            request.getSession().setAttribute("proximaPagina", "/listarLocaisCompeticao");
            response.sendRedirect("/identificarUsuario");
      }
    }
}
