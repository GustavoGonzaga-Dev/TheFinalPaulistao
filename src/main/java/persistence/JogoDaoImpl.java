package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

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
	public List<Jogo> encontrarJogos(String datajg) throws SQLException {
		try {
			c = JogoDaoImpll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("passou nessa parte");
		String sql = "SELECT tA.NomeTime AS TIMEA,tB.NomeTime AS TIMEB ,GolsTimeA,GolsTimeB,DataJogo FROM jogos j,Times tA, Times tB WHERE tA.CodigoTime = j.CodigoTimeA and tB.CodigoTime = j.CodigoTimeB and datajogo LIKE ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, datajg);
		ResultSet rs = ps.executeQuery();
		List <Jogo> listaJogos= new ArrayList<>();
		int i = 0;
		while (rs.next()) {
			Jogo jogo = new Jogo();
			//Time tA = new Time();
			//Time tB = new Time();
			jogo.settA(rs.getString("TIMEA"));
			//jogo.settA(tA);
			jogo.settB(rs.getString("TIMEB"));
			//jogo.settB(tB);
			jogo.setGolsTimeA(rs.getInt("GolsTimeA"));
			jogo.setGolsTImeB(rs.getInt("GolsTimeB"));
			jogo.setDataJogo(rs.getString("DataJogo"));
			//System.out.println("putaqueopariu " + jogo.gettA()+ jogo.getGolsTimeA());
			listaJogos.add(jogo);
			i++;
		}
		rs.close();
		ps.close();
		i--;
		System.out.println("acabou de carregar essa merda: " + listaJogos.get(1));
		return listaJogos;
	}

}
