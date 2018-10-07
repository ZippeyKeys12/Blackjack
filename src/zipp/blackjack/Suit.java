package zipp.blackjack;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


/**
 * Enumeration class Suit - Suits of Cards
 **/
public enum Suit
{
    SPADES, HEARTS, CLUBS, DIAMONDS;

    /**
     * Returns the suit as a String
     * @return Suit as a String
     */
    @NotNull
    @Contract(pure = true)
    @Override
    public String toString()
    {
        switch(this)
        {
            case SPADES:return"Spades";
            case HEARTS:return"Hearts";
            case CLUBS:return"Clubs";
            case DIAMONDS:return"Diamonds";
            default:return"";
        }
    }
}