package zipp.blackjack;

import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
class GameHelper
{

    /**
     * Converts Rank ID to a readable String
     * @param x Rank ID
     * @return Rank as a String
     */
    @Contract(pure = true)
    static String rankToStr(int x){final String[] FACES={"Jack", "Queen", "King", "Ace"};return (x < 11) ? "" + x : FACES[x - 11];}

    /**
     * Shuffles an array of Objects
     * @param arr Initial array of Objects
     */
    static void shuffle(Object[] arr) {
        int len=arr.length;
        Random rand=new Random();
        rand.nextInt();
        for (int i=0; i<len; i++) {
            int change=i+rand.nextInt(len-i);
            swap(arr, i, change);
        }
        Collections.shuffle(Arrays.asList(arr));
    }

    /**
     * Helper method to swap 2 values in an array
     * @param x Array which contains values
     * @param y First index for swap
     * @param z Second index for swap
     */
    private static void swap(Object[] x, int y, int z) {
        Object helper=x[y];
        x[y]=x[z];
        x[z]=helper;
    }
}