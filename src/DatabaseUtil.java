import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseUtil {

	private static Connection createConnection() {
        try {
            InitialContext ctx = new InitialContext();
            
            // Here we lookup the datasource with the name
            // "java:comp/env/jdbc/jcgDS"
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myds");
            return ds.getConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
    }
	
	public static List<String> getUserNames() {
		 
        Connection conn = createConnection();
        List<String> articleNames = new ArrayList<String>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from ODADM.ACL_ADUSER");
            while (rs.next()) {
                String articleName = rs.getString("USERNAME");
                if (articleName != null) {
                    articleNames.add(articleName);
                }
            }
            conn.close();
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return articleNames;
    }
}
