package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupo;
import persistence.GrupoDaoImpl;
import persistence.IGrupoDao;

@WebServlet("/Grupo")
public class GrupoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IGrupoDao igp ;
	
    public GrupoServlet() throws SQLException {
        igp = new GrupoDaoImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Grupo gruA =  new Grupo();
		Grupo gruB = new Grupo();
		Grupo gruC =  new Grupo();
		Grupo gruD = new Grupo();
		try {
			gruA = buscaGrupos("A");			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			request.setAttribute("TimesA", gruA.getNomeTime1());
			RequestDispatcher rd = request.getRequestDispatcher("grupos.jsp");
			rd.forward(request, response);
		}
		
		
		System.out.println("Japa otario");
		
	}

	private Grupo buscaGrupos(String g) throws SQLException {
		Grupo gru = new Grupo();
		gru.setNomeGrupo("A");
		gru = igp.selectGrupo(gru);
		return gru;
	}
	
}
