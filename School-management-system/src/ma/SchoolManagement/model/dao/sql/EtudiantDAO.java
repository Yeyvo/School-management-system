package ma.SchoolManagement.model.dao.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import ma.SchoolManagement.model.Etudiant;

public class EtudiantDAO extends DAO<Etudiant> {

	public EtudiantDAO(Connection conn) {
		super(conn);
	}

	@Override
	public Set<Etudiant> all() {
		Set<Etudiant> set_Etudiant = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM Etudiant");
			while (result.next()) {
				set_Etudiant.add(new Etudiant(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getDate(7).toLocalDate(),
						result.getString(8), result.getString(9), result.getInt(10), result.getString(11),
						result.getString(12), result.getString(13), result.getString(14), result.getString(15),
						result.getString(16), result.getString(17), result.getString(18),
						result.getDate(19).toLocalDate(), result.getDate(20).toLocalDate(), result.getString(21),
						result.getString(22), result.getString(23), result.getDate(24).toLocalDate(),
						result.getDate(25).toLocalDate()));
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

		return set_Etudiant;
	}

//	@Override
//	public boolean create(Etudiant obj) {
//		Statement stmt = null;
//		try {
//			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//			int result = stmt.executeUpdate("INSERT INTO Etudiant VALUES(" + obj.toString() + ")");
//			System.out.println(result + " Row affected ! ");
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
//	}
	
	/*public boolean createimport(Etudiant obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			System.out.println("INSERT INTO Etudiant (EtudCNE ,EtudNom ,EtudPrenom ,EtudSfam ,EtudNat ,EtudNai ,EtudSexe ,EtudAd1 ,EtudCPS ,EtudVil ,EtudDpt ,EtudTel ,EtudMail ,EtudRib ,CniePere ,EtudNomp ,EtudPrep ,EtudDNP ,EtudDDP ,CnieMere ,EtudNomm ,Etudprem ,EtudDNM ,EtudDDM ) VALUES("
					+ obj.toStringimport() + ")");
			int result = stmt.executeUpdate(
					"INSERT INTO Etudiant (EtudId ,EtudCNE ,EtudNom ,EtudPrenom ,EtudSfam ,EtudNat ,EtudNai ,EtudSexe ,EtudAd1 ,EtudCPS ,EtudVil ,EtudDpt ,EtudTel ,EtudMail ,EtudRib ,CniePere ,EtudNomp ,EtudPrep ,EtudDNP ,EtudDDP ,CnieMere ,EtudNomm ,Etudprem ,EtudDNM ,EtudDDM ) VALUES("
							+ obj.toStringimport() + ")");
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
	}*/
	
	@Override
	public boolean create(Etudiant obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			System.out.println("INSERT INTO Etudiant (EtudCNE ,EtudNom ,EtudPrenom ,EtudSfam ,EtudNat ,EtudNai ,EtudSexe ,EtudAd1 ,EtudCPS ,EtudVil ,EtudDpt ,EtudTel ,EtudMail ,EtudRib ,CniePere ,EtudNomp ,EtudPrep ,EtudDNP ,EtudDDP ,CnieMere ,EtudNomm ,Etudprem ,EtudDNM ,EtudDDM ) VALUES("
							+ obj.toString() + ")");
			int result = stmt.executeUpdate(
					"INSERT INTO Etudiant (EtudCNE ,EtudNom ,EtudPrenom ,EtudSfam ,EtudNat ,EtudNai ,EtudSexe ,EtudAd1 ,EtudCPS ,EtudVil ,EtudDpt ,EtudTel ,EtudMail ,EtudRib ,CniePere ,EtudNomp ,EtudPrep ,EtudDNP ,EtudDDP ,CnieMere ,EtudNomm ,Etudprem ,EtudDNM ,EtudDDM ) VALUES("
							+ obj.toString() + ")");
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
	public boolean delete(Etudiant obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("DELETE FROM Etudiant WHERE EtudId  = " + obj.getEtudId());
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
	public boolean update(Etudiant oldobj, Etudiant newobj) {
		try {
			delete(oldobj);
			create(newobj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Set<Etudiant> find(String nom) {
		Set<Etudiant> set_Etudiant = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery(
					"SELECT * FROM Etudiant where EtudNom = '" + nom + "' or  EtudPrenom = '" + nom + "'");
			while (result.next()) {
				set_Etudiant.add(new Etudiant(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getDate(7).toLocalDate(),
						result.getString(8), result.getString(9), result.getInt(10), result.getString(11),
						result.getString(12), result.getString(13), result.getString(14), result.getString(15),
						result.getString(16), result.getString(17), result.getString(18),
						result.getDate(19).toLocalDate(), result.getDate(20).toLocalDate(), result.getString(21),
						result.getString(22), result.getString(23), result.getDate(24).toLocalDate(),
						result.getDate(25).toLocalDate()));
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

		return set_Etudiant;
	}

}
