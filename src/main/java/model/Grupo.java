package model;

public class Grupo {

	private String nomeGrupo;
    private Integer CodigoTime1;
    private Integer CodigoTime2;
    private Integer CodigoTime3;
    private Integer CodigoTime4;

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public Integer getCodigoTime1() {
        return CodigoTime1;
    }

    public void setCodigoTime1(Integer codigoTime1) {
        CodigoTime1 = codigoTime1;
    }

    public Integer getCodigoTime2() {
        return CodigoTime2;
    }

    public void setCodigoTime2(Integer codigoTime2) {
        CodigoTime2 = codigoTime2;
    }

    public Integer getCodigoTime3() {
        return CodigoTime3;
    }

    public void setCodigoTime3(Integer codigoTime3) {
        CodigoTime3 = codigoTime3;
    }

    public Integer getCodigoTime4() {
        return CodigoTime4;
    }

    public void setCodigoTime4(Integer codigoTime4) {
        CodigoTime4 = codigoTime4;
    }

    @Override
    public String toString() {
        return "Grupos{" +
                "nomeGrupo='" + nomeGrupo + '\'' +
                ", CodigoTime1=" + CodigoTime1 +
                ", CodigoTime2=" + CodigoTime2 +
                ", CodigoTime3=" + CodigoTime3 +
                ", CodigoTime4=" + CodigoTime4 +
                '}';
    }
	
}

