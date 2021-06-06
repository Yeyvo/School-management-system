package ma.SchoolManagement.model;

public class Filiere {

	int CodeEtab, CodeFil;
	String DesFil;

	public Filiere(int codeEtab, int codeFil, String desFil) {
		CodeEtab = codeEtab;
		CodeFil = codeFil;
		DesFil = desFil;
	}

	public int getCodeEtab() {
		return CodeEtab;
	}

	public void setCodeEtab(int codeEtab) {
		CodeEtab = codeEtab;
	}

	public int getCodeFil() {
		return CodeFil;
	}

	public void setCodeFil(int codeFil) {
		CodeFil = codeFil;
	}

	public String getDesFil() {
		return DesFil;
	}

	public void setDesFil(String desFil) {
		DesFil = desFil;
	}

	@Override
	public String toString() {
		return  "CodeEtab : " +  CodeEtab + "  CodeFil :  " + CodeFil + " Designation " + DesFil ;
	}

	public String toStringdao() {
		return  CodeEtab + "," + CodeFil + ",'" + DesFil + "'";

	}
	
	
}
