
package game.utils;


import game.api.Gamer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class Parameters {

    public Parameters() {
    }
    
    public static final String PROJECT_NAME = "Guille";
    //public static final int EXPIRATION_MILLIS = 300 /* SECONDS */ *1000;
    public static final List<Gamer> gamers = new ArrayList<>();
    public static Integer assignedId = 0;
    public static final Map<String, Integer> visibleGamers = new HashMap();
    public static Integer turn = 0;
    public static int generateNumber(){
        int a=(int) (Math.random() * 5 + 1);
        return a;
    }
}
