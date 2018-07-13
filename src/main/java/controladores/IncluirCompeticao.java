package controladores;

import dados.datamappers.CompeticaoDataMapper;
import dados.datamappers.EnderecoCompeticaoMapper;
import dados.datamappers.EnderecoDataMapper;
import dados.datamappers.LocalDataMapper;
import dominio.CompeticaoMD;
import dominio.Perfil;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            String logradouro = request.getParameter("logradouro");
            int    numeroLograduro = Integer.parseInt(request.getParameter("numeroLogradouro"));
            String complemento = request.getParameter("complemento");
            String cidade = request.getParameter("cidade");
            String cep = request.getParameter("cep");
            String uf = request.getParameter("uf");
            String bairro = request.getParameter("bairro");


            if(logradouro.isEmpty())
                request.setAttribute("menssagemErro", "Preencha o campo logradouro");

            if(nome.isEmpty())
                request.setAttribute("mensagemErro", "Preencha o campo nome");


            EnderecoCompeticaoMapper enderecoCompeticaoMapper = new EnderecoCompeticaoMapper();
            boolean result = enderecoCompeticaoMapper.criar(nome, logradouro, numeroLograduro,
                    complemento, cep, bairro, cidade, uf);

            if (!result) {
                request.setAttribute("mensagemSucesso", "Local de competição criado com sucesso");
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
