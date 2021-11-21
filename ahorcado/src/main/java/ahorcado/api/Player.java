
package ahorcado.api;

public class Player {
    private String nick;
    private Integer score;
    
    public Player(){}

    public Player(String nick, Integer score) {
        this.nick = nick;
        this.score = score;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" + "nick=" + nick + ", score=" + score + '}';
    }
    
    
}
