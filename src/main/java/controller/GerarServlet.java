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
		Jogo jogo = new Jogo();
		Random random = new Random();
		int rGrupo;
		int rTime;
		
		
		for(int i = 0; i<8; i++) {
			jogo.setCodigoJogo(codJogo);
			jogo.setCodigoTimeA(null);
			jogo.setCodigoTimeB(null);
			jogo.setDataJogo(null);
			for(int ct = 1; ct<3; ct++) {
				rGrupo = random.nextInt(4)+1;
				switch (rGrupo) {
				case 1:
					rTime = random.nextInt(4)+1;
					if(ct == 1) {
						if(rTime  == 1 && gpA.getCodigoTime1() != null) {
							jogo.setCodigoTimeA(gpA.getCodigoTime1());
							gpA.setCodigoTime1(null);
						}else if(rTime  == 2 && gpA.getCodigoTime2() != null) {
							jogo.setCodigoTimeA(gpA.getCodigoTime2());
							gpA.setCodigoTime2(null);
						}else if(rTime  == 3 && gpA.getCodigoTime3() != null) {
							jogo.setCodigoTimeA(gpA.getCodigoTime3());
							gpA.setCodigoTime3(null);
						}else if(rTime  == 4 && gpA.getCodigoTime4() != null) {
							jogo.setCodigoTimeA(gpA.getCodigoTime4());
							gpA.setCodigoTime4(null);
						}else {
							ct--;
						}
					}else if(ct == 2) {
						if(rTime  == 1 && gpA.getCodigoTime1() != null) {
							jogo.setCodigoTimeB(gpA.getCodigoTime1());
							gpA.setCodigoTime1(null);
						}else if(rTime  == 2 && gpA.getCodigoTime2() != null) {
							jogo.setCodigoTimeB(gpA.getCodigoTime2());
							gpA.setCodigoTime2(null);
						}else if(rTime  == 3 && gpA.getCodigoTime3() != null) {
							jogo.setCodigoTimeB(gpA.getCodigoTime3());
							gpA.setCodigoTime3(null);
						}else if(rTime  == 4 && gpA.getCodigoTime4() != null) {
							jogo.setCodigoTimeB(gpA.getCodigoTime4());
							gpA.setCodigoTime4(null);
						}else {
							ct--;
						}
					}
					break;
				case 2:
					rTime = random.nextInt(4)+1;
					if(ct == 1) {
						if(rTime  == 1 && gpB.getCodigoTime1() != null) {
							jogo.setCodigoTimeA(gpB.getCodigoTime1());
							gpB.setCodigoTime1(null);
						}else if(rTime  == 2 && gpB.getCodigoTime2() != null) {
							jogo.setCodigoTimeA(gpB.getCodigoTime2());
							gpB.setCodigoTime2(null);
						}else if(rTime  == 3 && gpB.getCodigoTime3() != null) {
							jogo.setCodigoTimeA(gpB.getCodigoTime3());
							gpB.setCodigoTime3(null);
						}else if(rTime  == 4 && gpB.getCodigoTime4() != null) {
							jogo.setCodigoTimeA(gpB.getCodigoTime4());
							gpB.setCodigoTime4(null);
						}else {
							ct--;
						}
					}else if(ct == 2) {
						if(rTime  == 1 && gpB.getCodigoTime1() != null) {
							jogo.setCodigoTimeB(gpB.getCodigoTime1());
							gpB.setCodigoTime1(null);
						}else if(rTime  == 2 && gpB.getCodigoTime2() != null) {
							jogo.setCodigoTimeB(gpB.getCodigoTime2());
							gpB.setCodigoTime2(null);
						}else if(rTime  == 3 && gpB.getCodigoTime3() != null) {
							jogo.setCodigoTimeB(gpB.getCodigoTime3());
							gpB.setCodigoTime3(null);
						}else if(rTime  == 4 && gpB.getCodigoTime4() != null) {
							jogo.setCodigoTimeB(gpB.getCodigoTime4());
							gpB.setCodigoTime4(null);
						}else {
							ct--;
						}
					}
					break;
				case 3:
					rTime = random.nextInt(4)+1;
					if(ct == 1) {
						if(rTime  == 1 && gpC.getCodigoTime1() != null) {
							jogo.setCodigoTimeA(gpC.getCodigoTime1());
							gpC.setCodigoTime1(null);
						}else if(rTime  == 2 && gpC.getCodigoTime2() != null) {
							jogo.setCodigoTimeA(gpC.getCodigoTime2());
							gpC.setCodigoTime2(null);
						}else if(rTime  == 3 && gpC.getCodigoTime3() != null) {
							jogo.setCodigoTimeA(gpC.getCodigoTime3());
							gpC.setCodigoTime3(null);
						}else if(rTime  == 4 && gpC.getCodigoTime4() != null) {
							jogo.setCodigoTimeA(gpC.getCodigoTime4());
							gpC.setCodigoTime4(null);
						}else {
							ct--;
						}
					}else if(ct == 2) {
						if(rTime  == 1 && gpC.getCodigoTime1() != null) {
							jogo.setCodigoTimeB(gpC.getCodigoTime1());
							gpC.setCodigoTime1(null);
						}else if(rTime  == 2 && gpC.getCodigoTime2() != null) {
							jogo.setCodigoTimeB(gpC.getCodigoTime2());
							gpC.setCodigoTime2(null);
						}else if(rTime  == 3 && gpC.getCodigoTime3() != null) {
							jogo.setCodigoTimeB(gpC.getCodigoTime3());
							gpC.setCodigoTime3(null);
						}else if(rTime  == 4 && gpC.getCodigoTime4() != null) {
							jogo.setCodigoTimeB(gpC.getCodigoTime4());
							gpC.setCodigoTime4(null);
						}else {
							ct--;
						}
					}
					break;
				case 4:
					rTime = random.nextInt(4)+1;
					if(ct == 1) {
						if(rTime  == 1 && gpD.getCodigoTime1() != null) {
							jogo.setCodigoTimeA(gpD.getCodigoTime1());
							gpD.setCodigoTime1(null);
						}else if(rTime  == 2 && gpD.getCodigoTime2() != null) {
							jogo.setCodigoTimeA(gpD.getCodigoTime2());
							gpD.setCodigoTime2(null);
						}else if(rTime  == 3 && gpD.getCodigoTime3() != null) {
							jogo.setCodigoTimeA(gpD.getCodigoTime3());
							gpD.setCodigoTime3(null);
						}else if(rTime  == 4 && gpD.getCodigoTime4() != null) {
							jogo.setCodigoTimeA(gpD.getCodigoTime4());
							gpD.setCodigoTime4(null);
						}else {
							ct--;
						}
					}else if(ct == 2) {
						if(rTime  == 1 && gpD.getCodigoTime1() != null) {
							jogo.setCodigoTimeB(gpD.getCodigoTime1());
							gpD.setCodigoTime1(null);
						}else if(rTime  == 2 && gpD.getCodigoTime2() != null) {
							jogo.setCodigoTimeB(gpD.getCodigoTime2());
							gpD.setCodigoTime2(null);
						}else if(rTime  == 3 && gpD.getCodigoTime3() != null) {
							jogo.setCodigoTimeB(gpD.getCodigoTime3());
							gpD.setCodigoTime3(null);
						}else if(rTime  == 4 && gpD.getCodigoTime4() != null) {
							jogo.setCodigoTimeB(gpD.getCodigoTime4());
							gpD.setCodigoTime4(null);
						}else {
							ct--;
						}
					}
					break;
				}//end switch
			}//end for
			jogo.setCodRodada(codRodada);

			switch(jogo.getCodRodada()) {
			case 1:
				jogo.setDataJogo("01-09-2021");
			break;
			case 2:
				jogo.setDataJogo("05-09-2021");
			break;
			case 3:
				jogo.setDataJogo("08-09-2021");
			break;
			case 4:
				jogo.setDataJogo("12-09-2021");
			break;
			case 5:
				jogo.setDataJogo("15-09-2021");
			break;
			case 6:
				jogo.setDataJogo("19-09-2021");
			break;
			case 7:
				jogo.setDataJogo("22-09-2021");
			break;
			case 8:
				jogo.setDataJogo("26-09-2021");
			break;
			case 9:
				jogo.setDataJogo("29-09-2021");
			break;
			case 10:
				jogo.setDataJogo("03-10-2021");
			break;
			case 11:
				jogo.setDataJogo("06-10-2021");
			break;
			case 12:
				jogo.setDataJogo("10-10-2021");
			break;
			}	
			boolean validar = true;
			if(jogo.getCodRodada() != 1) {
				
				//validar = [chamar a procedure]
				try {
					validar = ijg.validaRodada(jogo);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(validar == true) {
				InserirJogosNaTabela(jogo);
				codJogo++;
			}else{
				i--;
			}
		}//end for
		codRodada++;
	}

}
