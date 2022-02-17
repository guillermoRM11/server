
package marsattack.db;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import marsattack.utils.Db;

public class Score {
    private Integer id;
    private String name;
    private Integer time;
    
    public Score() {
    }    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return name;
    }

    public void setNickname(String nickname) {
        this.name = nickname;
    }

    public Integer getScore() {
        return time;
    }

    public void setScore(Integer score) {
        this.time = score;
    }

    @Override
    public String toString() {
        return "Score{" + "nickname=" + name + ", score=" + time + '}';
    }
    
    
    public void insertScores_DB(Db myDb) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement ps = myDb.prepareStatement(
                "INSERT INTO records (name,time) VALUES (?, ?);"
                //Es buena costumbre que cuando se haga el insert devolver el id de postgres
        );
        ps.setString(1, this.getNickname());
        ps.setInt(2, this.getScore());
        ps.executeUpdate();
       
    }
    
        public static List selectScores_DB(Db myDb) throws SQLException, Exception {        
        PreparedStatement ps = myDb.prepareStatement(
                "SELECT (id,name,time) FROM records;"
        );
        ResultSet rs = myDb.executeQuery(ps);
        
        List <Score> scores = new ArrayList();
        
        while(rs.next()){//Si se tiene mas de una fila es necesario el while para recorrerlas todas, si solo se tiene una, con un solo rs.next() sobra
            Score newScore = new Score();
            newScore.setId(rs.getInt(1));
            newScore.setNickname(rs.getString(2));
            newScore.setScore(rs.getInt(3));
            scores.add(newScore);
        }
        return scores;
    }

    }
    

    
