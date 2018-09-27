package b17.mission.table;

import b17.util.Util;

/**
 * O-7
 */
public class BombingAccuracyTable {
    private static final int[] ON_TARGET  = new int[]{ 75, 60, 30, 20, 30, 40, 30, 20, 30, 50, 88 };
    private static final int[] OFF_TARGET = new int[]{ 10, 5, 0, 0, 0, 0, 0, 0, 0, 5, 10 };

    public static int getAccuracy( boolean onTarget ) {
        if( onTarget )
            return ON_TARGET[ Util.roll( 2, true ) - 2 ];
        return OFF_TARGET[ Util.roll( 2, true ) - 2 ];
    }

    private BombingAccuracyTable(){}
}
