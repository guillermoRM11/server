
package restaurante.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import restaurante.menu.Dish;


public final class Parameters {
    public static final Map<Integer, Dish> menu = new HashMap();
    public static final AtomicInteger id = new AtomicInteger(0);
    public static final String PROJECT_NAME = "Guille";
}
