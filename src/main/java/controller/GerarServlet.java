package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.GrupoDaoImpl;
import persistence.IGrupoDao;

@WebServlet("/Gerar")
public class GerarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IGrupoDao igp;   
	
    public GerarServlet() {
        igp = new GrupoDaoImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("button");
		//System.out.println("Japa otario" + cmd);
		switch (cmd){
		case "Gerar Grupos":
			System.out.println("Japa otario");
			try {
				igp.gerarGrupos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rdG = request.getRequestDispatcher("grupos.jsp");
			rdG.forward(request, response);
		break;
		case "Gerar Jogos":
			System.out.println("Japa babaca");
			RequestDispatcher rdJ = request.getRequestDispatcher("jogos.jsp");
			rdJ.forward(request, response);
		break;
		case "Gerar Rodadas":
			System.out.println("Japa viado");
			RequestDispatcher rd = request.getRequestDispatcher("rodadas.jsp");
			rd.forward(request, response);
		break;
		
		}
	}

}
