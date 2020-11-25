package blackjackGame;

import java.util.Scanner;

public class singlePlayerGame {
    private deck Deck;
    private player Player, Dealer;
    public Scanner keyboard = new Scanner(System.in);

    private void gameSetup() {
        Deck = new deck(false);
        Player = new player("Player", 1);
        Dealer = player.dealer();
        Deck.shuffle();
        for (int i = 0; i < 2; i++) {
            Player.deal(Deck.deal());
            Dealer.deal(Deck.deal());
        }
        System.out.println(Player.getHandForPrint());
    }

    public void game() {
        gameSetup();
        if (Player.getHandValue() == 21) {
            System.out.println("Blackjack, you win!");
        } else {
            int turn;
            boolean stand = false;
            while (!stand && Player.getHandValue() < 21) {
                System.out.println("\nYour hand: " + Player.getHandForPrint()+" = "+Player.getHandValue());
                System.out.println("Dealer has " + Dealer.getHand().get(0).getCard()+" = "+Dealer.getHand().get(0).getValue());
                System.out.print("Hit or Stand (1 or 2)? ");
                turn = keyboard.nextInt();
                if (turn == 1) {
                    Player.deal(Deck.deal());
                } else if (turn == 2) {
                    stand = true;
                } else System.out.println("\nNot an option.\n");
            }
            System.out.println("\nYour hand: " + Player.getHandForPrint()+" = "+Player.getHandValue());
            if (Player.getHandValue() > 21) {
                System.out.println("\nHand is over 21.\n");
                System.out.print("You lose.");
            } else {
                Dealer.dealerEnd(Deck.deal());
                if (Dealer.getHandValue() > 20) {
                    System.out.println(Dealer.getHandForPrint() + " \t= " + Dealer.getHandValue());
                    System.out.println(Player.getName() +" Wins!");
                } else {
                    System.out.println(Player.getHandForPrint() + " \t= " + Player.getHandValue());
                    System.out.println(Dealer.getHandForPrint() + " \t= " + Dealer.getHandValue());
                    if (Player.getHandValue() == Dealer.getHandValue()) {
                        System.out.println("Tie!");
                    } else {
                        System.out.println((Player.getHandValue() > Dealer.getHandValue() ? Player.getName() : Dealer.getName()) + " Wins!");
                    }
                }
            }
        }
        char menu;
        System.out.print("\nPlay again (y/n)? ");
        keyboard.nextLine();
        menu = keyboard.nextLine().toLowerCase().charAt(0);
        if (menu == 'y') {
            game();
        }
    }
}
