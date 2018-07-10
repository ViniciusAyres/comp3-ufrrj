package dominio;

import Utils.MensagemResposta;
import dados.datamappers.PessoaDataMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "UsuarioDominio", urlPatterns = "/usuario")
public class UsuarioDominio extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        MensagemResposta msg = validarLogin(matricula, senha);
        if(msg.getId() == 0) {// sucesso
            PessoaDataMapper pessoaDM = new PessoaDataMapper();
            ResultSet resultSet = pessoaDM.buscarPorMatricula(matricula);
            try {
                if (resultSet.next() == false){
                    request.setAttribute("erro", "Usuário ou senha incorreto.");
                    request.getRequestDispatcher("/identificarUsuario.jsp").forward(request, response);
                }
                else{
                    //request.setAttribute("sucesso", msg.getResposta());
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else {
            request.setAttribute("erro", msg.getResposta());
            request.getRequestDispatcher("/identificarUsuario.jsp").forward(request, response);
        }


    }

    private MensagemResposta validarLogin(String matricula, String senha){
        MensagemResposta msg;

        if(matricula.isEmpty() || senha.isEmpty()){
            return msg = new MensagemResposta(1, "Informe a matricula e a senha");

        }else{
            return msg = new MensagemResposta(0, "");
        }
    }

}
