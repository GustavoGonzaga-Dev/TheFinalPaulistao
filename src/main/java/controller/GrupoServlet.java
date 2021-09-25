package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		/*try {
			igp.selectGrupo();
		}catch(SQLException e){
			
		}*/
		
		
		System.out.println("Japa otario");
		
	}

}
