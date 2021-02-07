package b17.game.mission.table;

import b17.game.mission.FighterApproach;
import b17.game.mission.FighterType;
import b17.util.Util;

import java.util.*;

/**
 * B-4
 */
public class ShellHitsTable {
    private static final Map<FighterApproach, List<Integer>> HITS = new HashMap<>();

    static {
        HITS.put( FighterApproach.AREA_12, Arrays.asList( new Integer[]{ 3, 2, 2, 2, 1, 1, 1, 2, 2, 2, 4 } ) );
        HITS.put( FighterApproach.AREA_1_30, Arrays.asList( new Integer[]{ 3, 2, 2, 2, 1, 1, 1, 2, 2, 2, 4 } ) );
        HITS.put( FighterApproach.AREA_10_30, Arrays.asList( new Integer[]{ 3, 2, 2, 2, 1, 1, 1, 2, 2, 2, 4 } ) );
        HITS.put( FighterApproach.AREA_3, Arrays.asList( new Integer[]{ 4, 3, 3, 3, 2, 1, 2, 3, 3, 3, 5 } ) );
        HITS.put( FighterApproach.AREA_9, Arrays.asList( new Integer[]{ 4, 3, 3, 3, 2, 1, 2, 3, 3, 3, 5 } ) );
        HITS.put( FighterApproach.AREA_6, Arrays.asList( new Integer[]{ 6, 5, 4, 3, 2, 2, 2, 3, 4, 5, 7 } ) );
        HITS.put( FighterApproach.VERTICAL_DIVE, Arrays.asList( new Integer[]{ 3, 2, 2, 1, 1, 1, 1, 1, 2, 2, 4 } ) );
        HITS.put( FighterApproach.VERTICAL_CLIMB, Arrays.asList( new Integer[]{ 4, 4, 3, 2, 2, 1, 2, 2, 3, 4, 5 } ) );
    }

    public static int get( FighterApproach approach, FighterType fighterType ) {
        int r = Util.roll( 2, true );
        int hits = HITS.get( approach ).get( r - 2 );
        if( fighterType == FighterType.FIGHTER_190 ) {
            hits = (int) (((double) hits) * 1.5);
        } else if( fighterType == FighterType.FIGHTER_110 ) {
            hits += 1;
        }
        return hits;
    }

    private ShellHitsTable(){}
}
