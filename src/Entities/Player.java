import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
