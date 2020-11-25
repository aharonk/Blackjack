package blackjackGame;

public class card {
    private String suit;
    private String rank;

    public card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
    public String getCard() {
        return rank+suit;
    }
    public int getValue() {
        if (rank.equals("J") || rank.equals("Q") || rank.equals("K")){
            return 10;
        } else if (rank.equals("A")) {
            return 11;
        } else {
            return Integer.parseInt(rank);
        }
    }
}
