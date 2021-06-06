package ma.SchoolManagement.model.dao.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import ma.SchoolManagement.model.Filiere;

public class FiliereDAO extends DAO<Filiere> {

	public FiliereDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Set<Filiere> all() {
		Set<Filiere> set_Filiere = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM Filiere");
			while (result.next()) {
				set_Filiere.add(new Filiere(result.getInt(1), result.getInt(2), result.getString(3)));
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

		return set_Filiere;
	}

	@Override
	public boolean create(Filiere obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			System.out.println("INSERT INTO Filiere VALUES(" + obj.toString() + ")");
			int result = stmt.executeUpdate("INSERT INTO Filiere VALUES(" + obj.toString() + ")");
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
	public boolean delete(Filiere obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("DELETE FROM Filiere WHERE CodeEtab = " + obj.getCodeEtab()+ " and CodeFil  = " + obj.getCodeFil()+ "");
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
	public boolean update(Filiere oldobj, Filiere newobj) {
		try {
			delete(oldobj);
			create(newobj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<Filiere> find(String nom) {
		Set<Filiere> setdata = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery(
					"SELECT * FROM Filiere where DesFil = '" + nom + "'");
			while (result.next()) {
				setdata.add(new Filiere(result.getInt(1), result.getInt(2), result.getString(3)));
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

		return setdata;
	}

}
