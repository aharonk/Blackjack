package blackjackGame;

import java.util.ArrayList;

public class player {
    private double money;
    private double starting_money;
    private String name;
    private ArrayList<card> hand = new ArrayList<>();

    public player(String name, double money) {
        this.starting_money = money;
        this.name = name;
        this.money = money;
    }

    public static player dealer() {
        return new player("Dealer", 0);
    }

    public String getName() {
        return name;
    }
    public double getMoney() {
        return money;
    }
    public double getStartingMoney() {return starting_money;}
    public ArrayList<card> getHand() {
        return hand;
    }
    public String getHandForPrint() {
        StringBuilder return_hand= new StringBuilder();
        for (card Card: hand) {
            return_hand.append(Card.getCard()).append("  ");
        }
        return return_hand.toString();
    }
    public int getHandValue() {
        int total = 0, counter = 0;
        for (card Card:hand) {
            if (Card.getValue() == 11) {
                counter++;
            }
            total += Card.getValue();
        }
        while (counter > 0) {
            if (total > 21) {
                total -= 10;
            }
            counter--;
        }
        return total;
    }
    public void addMoney(double value) {
        money += value;
    }
    public void deal(card Card) {
        hand.add(Card);
    }

    public void dealerEnd(card dealt_card) {
        while (getHandValue() < 17) {
            deal(dealt_card);
        }
    }
}
