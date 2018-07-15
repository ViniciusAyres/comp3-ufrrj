package controladores;

import dados.datamappers.EnderecoCompeticaoMapper;
import dados.datamappers.LocalCompeticaoDataMapper;
import dados.datamappers.LocalDataMapper;
import dominio.CompeticaoMD;
import dominio.LocalCompeticaoMT;
import dominio.Perfil;
import dominio.excecoes.RegistroInvalido;
import utils.RecordSet;
import utils.Row;
import utils.Utils;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "IncluirLocalCompeticao", urlPatterns = "/incluirLocaisCompeticao")
public class IncluirLocalCompeticao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.getSession().setAttribute("proximaPagina", "/incluirLocaisCompeticao.jsp");
            request.getRequestDispatcher("/identificarUsuario").forward(request, response);
        }
        catch (Exception ex){
            request.getSession().setAttribute("proximaPagina", "/incluirLocaisCompeticao");
            response.sendRedirect("/identificarUsuario");
        }

    }

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Row row = new Row();
        RecordSet recordSet = new RecordSet();

        row.put("nome",  request.getParameter("nome"));
        row.put("endereco",  request.getParameter("endereco"));

        row.put("tamanhoPiscina", Utils.getTamanhoPiscinaId(
                request.getParameter("custon25"), request.getParameter("custon50")));

        try {
            recordSet.add(row);

            LocalCompeticaoMT localCompeticaoMT = new LocalCompeticaoMT(recordSet);
            LocalDataMapper localDataMapper =  new LocalDataMapper();

            localDataMapper.criar(recordSet);

            request.getSession().setAttribute("mensagemSucesso","Local de competição criado com sucesso!");
            response.sendRedirect("/index.jsp");

        }
        catch (RegistroInvalido exReg)
        {
            exReg.printStackTrace();
            request.getSession().setAttribute("mensagemErro" ,exReg.getMessage());
            request.getRequestDispatcher("/incluirLocaisCompeticao.jsp").forward(request,response);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
