package dominio;
import Utils.MensagemResposta;
import dados.datamappers.AssociacaoDataMapper;
import dados.datamappers.AtletaEquipeDataMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AtletaDominio", urlPatterns = "/atleta")
public class AtletaDominio extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            inserirAtleta(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void inserirAtleta(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException, ServletException, IOException {

        String numeroOficio = request.getParameter("numeroOficio");
        Date dataOficio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataOficio"));
        String nome = request.getParameter("nome");
        Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataNascimento"));
        Date dataAssociacao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataAssociacao"));
        String matriculaAssociacao = request.getParameter("matriculaAssociacao");
        String numeroComprovante = request.getParameter("numeroComprovante");


        AssociacaoDataMapper associacaoDM = new AssociacaoDataMapper();
        ResultSet resultSet = associacaoDM.buscarPorMatricula(matriculaAssociacao);
        if (resultSet.next() == false){
            request.setAttribute("erro", "Matricula da associação não existe.");
            request.getRequestDispatcher("/cadastrarAtleta.jsp").forward(request, response);
        }else{
            
        }


    }
}
