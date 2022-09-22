import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck

	// add more instance variables if needed
		public Deck(){
		// make a 52 card deck here        
        cards = new Card[52];
        int index = 0;
        
        for (int i = 0; i < 13; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                cards[index] = new Card(j,i);
                index++;
            }
        }
        
	}
    
    public void shuffle(){
        //shuffle the deck here 
          for (int i = 0; i < cards.length; i++)
          {
              int shuffler = (int)(Math.random()*52);
              
              Card temp = cards[i];
              cards[i] = cards[shuffler];
              cards[shuffler] = temp;
          }
    }
	
	public Card deal(){
		// deal the top card in the deck               
        top++;
        if(top==52)
        {
            top = 0;
        }
        return cards[top];
	}
    
    //made this method early on in the coding process to test
    //out simpler hands 
    public Card testDeal(){
        return cards[0];
    }
    
	// add more methods here if needed

}