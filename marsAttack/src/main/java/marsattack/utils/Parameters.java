
package marsAttack.utils;
import marsattack.utils.Secrets;


public final class Parameters {

    public Parameters() {
    }
    
    public static final String PROJECT_NAME = "GuillermoCancer";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/marcianos_db";
    public static final String DB_USER = "marcianos_user";
    public static final String DB_PASS = Secrets.DB_PASS;
}
