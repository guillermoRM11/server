
package marsattack.utils;

import marsattack.db.Score;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    
    private Integer responseCode;
    private Score score;
    private List <Score> scores;

    public List<Score> getScores() {
        return scores;
    }

    public void setScore(List<Score> scores) {
        this.scores = scores;
    }
    
    

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score= score;
    }
    
}
