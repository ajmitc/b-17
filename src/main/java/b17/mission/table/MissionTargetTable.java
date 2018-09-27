package b17.mission.table;

import b17.mission.Target;
import b17.mission.TargetType;
import b17.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * G-1, G-2, and G-3
 */
public class MissionTargetTable {
    private static List<Target> targets1_5 = new ArrayList<>();
    private static List<TargetType> targetTypes1_5 = new ArrayList<>();
    //private static List<Integer> zone1_5 = new ArrayList<>();
    private static List<Target> targets6_10 = new ArrayList<>();
    private static List<TargetType> targetTypes6_10 = new ArrayList<>();
    //private static List<Integer> zone6_10 = new ArrayList<>();
    private static Map<Integer, Target> targets11_24 = new HashMap<>();
    private static Map<Integer, TargetType> targetTypes11_24 = new HashMap<>();
    //private static List<Integer> zone11_24 = new ArrayList<>();

    static {
        targets1_5.add( Target.ST_OMER );
        targets1_5.add( Target.CHERBOURG );
        targets1_5.add( Target.AMIENS );
        targets1_5.add( Target.MEAULTE );
        targets1_5.add( Target.ABBEVILLE );
        targets1_5.add( Target.LILLE );

        targetTypes1_5.add( TargetType.AIRFIELD );
        targetTypes1_5.add( TargetType.AIRFIELD );
        targetTypes1_5.add( TargetType.RAIL_YARD );
        targetTypes1_5.add( TargetType.AIRCRAFT );
        targetTypes1_5.add( TargetType.AIRFIELD );
        targetTypes1_5.add( TargetType.INDUSTRY );

        /*
        zone1_5.add( 2 );
        zone1_5.add( 3 );
        zone1_5.add( 3 );
        zone1_5.add( 3 );
        zone1_5.add( 3 );
        zone1_5.add( 3 );
        */

        targets6_10.add( Target.ABBEVILLE );
        targets6_10.add( Target.MEAULTE );
        targets6_10.add( Target.LILLE );
        targets6_10.add( Target.ROTTERDAM );
        targets6_10.add( Target.ANTWERP );
        targets6_10.add( Target.ROUEN );

        targetTypes6_10.add( TargetType.AIRFIELD );
        targetTypes6_10.add( TargetType.AIRCRAFT );
        targetTypes6_10.add( TargetType.INDUSTRY );
        targetTypes6_10.add( TargetType.SHIP_YARD );
        targetTypes6_10.add( TargetType.INDUSTRY );
        targetTypes6_10.add( TargetType.RAIL_YARD );

        /*
        zone6_10.add( 3 );
        zone6_10.add( 3 );
        zone6_10.add( 3 );
        zone6_10.add( 4 );
        zone6_10.add( 4 );
        zone6_10.add( 4 );
        */

        targets11_24.put( 11, Target.ST_OMER );
        targets11_24.put( 12, Target.CHERBOURG );
        targets11_24.put( 13, Target.AMIENS );
        targets11_24.put( 14, Target.MEAULTE );
        targets11_24.put( 15, Target.ABBEVILLE );
        targets11_24.put( 16, Target.LILLE );
        targets11_24.put( 21, Target.ROTTERDAM );
        targets11_24.put( 22, Target.ANTWERP );
        targets11_24.put( 23, Target.ROUEN );
        targets11_24.put( 24, Target.PARIS );
        targets11_24.put( 25, Target.PARIS );
        targets11_24.put( 26, Target.ROMILLY_SUR_SEINE );
        targets11_24.put( 31, Target.ROMILLY_SUR_SEINE );
        targets11_24.put( 32, Target.RENNES );
        targets11_24.put( 33, Target.RENNES );
        targets11_24.put( 34, Target.BREST );
        targets11_24.put( 35, Target.BREST );
        targets11_24.put( 36, Target.LORIENT );
        targets11_24.put( 41, Target.LORIENT );
        targets11_24.put( 42, Target.ST_NAZAIRE );
        targets11_24.put( 43, Target.ST_NAZAIRE );
        targets11_24.put( 44, Target.ST_NAZAIRE );
        targets11_24.put( 45, Target.WILHELMSHAVEN );
        targets11_24.put( 46, Target.WILHELMSHAVEN );
        targets11_24.put( 51, Target.EMDEN );
        targets11_24.put( 52, Target.EMDEN );
        targets11_24.put( 53, Target.VEGESACK );
        targets11_24.put( 54, Target.VEGESACK );
        targets11_24.put( 55, Target.BREMEN );
        targets11_24.put( 56, Target.BREMEN );
        targets11_24.put( 61, Target.HAMM );
        targets11_24.put( 62, Target.HAMM );
        targets11_24.put( 63, Target.LA_ROCHELLE );
        targets11_24.put( 64, Target.LA_ROCHELLE );
        targets11_24.put( 65, Target.KIEL );
        targets11_24.put( 66, Target.KIEL );

        targetTypes11_24.put( 11, TargetType.AIRFIELD );
        targetTypes11_24.put( 12, TargetType.AIRFIELD );
        targetTypes11_24.put( 13, TargetType.RAIL_YARD );
        targetTypes11_24.put( 14, TargetType.AIRCRAFT );
        targetTypes11_24.put( 15, TargetType.AIRFIELD );
        targetTypes11_24.put( 16, TargetType.INDUSTRY );
        targetTypes11_24.put( 21, TargetType.SHIP_YARD );
        targetTypes11_24.put( 22, TargetType.INDUSTRY );
        targetTypes11_24.put( 23, TargetType.RAIL_YARD );
        targetTypes11_24.put( 24, TargetType.INDUSTRY );
        targetTypes11_24.put( 25, TargetType.INDUSTRY );
        targetTypes11_24.put( 26, TargetType.AIRCRAFT );
        targetTypes11_24.put( 31, TargetType.AIRCRAFT );
        targetTypes11_24.put( 32, TargetType.RAIL_YARD );
        targetTypes11_24.put( 33, TargetType.RAIL_YARD );
        targetTypes11_24.put( 34, TargetType.U_BOATS );
        targetTypes11_24.put( 35, TargetType.U_BOATS );
        targetTypes11_24.put( 36, TargetType.U_BOATS );
        targetTypes11_24.put( 41, TargetType.U_BOATS );
        targetTypes11_24.put( 42, TargetType.U_BOATS );
        targetTypes11_24.put( 43, TargetType.U_BOATS );
        targetTypes11_24.put( 44, TargetType.U_BOATS );
        targetTypes11_24.put( 45, TargetType.U_BOATS );
        targetTypes11_24.put( 46, TargetType.U_BOATS );
        targetTypes11_24.put( 51, TargetType.INDUSTRY );
        targetTypes11_24.put( 52, TargetType.INDUSTRY );
        targetTypes11_24.put( 53, TargetType.U_BOATS );
        targetTypes11_24.put( 54, TargetType.U_BOATS );
        targetTypes11_24.put( 55, TargetType.AIRCRAFT );
        targetTypes11_24.put( 56, TargetType.AIRCRAFT );
        targetTypes11_24.put( 61, TargetType.RAIL_YARD );
        targetTypes11_24.put( 62, TargetType.RAIL_YARD );
        targetTypes11_24.put( 63, TargetType.U_BOATS );
        targetTypes11_24.put( 64, TargetType.U_BOATS );
        targetTypes11_24.put( 65, TargetType.U_BOATS );
        targetTypes11_24.put( 66, TargetType.U_BOATS );

        /*
        zone11_24.add( 11, 3 );
        zone11_24.add( 11, 3 );
        zone11_24.add( 11, 3 );
        zone11_24.add( 11, 4 );
        zone11_24.add( 11, 4 );
        zone11_24.add( 11, 4 );
        */
    }

    public static Target getMissionTarget( int missionNumber ) {
        if( missionNumber <= 5 ) {
            return targets1_5.get( Util.roll() - 1 );
        }
        else if( missionNumber <= 10 ) {
            return targets6_10.get( Util.roll() - 1 );
        }
        else if( missionNumber <= 24 ) {
            return targets11_24.get( Util.roll( 2, false ) );
        }
        return null;
    }

    public static TargetType getMissionTargetType( int missionNumber ) {
        if( missionNumber <= 5 ) {
            return targetTypes1_5.get( Util.roll() - 1 );
        }
        else if( missionNumber <= 10 ) {
            return targetTypes6_10.get( Util.roll() - 1 );
        }
        else if( missionNumber <= 24 ) {
            return targetTypes11_24.get( Util.roll( 2, false ) );
        }
        return null;
    }

    private MissionTargetTable() {}
}
