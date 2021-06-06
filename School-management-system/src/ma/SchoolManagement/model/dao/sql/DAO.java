package ma.SchoolManagement.model.dao.sql;

import java.sql.Connection;
import java.util.Set;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn) {
		this.connect = conn;
	}

	public abstract boolean create(T obj);

	public abstract boolean delete(T obj);

	public boolean update(T oldobj, T newobj) {
		return false;
	}


	public abstract Set<T> all();
	
	
	public abstract Set<T> find (String str);

}
