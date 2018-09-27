package b17.mission.table;

import b17.crew.CrewMember;
import b17.crew.CrewStatus;
import b17.util.Util;

/**
 * O-6
 */
public class OnTargetTable {
    private static final boolean[] TABLE = new boolean[]{ false, false, false, true, true, true, true, true };

    public static boolean isOnTarget( int mission_number, boolean hit_by_flak, CrewMember bombardier ) {
        if( bombardier.getStatus() == CrewStatus.SERIOUS_WOUND || bombardier.getStatus() == CrewStatus.KIA )
            return false;
        int r = Util.roll();
        if( mission_number >= 11 )
            r += 1;
        if( hit_by_flak )
            r -= 1;
        return TABLE[ r ];
    }


    private OnTargetTable(){}
}
