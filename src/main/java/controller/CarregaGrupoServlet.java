package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupo;
import persistence.GrupoDaoImpl;
import persistence.IGrupoDao;

/**
 * Servlet implementation class CarregaGrupoServlet
 */
@WebServlet("/CarregaGrupoServlet")
public class CarregaGrupoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IGrupoDao igp; 
	private Grupo gpA = new Grupo();
	private Grupo gpB = new Grupo();
	private Grupo gpC = new Grupo();
	private Grupo gpD = new Grupo();
	
	
    public CarregaGrupoServlet() {
    	igp = new GrupoDaoImpl();
       
    }

    public void encherVariaveis() {
		try {
			gpA.setNomeGrupo("A");
			gpB.setNomeGrupo("B");
			gpC.setNomeGrupo("C");
			gpD.setNomeGrupo("D");
			gpA = igp.selectGrupo(gpA);
			gpB = igp.selectGrupo(gpB);
			gpC = igp.selectGrupo(gpC);
			gpD = igp.selectGrupo(gpD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		encherVariaveis();
		ArrayList<String> t1 = new ArrayList<String>();
		System.out.println("ta chamando essa buceta");
		t1.add(gpA.getNomeTime1());
		t1.add(gpA.getNomeTime2());
		t1.add(gpA.getNomeTime3());
		t1.add(gpA.getNomeTime4());
		ArrayList<String> t2 = new ArrayList<String>();
		t2.add(gpB.getNomeTime1());
		t2.add(gpB.getNomeTime2());
		t2.add(gpB.getNomeTime3());
		t2.add(gpB.getNomeTime4());
		ArrayList<String> t3 = new ArrayList<String>();
		t3.add(gpC.getNomeTime1());
		t3.add(gpC.getNomeTime2());
		t3.add(gpC.getNomeTime3());
		t3.add(gpC.getNomeTime4());		
		ArrayList<String> t4 = new ArrayList<String>();
		t4.add(gpD.getNomeTime1());
		t4.add(gpD.getNomeTime2());
		t4.add(gpD.getNomeTime3());
		t4.add(gpD.getNomeTime4());		
		
		request.setAttribute("gpA", t1);
		request.setAttribute("gpB", t2);
		request.setAttribute("gpC", t3);
		request.setAttribute("gpD", t4);		
		RequestDispatcher rd = request.getRequestDispatcher("grupos.jsp");
        rd.forward(request, response);
	}

}
