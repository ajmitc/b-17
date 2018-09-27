package b17.util;

import java.util.Date;
import java.util.Random;

public class Util {
    private static Random GEN = new Random( new Date().getTime() );

    public static int roll() {
        return GEN.nextInt( 6 ) + 1;
    }

    public static int roll( int numDice, boolean sum ) {
        if( numDice == 0 ) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int total = 0;
        for( int i = 0; i < numDice; ++i ) {
            int result = roll();
            total += result;
            sb.append( result );
        }
        if( sum ) {
            return total;
        }
        return Integer.decode( sb.toString() );
    }

    private Util(){}
}
