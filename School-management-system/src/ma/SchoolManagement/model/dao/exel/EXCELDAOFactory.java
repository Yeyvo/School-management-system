package ma.SchoolManagement.model.dao.exel;

public class EXCELDAOFactory {
	


	public static EtudiantEXCELDAO getEtudiantDAO() {
		return new EtudiantEXCELDAO();
	}

	public static EtablissemenEXCELDAO getEtablissementDAO() {
		return new EtablissemenEXCELDAO();
	}

	public static FiliereEXCELDAO getFiliereDAO() {
		return new FiliereEXCELDAO();
	}

	public static InscriptionEXCELDAO getInscriptionDAO() {
		return new InscriptionEXCELDAO();
	}

	public static ServicesEtudEXCELDAO getServicesEtudDAO() {
		return new ServicesEtudEXCELDAO();
	}

}

