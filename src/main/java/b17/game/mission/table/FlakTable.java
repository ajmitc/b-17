package b17.game.mission.table;

import b17.game.mission.Flak;
import b17.util.Util;

/**
 * O-2, O-3
 */
public class FlakTable {
    private static final Flak[] AMOUNT = new Flak[]{
            Flak.NO_FLAK,
            Flak.LIGHT_FLAK,
            Flak.LIGHT_FLAK,
            Flak.MEDIUM_FLAK,
            Flak.MEDIUM_FLAK,
            Flak.HEAVY_FLAK,
    };

    public static FlakResult get() {
        int r = Util.roll();
        Flak amount = AMOUNT[ r ];
        if( amount == Flak.NO_FLAK ) {
            return new FlakResult( Flak.NO_FLAK,0 );
        }

        int hits = 0;
        for( int i = 0; i < 3; ++i ) {
            r = Util.roll( 2, true );
            if( r == 2 || r == 12 ) {
                hits += 1;
            }
            if( amount == Flak.MEDIUM_FLAK && r == 7 ) {
                hits += 1;
            }
            if( amount == Flak.HEAVY_FLAK && r % 2 == 1 ) {
                hits += 1;
            }
        }

        return new FlakResult( amount, hits );
    }

    public static class FlakResult {
        public Flak flakAmount;
        public int hits;

        public FlakResult( Flak amount, int hits ) {
            this.flakAmount = amount;
            this.hits = hits;
        }
    }

    private FlakTable(){}
}
