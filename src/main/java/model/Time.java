package model;

public class Time {
	public int CodigoTime;
	public String NomeTime; 
	public String Cidade;
	public String Estadio; 
	
	
	public int getCodigoTime() {
		return CodigoTime;
	}
	public void setCodigoTime(int codigoTime) {
		CodigoTime = codigoTime;
	}
	public String getNomeTime() {
		return NomeTime;
	}
	public void setNomeTime(String nomeTime) {
		NomeTime = nomeTime;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getEstadio() {
		return Estadio;
	}
	public void setEstadio(String estadio) {
		Estadio = estadio;
	}
	
	@Override
	public String toString() {
		return "Time [CodigoTime=" + CodigoTime + 
				", NomeTime=" + NomeTime + 
				", Cidade=" + Cidade + 
				", Estadio=" + Estadio + "]";
	}
 
}

