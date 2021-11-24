
package restaurant.utils;

import java.util.ArrayList;
import restaurant.db.Dish;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public final class Parameters {

    public Parameters() {
    }
    
    public static final String PROJECT_NAME = "Restaurant";
        
    public static final List<Dish> dishes = new ArrayList();
    public static final AtomicInteger idUsers = new AtomicInteger(0);
    
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/twitter_db";
    public static final String DB_USER = "menuqr_user";
    public static final String DB_PASS = Secrets.DB_PASS;
    
}
