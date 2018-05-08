package main;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.ext.ContextResolver;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class RestMain {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://0.0.0.0:9991/selServices/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {    	


        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
        final ContextResolver<MoxyJsonConfig> jsonConfigResolver = moxyJsonConfig.resolver();
        // create a resource config that scans for JAX-RS resources and providers
        // in tutorial.example package
        final ResourceConfig rc = new ResourceConfig().packages("restService")
        		.register(MoxyJsonFeature.class)
                .register(jsonConfigResolver);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdownNow();
    }
}
