package b17.mission.table;


import b17.mission.FighterCoverage;
import b17.util.Util;

/**
 * G-5
 */
public class FighterCoverageTable {
    public static FighterCoverage getFighterCoverage( int missionNumber ) {
        if( missionNumber <= 5 )
            return FighterCoverage.GOOD;
        int r = Util.roll();
        if( r <= 2 )
            return FighterCoverage.POOR;
        if( r <= 4 )
            return FighterCoverage.FAIR;
        return FighterCoverage.GOOD;
    }

    private FighterCoverageTable(){}
}
