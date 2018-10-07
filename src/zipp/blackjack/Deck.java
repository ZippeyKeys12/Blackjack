package zipp.blackjack;

/**
 * Generates and shuffles decks for shoe
 */
class Deck
{
    private final Card[] cardList=new Card[52];

    /**
     * Fills Deck with all deck cards
     */
    Deck()
    {
        Suit[] suits={Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS, Suit.SPADES};
        int index=0;
        for(int i=0; i<4; i++)
            if(i<2){
                cardList[index++]=new Card(14, suits[i]);
                for(int j=2; j<=13; j++)
                    cardList[index++]=new Card(j, suits[i]);
            }else{
                for(int j=13; j>=2; j--)
                    cardList[index++]=new Card(j, suits[i]);
                cardList[index++]=new Card(14, suits[i]);}
        GameHelper.shuffle(cardList);
    }

    /**
     * Returns an array of all the Card objects
     * @return array of Card objects
     */
    Card[] getCards(){return cardList;}
}