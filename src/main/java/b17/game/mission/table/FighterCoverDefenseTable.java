package b17.game.mission.table;

import b17.game.mission.Weather;
import b17.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * M-4
 */
public class FighterCoverDefenseTable {
    private static Map<Weather, List<Integer>> INITIAL_ATTACK_TABLE = new HashMap<>();
    private static Map<Weather, List<Integer>> SUCCESSIVE_ATTACK_TABLE = new HashMap<>();

    static {
        INITIAL_ATTACK_TABLE.put(Weather.POOR, new ArrayList<>());
        SUCCESSIVE_ATTACK_TABLE.put(Weather.POOR, new ArrayList<>());
        INITIAL_ATTACK_TABLE.put(Weather.FAIR, new ArrayList<>());
        SUCCESSIVE_ATTACK_TABLE.put(Weather.FAIR, new ArrayList<>());
        INITIAL_ATTACK_TABLE.put(Weather.GOOD, new ArrayList<>());
        SUCCESSIVE_ATTACK_TABLE.put(Weather.GOOD, new ArrayList<>());

        INITIAL_ATTACK_TABLE.get(Weather.POOR).add(0);
        INITIAL_ATTACK_TABLE.get(Weather.POOR).add(0);
        INITIAL_ATTACK_TABLE.get(Weather.POOR).add(0);
        INITIAL_ATTACK_TABLE.get(Weather.POOR).add(0);
        INITIAL_ATTACK_TABLE.get(Weather.POOR).add(0);
        INITIAL_ATTACK_TABLE.get(Weather.POOR).add(1);
        INITIAL_ATTACK_TABLE.get(Weather.POOR).add(1);

        SUCCESSIVE_ATTACK_TABLE.get(Weather.POOR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.POOR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.POOR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.POOR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.POOR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.POOR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.POOR).add(0);

        INITIAL_ATTACK_TABLE.get(Weather.FAIR).add(0);
        INITIAL_ATTACK_TABLE.get(Weather.FAIR).add(0);
        INITIAL_ATTACK_TABLE.get(Weather.FAIR).add(0);
        INITIAL_ATTACK_TABLE.get(Weather.FAIR).add(1);
        INITIAL_ATTACK_TABLE.get(Weather.FAIR).add(1);
        INITIAL_ATTACK_TABLE.get(Weather.FAIR).add(2);
        INITIAL_ATTACK_TABLE.get(Weather.FAIR).add(2);

        SUCCESSIVE_ATTACK_TABLE.get(Weather.FAIR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.FAIR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.FAIR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.FAIR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.FAIR).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.FAIR).add(1);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.FAIR).add(1);

        INITIAL_ATTACK_TABLE.get(Weather.GOOD).add(0);
        INITIAL_ATTACK_TABLE.get(Weather.GOOD).add(1);
        INITIAL_ATTACK_TABLE.get(Weather.GOOD).add(1);
        INITIAL_ATTACK_TABLE.get(Weather.GOOD).add(2);
        INITIAL_ATTACK_TABLE.get(Weather.GOOD).add(2);
        INITIAL_ATTACK_TABLE.get(Weather.GOOD).add(3);
        INITIAL_ATTACK_TABLE.get(Weather.GOOD).add(3);

        SUCCESSIVE_ATTACK_TABLE.get(Weather.GOOD).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.GOOD).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.GOOD).add(0);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.GOOD).add(1);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.GOOD).add(1);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.GOOD).add(2);
        SUCCESSIVE_ATTACK_TABLE.get(Weather.GOOD).add(2);
    }

    public static int getInitialAttackDefense(Weather weather) {
        int r = Util.roll();
        return INITIAL_ATTACK_TABLE.get(weather).get(r);
    }

    public static int getSuccessiveAttackDefense(Weather weather) {
        int r = Util.roll();
        return SUCCESSIVE_ATTACK_TABLE.get(weather).get(r);
    }

    private FighterCoverDefenseTable() {
    }
}
