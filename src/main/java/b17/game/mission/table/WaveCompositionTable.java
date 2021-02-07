package b17.game.mission.table;

import b17.game.mission.FighterAltitude;
import b17.game.mission.FighterApproach;
import b17.game.mission.FighterType;
import b17.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * B-3
 */
public class WaveCompositionTable {

    private static Map<Integer, List<FighterInfo>> FIGHTERS = new HashMap<>();

    static {
        FIGHTERS.put(11, new ArrayList<>());
        FIGHTERS.get(11).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_6, FighterAltitude.HIGH));

        FIGHTERS.put(12, new ArrayList<>());
        FIGHTERS.get(12).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_1_30, FighterAltitude.HIGH));
        FIGHTERS.get(12).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_9, FighterAltitude.LEVEL));

        FIGHTERS.put(13, new ArrayList<>());
        FIGHTERS.get(13).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(13).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_10_30, FighterAltitude.HIGH));
        FIGHTERS.get(13).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_3, FighterAltitude.HIGH));

        FIGHTERS.put(14, new ArrayList<>());
        FIGHTERS.get(14).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(14).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_10_30, FighterAltitude.HIGH));
        FIGHTERS.get(14).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_1_30, FighterAltitude.HIGH));
        FIGHTERS.get(14).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.LEVEL));

        FIGHTERS.put(15, new ArrayList<>());
        FIGHTERS.get(15).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(15).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_10_30, FighterAltitude.LEVEL));
        FIGHTERS.get(15).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_9, FighterAltitude.LEVEL));
        FIGHTERS.get(15).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_6, FighterAltitude.HIGH));
        FIGHTERS.get(15).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.VERTICAL_DIVE, FighterAltitude.HIGH));

        FIGHTERS.put(16, new ArrayList<>());

        FIGHTERS.put(21, new ArrayList<>());
        FIGHTERS.get(21).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.VERTICAL_DIVE, FighterAltitude.HIGH));

        FIGHTERS.put(22, new ArrayList<>());
        FIGHTERS.get(22).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_12, FighterAltitude.LOW));
        FIGHTERS.get(22).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_10_30, FighterAltitude.LOW));

        FIGHTERS.put(23, new ArrayList<>());
        FIGHTERS.get(23).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(23).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_3, FighterAltitude.LEVEL));
        FIGHTERS.get(23).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_3, FighterAltitude.HIGH));

        FIGHTERS.put(24, new ArrayList<>());
        FIGHTERS.get(24).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(24).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_3, FighterAltitude.HIGH));
        FIGHTERS.get(24).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_9, FighterAltitude.HIGH));
        FIGHTERS.get(24).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_9, FighterAltitude.LEVEL));

        FIGHTERS.put(25, new ArrayList<>());
        FIGHTERS.get(25).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(25).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_1_30, FighterAltitude.HIGH));
        FIGHTERS.get(25).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_3, FighterAltitude.HIGH));
        FIGHTERS.get(25).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_6, FighterAltitude.HIGH));
        FIGHTERS.get(25).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_9, FighterAltitude.HIGH));

        FIGHTERS.put(26, new ArrayList<>());

        FIGHTERS.put(31, new ArrayList<>());
        FIGHTERS.get(31).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.VERTICAL_CLIMB, FighterAltitude.LOW));

        FIGHTERS.put(32, new ArrayList<>());
        FIGHTERS.get(32).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_10_30, FighterAltitude.HIGH));
        FIGHTERS.get(32).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_3, FighterAltitude.LEVEL));

        FIGHTERS.put(33, new ArrayList<>());
        FIGHTERS.get(33).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.LEVEL));
        FIGHTERS.get(33).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(33).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_1_30, FighterAltitude.LEVEL));

        FIGHTERS.put(34, new ArrayList<>());
        FIGHTERS.get(34).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_10_30, FighterAltitude.HIGH));
        FIGHTERS.get(34).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.VERTICAL_CLIMB, FighterAltitude.LOW));

        FIGHTERS.put(35, new ArrayList<>());
        FIGHTERS.get(35).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.LEVEL));
        FIGHTERS.get(35).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_1_30, FighterAltitude.LOW));

        FIGHTERS.put(36, new ArrayList<>());

        FIGHTERS.put(41, new ArrayList<>());
        FIGHTERS.get(41).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.HIGH));

        FIGHTERS.put(42, new ArrayList<>());
        FIGHTERS.get(42).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.LEVEL));
        FIGHTERS.get(42).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_1_30, FighterAltitude.HIGH));

        FIGHTERS.put(43, new ArrayList<>());
        FIGHTERS.get(43).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(43).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_1_30, FighterAltitude.LEVEL));
        FIGHTERS.get(43).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_3, FighterAltitude.LEVEL));

        FIGHTERS.put(44, new ArrayList<>());
        FIGHTERS.get(44).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(44).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.LOW));
        FIGHTERS.get(44).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_1_30, FighterAltitude.LEVEL));
        FIGHTERS.get(44).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_6, FighterAltitude.LOW));

        FIGHTERS.put(45, new ArrayList<>());
        FIGHTERS.get(45).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_10_30, FighterAltitude.LEVEL));
        FIGHTERS.get(45).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.LEVEL));
        FIGHTERS.get(45).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_10_30, FighterAltitude.LOW));

        FIGHTERS.put(46, new ArrayList<>());

        FIGHTERS.put(51, new ArrayList<>());
        FIGHTERS.get(51).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_10_30, FighterAltitude.HIGH));

        FIGHTERS.put(52, new ArrayList<>());
        FIGHTERS.get(52).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_6, FighterAltitude.LEVEL));
        FIGHTERS.get(52).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_9, FighterAltitude.LOW));

        FIGHTERS.put(53, new ArrayList<>());
        FIGHTERS.get(53).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_12, FighterAltitude.LOW));
        FIGHTERS.get(53).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_10_30, FighterAltitude.LEVEL));
        FIGHTERS.get(53).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_6, FighterAltitude.LOW));

        FIGHTERS.put(54, new ArrayList<>());
        FIGHTERS.get(54).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.LOW));
        FIGHTERS.get(54).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.LEVEL));
        FIGHTERS.get(54).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(54).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_9, FighterAltitude.HIGH));

        FIGHTERS.put(55, new ArrayList<>());
        FIGHTERS.get(55).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.LOW));
        FIGHTERS.get(55).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.LEVEL));
        FIGHTERS.get(55).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(55).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_10_30, FighterAltitude.LEVEL));

        FIGHTERS.put(56, new ArrayList<>());

        FIGHTERS.put(61, new ArrayList<>());
        FIGHTERS.get(61).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.VERTICAL_DIVE, FighterAltitude.HIGH));

        FIGHTERS.put(62, new ArrayList<>());
        FIGHTERS.get(62).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_3, FighterAltitude.LOW));
        FIGHTERS.get(62).add(new FighterInfo(FighterType.FIGHTER_110, FighterApproach.AREA_1_30, FighterAltitude.LOW));

        FIGHTERS.put(63, new ArrayList<>());
        FIGHTERS.get(63).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_10_30, FighterAltitude.HIGH));
        FIGHTERS.get(63).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.HIGH));
        FIGHTERS.get(63).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_1_30, FighterAltitude.HIGH));

        FIGHTERS.put(64, new ArrayList<>());
        FIGHTERS.get(64).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_12, FighterAltitude.LEVEL));
        FIGHTERS.get(64).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_1_30, FighterAltitude.LEVEL));
        FIGHTERS.get(64).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_3, FighterAltitude.LOW));
        FIGHTERS.get(64).add(new FighterInfo(FighterType.FIGHTER_190, FighterApproach.AREA_9, FighterAltitude.HIGH));

        FIGHTERS.put(65, new ArrayList<>());
        FIGHTERS.get(65).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_12, FighterAltitude.LEVEL));
        FIGHTERS.get(65).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_3, FighterAltitude.HIGH));
        FIGHTERS.get(65).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_1_30, FighterAltitude.HIGH));
        FIGHTERS.get(65).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.AREA_6, FighterAltitude.HIGH));
        FIGHTERS.get(65).add(new FighterInfo(FighterType.FIGHTER_109, FighterApproach.VERTICAL_DIVE, FighterAltitude.HIGH));

        FIGHTERS.put(66, new ArrayList<>());
    }

    public static List<FighterInfo> get(boolean outOfFormation) {
        int r = Util.roll(2, false);
        if (r == 66) {
            // TODO Random Event
            return null;
        }
        while ((r == 16 || r == 26 || r == 36 || r == 46 || r == 56) && outOfFormation) {
            r = Util.roll(2, false);
        }
        return FIGHTERS.get(r);
    }


    private WaveCompositionTable() {
    }
}
