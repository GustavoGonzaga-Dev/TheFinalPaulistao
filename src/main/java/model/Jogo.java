package model;

import java.util.Date;

public class Jogo {
	
	private Integer CodigoJogo;
	private Integer CodigoTimeA;
    private Integer CodigoTimeB;
    private Integer GolsTimeA;
    private Integer GolsTImeB;
    private Date DataJogo;
    private Integer CodRodada;
    
	public Integer getCodigoJogo() {
		return CodigoJogo;
	}
	public void setCodigoJogo(Integer codigoJogo) {
		CodigoJogo = codigoJogo;
	}
	public Integer getCodigoTimeA() {
		return CodigoTimeA;
	}
	public void setCodigoTimeA(Integer codigoTimeA) {
		CodigoTimeA = codigoTimeA;
	}
	public Integer getCodigoTimeB() {
		return CodigoTimeB;
	}
	public void setCodigoTimeB(Integer codigoTimeB) {
		CodigoTimeB = codigoTimeB;
	}
	public Integer getGolsTimeA() {
		return GolsTimeA;
	}
	public void setGolsTimeA(Integer golsTimeA) {
		GolsTimeA = golsTimeA;
	}
	public Integer getGolsTImeB() {
		return GolsTImeB;
	}
	public void setGolsTImeB(Integer golsTImeB) {
		GolsTImeB = golsTImeB;
	}
	public Date getDataJogo() {
		return DataJogo;
	}
	public void setDataJogo(Date dataJogo) {
		DataJogo = dataJogo;
	}
	public Integer getCodRodada() {
		return CodRodada;
	}
	public void setCodRodada(Integer codRodada) {
		CodRodada = codRodada;
	}
}
