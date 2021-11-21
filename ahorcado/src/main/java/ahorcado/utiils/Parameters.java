
package ahorcado.utiils;

import ahorcado.api.Player;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Parameters {

    public Parameters() {
    }
    
    public static final String PROJECT_NAME = "Guille";
    //public static final int EXPIRATION_MILLIS = 300 /* SECONDS */ *1000;
    public static final Map<Integer,Player> players = new HashMap();
    public static AtomicInteger assignedId = new AtomicInteger(0);
    public static List<String[]> confWords = new ArrayList();
    public static List<String[]> hidden = new ArrayList();
    public static Integer turn = 1;
    public static int myIndex=(int) Math.floor(Math.random()*11+1);
    public void generateWords(){
        String word1[]={"a","h","o","r","c","a","d","o"};
        confWords.add(word1);
        String word2[]={"s","e","r","v","i","d","o","r"};
        confWords.add(word2);
        String word3[]={"d","e","s","p","l","i","e","g","u","e"};
        confWords.add(word3);
        String word4[]={"i","n","t","e","r","f","a","z"};
        confWords.add(word4);
        String word5[]={"d","e","s","a","r","r","o","l","l","o"};
        confWords.add(word5);
        String word6[]={"a","p","l","i","c","a","c","i","o","n"};
        confWords.add(word6);
        String word7[]={"e","n","t","o","r","n","o"};
        confWords.add(word7);
        String word8[]={"o","r","d","e","n","a","d","o","r"};
        confWords.add(word8);
        String word9[]={"p","l","a","t","a","f","o","r","m","a"};
        confWords.add(word9);
        String word10[]={"v","i","r","t","u","a","l"};
        confWords.add(word10);
    }
    public static String[] myWord = confWords.get(myIndex);
    public void generateHidden(){
        String hide1[]={"_","_","_","_","_","_","_","_"};
        hidden.add(hide1);
        String hide2[]={"_","_","_","_","_","_","_","_"};
        hidden.add(hide2);
        String hide3[]={"_","_","_","_","_","_","_","_","_","_"};
        hidden.add(hide3);
        String hide4[]={"_","_","_","_","_","_","_","_"};
        hidden.add(hide4);
        String hide5[]={"_","_","_","_","_","_","_","_","_","_"};
        hidden.add(hide5);
        String hide6[]={"_","_","_","_","_","_","_","_","_","_"};
        hidden.add(hide6);
        String hide7[]={"_","_","_","_","_","_","_"};
        hidden.add(hide7);
        String hide8[]={"_","_","_","_","_","_","_","_","_"};
        hidden.add(hide8);
        String hide9[]={"_","_","_","_","_","_","_","_","_","_"};
        hidden.add(hide9);
        String hide10[]={"_","_","_","_","_","_","_"};
        hidden.add(hide10);
    }
    public static String [] myHiddenWord = confWords.get(myIndex);

}

