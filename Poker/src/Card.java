
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Card implements Comparable<Card> {

    private int suit = 0;
    private String[] suitArray = {"C", "D", "H", "S"};
    private int rank = 0;
    private String[] rankArray = {"A", "2", "3", "4", "5",
        "6", "7", "8", "9",
        "10", "J", "K", "Q"};

    public Card(int s, int r) {
        //make a card with suit s and value v
        suit = s;
        rank = r;
    }

    public int compareTo(Card c) {
        // use this method to compare cards so they 
        // may be easily sorted    
        int judge = 0;
        if (this.rank > c.rank) {
            judge = 1;
        }

        if (this.rank == c.rank) {
            if (this.suit > c.suit) {
                judge = 1;
            } else if (this.suit < c.suit) {
                judge = -1;
            }
        } else if (this.rank < c.rank) {
            judge = -1;
        }

        return judge;

    }

    public String toString() {
        // use this method to easily print a Card object
        return rankArray[rank] + " of " + suitArray[suit];
    }
    // add some more methods here if needed

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public String getCardRank() {
        return rankArray[rank];
    }

    public String getSuitRank() {
        return suitArray[suit];
    }
}