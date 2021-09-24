package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Grupo;

public interface IGrupoDao {
	    //o THROWS SQLException pois tudo vai ser sensivel ao SQL entao os metodos sao colocados com essa exception
	    public String gerarGrupos() throws SQLException;
	    public Grupo selectGrupo(Grupo gp) throws SQLException;
	
}