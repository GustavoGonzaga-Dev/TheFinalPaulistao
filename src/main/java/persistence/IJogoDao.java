package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Jogo;

public interface IJogoDao {
	public String insereJogos(Jogo jogo) throws SQLException;
	public boolean validaRodada(Jogo jogo) throws SQLException;
	public List<Jogo> encontrarJogos(String datajg) throws SQLException;
	public String AtualizaJogos(Jogo jogo )throws SQLException;
	public String BuscaResultadoJogos(int codigo) throws SQLException;
	public String ClassGeral() throws SQLException ;
}
