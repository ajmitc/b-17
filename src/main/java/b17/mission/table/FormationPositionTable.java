package b17.mission.table;

import b17.mission.FormationPosition;
import b17.mission.SquadronPosition;
import b17.util.Util;

/**
 * G-4
 */
public class FormationPositionTable {

    public static FormationPosition getFormationPosition() {
        int r = Util.roll( 2, true );
        if( r == 2 )
            return FormationPosition.LEAD;
        if( r == 12 )
            return FormationPosition.TAIL;
        return FormationPosition.MIDDLE;
    }

    public static SquadronPosition getSquadronPosition() {
        int r = Util.roll( 2, true );
        if( r <= 2 )
            return SquadronPosition.HIGH;
        if( r <= 4 )
            return SquadronPosition.MIDDLE;
        return SquadronPosition.LOW;
    }

    private FormationPositionTable(){}
}
