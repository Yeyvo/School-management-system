package ma.SchoolManagement.model.dao;

import java.sql.Connection;

public class DAOFactory {
	protected static final Connection conn = BddConnection.getInstance();


	public static EtudiantDAO getEtudiantDAO() {
		return new EtudiantDAO(conn);
	}

	public static EtablissementDAO getEtablissementDAO() {
		return new EtablissementDAO(conn);
	}

	public static FiliereDAO getFiliereDAO() {
		return new FiliereDAO(conn);
	}

	public static InscriptionDAO getInscriptionDAO() {
		return new InscriptionDAO(conn);
	}

	public static ServicesEtudDAO getServicesEtudDAO() {
		return new ServicesEtudDAO(conn);
	}

}
