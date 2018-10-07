package zipp.blackjack;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
/**
 * Provides player functions
 */
final class Player
{
    private int insurance=0, money;
    private ArrayList<Hand> hands;
    private final Shoe shoe;

    /**
     * Saves Shoe address and draws a Hand
     * @param shoe Address of Shoe used in Game
     * @param money Money Player starts with
     */
    Player(Shoe shoe, int money)
    {
        this.shoe = shoe;
        this.money=money;
        reset();
    }

    /**
     * Resets hand
     */
    void reset()
    {
        insurance=0;
        hands=new ArrayList<Hand>()
        {
            {
                add(new Hand(shoe.draw(), shoe.draw()));
            }
        };
    }

    /**
     * Returns ArrayList of Hands
     * @return All Hands
     */
    @Contract(pure = true)
    ArrayList<Hand> getHands(){return hands;}

    int getNumHands(){return hands.size();}

    /**
     * Returns the Hand of the Player
     * @param x Which hand
     * @return Player's Hand
     */
    Hand getHand(int x){return hands.get(x);}

    /**
     * Returns total money player has
     * @return Amount of Money
     */
    @Contract(pure = true)
    int getMoney(){return money;}

    /**
     * Does calculations based off if the hand won
     * @param x Did the hand win
     * @param hand Which Hand
     */
    /*
     * if(blackjack)
     *    money+=bet*1.5
     * else{
     *    if(win)
     *       money+=bet
     *    else
     *       money-=bet
     * }
     */
    void win(boolean x, int hand){money += (hands.get(hand).isBlackJack()) ? (int) (hands.get(hand).getBet() * 1.5) : (hands.get(hand).getBet() * ((x) ? 1 : -1));}

    /**
     * Sets insurance bet and returns true
     * @param insurance Amount Insured
     * @return True
     */
    boolean setInsurance(int insurance){this.insurance=insurance;return true;}

    /**
     * Returns the amount insured
     * @return Insurance Side Bet
     */
    @Contract(pure = true)
    int getInsurance(){return insurance;}

    /**
     * Applies insurance bet, 2:1 pay-out
     * @param x Did the side bet win
     */
    boolean winInsurance(boolean x){money += insurance * ((x) ? 2 : -1);return x;}

    void surrender(){money-= hands.get(0).getBet() * .5;reset();}
    
    /**
     * Splits hand x
     * @param x Which index hand to split
     */
    private void split(int x)
    {
        hands.add(new Hand(hands.get(x).removeCard(), shoe.draw()));
        hands.get(x).addCard(shoe.draw());
        hands.get(x+1).setBet(hands.get(x).getBet());
        hands.size();
    }

    /**
     * Acts out specified actions
     * @param x Action Value: 0=Stand, 1=Hit, 2=Split, 3=Double Down
     * @param h Which hand is being played
     * @return !If player is done playing
     */
    boolean toDo(int x, int h)
    {
        int n=x;
        Hand hand=hands.get(h);
        if(x==-1)
            x+=2;
        if(x==2){
            split(h);
            x--;}
        if(n==3){
            hand.setBet(hand.getBet()*2);
            n-=2;
        }if(n==1)
            hand.addCard(shoe.draw());
        return (x==1&&!hand.isBust());
    }
}