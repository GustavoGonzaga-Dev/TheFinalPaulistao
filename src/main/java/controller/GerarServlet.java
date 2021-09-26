package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupo;
import model.Jogo;
import persistence.GrupoDaoImpl;
import persistence.IGrupoDao;
import persistence.IJogoDao;
import persistence.JogoDaoImpl;

@WebServlet("/Gerar")
public class GerarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGrupoDao igp;   
	private Grupo gpA = new Grupo();
	private Grupo gpB = new Grupo();
	private Grupo gpC = new Grupo();
	private Grupo gpD = new Grupo();
	private int codRodada = 1;
	private int codJogo = 1;

	private IJogoDao ijg;


	public GerarServlet() {
		igp = new GrupoDaoImpl();
		ijg = new JogoDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("button");
		switch (cmd){
		case "Gerar Grupos":
			EnxerTabGrupo();
			System.out.println("Termminei o metodo de gerar grupos");
			RequestDispatcher rdG = request.getRequestDispatcher("grupos.jsp");
			rdG.forward(request, response);
			break;
		case "Gerar Jogos":
			geraJogo();
			System.out.println("Termminei o metodo de gerar jogo");
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



	public void InserirJogosNaTabela(Jogo jogo) {
		try {
			ijg.insereJogos(jogo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void EnxerTabGrupo() {
		try {
			igp.gerarGrupos();
			encherVariaveis();
			System.out.println(gpA.getNomeGrupo() + gpA.getCodigoTime1()+ gpA.getCodigoTime2()+ gpA.getCodigoTime3()+ gpA.getCodigoTime4());
			System.out.println(gpB.getNomeGrupo() + gpB.getCodigoTime1()+ gpB.getCodigoTime2()+ gpB.getCodigoTime3()+ gpB.getCodigoTime4());
			System.out.println(gpC.getNomeGrupo() + gpC.getCodigoTime1()+ gpC.getCodigoTime2()+ gpC.getCodigoTime3()+ gpC.getCodigoTime4());
			System.out.println(gpD.getNomeGrupo() + gpD.getCodigoTime1()+ gpD.getCodigoTime2()+ gpD.getCodigoTime3()+ gpD.getCodigoTime4());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void geraJogo() {
		if(gpA.getCodigoTime1() == null) {
			encherVariaveis();
		}
		/////////////////////////////////////////1
		for(int i = 1; i<9; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 1:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 2:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 3:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 4:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 5:
				jogo.setCodigoTimeA(gpC.getCodigoTime1());
				jogo.setCodigoTimeB(gpD.getCodigoTime1());
				break;
			case 6:
				jogo.setCodigoTimeA(gpC.getCodigoTime2());
				jogo.setCodigoTimeB(gpD.getCodigoTime2());
				break;
			case 7:
				jogo.setCodigoTimeA(gpC.getCodigoTime3());
				jogo.setCodigoTimeB(gpD.getCodigoTime3());
				break;
			case 8:
				jogo.setCodigoTimeA(gpC.getCodigoTime4());
				jogo.setCodigoTimeB(gpD.getCodigoTime4());
				break;
			}
			jogo.setDataJogo("01-09-2021");
			jogo.setCodRodada(1);
			InserirJogosNaTabela(jogo);
		}

		////////////////////////////////////////////////2
		for(int i = 9; i<17; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 9:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 10:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 11:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 12:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 13:
				jogo.setCodigoTimeA(gpC.getCodigoTime1());
				jogo.setCodigoTimeB(gpD.getCodigoTime2());
				break;
			case 14:
				jogo.setCodigoTimeA(gpC.getCodigoTime2());
				jogo.setCodigoTimeB(gpD.getCodigoTime1());
				break;
			case 15:
				jogo.setCodigoTimeA(gpC.getCodigoTime3());
				jogo.setCodigoTimeB(gpD.getCodigoTime4());
				break;
			case 16:
				jogo.setCodigoTimeA(gpC.getCodigoTime4());
				jogo.setCodigoTimeB(gpD.getCodigoTime3());
				break;
			}
			jogo.setDataJogo("05-09-2021");
			jogo.setCodRodada(2);
			InserirJogosNaTabela(jogo);
		}

		////////////////////////////////////////////////3
		for(int i = 17; i<25; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 17:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 18:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 19:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 20:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 21:
				jogo.setCodigoTimeA(gpC.getCodigoTime1());
				jogo.setCodigoTimeB(gpD.getCodigoTime3());
				break;
			case 22:
				jogo.setCodigoTimeA(gpC.getCodigoTime2());
				jogo.setCodigoTimeB(gpD.getCodigoTime4());
				break;
			case 23:
				jogo.setCodigoTimeA(gpC.getCodigoTime3());
				jogo.setCodigoTimeB(gpD.getCodigoTime1());
				break;
			case 24:
				jogo.setCodigoTimeA(gpC.getCodigoTime4());
				jogo.setCodigoTimeB(gpD.getCodigoTime2());
				break;
			}
			jogo.setDataJogo("08-09-2021");
			jogo.setCodRodada(3);
			InserirJogosNaTabela(jogo);
		}

		////////////////////////////////////////////////4
		for(int i = 25; i<33; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 25:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 26:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 27:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 28:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 29:
				jogo.setCodigoTimeA(gpC.getCodigoTime1());
				jogo.setCodigoTimeB(gpD.getCodigoTime4());
				break;
			case 30:
				jogo.setCodigoTimeA(gpC.getCodigoTime2());
				jogo.setCodigoTimeB(gpD.getCodigoTime3());
				break;
			case 31:
				jogo.setCodigoTimeA(gpC.getCodigoTime3());
				jogo.setCodigoTimeB(gpD.getCodigoTime2());
				break;
			case 32:
				jogo.setCodigoTimeA(gpC.getCodigoTime4());
				jogo.setCodigoTimeB(gpD.getCodigoTime1());
				break;
			}
			jogo.setDataJogo("12-09-2021");
			jogo.setCodRodada(4);
			InserirJogosNaTabela(jogo);
		}
		/////////////////////////////////////////5
		for(int i = 33; i<41; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 33:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpD.getCodigoTime1());
				break;
			case 34:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpD.getCodigoTime2());
				break;
			case 35:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpD.getCodigoTime3());
				break;
			case 36:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpD.getCodigoTime4());
				break;
			case 37:
				jogo.setCodigoTimeA(gpC.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 38:
				jogo.setCodigoTimeA(gpC.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 39:
				jogo.setCodigoTimeA(gpC.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 40:
				jogo.setCodigoTimeA(gpC.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			}
			jogo.setDataJogo("15-09-2021");
			jogo.setCodRodada(5);
			InserirJogosNaTabela(jogo);
		}

		////////////////////////////////////////////////6
		for(int i = 41; i<49; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 41:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpD.getCodigoTime2());
				break;
			case 42:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpD.getCodigoTime1());
				break;
			case 43:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpD.getCodigoTime4());
				break;
			case 44:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpD.getCodigoTime3());
				break;
			case 45:
				jogo.setCodigoTimeA(gpC.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 46:
				jogo.setCodigoTimeA(gpC.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 47:
				jogo.setCodigoTimeA(gpC.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 48:
				jogo.setCodigoTimeA(gpC.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			}
			jogo.setDataJogo("19-09-2021");
			jogo.setCodRodada(6);
			InserirJogosNaTabela(jogo);
		}

		////////////////////////////////////////////////7
		for(int i = 49; i<57; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 49:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpD.getCodigoTime3());
				break;
			case 50:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpD.getCodigoTime4());
				break;
			case 51:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpD.getCodigoTime1());
				break;
			case 52:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpD.getCodigoTime2());
				break;
			case 53:
				jogo.setCodigoTimeA(gpC.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 54:
				jogo.setCodigoTimeA(gpC.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 55:
				jogo.setCodigoTimeA(gpC.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 56:
				jogo.setCodigoTimeA(gpC.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			}
			jogo.setDataJogo("22-09-2021");
			jogo.setCodRodada(7);
			InserirJogosNaTabela(jogo);
		}

		////////////////////////////////////////////////8
		for(int i = 57; i<65; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 57:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpD.getCodigoTime4());
				break;
			case 58:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpD.getCodigoTime3());
				break;
			case 59:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpD.getCodigoTime2());
				break;
			case 60:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpD.getCodigoTime1());
				break;
			case 61:
				jogo.setCodigoTimeA(gpC.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 62:
				jogo.setCodigoTimeA(gpC.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 63:
				jogo.setCodigoTimeA(gpC.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 64:
				jogo.setCodigoTimeA(gpC.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			}
			jogo.setDataJogo("26-09-2021");
			jogo.setCodRodada(8);
			InserirJogosNaTabela(jogo);
		}
		/////////////////////////////////////////9
		for(int i = 65; i<73; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 65:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpC.getCodigoTime1());
				break;
			case 66:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpC.getCodigoTime2());
				break;
			case 67:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpC.getCodigoTime3());
				break;
			case 68:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpC.getCodigoTime4());
				break;
			case 69:
				jogo.setCodigoTimeA(gpD.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 70:
				jogo.setCodigoTimeA(gpD.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 71:
				jogo.setCodigoTimeA(gpD.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 72:
				jogo.setCodigoTimeA(gpD.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			}
			jogo.setDataJogo("29-09-2021");
			jogo.setCodRodada(9);
			InserirJogosNaTabela(jogo);
		}

		////////////////////////////////////////////////10
		for(int i = 73; i<81; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 73:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpC.getCodigoTime2());
				break;
			case 74:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpC.getCodigoTime1());
				break;
			case 75:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpC.getCodigoTime4());
				break;
			case 76:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpC.getCodigoTime3());
				break;
			case 77:
				jogo.setCodigoTimeA(gpD.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 78:
				jogo.setCodigoTimeA(gpD.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 79:
				jogo.setCodigoTimeA(gpD.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 80:
				jogo.setCodigoTimeA(gpD.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			}
			jogo.setDataJogo("03-10-2021");
			jogo.setCodRodada(10);
			InserirJogosNaTabela(jogo);
		}

		////////////////////////////////////////////////11
		for(int i = 81; i<89; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 81:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpC.getCodigoTime3());
				break;
			case 82:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpC.getCodigoTime4());
				break;
			case 83:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpC.getCodigoTime1());
				break;
			case 84:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpC.getCodigoTime2());
				break;
			case 85:
				jogo.setCodigoTimeA(gpD.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 86:
				jogo.setCodigoTimeA(gpD.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 87:
				jogo.setCodigoTimeA(gpD.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			case 88:
				jogo.setCodigoTimeA(gpD.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			}
			jogo.setDataJogo("06-10-2021");
			jogo.setCodRodada(11);
			InserirJogosNaTabela(jogo);
		}

		////////////////////////////////////////////////12
		for(int i = 89; i<97; i++) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(i);
			switch(i) {
			case 89:
				jogo.setCodigoTimeA(gpA.getCodigoTime1());
				jogo.setCodigoTimeB(gpC.getCodigoTime4());
				break;
			case 90:
				jogo.setCodigoTimeA(gpA.getCodigoTime2());
				jogo.setCodigoTimeB(gpC.getCodigoTime3());
				break;
			case 91:
				jogo.setCodigoTimeA(gpA.getCodigoTime3());
				jogo.setCodigoTimeB(gpC.getCodigoTime2());
				break;
			case 92:
				jogo.setCodigoTimeA(gpA.getCodigoTime4());
				jogo.setCodigoTimeB(gpC.getCodigoTime1());
				break;
			case 93:
				jogo.setCodigoTimeA(gpD.getCodigoTime1());
				jogo.setCodigoTimeB(gpB.getCodigoTime4());
				break;
			case 94:
				jogo.setCodigoTimeA(gpD.getCodigoTime2());
				jogo.setCodigoTimeB(gpB.getCodigoTime3());
				break;
			case 95:
				jogo.setCodigoTimeA(gpD.getCodigoTime3());
				jogo.setCodigoTimeB(gpB.getCodigoTime2());
				break;
			case 96:
				jogo.setCodigoTimeA(gpD.getCodigoTime4());
				jogo.setCodigoTimeB(gpB.getCodigoTime1());
				break;
			}
			jogo.setDataJogo("10-10-2021");
			jogo.setCodRodada(12);
			InserirJogosNaTabela(jogo);
		}
	}



}
