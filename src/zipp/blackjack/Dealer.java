package zipp.blackjack;

/**
 * Logic for the Dealer
 */
class Dealer
{
    private Hand hand;
    private Shoe shoe;

    /**
     * Creates a hand and an alias of the Shoe
     * @param shoe Shoe address
     */
    Dealer(Shoe shoe)
    {
        hand=new Hand(shoe.draw(),shoe.draw());
        this.shoe=shoe;
    }

    /**
     * Returns the Hand
     * @return Dealer's Hand
     */
    Hand getHand(){return hand;}

    /**
     * Draws card and returns whether the dealer busted
     */
    void cheapAct()
    {
        while(hand.getCardsVal()<17){
            hand.addCard(shoe.draw());
            hand.isBust();
        }
        hand.isBust();
    }
}
