package ma.SchoolManagement.model;

public class Etablissement {
	int CodeEtab;
	String DesEtab, EtudDPM;

	public Etablissement(int codeEtab, String desEtab, String etudDPM) {
		CodeEtab = codeEtab;
		DesEtab = desEtab;
		EtudDPM = etudDPM;
	}

	public int getCodeEtab() {
		return CodeEtab;
	}

	public void setCodeEtab(int codeEtab) {
		CodeEtab = codeEtab;
	}

	public String getDesEtab() {
		return DesEtab;
	}

	public void setDesEtab(String desEtab) {
		DesEtab = desEtab;
	}

	public String getEtudDPM() {
		return EtudDPM;
	}

	public void setEtudDPM(String etudDPM) {
		EtudDPM = etudDPM;
	}

	@Override
	public String toString() {
		return  " CodeEtab : " + CodeEtab + " Designation : " + DesEtab + " DPM " + EtudDPM ;
	}
	
	public String toStringdao() {
		return  CodeEtab + ",'" + DesEtab + "','" + EtudDPM + "'";
	}
	
	

}
