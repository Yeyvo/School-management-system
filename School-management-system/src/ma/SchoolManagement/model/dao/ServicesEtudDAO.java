package ma.SchoolManagement.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import ma.SchoolManagement.model.ServicesEtud;

public class ServicesEtudDAO extends DAO<ServicesEtud> {

	public ServicesEtudDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Set<ServicesEtud> all() {
		Set<ServicesEtud> set_ServicesEtud = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM ServicesEtud");
			while (result.next()) {
				set_ServicesEtud.add(
						new ServicesEtud(result.getInt(1), result.getString(2), result.getBoolean(3), result.getBoolean(4), result.getBoolean(5), result.getString(6)));
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return set_ServicesEtud;
	}

	@Override
	public boolean create(ServicesEtud obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("INSERT INTO ServicesEtud VALUES(" + obj.toString() + ")");
			System.out.println(result + " Row affected ! ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean delete(ServicesEtud obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("DELETE FROM ServicesEtud WHERE EtudId  = " + obj.getEtudId()
					+ " and EtudANS = '" + obj.getEtudANSC() + "'");
			System.out.println(result + " Row affected !");
			return (true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (false);
	}

	@Override
	public boolean update(ServicesEtud oldobj, ServicesEtud newobj) {
		try {
			delete(oldobj);
			create(newobj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
