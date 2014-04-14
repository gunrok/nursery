import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IstDB {

	public static void main(String args[]) {
		String dbURL = "jdbc:mariadb://localhost:3306/test";
		String username = "root";
		String password = "root";

		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rs = null;

		String query = "select count(*) from test";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// getting database connection to MySQL server
			dbCon = DriverManager.getConnection(dbURL, username, password);

			// getting PreparedStatment to execute query
			stmt = dbCon.prepareStatement(query);

			// Resultset returned by query
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int count = rs.getInt(1);
				System.out.println("count of stock : " + count);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}