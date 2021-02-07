package b17.game.mission.table;

import b17.game.mission.FighterApproach;
import b17.util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * M-3
 */
public class GermanOffensiveFireTable {
    private static final Map<FighterApproach, Integer> MINROLLS = new HashMap<>();

    static {
        MINROLLS.put(FighterApproach.AREA_12, 5);
        MINROLLS.put(FighterApproach.AREA_1_30, 5);
        MINROLLS.put(FighterApproach.AREA_10_30, 5);
        MINROLLS.put(FighterApproach.AREA_3, 4);
        MINROLLS.put(FighterApproach.AREA_9, 4);
        MINROLLS.put(FighterApproach.AREA_6, 3);
        MINROLLS.put(FighterApproach.VERTICAL_DIVE, 5);
        MINROLLS.put(FighterApproach.VERTICAL_CLIMB, 4);
    }

    public static boolean isHit(FighterApproach area) {
        int r = Util.roll();
        if (r == 6)
            return true;
        if (r >= MINROLLS.get(area)) {
            return true;
        }
        return false;
    }
}
