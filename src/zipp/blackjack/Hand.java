package zipp.blackjack;

import java.util.ArrayList;
/**
 * Holds cards
 */
public class Hand
{
    private boolean blackjack=false, win=false;
    private int bet=0;
    private final ArrayList<Card> cards;

    /**
     * Creates a hand with 2 cards
     * @param c1 First Card
     * @param c2 Second Card
     */
    Hand(Card c1, Card c2)
    {
        cards=new ArrayList<Card>()
        {
            {
                add(c1); add(c2);
            }
        };
    }

    /**
     * Return an ArrayList of the cards in the hand
     * @return ArrayList of cards in hand
     */
    ArrayList<Card> getCards(){return cards;}

    Card getCard(int x){return cards.get(x);}

    /**
     * Returns the number of cards in the hand
     * @return # of cards in hand
     */
    int getNumCards(){return cards.size();}

    /**
     * Adds specified Card to the hand
     * @param card Card to add
     */
    void addCard(Card card)
    {
        cards.add(card);
        getNumCards();
    }

    /**
     * Removes a card from the hand and returns it
     * @return Card that was removed
     */
    Card removeCard(){return cards.remove(1);}

    /**
     * Set the bet to the given value
     * @param bet The bet to be made
     */
    void setBet(int bet){this.bet = bet;}

    /**
     * Returns the bet made
     * @return The bet
     */
    int getBet(){return bet;}

    /**
     * Gives player a blackjack
     * @return true
     */
    boolean giveBlackJack(){return blackjack=isWin();}

    /**
     * Returns if the Hand is a BlackJack
     * @return If the Hand is BlackJack
     */
    boolean isBlackJack(){return blackjack;}

    /**
     * Marks this zipp.blackjack.Hand as a win
     * @return true
     */
    boolean isWin(){return win=true;}

    /**
     * Returns if this hand is a win
     * @return Is the card a win
     */
    boolean getWin(){return win;}

    /**
     * Returns if the hand is a bust
     * @return if hand is a bust
     */
    boolean isBust()
    {
        boolean bust=false;
        if(getCardsVal()>21){
            bust=true;
            for(Card i:cards)
                if(bust&&i.getRank()==14)
                    bust=i.switchAce();
        }
        return bust;
    }

    /**
     * Returns sum of cards' values
     * @return sum of cards' values
     */
    int getCardsVal()
    {
        int totVal=0;
        for(Card i:cards)
            totVal+=i.getVal();
        return totVal;
    }

    /**
     * Returns the name of cards in your hand
     * @return your hand
     */
    @Override
    public String toString()
    {
        StringBuilder str= new StringBuilder();
        for(int i=0; i<cards.size()-1; i++)
            str.append((cards.get(i).toString().substring(0, 1).equals("A")) ? " an " : " a ").append(cards.get(i).toString()).append(",");
        return String.valueOf(str.append(" and a ").append(cards.get(cards.size() - 1).toString()));
    }
}