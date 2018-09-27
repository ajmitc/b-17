package b17.mission.table;

import b17.bomber.BomberStatus;
import b17.crew.CrewLandingStatus;
import b17.crew.CrewStatus;
import b17.mission.MapAreaCode;
import b17.util.Util;

/**
 * G-9, G-10
 */
public class LandingTable {
    private static final CrewLandingStatus[] ON_LAND_CREW_STATUS = new CrewLandingStatus[]{
            CrewLandingStatus.KIA,                        // -3
            CrewLandingStatus.ROLL_FOR_WOUNDS_PLUS_ONE,   // -2
            CrewLandingStatus.ROLL_FOR_WOUNDS,            // -1
            CrewLandingStatus.SAFE,                       //  0
            CrewLandingStatus.SAFE,                       //  1
            CrewLandingStatus.SAFE,                       // 2-12
    };

    private static final BomberStatus[] ON_LAND_BOMBER_STATUS = new BomberStatus[]{
            BomberStatus.WRECKED,    // -3
            BomberStatus.WRECKED,    // -2
            BomberStatus.WRECKED,    // -1
            BomberStatus.WRECKED,    //  0
            BomberStatus.REPAIRABLE, //  1
            BomberStatus.SAFE        // 2-12
    };

    private static final CrewLandingStatus[] ON_WATER = new CrewLandingStatus[]{
            CrewLandingStatus.LOST,
            CrewLandingStatus.LOST,
            CrewLandingStatus.RESCUED,
            CrewLandingStatus.RESCUED,
            CrewLandingStatus.RESCUED,
            CrewLandingStatus.RESCUED,
            CrewLandingStatus.RESCUED,
            CrewLandingStatus.RESCUED,
            CrewLandingStatus.RESCUED,
            CrewLandingStatus.RESCUED,
            CrewLandingStatus.RESCUED,
    };

    public static CrewLandingStatus getCrewLandingStatus( boolean onLand, int modifier, MapAreaCode fighterWaveModifierCode ) {
        int r = Util.roll( 2, true );
        if( onLand ) {
            // Add 3 to account for -3 index
            r += modifier + 3;

            if( r < 0 )
                r = 0;

            if( r < ON_LAND_CREW_STATUS.length ) {
                return ON_LAND_CREW_STATUS[ r ];
            }
            return ON_LAND_CREW_STATUS[ ON_LAND_CREW_STATUS.length - 1 ];
        }
        if( r == 12 )
            return CrewLandingStatus.RESCUED;
        if( fighterWaveModifierCode == MapAreaCode.GERMANY || fighterWaveModifierCode == MapAreaCode.NETHERLANDS )
            return CrewLandingStatus.CAPTURED;
        r += modifier;
        if( r < ON_WATER.length ) {
            return ON_WATER[ r ];
        }
        return ON_WATER[ ON_WATER.length - 1 ];
    }
}
