
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Poker {
    // instance variables
    JFrame frame;
    private Player p;
    private Deck cards;
    private double odds;
    ArrayList<Card> currentCards;
    double playerBet;
    // constructor
    public Poker() {
        p = new Player();
        cards = new Deck();
        frame = new JFrame();
        initComponents();

        newGame();
    }
    // function to show hand
    public void showHand() {
        cards.shuffle();

        p.addCard(cards.deal());
        p.addCard(cards.deal());
        p.addCard(cards.deal());
        p.addCard(cards.deal());
        p.addCard(cards.deal());

        currentCards = p.getHand();
        //System.out.println("deck/" + cards.get(0).getSuitRank() + "/" + cards.get(0).getRank() + ".png");
        card1Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(0).getSuitRank() + "/" + currentCards.get(0).getCardRank() + ".png"));
        card2Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(1).getSuitRank() + "/" + currentCards.get(1).getCardRank() + ".png"));
        card3Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(2).getSuitRank() + "/" + currentCards.get(2).getCardRank() + ".png"));
        card4Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(3).getSuitRank() + "/" + currentCards.get(3).getCardRank() + ".png"));
        card5Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(4).getSuitRank() + "/" + currentCards.get(4).getCardRank() + ".png"));
    }

    private void initComponents() {
        // creating frame elements
        leftPanel = new JPanel();
        card4Lbl = new JLabel();
        card3Lbl = new JLabel();
        card2Lbl = new JLabel();
        card1Lbl = new JLabel();
        card5Lbl = new JLabel();
        pageTitleLbl = new JLabel();
        card1Swap = new JButton();
        card2Swap = new JButton();
        card3Swap = new JButton();
        card4Swap = new JButton();
        card5Swap = new JButton();
        checkScore = new JButton();
        newGame = new JButton();
        handScoreLbl = new JLabel();
        handTextLbl = new JLabel();
        rightPanel = new JPanel();
        amountAvailableLbl = new JLabel();
        tokenLbl = new JLabel();
        amountLbl = new JLabel();
        // setting frame properties
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setMaximizedBounds(new Rectangle(800, 600, 600, 600));
        frame.setMaximumSize(new Dimension(800, 600));
        frame.setMinimumSize(new Dimension(800, 600));
        frame.getContentPane().setLayout(null);

        leftPanel.setLayout(null);
        // setting panel elements properties and adding to panel
        card4Lbl.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        leftPanel.add(card4Lbl);
        card4Lbl.setBounds(380, 80, 100, 140);

        card3Lbl.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        leftPanel.add(card3Lbl);
        card3Lbl.setBounds(250, 80, 100, 140);

        card2Lbl.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        leftPanel.add(card2Lbl);
        card2Lbl.setBounds(130, 80, 100, 140);

        card1Lbl.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        leftPanel.add(card1Lbl);
        card1Lbl.setBounds(10, 80, 100, 140);

        card5Lbl.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        leftPanel.add(card5Lbl);
        card5Lbl.setBounds(500, 80, 100, 140);

        pageTitleLbl.setFont(new Font("Tahoma", 1, 24));
        pageTitleLbl.setForeground(new Color(255, 0, 51));
        pageTitleLbl.setText("POKER");
        leftPanel.add(pageTitleLbl);
        pageTitleLbl.setBounds(260, 20, 100, 30);

        card5Swap.setText("SWAP");
        leftPanel.add(card5Swap);
        card5Swap.setBounds(510, 240, 80, 23);
        card5Swap.addActionListener(this::card5SwapActionPerformed);

        card1Swap.setText("SWAP");
        leftPanel.add(card1Swap);
        card1Swap.setBounds(20, 240, 80, 23);
        card1Swap.addActionListener(this::card1SwapActionPerformed);

        card2Swap.setText("SWAP");
        leftPanel.add(card2Swap);
        card2Swap.setBounds(140, 240, 80, 23);
        card2Swap.addActionListener(this::card2SwapActionPerformed);

        card3Swap.setText("SWAP");
        leftPanel.add(card3Swap);
        card3Swap.setBounds(260, 240, 80, 23);
        card3Swap.addActionListener(this::card3SwapActionPerformed);
        card4Swap.setText("SWAP");
        leftPanel.add(card4Swap);
        card4Swap.setBounds(390, 240, 80, 23);
        card4Swap.addActionListener(this::card4SwapActionPerformed);

        checkScore.setText("Check Score");
        checkScore.addActionListener(this::checkScoreActionPerformed);
        leftPanel.add(checkScore);
        checkScore.setBounds(240, 303, 130, 30);

        newGame.setText("New Game");
        newGame.addActionListener(this::newGameActionPerformed);
        leftPanel.add(newGame);
        newGame.setBounds(240, 303, 130, 30);
        newGame.setVisible(false);

        handScoreLbl.setFont(new Font("Tahoma", 1, 16));
        handScoreLbl.setForeground(new Color(0, 204, 102));
        handScoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
        handScoreLbl.setText("You Earned $10.");
        leftPanel.add(handScoreLbl);
        handScoreLbl.setBounds(10, 420, 600, 30);

        handTextLbl.setFont(new Font("Tahoma", 1, 16));
        handTextLbl.setForeground(new Color(0, 204, 102));
        handTextLbl.setHorizontalAlignment(SwingConstants.CENTER);
        handTextLbl.setText("Your Hand Has two pairs");
        leftPanel.add(handTextLbl);
        handTextLbl.setBounds(10, 380, 600, 30);

        frame.getContentPane().add(leftPanel);
        leftPanel.setBounds(0, 0, 630, 600);

        rightPanel.setLayout(null);

        amountAvailableLbl.setFont(new Font("Tahoma", 1, 14));
        amountAvailableLbl.setForeground(new Color(255, 51, 102));
        amountAvailableLbl.setText("Amount AVAILABLE");
        rightPanel.add(amountAvailableLbl);
        amountAvailableLbl.setBounds(10, 40, 142, 20);

        tokenLbl.setFont(new Font("Tahoma", 0, 14));
        tokenLbl.setHorizontalAlignment(SwingConstants.CENTER);
        tokenLbl.setText("(1 token = $1)");
        rightPanel.add(tokenLbl);
        tokenLbl.setBounds(0, 110, 170, 20);

        amountLbl.setFont(new Font("Tahoma", 1, 12));
        amountLbl.setHorizontalAlignment(SwingConstants.CENTER);
        amountLbl.setText("$100.0");
        rightPanel.add(amountLbl);
        amountLbl.setBounds(0, 80, 170, 15);

        frame.getContentPane().add(rightPanel);
        rightPanel.setBounds(630, 0, 170, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    // This function will start new game
    public void newGame() {
        if (p.getBankroll() == 0.0) { // checking if player got money to play
            JOptionPane.showMessageDialog(null, "you have no more money, thanks for playing");
            System.exit(0);
        } else {
            // resetting 
            amountLbl.setText("$" + p.getBankroll() + "");
            card1Swap.setEnabled(true);
            card2Swap.setEnabled(true);
            card3Swap.setEnabled(true);
            card4Swap.setEnabled(true);
            card5Swap.setEnabled(true);
            while (true) {
                String op = JOptionPane.showInputDialog(null, "how many tokens will you bet? (1-5)"); // asking for bet value
                System.out.println(op);
                if (op != null) {
                    playerBet = Double.parseDouble(op);
                    if (playerBet < 6 && playerBet > 0) {
                        p.bets(Double.parseDouble(op));
                        showHand();
                        break;
                    }
                }
            }
        }
    }
    // This function will be triggered when new game button will be clicked
    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {
        handTextLbl.setText("");
        handScoreLbl.setText("Play to win.");
        newGame();
        newGame.setVisible(false);
        checkScore.setVisible(true);
    }
    // This function will be triggered when check score button will be clicked
    private void checkScoreActionPerformed(java.awt.event.ActionEvent evt) {
        handTextLbl.setText("Your hand has " + this.checkHand(p.getHand()));
        p.winnings(odds);

        amountLbl.setText("$" + p.getBankroll() + "");
        if ((playerBet * odds) > 0) {
            handScoreLbl.setText("You won $" + (playerBet * odds));
        } else {
            handScoreLbl.setText("");
        }
        newGame.setVisible(true);
        checkScore.setVisible(false);

        card1Swap.setEnabled(false);
        card2Swap.setEnabled(false);
        card3Swap.setEnabled(false);
        card4Swap.setEnabled(false);
        card5Swap.setEnabled(false);
    }
    // This function will be triggered when card 2 swap button will be clicked
    private void card2SwapActionPerformed(java.awt.event.ActionEvent evt) {
        p.cardswap(1, cards.deal());
        currentCards = p.getHand();
        card2Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(1).getSuitRank() + "/" + currentCards.get(1).getCardRank() + ".png"));
        card2Swap.setEnabled(false);
    }
    // This function will be triggered when card 3 swap button will be clicked
    private void card3SwapActionPerformed(java.awt.event.ActionEvent evt) {
        p.cardswap(2, cards.deal());
        currentCards = p.getHand();
        card3Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(2).getSuitRank() + "/" + currentCards.get(2).getCardRank() + ".png"));
        card3Swap.setEnabled(false);
    }
    // This function will be triggered when card 4 swap button will be clicked
    private void card4SwapActionPerformed(java.awt.event.ActionEvent evt) {
        p.cardswap(3, cards.deal());
        currentCards = p.getHand();
        card4Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(3).getSuitRank() + "/" + currentCards.get(3).getCardRank() + ".png"));
        card4Swap.setEnabled(false);
    }
    // This function will be triggered when card 5 swap button will be clicked
    private void card5SwapActionPerformed(java.awt.event.ActionEvent evt) {
        p.cardswap(4, cards.deal());
        currentCards = p.getHand();
        card5Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(4).getSuitRank() + "/" + currentCards.get(4).getCardRank() + ".png"));
        card5Swap.setEnabled(false);
    }
    // This function will be triggered when card 1 swap button will be clicked
    private void card1SwapActionPerformed(java.awt.event.ActionEvent evt) {
        p.cardswap(0, cards.deal());
        currentCards = p.getHand();
        card1Lbl.setIcon(new ImageIcon("deck/" + currentCards.get(0).getSuitRank() + "/" + currentCards.get(0).getCardRank() + ".png"));
        card1Swap.setEnabled(false);
    }

    public String checkHand(ArrayList<Card> hand) {
        // this method should take an ArrayList of cards
        // as input and then determine what evaluates to and
        // return that as a String

        Collections.sort(hand);

        //checkHand checks which hand you have in descending order
        //of hand values in terms of payout so the first one is royal
        //flush and the last one is pair 
        if (royalflush(hand) == true) {
            return "a royalflush";
        } else if (straightflush(hand) == true) {
            return "a straight flush";
        } else if (fourofakind(hand) == true) {
            return "a four of a kind";
        } else if (fullhouse(hand) == true) {
            return "a full house";
        } else if (flush(hand) == true) {
            return "a flush";
        } else if (straight(hand) == true) {
            return "a straight";
        } else if (threeofakind(hand) == true) {
            return "a three of a kind";
        } else if (twopairs(hand) == true) {
            return "two pairs";
        } else if (pair(hand) == true) {
            return "a pair";
        } else {
            odds = -1.0;
            return "nothing";
        }
    }

    public boolean pair(ArrayList<Card> hand) {
        boolean ispair = false;
        //checks if two cards have equal ranks
        for (int i = 0; i < 4; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
                ispair = true;
            }
        }
        if (ispair) {
            odds = 1.0;
        }
        return ispair;
    }

    public boolean twopairs(ArrayList<Card> hand) {
        boolean istwopairs = false;
        //if the pairs are the first four cards ex: 2,2,3,3,5
        if ((hand.get(0).getRank() == hand.get(1).getRank())
                && (hand.get(2).getRank() == hand.get(3).getRank())) {
            istwopairs = true;
        } //if the pairs are the last four cards ex: 2,3,3,5,5
        else if ((hand.get(1).getRank() == hand.get(2).getRank())
                && (hand.get(3).getRank() == hand.get(4).getRank())) {
            istwopairs = true;
        } //if the pairs are the first two and last two cards ex: 2,2,3,5,5
        else if ((hand.get(0).getRank() == hand.get(1).getRank())
                && (hand.get(3).getRank() == hand.get(4).getRank())) {
            istwopairs = true;
        }
        if (istwopairs) {
            odds = 2.0;
        }
        return istwopairs;
    }

    public boolean threeofakind(ArrayList<Card> hand) {
        boolean isthreeofakind = false;
        //checks if three cards have equal ranks 
        for (int i = 0; i < 3; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
                if (hand.get(i + 1).getRank() == hand.get(i + 2).getRank()) {
                    isthreeofakind = true;
                }
            }
        }
        if (isthreeofakind) {
            odds = 3.0;
        }
        return isthreeofakind;
    }

    public boolean fourofakind(ArrayList<Card> hand) {
        boolean isfourofakind = false;
        //checks if four cards have equal ranks 
        for (int i = 0; i < 2; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
                if (hand.get(i + 1).getRank() == hand.get(i + 2).getRank()) {
                    if (hand.get(i + 2).getRank() == hand.get(i + 3).getRank()) {
                        isfourofakind = true;
                    }
                }
            }
        }
        if (isfourofakind) {
            odds = 25.0;
        }
        return isfourofakind;
    }

    public boolean straight(ArrayList<Card> hand) {
        boolean isstraight = false;
        //checks the edge case where the straight is 10,J,K,Q,A
        if (hand.get(0).getRank() == 1) {
            if (hand.get(1).getRank() == 10) {
                if (hand.get(2).getRank() == 11) {
                    if (hand.get(3).getRank() == 12) {
                        if (hand.get(4).getRank() == 13) {
                            isstraight = true;
                        }
                    }
                }
            }
        }
        //checks if the ranks are in consecutive order
        if (hand.get(4).getRank() == hand.get(3).getRank() + 1) {
            if (hand.get(3).getRank() == hand.get(2).getRank() + 1) {
                if (hand.get(2).getRank() == hand.get(1).getRank() + 1) {
                    if (hand.get(1).getRank() == hand.get(0).getRank() + 1) {
                        isstraight = true;
                    }
                }
            }
        }
        if (isstraight) {
            odds = 4.0;
        }
        return isstraight;
    }

    public boolean royalflush(ArrayList<Card> hand) {
        boolean isroyalflush = false;
        //checks if the suits are all equal
        if (hand.get(0).getSuit() == hand.get(1).getSuit()) {
            if (hand.get(1).getSuit() == hand.get(2).getSuit()) {
                if (hand.get(2).getSuit() == hand.get(3).getSuit()) {
                    if (hand.get(3).getSuit() == hand.get(4).getSuit()) {
                        //checks for specific ranks: 10,J,K,Q,A                           
                        if (hand.get(0).getRank() == 1) {
                            if (hand.get(1).getRank() == 10) {
                                if (hand.get(2).getRank() == 11) {
                                    if (hand.get(3).getRank() == 12) {
                                        if (hand.get(4).getRank() == 13) {
                                            isroyalflush = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isroyalflush) {
            odds = 250.0;
        }
        return isroyalflush;
    }

    public boolean flush(ArrayList<Card> hand) {
        boolean isflush = false;
        //checks if the suits are all equal
        if (hand.get(0).getSuit() == hand.get(1).getSuit()) {
            if (hand.get(1).getSuit() == hand.get(2).getSuit()) {
                if (hand.get(2).getSuit() == hand.get(3).getSuit()) {
                    if (hand.get(3).getSuit() == hand.get(4).getSuit()) {
                        isflush = true;
                    }
                }
            }
        }
        if (isflush) {
            odds = 5.0;
        }
        return isflush;
    }

    public boolean straightflush(ArrayList<Card> hand) {
        boolean isstraightflush = false;
        //first checks if the suits are all equal
        if (hand.get(0).getSuit() == hand.get(1).getSuit()) {
            if (hand.get(1).getSuit() == hand.get(2).getSuit()) {
                if (hand.get(2).getSuit() == hand.get(3).getSuit()) {
                    if (hand.get(3).getSuit() == hand.get(4).getSuit()) {
                        //checks if the ranks are consecutive 
                        if (hand.get(4).getRank() == hand.get(3).getRank() + 1) {
                            if (hand.get(4).getRank() == hand.get(3).getRank() + 1) {
                                if (hand.get(3).getRank() == hand.get(2).getRank() + 1) {
                                    if (hand.get(2).getRank() == hand.get(1).getRank() + 1) {
                                        if (hand.get(1).getRank() == hand.get(0).getRank() + 1) {
                                            isstraightflush = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isstraightflush) {
            odds = 50.0;
        }
        return isstraightflush;
    }
    
    public boolean fullhouse(ArrayList<Card> hand) {
        boolean isfullhouse = false;
        //if the first two cards are a pair and the three
        //are three of a kind 
        if ((hand.get(0).getRank() == hand.get(1).getRank())
                && (hand.get(2).getRank() == hand.get(4).getRank())) {
            isfullhouse = true;
        } //if the first three cards are a three of a kind 
        //and the last two are a pair
        else if ((hand.get(0).getRank() == hand.get(2).getRank())
                && (hand.get(3).getRank() == hand.get(4).getRank())) {
            isfullhouse = true;
        }
        if (isfullhouse) {
            odds = 6.0;
        }
        return isfullhouse;
    }
    // main function
    public static void main(String args[]) {

        new Poker();
    }
    // instance variables
    private JLabel card1Lbl;
    private JLabel card2Lbl;
    private JLabel card3Lbl;
    private JLabel card4Lbl;
    private JLabel card5Lbl;
    private JButton card1Swap;
    private JButton card2Swap;
    private JButton card3Swap;
    private JButton card4Swap;
    private JButton card5Swap;
    private JLabel pageTitleLbl;
    private JLabel amountAvailableLbl;
    private JButton checkScore;
    private JButton newGame;
    private JLabel tokenLbl;
    private JLabel amountLbl;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel handScoreLbl;
    private JLabel handTextLbl;
}