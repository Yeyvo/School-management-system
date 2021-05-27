package ma.SchoolManagement.dao;

import java.sql.Connection;

public class DAOFactory {
	protected static final Connection conn = BddConnection.getInstance();


	public static EtudiantDAO getEtudiantDAO() {
		return new EtudiantDAO(conn);
	}

}
