package zipp.blackjack;

import java.util.Arrays;
import java.util.ArrayList;
/**
 * Combines decks into a shoe
 */
public final class Shoe
{
    private final int deckNum;
    private int cutCard;
    private ArrayList<Card> cardList;

    /**
     * Runs Creator
     * @param deckNum Number of Decks
     */
    Shoe(int deckNum)
    {
        this.deckNum=deckNum;
        makeDeck();
    }

    /**
     * Creates multiple decks and combines them and puts a cut card
     */
    private Shoe makeDeck()
    {
        ArrayList<Card> cardList1=new ArrayList<>();
        for(int i=0; i<deckNum; i++)
        {
            cardList1.addAll(Arrays.asList(new Deck().getCards()));
            GameHelper.shuffle(cardList1.toArray());
        }
		//Cuts the Deck
        cardList=new ArrayList<Card>()
        {
            {
				int rand=(int)(Math.random()*17-8);
                addAll(cardList1.subList(cardList1.size()/2+rand,cardList1.size()));
                addAll(cardList1.subList(0,cardList1.size()/2+rand));
            }
        };
        //Inserts Cut Card
        cutCard=cardList.size()/4-(int)(Math.random()*11)-5;
        //Burns a Card
        cardList.remove(0);
        return this;
    }

    /**
     * Removes a card from the shoe and returns it
     * @return a random card
     */
    Card draw()
    {
        return (cardList.size()<cutCard)?makeDeck().draw():cardList.remove(0);
    }

    /**
     * Returns cardList as a String
     * @return cardList.toString()
     */
    @Override
    public String toString(){return cardList.toString();}
}