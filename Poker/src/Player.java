
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

// add your own banner here
public class Player {

    private ArrayList<Card> hand; // the player's cards
    private double bankroll;
    private double bet;

    // you may choose to use more instance variables
    public Player() {
        // create a player here
        bankroll = 100.0;
        bet = 0.0;
        hand = new ArrayList<Card>();
    }

    public void addCard(Card c) {
        // add the card c to the player's hand
        hand.add(c);
    }

    public void removeCard(Card c) {
        // remove the card c from the player's hand
        hand.remove(c);
    }

    public void bets(double amt) {
        // player makes a bet
        bet = amt;
    }

    public void winnings(double odds) {
        //	adjust bankroll if player wins
        bankroll = bankroll + (bet * odds);
    }

    public double getBankroll() {
        // return current balance of bankroll
        return bankroll;
    }

    // you may wish to use more methods here
    //easily returns the current hand 
    public ArrayList<Card> getHand() {
        return hand;
    }

    //combines the remove and add card method 
    public void cardswap(int place, Card c) {
        hand.set(place, c);
    }
    //clears the players hand after each round

    public void clearhand() {
        hand.clear();
    }
}