package jetty;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import resteasysample.jaxrs.PathInfo;
import resteasysample.jaxrs.ResteasySampleApplication;

/**
 *
 * @author mattong
 */
public class JettyServer {

    public static void main(String[] args) throws Exception {


        Server server = new Server();

        HttpConfiguration httpConfig = new HttpConfiguration();
        httpConfig.setOutputBufferSize(1024 * 32);

        ServerConnector connector = new ServerConnector(server,
                new HttpConnectionFactory(httpConfig));
        connector.setHost("0.0.0.0");
        connector.setPort(8080);        
        
        server.addConnector(connector);

        WebAppContext context = new WebAppContext();
        context.setResourceBase("src/main/webapp");
        context.setContextPath(PathInfo.ApplicationPath);
        context.setParentLoaderPriority(true);
        context.addEventListener(new ResteasyBootstrap());
        context.setInitParameter("javax.ws.rs.Application", ResteasySampleApplication.class.getCanonicalName());
        context.setInitParameter("resteasy.servlet.mapping.prefix", PathInfo.RestPath);
        // MUST add the /* to the end of that path.
        context.addServlet(HttpServletDispatcher.class, PathInfo.RestPath + "/*");
        context.setServer(server);

        server.setHandler(context);
        server.start();
        server.join();
    }

}
