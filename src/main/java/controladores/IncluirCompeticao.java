package controladores;

import dados.datamappers.EnderecoCompeticaoMapper;
import dominio.CompeticaoMD;
import dominio.Perfil;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "IncluirCompeticao", urlPatterns = "/incluirLocaisCompeticao")

public class IncluirCompeticao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ArrayList<Integer> perfisAutorizados = new ArrayList<Integer>();
            perfisAutorizados.add(Perfil.DIRETOR_TECNICO.getId());

            Utils.autenticar(request, perfisAutorizados);
            request.getRequestDispatcher("/incluirLocaisCompeticao.jsp").forward(request, response);
        }
        catch (Exception ex){
            request.getSession().setAttribute("proximaPagina", "/incluirLocaisCompeticao");
            response.sendRedirect("/identificarUsuario");
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");

            ResultSet resultSet = null;

            EnderecoCompeticaoMapper enderecoCompeticaoMapper = new EnderecoCompeticaoMapper();
            CompeticaoMD competicaoMd = new CompeticaoMD(resultSet);

            request.setAttribute("mensagemSucesso", "Local de competição criado com sucesso");

            request.getRequestDispatcher("/index.jsp").forward(request, response);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
