import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {
	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);
		ServletContextHandler handler = new ServletContextHandler(server, "");
		handler.addServlet(HelloHandler.class, "/");
		//Create a WebApp
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar("./jettyWar.war");
        server.setHandler(webapp);
		
        InitialContext ctx = new InitialContext();
        DataSource myDS = (DataSource)ctx.lookup("java:comp/env/jdbc/testDS"); 
        
        
		server.start();
	}
}
