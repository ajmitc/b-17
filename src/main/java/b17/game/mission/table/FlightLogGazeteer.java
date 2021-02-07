package b17.game.mission.table;

import b17.game.mission.MapAreaCode;
import b17.game.mission.Target;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * G-11
 */
public class FlightLogGazeteer {
    private static Map<Target, Map<Integer, ZoneInfo>> zoneInfo = new HashMap<>();

    static {
        zoneInfo.put( Target.ABBEVILLE, new HashMap<>() );
        zoneInfo.get( Target.ABBEVILLE ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.ABBEVILLE ).put( 3, new ZoneInfo( 1, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.AMIENS, new HashMap<>() );
        zoneInfo.get( Target.AMIENS ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.AMIENS ).put( 3, new ZoneInfo( 1, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.ANTWERP, new HashMap<>() );
        zoneInfo.get( Target.ANTWERP ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.ANTWERP ).put( 3, new ZoneInfo( 1, MapAreaCode.BELGIUM ) );
        zoneInfo.get( Target.ANTWERP ).put( 4, new ZoneInfo( 0, MapAreaCode.BELGIUM ) );

        zoneInfo.put( Target.BREMEN, new HashMap<>() );
        zoneInfo.get( Target.BREMEN ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.BREMEN ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.BREMEN ).put( 4, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.BREMEN ).put( 5, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.BREMEN ).put( 6, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.BREMEN ).put( 7, new ZoneInfo( 0, MapAreaCode.GERMANY ) );

        zoneInfo.put( Target.BREST, new HashMap<>() );
        zoneInfo.get( Target.BREST ).put( 2, new ZoneInfo( -3, MapAreaCode.WATER ) );
        zoneInfo.get( Target.BREST ).put( 3, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.BREST ).put( 4, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.BREST ).put( 5, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.BREST ).put( 6, new ZoneInfo( 1, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.CHERBOURG, new HashMap<>() );
        zoneInfo.get( Target.CHERBOURG ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.CHERBOURG ).put( 3, new ZoneInfo( 0, MapAreaCode.FRANCE, MapAreaCode.WATER ) );

        zoneInfo.put( Target.EMDEN, new HashMap<>() );
        zoneInfo.get( Target.EMDEN ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.EMDEN ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.EMDEN ).put( 4, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.EMDEN ).put( 5, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.EMDEN ).put( 6, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.EMDEN ).put( 7, new ZoneInfo( 0, MapAreaCode.GERMANY ) );

        zoneInfo.put( Target.HAMM, new HashMap<>() );
        zoneInfo.get( Target.HAMM ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.HAMM ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.HAMM ).put( 4, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.HAMM ).put( 5, new ZoneInfo( 0, MapAreaCode.NETHERLANDS ) );
        zoneInfo.get( Target.HAMM ).put( 6, new ZoneInfo( 0, MapAreaCode.NETHERLANDS ) );
        zoneInfo.get( Target.HAMM ).put( 7, new ZoneInfo( 0, MapAreaCode.GERMANY ) );

        zoneInfo.put( Target.KIEL, new HashMap<>() );
        zoneInfo.get( Target.KIEL ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.KIEL ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.KIEL ).put( 4, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.KIEL ).put( 5, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.KIEL ).put( 6, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.KIEL ).put( 7, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.KIEL ).put( 8, new ZoneInfo( 0, MapAreaCode.GERMANY ) );

        zoneInfo.put( Target.LA_ROCHELLE, new HashMap<>() );
        zoneInfo.get( Target.LA_ROCHELLE ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.LA_ROCHELLE ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.LA_ROCHELLE ).put( 4, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.LA_ROCHELLE ).put( 5, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.LA_ROCHELLE ).put( 6, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.LA_ROCHELLE ).put( 7, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.LA_ROCHELLE ).put( 8, new ZoneInfo( 0, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.LILLE, new HashMap<>() );
        zoneInfo.get( Target.LILLE ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.LILLE ).put( 3, new ZoneInfo( 0, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.LORIENT, new HashMap<>() );
        zoneInfo.get( Target.LORIENT ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.LORIENT ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.LORIENT ).put( 4, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.LORIENT ).put( 5, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.LORIENT ).put( 6, new ZoneInfo( 0, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.MEAULTE, new HashMap<>() );
        zoneInfo.get( Target.MEAULTE ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.MEAULTE ).put( 3, new ZoneInfo( 0, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.PARIS, new HashMap<>() );
        zoneInfo.get( Target.PARIS ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.PARIS ).put( 3, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.PARIS ).put( 4, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.PARIS ).put( 5, new ZoneInfo( 0, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.RENNES, new HashMap<>() );
        zoneInfo.get( Target.RENNES ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.RENNES ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.RENNES ).put( 4, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.RENNES ).put( 5, new ZoneInfo( 0, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.ROMILLY_SUR_SEINE, new HashMap<>() );
        zoneInfo.get( Target.ROMILLY_SUR_SEINE ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.ROMILLY_SUR_SEINE ).put( 3, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.ROMILLY_SUR_SEINE ).put( 4, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.ROMILLY_SUR_SEINE ).put( 5, new ZoneInfo( 0, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.ROTTERDAM, new HashMap<>() );
        zoneInfo.get( Target.ROTTERDAM ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.ROTTERDAM ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.ROTTERDAM ).put( 4, new ZoneInfo( 0, MapAreaCode.WATER, MapAreaCode.NETHERLANDS ) );

        zoneInfo.put( Target.ROUEN, new HashMap<>() );
        zoneInfo.get( Target.ROUEN ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.ROUEN ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.ROUEN ).put( 4, new ZoneInfo( 0, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.ST_OMER, new HashMap<>() );
        zoneInfo.get( Target.ST_OMER ).put( 2, new ZoneInfo( 0, MapAreaCode.WATER, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.ST_NAZAIRE, new HashMap<>() );
        zoneInfo.get( Target.ST_NAZAIRE ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.ST_NAZAIRE ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.ST_NAZAIRE ).put( 4, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.ST_NAZAIRE ).put( 5, new ZoneInfo( 0, MapAreaCode.FRANCE ) );
        zoneInfo.get( Target.ST_NAZAIRE ).put( 6, new ZoneInfo( 1, MapAreaCode.FRANCE ) );

        zoneInfo.put( Target.VEGESACK, new HashMap<>() );
        zoneInfo.get( Target.VEGESACK ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.VEGESACK ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.VEGESACK ).put( 4, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.VEGESACK ).put( 5, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.VEGESACK ).put( 6, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.VEGESACK ).put( 7, new ZoneInfo( 0, MapAreaCode.GERMANY ) );

        zoneInfo.put( Target.WILHELMSHAVEN, new HashMap<>() );
        zoneInfo.get( Target.WILHELMSHAVEN ).put( 2, new ZoneInfo( -2, MapAreaCode.WATER ) );
        zoneInfo.get( Target.WILHELMSHAVEN ).put( 3, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.WILHELMSHAVEN ).put( 4, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.WILHELMSHAVEN ).put( 5, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.WILHELMSHAVEN ).put( 6, new ZoneInfo( -1, MapAreaCode.WATER ) );
        zoneInfo.get( Target.WILHELMSHAVEN ).put( 7, new ZoneInfo( 0, MapAreaCode.GERMANY ) );
    }

    public static int getModifier( Target target, int zone ) {
        ZoneInfo info = zoneInfo.get(  target ).get( zone );
        return info.fighterWaveModifier;
    }

    public static List<MapAreaCode> getMapAreaCodes( Target target, int zone ) {
        ZoneInfo info = zoneInfo.get(  target ).get( zone );
        return info.codes;
    }

    private FlightLogGazeteer(){}

    public static class ZoneInfo {
        public int fighterWaveModifier;
        public List<MapAreaCode> codes = new ArrayList<>();

        public ZoneInfo( int modifier, MapAreaCode code ) {
            this.fighterWaveModifier = modifier;
            codes.add( code );
        }

        public ZoneInfo( int modifier, MapAreaCode code1, MapAreaCode code2 ) {
            this.fighterWaveModifier = modifier;
            codes.add( code1 );
            codes.add( code2 );
        }
    }
}
