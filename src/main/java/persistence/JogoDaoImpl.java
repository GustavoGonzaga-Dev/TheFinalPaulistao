package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import model.Jogo;
import model.Time;
public class JogoDaoImpl implements IJogoDao {

	private Connection c;

	public Connection JogoDaoImpll () throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
		return c;
	}
	
	@Override
	public String insereJogos(Jogo jogo) throws SQLException {
		try {
			c = JogoDaoImpll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "{CALL sp_geraJogo(?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setInt(1, jogo.getCodigoJogo());
		cs.setInt(2, jogo.getCodigoTimeA());
		cs.setInt(3, jogo.getCodigoTimeB());
		cs.setInt(4, jogo.getCodRodada());
		cs.setString(5, jogo.getDataJogo());
		//cs.registerOutParameter(2, Types.VARCHAR);
		cs.execute();
		cs.close();

		String saida = "Chamou aqui";
		//System.out.println(saida);
		return saida;

	}

	@Override
	public boolean validaRodada(Jogo jogo) throws SQLException {
		try {
			c = JogoDaoImpll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "{CALL sp_confereJogo(?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setInt(1, jogo.getCodigoTimeA());
		cs.setInt(2, jogo.getCodigoTimeB());
		cs.registerOutParameter(3, Types.INTEGER);
		cs.execute();
		int saida = cs.getInt(3);
		cs.close();
		if(saida!= 0){
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Jogo> encontrarJogos(String jg) throws SQLException {
		try {
			c = JogoDaoImpll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList <Jogo> listaJogos= new ArrayList<>();
		String sql = "SELECT tA.NomeTime AS TIMEA,tB.NomeTime AS TIMEB ,GolsTimeA,GolsTImeB,DataJogo FROM jogos j,Times tA, Times tB WHERE tA.CodigoTime = j.CodigoTimeA and tB.CodigoTime = j.CodigoTimeB and datajogo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,jg.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Jogo jogo = new Jogo();
			Time tA = new Time();
			Time tB = new Time();
			tA.setNomeTime(rs.getString("TIMEA"));
			jogo.settA(tA);
			tB.setNomeTime(rs.getString("TIMEB"));
			jogo.settB(tB);
			jogo.setGolsTimeA(rs.getInt("GolsTimeA"));
			jogo.setGolsTImeB(rs.getInt("GolsTimeB"));
			jogo.setDataJogo(rs.getString("DataJogo"));
			
			listaJogos.add(jogo);
		}
		rs.close();
		ps.close();
		return listaJogos;
	}

}
