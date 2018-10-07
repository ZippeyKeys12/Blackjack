package zipp.blackjack;

/**
 * Holds card's Rank, Suit and Value
 */
public class Card
{
    private int val;
    private final int rank;
    private final Suit suit;

    /**
     * Takes rank and suit and sets appropriate value
     * @param rank Rank of card, 11->14 for Jack thru Ace and numbers retain
     * @param suit whether the card is spades, hearts, clubs, or diamonds
     */
    Card(int rank, Suit suit)
    {
        this.rank=rank;
        //If less than 11, val=rank, else if rank=14, val=11, else val=10
        val=(rank<11)?rank:((rank==14)?11:10);
        this.suit=suit;
    }

    /**
     * Returns value of the card
     * @return Value of the card
     */
    int getVal(){return val;}

    /**
     * Returns rank of the card
     * @return Rank of the card
     */
    int getRank(){return rank;}

    /**
     * Returns suit of the card
     * @return Suit of the card
     */
    Suit getSuit(){return suit;}

    /**
     * Checks if it is possible to make an ace a 1 from a 11
     * @return !can be made into a 1 from 11
     */
    boolean switchAce()
    {
        if(val==11)
        {
            val=1;
            return false;
        }
        return true;
    }

    /**
     * Return relevant information as a String
     * @return Relevant info
     */
    @Override
    public String toString()
    {
        return GameHelper.rankToStr(rank)+" of "+suit.toString();
    }
}