
package resteasysample.jaxrs;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;


/**
 *
 * @author mattong
 */
@ApplicationPath(PathInfo.ApplicationPath)
public class ResteasySampleApplication  extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> clazzes = new HashSet<>();        
        clazzes.add(PersonController.class);
        return clazzes;
    }

}

