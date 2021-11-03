
package albares.utils;

import albares.basic.api.User;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public final class Parameters {

    public Parameters() {
    }
    
    public static final String PROJECT_NAME = "Jose";
    public static final int EXPIRATION_MILLIS = 300 /* SECONDS */ *1000;
    public static final Map<Integer, User> users = new HashMap();
    public static final AtomicInteger id = new AtomicInteger(0);
    
}
