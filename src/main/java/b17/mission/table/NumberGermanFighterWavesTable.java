package b17.mission.table;

import b17.mission.Weather;
import b17.util.Util;

/**
 * B-1, B-2
 */
public class NumberGermanFighterWavesTable {

    public static int get( boolean targetZone, Weather weather ) {
        int r = Util.roll();
        if( targetZone ) {
            if( weather != null && weather == Weather.POOR ) {
                r -= 1;
            }
            return new int[]{ 1, 1, 1, 1, 2, 2, 3 }[ r ];
        }
        return new int[]{ 0, 0, 0, 1, 1, 1, 2 }[ r ];
    }

    public static int get( boolean targetZone ) {
        return get( targetZone, null );
    }

    private NumberGermanFighterWavesTable(){}
}
