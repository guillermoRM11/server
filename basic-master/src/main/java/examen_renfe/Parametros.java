
package examen_renfe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class Parametros {
    
    public Parametros() {
    }
    
    public static final String PROJECT_NAME = "Guille";
    //public static final int EXPIRATION_MILLIS = 300 /* SECONDS */ *1000;
    public static final Map<Integer, Train> horarios = new HashMap();
    public static final AtomicInteger id = new AtomicInteger(0);
    public static final Map<Integer, Train> horarioFiltrado = new HashMap();
    public static final AtomicInteger idf = new AtomicInteger(0);
    
}
