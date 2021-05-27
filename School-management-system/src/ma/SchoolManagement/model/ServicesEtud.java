package ma.SchoolManagement.model;

public class ServicesEtud {

	int EtudId;
	boolean EtudBO, EtudCU, EtudCMB;
	String EtudCMBO, EtudANSC;

	public ServicesEtud(int etudId, String etudANSC, boolean etudBO, boolean etudCU, boolean etudCMB, String etudCMBO) {
		EtudId = etudId;
		EtudBO = etudBO;
		EtudCU = etudCU;
		EtudCMB = etudCMB;
		EtudCMBO = etudCMBO;
		EtudANSC = etudANSC;
	}

	public int getEtudId() {
		return EtudId;
	}

	public void setEtudId(int etudId) {
		EtudId = etudId;
	}

	public boolean isEtudBO() {
		return EtudBO;
	}

	public void setEtudBO(boolean etudBO) {
		EtudBO = etudBO;
	}

	public boolean isEtudCU() {
		return EtudCU;
	}

	public void setEtudCU(boolean etudCU) {
		EtudCU = etudCU;
	}

	public boolean isEtudCMB() {
		return EtudCMB;
	}

	public void setEtudCMB(boolean etudCMB) {
		EtudCMB = etudCMB;
	}

	public String getEtudCMBO() {
		return EtudCMBO;
	}

	public void setEtudCMBO(String etudCMBO) {
		EtudCMBO = etudCMBO;
	}

	public String getEtudANSC() {
		return EtudANSC;
	}

	public void setEtudANSC(String etudANSC) {
		EtudANSC = etudANSC;
	}

	@Override
	public String toString() {
		return EtudId  + ",'" + EtudANSC + "'," + EtudBO + "," + EtudCU + "," + EtudCMB + ",'" + EtudCMBO + "'";
	}
	
	

}
