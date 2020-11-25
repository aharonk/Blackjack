package blackjackGame;

import java.util.ArrayList;
import java.util.Random;

public class deck {
    private ArrayList<card> deck = new ArrayList<>();
    private String[] suits = {"\u2665","\u2663","\u2666","\u2660"};
    private String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private boolean Jokers;

    public deck(ArrayList<card> deck) {
        this.deck = deck;
    }
    public deck(boolean jokers) {
        this.Jokers = jokers;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new card(ranks[j],suits[i]));
            }
        }
        if (Jokers) {
            deck.add(new card("Joker", "Red"));
            deck.add(new card("Joker", "Black"));
        }
    }
    public void shuffle() {
        //Fisher-Yates Shuffle
        Random rand = new Random();
        card holder;
        for (int i = deck.size()-1; i > 0; i--) {
            int j = rand.nextInt(i+1);
            holder = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, holder);
        }
    }
    public void sort() {
        card holder;
        for (int i = 0; i < deck.size()-1; i++) {
            for (int j = i+1; j < deck.size(); j++) {
                if (deck.get(i).getValue() > deck.get(j).getValue()) {
                    holder = deck.get(i);
                    deck.set(i, deck.get(j));
                    deck.set(j, holder);
                }
            }
        }
    }
    public void reset() {
        deck.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new card(ranks[j],suits[i]));
            }
        }
        if (Jokers) {
            deck.add(new card("Joker", "Red"));
            deck.add(new card("Joker", "Black"));
        }
    }
    public ArrayList<card> getDeck() {
        return deck;
    }

    public card deal() {
        card Card = deck.get(0);
        deck.remove(0);
        return Card;
    }
}
