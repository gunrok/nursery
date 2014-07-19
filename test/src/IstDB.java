import java.io.StringReader;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import nurseryinfo.Channel;

public class IstDB {

	public static void main(String args[]) throws ParserConfigurationException,
			JAXBException {
		String dbURL = "jdbc:mariadb://gunrok.synology.me:3306/qniv";
		String username = "asya393";
		String password = "qnivasya393";

		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pdstmt = null;

		String query = "SELECT st_code,cr_addr,lat,lng FROM `QNIV_REF_NURSERY` where lat is null";
		String query2 = "Update  `QNIV_REF_NURSERY` set  lat=? , lng=? where st_code=?";

		HttpGetContents hgc = new HttpGetContents();

		JAXBContext contextAddr = JAXBContext.newInstance(Channel.class);
		Unmarshaller unAddr = contextAddr.createUnmarshaller();

		// channel노드를 객체화 하기

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// getting database connection to MySQL server
			dbCon = DriverManager.getConnection(dbURL, username, password);

			// getting PreparedStatment to execute query
			stmt = dbCon.prepareStatement(query);

			pdstmt = dbCon.prepareStatement(query2);

			// Resultset returned by query
			rs = stmt.executeQuery(query);
			String key = "";
			String addr = "";
			StringReader sr = null;

			while (rs.next()) {
				key = rs.getString(1);
				addr = rs.getString(2);
				hgc.setURI_F_GPS(URLEncoder.encode(addr, "UTF-8"));
				hgc.requestContents();
				System.out.println("key/addr " + key + "|" + addr
						+ rs.getString(3) + rs.getString(4));

				// sr = new StringReader(hgc.getContents());

				Channel cl = (Channel) unAddr.unmarshal(new StringReader(hgc
						.getContents()));
				System.out.println("test:" + cl.getItem());
				if (cl.getItem() != null) {
					pdstmt.setString(1, cl.getItem().getLat());
					pdstmt.setString(2, cl.getItem().getLng());
					pdstmt.setString(3, key);
					pdstmt.executeUpdate();
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}