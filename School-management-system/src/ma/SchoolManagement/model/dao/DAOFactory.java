package ma.SchoolManagement.model.dao;

import ma.SchoolManagement.model.dao.exel.EXCELDAOFactory;
import ma.SchoolManagement.model.dao.sql.SQLDAOFactory;

public class DAOFactory {
	
	
	
	public static EXCELDAOFactory getEXCELDAOFactory() {
		return new EXCELDAOFactory();
	}

	public static SQLDAOFactory getSQLDAOFactory() {
		return new SQLDAOFactory();
	}


}
