package ma.SchoolManagement.model;

import java.time.LocalDate;

public class Etudiant {
	int EtudId, EtudCPS;
	String EtudCNE, EtudNom, EtudPre, EtudSfam, EtudNat, EtudSexe, EtudAd1, EtudVil, EtudDpt, EtudTel, EtudMail,
			EtudRib;
	LocalDate EtudNai;
	String CniePere, EtudNomp, EtudPrep;
	LocalDate EtudDNP, EtudDDP;
	String CnieMere, EtudNomm, Etudprem;
	LocalDate EtudDNM, EtudDDM;

	public Etudiant(int etudId, String etudCNE, String etudNom, String etudPrenom, String etudSfam, String etudNat,
			LocalDate etudNai, String etudSexe, String etudAd1, int etudCPS, String etudVil, String etudDpt,
			String etudTel, String etudMail, String etudRib, String cniePere, String etudNomp, String etudPrep,
			LocalDate etudDNP, LocalDate etudDDP, String cnieMere, String etudNomm, String etudprem, LocalDate etudDNM,
			LocalDate etudDDM) {
		EtudId = etudId;
		EtudCPS = etudCPS;
		EtudCNE = etudCNE;
		EtudNom = etudNom;
		EtudPre = etudPrenom;
		EtudSfam = etudSfam;
		EtudNat = etudNat;
		EtudSexe = etudSexe;
		EtudAd1 = etudAd1;
		EtudVil = etudVil;
		EtudDpt = etudDpt;
		EtudTel = etudTel;
		EtudMail = etudMail;
		EtudRib = etudRib;
		EtudNai = etudNai;
		CniePere = cniePere;
		EtudNomp = etudNomp;
		EtudPrep = etudPrep;
		EtudDNP = etudDNP;
		EtudDDP = etudDDP;
		CnieMere = cnieMere;
		EtudNomm = etudNomm;
		Etudprem = etudprem;
		EtudDNM = etudDNM;
		EtudDDM = etudDDM;
	}

	public int getEtudId() {
		return EtudId;
	}

	public void setEtudId(int etudId) {
		EtudId = etudId;
	}

	public int getEtudCPS() {
		return EtudCPS;
	}

	public void setEtudCPS(int etudCPS) {
		EtudCPS = etudCPS;
	}

	public String getEtudCNE() {
		return EtudCNE;
	}

	public void setEtudCNE(String etudCNE) {
		EtudCNE = etudCNE;
	}

	public String getEtudNom() {
		return EtudNom;
	}

	public void setEtudNom(String etudNom) {
		EtudNom = etudNom;
	}

	public String getEtudPrenom() {
		return EtudPre;
	}

	public void setEtudPrenom(String etudPrenom) {
		EtudPre = etudPrenom;
	}

	public String getEtudSfam() {
		return EtudSfam;
	}

	public void setEtudSfam(String etudSfam) {
		EtudSfam = etudSfam;
	}

	public String getEtudNat() {
		return EtudNat;
	}

	public void setEtudNat(String etudNat) {
		EtudNat = etudNat;
	}

	public String getEtudSexe() {
		return EtudSexe;
	}

	public void setEtudSexe(String etudSexe) {
		EtudSexe = etudSexe;
	}

	public String getEtudAd1() {
		return EtudAd1;
	}

	public void setEtudAd1(String etudAd1) {
		EtudAd1 = etudAd1;
	}

	public String getEtudVil() {
		return EtudVil;
	}

	public void setEtudVil(String etudVil) {
		EtudVil = etudVil;
	}

	public String getEtudDpt() {
		return EtudDpt;
	}

	public void setEtudDpt(String etudDpt) {
		EtudDpt = etudDpt;
	}

	public String getEtudTel() {
		return EtudTel;
	}

	public void setEtudTel(String etudTel) {
		EtudTel = etudTel;
	}

	public String getEtudMail() {
		return EtudMail;
	}

	public void setEtudMail(String etudMail) {
		EtudMail = etudMail;
	}

	public String getEtudRib() {
		return EtudRib;
	}

	public void setEtudRib(String etudRib) {
		EtudRib = etudRib;
	}

	public LocalDate getEtudNai() {
		return EtudNai;
	}

	public void setEtudNai(LocalDate etudNai) {
		EtudNai = etudNai;
	}

	public String getCniePere() {
		return CniePere;
	}

	public void setCniePere(String cniePere) {
		CniePere = cniePere;
	}

	public String getEtudNomp() {
		return EtudNomp;
	}

	public void setEtudNomp(String etudNomp) {
		EtudNomp = etudNomp;
	}

	public String getEtudPrep() {
		return EtudPrep;
	}

	public void setEtudPrep(String etudPrep) {
		EtudPrep = etudPrep;
	}

	public LocalDate getEtudDNP() {
		return EtudDNP;
	}

	public void setEtudDNP(LocalDate etudDNP) {
		EtudDNP = etudDNP;
	}

	public LocalDate getEtudDDP() {
		return EtudDDP;
	}

	public void setEtudDDP(LocalDate etudDDP) {
		EtudDDP = etudDDP;
	}

	public String getCnieMere() {
		return CnieMere;
	}

	public void setCnieMere(String cnieMere) {
		CnieMere = cnieMere;
	}

	public String getEtudNomm() {
		return EtudNomm;
	}

	public void setEtudNomm(String etudNomm) {
		EtudNomm = etudNomm;
	}

	public String getEtudprem() {
		return Etudprem;
	}

	public void setEtudprem(String etudprem) {
		Etudprem = etudprem;
	}

	public LocalDate getEtudDNM() {
		return EtudDNM;
	}

	public void setEtudDNM(LocalDate etudDNM) {
		EtudDNM = etudDNM;
	}

	public LocalDate getEtudDDM() {
		return EtudDDM;
	}

	public void setEtudDDM(LocalDate etudDDM) {
		EtudDDM = etudDDM;
	}

	@Override
	public String toString() {
		return "Id : " + nullcheck(EtudId) + " Nom : " + nullcheck(EtudNom) + " Prenom : " + nullcheck(EtudPre);
	}

	
	public String toStringdao() {
		return nullcheck(EtudId) + "," + nullcheck(EtudCNE) + "," + nullcheck(EtudNom) + "," + nullcheck(EtudPre) + ","
				+ nullcheck(EtudSfam) + "," + nullcheck(EtudNat) + "," + nullcheck(EtudNai) + "," + nullcheck(EtudSexe)
				+ "," + nullcheck(EtudAd1) + "," + nullcheck(EtudCPS) + "," + nullcheck(EtudVil) + ","
				+ nullcheck(EtudDpt) + "," + nullcheck(EtudTel) + "," + nullcheck(EtudMail) + "," + nullcheck(EtudRib)
				+ "," + nullcheck(CniePere) + "," + nullcheck(EtudNomp) + "," + nullcheck(EtudPrep) + ","
				+ nullcheck(EtudDNP) + "," + nullcheck(EtudDDP) + "," + nullcheck(CnieMere) + "," + nullcheck(EtudNomm)
				+ "," + nullcheck(Etudprem) + "," + nullcheck(EtudDNM) + "," + nullcheck(EtudDDM);
	}

	public String toStringimport() {
		return nullcheck(EtudId) + "," + nullcheck(EtudCNE) + "," + nullcheck(EtudNom) + "," + nullcheck(EtudPre) + ","
				+ nullcheck(EtudSfam) + "," + nullcheck(EtudNat) + "," + nullcheck(EtudNai) + "," + nullcheck(EtudSexe)
				+ "," + nullcheck(EtudAd1) + "," + nullcheck(EtudCPS) + "," + nullcheck(EtudVil) + ","
				+ nullcheck(EtudDpt) + "," + nullcheck(EtudTel) + "," + nullcheck(EtudMail) + "," + nullcheck(EtudRib)
				+ "," + nullcheck(CniePere) + "," + nullcheck(EtudNomp) + "," + nullcheck(EtudPrep) + ","
				+ nullcheck(EtudDNP) + "," + nullcheck(EtudDDP) + "," + nullcheck(CnieMere) + "," + nullcheck(EtudNomm)
				+ "," + nullcheck(Etudprem) + "," + nullcheck(EtudDNM) + "," + nullcheck(EtudDDM);
	}

	public Object nullcheck(Object obj) {
		return obj == null ? "null" : (obj instanceof Integer ? obj : "'" + obj + "'");
	}

}
