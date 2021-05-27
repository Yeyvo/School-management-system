package ma.SchoolManagement.model;

public class Inscription {

	int EtudId, EtudEtab, EtudFil;
	String EtudInsc;

	public Inscription(int etudId, int etudEtab, int etudFil, String etudInsc) {
		EtudId = etudId;
		EtudEtab = etudEtab;
		EtudFil = etudFil;
		EtudInsc = etudInsc;
	}

	public int getEtudId() {
		return EtudId;
	}

	public void setEtudId(int etudId) {
		EtudId = etudId;
	}

	public int getEtudEtab() {
		return EtudEtab;
	}

	public void setEtudEtab(int etudEtab) {
		EtudEtab = etudEtab;
	}

	public int getEtudFil() {
		return EtudFil;
	}

	public void setEtudFil(int etudFil) {
		EtudFil = etudFil;
	}

	public String getEtudInsc() {
		return EtudInsc;
	}

	public void setEtudInsc(String etudInsc) {
		EtudInsc = etudInsc;
	}

	@Override
	public String toString() {
		return  EtudId + "," + EtudEtab + "," + EtudFil + ",'" + EtudInsc + "'";
	}

	
	
}
