
package game.api;

import java.util.concurrent.atomic.AtomicInteger;

public class Gamer {
    
    private String nickname;
    private Integer id;
    private String assignedToken;
    private int score;
    
    public Gamer(){}

    public Gamer(String nickname, Integer id, String assignedToken, int score) {
        this.nickname = nickname;
        this.id = id;
        this.assignedToken = assignedToken;
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssignedToken() {
        return assignedToken;
    }

    public void setAssignedToken(String assignedToken) {
        this.assignedToken = assignedToken;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Gamer{" + "nickname=" + nickname + ", id=" + id + ", assignedToken=" + assignedToken + ", score=" + score + '}';
    }
    
    
    
}
