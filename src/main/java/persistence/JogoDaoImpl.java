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

public class JogoDaoImpl implements IJogoDao {

	private Connection c;

	public Connection JogoDaoImpll() throws ClassNotFoundException, SQLException {
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
		cs.execute();
		cs.close();

		String saida = "Chamou aqui";

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
		String sql = "SELECT j.CodigoJogo, tA.NomeTime AS TIMEA,tB.NomeTime AS TIMEB ,GolsTimeA,GolsTimeB,DataJogo, j.CodRodada FROM jogos j,Times tA, Times tB WHERE tA.CodigoTime = j.CodigoTimeA and tB.CodigoTime = j.CodigoTimeB and datajogo LIKE ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, datajg);
		ResultSet rs = ps.executeQuery();
		List <Jogo> listaJogos= new ArrayList<>();
		while (rs.next()) {
			Jogo jogo = new Jogo();
			jogo.setCodigoJogo(rs.getInt("CodigoJogo"));
			jogo.settA(rs.getString("TIMEA"));
			jogo.settB(rs.getString("TIMEB"));
			jogo.setGolsTimeA(rs.getInt("GolsTimeA"));
			jogo.setGolsTImeB(rs.getInt("GolsTimeB"));
			jogo.setDataJogo(rs.getString("DataJogo"));
			jogo.setCodRodada(rs.getInt("CodRodada"));
			listaJogos.add(jogo);
		}
		rs.close();
		ps.close();
		/*for(int i = 0; i < listaJogos.size();i++) {
			System.out.println(listaJogos.get(i));
		}*/
		return listaJogos;
	}

}
