package resteasysample.jaxrs;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

/**
 * @author mattong
 */
@Path("/persons")
public class PersonController {

    private static Logger log = Logger.getLogger(PersonController.class);

    List<Person> persons = Arrays.asList(
            new Person("Kok Ju"),
            new Person("Java Raj"),
            new Person("Beng Seng"),
            new Person("Amy"),
            new Person("Sam"),
            new Person("May Fong"),
            new Person("Wee Hon"),
            new Person("Yah Sing"));

    @GET
    @Path("stats")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStatus() {
        log.info("Getting STATUS");
        String reply = PersonController.class.getCanonicalName() + ":OK\n";
        return Response.status(Response.Status.OK).entity(reply).build();
    }

    @GET
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public Person[] get() {
        return persons.toArray(new Person[0]);
    }

    @GET
    @Path("{id}")
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public Person get(@PathParam("id") int id) {
        if (id < persons.size()) {
            return persons.get(id);
        }
        return null;
    }
}
