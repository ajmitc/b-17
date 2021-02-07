package b17.game.mission.table;

import b17.game.bomber.GunPosition;
import b17.game.mission.FighterAltitude;
import b17.game.mission.FighterApproach;
import b17.game.mission.FighterType;

import java.util.HashMap;
import java.util.Map;

/**
 * M-1
 */
public class DefensiveFireTable {
    private static final Map<FighterApproach, Map<FighterAltitude, Map<GunPosition, Map<FighterType, Integer>>>> TABLE = new HashMap<>();

    static {
        // { area: { altitude: { gun: { fighter: min_roll_for_hit } } } }
        for (FighterApproach approach : FighterApproach.values()) {
            TABLE.put(approach, new HashMap<>());
            for (FighterAltitude altitude : FighterAltitude.values()) {
                TABLE.get(approach).put(altitude, new HashMap<>());
            }
        }

        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.HIGH).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.HIGH).put(GunPosition.NOSE, new HashMap<>());
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.HIGH).get(GunPosition.NOSE).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.HIGH).get(GunPosition.NOSE).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.HIGH).get(GunPosition.NOSE).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LEVEL).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LEVEL).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LEVEL).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LEVEL).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LEVEL).put(GunPosition.NOSE, new HashMap<>());
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LEVEL).get(GunPosition.NOSE).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LEVEL).get(GunPosition.NOSE).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LEVEL).get(GunPosition.NOSE).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LOW).put(GunPosition.BALL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LOW).put(GunPosition.NOSE, new HashMap<>());
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LOW).get(GunPosition.NOSE).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LOW).get(GunPosition.NOSE).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_12).get(FighterAltitude.LOW).get(GunPosition.NOSE).put(FighterType.FIGHTER_190, 6);


        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).put(GunPosition.STBD_CHEEK, new HashMap<>());
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).get(GunPosition.STBD_CHEEK).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).get(GunPosition.STBD_CHEEK).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).get(GunPosition.STBD_CHEEK).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).put(GunPosition.STBD_WAIST, new HashMap<>());
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.HIGH).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LEVEL).put(GunPosition.STBD_CHEEK, new HashMap<>());
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LEVEL).get(GunPosition.STBD_CHEEK).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LEVEL).get(GunPosition.STBD_CHEEK).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LEVEL).get(GunPosition.STBD_CHEEK).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LOW).put(GunPosition.BALL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LOW).put(GunPosition.STBD_CHEEK, new HashMap<>());
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LOW).get(GunPosition.STBD_CHEEK).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LOW).get(GunPosition.STBD_CHEEK).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_1_30).get(FighterAltitude.LOW).get(GunPosition.STBD_CHEEK).put(FighterType.FIGHTER_190, 6);


        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).put(GunPosition.PORT_CHEEK, new HashMap<>());
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).get(GunPosition.PORT_CHEEK).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).get(GunPosition.PORT_CHEEK).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).get(GunPosition.PORT_CHEEK).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).put(GunPosition.PORT_WAIST, new HashMap<>());
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.HIGH).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LEVEL).put(GunPosition.PORT_CHEEK, new HashMap<>());
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LEVEL).get(GunPosition.PORT_CHEEK).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LEVEL).get(GunPosition.PORT_CHEEK).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LEVEL).get(GunPosition.PORT_CHEEK).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LOW).put(GunPosition.BALL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LOW).put(GunPosition.PORT_CHEEK, new HashMap<>());
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LOW).get(GunPosition.PORT_CHEEK).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LOW).get(GunPosition.PORT_CHEEK).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_10_30).get(FighterAltitude.LOW).get(GunPosition.PORT_CHEEK).put(FighterType.FIGHTER_190, 6);


        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.HIGH).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 5);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 4);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 5);

        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.HIGH).put(GunPosition.STBD_WAIST, new HashMap<>());
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.HIGH).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.HIGH).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.HIGH).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 5);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 4);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 5);

        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).put(GunPosition.BALL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_109, 5);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_110, 4);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_190, 5);

        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).put(GunPosition.STBD_WAIST, new HashMap<>());
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LEVEL).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LOW).put(GunPosition.BALL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_109, 5);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_110, 4);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_190, 5);

        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LOW).put(GunPosition.STBD_WAIST, new HashMap<>());
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LOW).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LOW).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_3).get(FighterAltitude.LOW).get(GunPosition.STBD_WAIST).put(FighterType.FIGHTER_190, 6);


        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.HIGH).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 5);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 4);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 5);

        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.HIGH).put(GunPosition.PORT_WAIST, new HashMap<>());
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.HIGH).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.HIGH).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.HIGH).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 5);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 4);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 5);

        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).put(GunPosition.BALL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_109, 5);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_110, 4);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_190, 5);

        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).put(GunPosition.PORT_WAIST, new HashMap<>());
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LEVEL).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LOW).put(GunPosition.BALL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_109, 5);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_110, 4);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_190, 5);

        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LOW).put(GunPosition.PORT_WAIST, new HashMap<>());
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LOW).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LOW).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_9).get(FighterAltitude.LOW).get(GunPosition.PORT_WAIST).put(FighterType.FIGHTER_190, 6);


        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 4);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 3);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 4);

        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).put(GunPosition.RADIO, new HashMap<>());
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).get(GunPosition.RADIO).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).get(GunPosition.RADIO).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).get(GunPosition.RADIO).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).put(GunPosition.TAIL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).get(GunPosition.TAIL_TURRET).put(FighterType.FIGHTER_109, 4);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).get(GunPosition.TAIL_TURRET).put(FighterType.FIGHTER_110, 3);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.HIGH).get(GunPosition.TAIL_TURRET).put(FighterType.FIGHTER_190, 4);

        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LEVEL).put(GunPosition.TAIL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LEVEL).get(GunPosition.TAIL_TURRET).put(FighterType.FIGHTER_109, 4);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LEVEL).get(GunPosition.TAIL_TURRET).put(FighterType.FIGHTER_110, 3);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LEVEL).get(GunPosition.TAIL_TURRET).put(FighterType.FIGHTER_190, 4);

        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LOW).put(GunPosition.BALL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_109, 4);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_110, 3);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_190, 4);

        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LOW).put(GunPosition.TAIL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LOW).get(GunPosition.TAIL_TURRET).put(FighterType.FIGHTER_109, 4);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LOW).get(GunPosition.TAIL_TURRET).put(FighterType.FIGHTER_110, 3);
        TABLE.get(FighterApproach.AREA_6).get(FighterAltitude.LOW).get(GunPosition.TAIL_TURRET).put(FighterType.FIGHTER_190, 4);


        TABLE.get(FighterApproach.VERTICAL_CLIMB).get(FighterAltitude.LOW).put(GunPosition.BALL_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.VERTICAL_CLIMB).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_109, 3);
        TABLE.get(FighterApproach.VERTICAL_CLIMB).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_110, 3);
        TABLE.get(FighterApproach.VERTICAL_CLIMB).get(FighterAltitude.LOW).get(GunPosition.BALL_TURRET).put(FighterType.FIGHTER_190, 3);


        TABLE.get(FighterApproach.VERTICAL_DIVE).get(FighterAltitude.HIGH).put(GunPosition.TOP_TURRET, new HashMap<>());
        TABLE.get(FighterApproach.VERTICAL_DIVE).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.VERTICAL_DIVE).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.VERTICAL_DIVE).get(FighterAltitude.HIGH).get(GunPosition.TOP_TURRET).put(FighterType.FIGHTER_190, 6);

        TABLE.get(FighterApproach.VERTICAL_DIVE).get(FighterAltitude.HIGH).put(GunPosition.RADIO, new HashMap<>());
        TABLE.get(FighterApproach.VERTICAL_DIVE).get(FighterAltitude.HIGH).get(GunPosition.RADIO).put(FighterType.FIGHTER_109, 6);
        TABLE.get(FighterApproach.VERTICAL_DIVE).get(FighterAltitude.HIGH).get(GunPosition.RADIO).put(FighterType.FIGHTER_110, 6);
        TABLE.get(FighterApproach.VERTICAL_DIVE).get(FighterAltitude.HIGH).get(GunPosition.RADIO).put(FighterType.FIGHTER_190, 6);
    }


    public static Map<GunPosition, Map<FighterType, Integer>> getGuns(FighterApproach approach, FighterAltitude altitude) {
        return TABLE.get(approach).get(altitude);
    }


    public static int getMinHitRoll(FighterType fighter, FighterApproach approach, FighterAltitude altitude, GunPosition gun) {
        Map<GunPosition, Map<FighterType, Integer>> guns = TABLE.get(approach).get(altitude);
        if (guns.containsKey(gun)) {
            return guns.get(gun).get(fighter);
        }
        return 99; // Return a number too big to allow any hit
    }


    private DefensiveFireTable() {
    }
}
