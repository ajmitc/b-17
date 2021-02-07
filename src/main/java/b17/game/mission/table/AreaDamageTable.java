package b17.game.mission.table;

import b17.game.mission.FighterAltitude;

import java.util.*;

import b17.game.bomber.BomberAreaType;
import b17.game.mission.FighterApproach;
import b17.util.Util;

/**
 * B-5
 */
public class AreaDamageTable {
    private static final String FRONT = "Front";
    private static final String SIDE = "Side";
    private static final String WING_ATTACKING_SIDE = "Wing - attacking side";
    private static final String FUSELAGE_A = "Fuselage (a)";
    private static final String FUSELAGE_C = "Fuselage (c)";
    private static final String WINGS = "Wings";
    private static final String SUPERFICIAL_DAMAGE = "Superficial Damage";
    private static final BomberAreaType[] FUSELAGE_A_EFFECT = {BomberAreaType.NOSE, BomberAreaType.PILOT_COMPARTMENT, BomberAreaType.BOMB_BAY, BomberAreaType.RADIO_ROOM, BomberAreaType.WAIST, BomberAreaType.TAIL};

    private static final Map<String, Map<FighterAltitude, List<String>>> AREAS = new HashMap<>();

    static {
        AREAS.put(FRONT, new HashMap<>());
        AREAS.get(FRONT).put(FighterAltitude.HIGH, Arrays.asList(new String[]{
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.RADIO_ROOM.name(),
                BomberAreaType.NOSE.name(),
                BomberAreaType.PILOT_COMPARTMENT.name(),
                null, //[PORT_WING, PORT_WING, PORT_WING, STBD_WING, STBD_WING, STBD_WING ],
                BomberAreaType.WAIST.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.BOMB_BAY.name(),
                FUSELAGE_A
        }));

        AREAS.get(FRONT).put(FighterAltitude.LEVEL, Arrays.asList(new String[]{
                BomberAreaType.PORT_WING.name(),
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.PORT_WING.name(),
                BomberAreaType.NOSE.name(),
                BomberAreaType.STBD_WING.name(),
                BomberAreaType.PILOT_COMPARTMENT.name(),
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.STBD_WING.name()
        }));

        AREAS.get(FRONT).put(FighterAltitude.LOW, Arrays.asList(new String[]{
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.RADIO_ROOM.name(),
                BomberAreaType.NOSE.name(),
                BomberAreaType.BOMB_BAY.name(),
                null, // [ PORT_WING, PORT_WING, PORT_WING, STBD_WING, STBD_WING, STBD_WING ],
                BomberAreaType.WAIST.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.PILOT_COMPARTMENT.name(),
                FUSELAGE_A
        }));

        AREAS.put(SIDE, new HashMap<>());
        AREAS.get(SIDE).put(FighterAltitude.HIGH, Arrays.asList(new String[]{
                WINGS,
                BomberAreaType.NOSE.name(),
                BomberAreaType.PILOT_COMPARTMENT.name(),
                BomberAreaType.BOMB_BAY.name(),
                BomberAreaType.PORT_WING.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.STBD_WING.name(),
                BomberAreaType.RADIO_ROOM.name(),
                BomberAreaType.WAIST.name(),
                SUPERFICIAL_DAMAGE,
                FUSELAGE_A
        }));

        AREAS.get(SIDE).put(FighterAltitude.LEVEL, Arrays.asList(new String[]{
                BomberAreaType.BOMB_BAY.name(),
                WING_ATTACKING_SIDE,
                BomberAreaType.NOSE.name(),
                BomberAreaType.WAIST.name(),
                WING_ATTACKING_SIDE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.TAIL.name(),
                BomberAreaType.RADIO_ROOM.name(),
                BomberAreaType.PILOT_COMPARTMENT.name(),
                FUSELAGE_C
        }));

        AREAS.get(SIDE).put(FighterAltitude.LOW, Arrays.asList(new String[]{
                WINGS,
                BomberAreaType.NOSE.name(),
                BomberAreaType.BOMB_BAY.name(),
                BomberAreaType.RADIO_ROOM.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.PORT_WING.name(),
                BomberAreaType.STBD_WING.name(),
                SUPERFICIAL_DAMAGE,
                BomberAreaType.WAIST.name(),
                BomberAreaType.PILOT_COMPARTMENT.name(),
                FUSELAGE_A
        }));

        AREAS.put(FighterApproach.AREA_6.name(), new HashMap<>());
        AREAS.get(FighterApproach.AREA_6.name()).put(FighterAltitude.HIGH, Arrays.asList(new String[]{
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.RADIO_ROOM.name(),
                BomberAreaType.BOMB_BAY.name(),
                BomberAreaType.PORT_WING.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.STBD_WING.name(),
                BomberAreaType.WAIST.name(),
                BomberAreaType.PILOT_COMPARTMENT.name(),
                FUSELAGE_A,
                BomberAreaType.NOSE.name()
        }));

        AREAS.get(FighterApproach.AREA_6.name()).put(FighterAltitude.LEVEL, Arrays.asList(new String[]{
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.TAIL.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.PORT_WING.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.STBD_WING.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.WAIST.name(),
                SUPERFICIAL_DAMAGE
        }));

        AREAS.get(FighterApproach.AREA_6.name()).put(FighterAltitude.LOW, Arrays.asList(new String[]{
                BomberAreaType.NOSE.name(),
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.BOMB_BAY.name(),
                BomberAreaType.PORT_WING.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.STBD_WING.name(),
                BomberAreaType.WAIST.name(),
                BomberAreaType.RADIO_ROOM.name(),
                FUSELAGE_A,
                BomberAreaType.PILOT_COMPARTMENT.name()
        }));

        AREAS.put(FighterApproach.VERTICAL_DIVE.name(), new HashMap<>());
        AREAS.get(FighterApproach.VERTICAL_DIVE.name()).put(FighterAltitude.HIGH, Arrays.asList(new String[]{
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.BOMB_BAY.name(),
                BomberAreaType.RADIO_ROOM.name(),
                BomberAreaType.PORT_WING.name(),
                FUSELAGE_A,
                BomberAreaType.STBD_WING.name(),
                BomberAreaType.PILOT_COMPARTMENT.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.WAIST.name(),
                BomberAreaType.NOSE.name()
        }));

        AREAS.put(FighterApproach.VERTICAL_CLIMB.name(), new HashMap<>());
        AREAS.get(FighterApproach.VERTICAL_CLIMB.name()).put(FighterAltitude.LOW, Arrays.asList(new String[]{
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BomberAreaType.BOMB_BAY.name(),
                BomberAreaType.TAIL.name(),
                BomberAreaType.PORT_WING.name(),
                BomberAreaType.RADIO_ROOM.name(),
                BomberAreaType.STBD_WING.name(),
                FUSELAGE_A,
                BomberAreaType.PILOT_COMPARTMENT.name(),
                BomberAreaType.WAIST.name(),
                BomberAreaType.NOSE.name()
        }));
    }

    public static List<BomberAreaType> get(FighterApproach approach, FighterAltitude altitude) {
        List<BomberAreaType> hitAreas = new ArrayList<>();

        String key = approach.name();
        if (approach == FighterApproach.AREA_12 || approach == FighterApproach.AREA_1_30 || approach == FighterApproach.AREA_10_30) {
            key = FRONT;
        } else if (approach == FighterApproach.AREA_3 || approach == FighterApproach.AREA_9) {
            key = SIDE;
        }

        int r = Util.roll(2, true) - 2;

        Map<FighterAltitude, List<String>> altitudeMap = AREAS.get(key);

        if (approach == FighterApproach.VERTICAL_CLIMB) {
            String effect = altitudeMap.get(FighterAltitude.LOW).get(r);
            if (effect.equals(SUPERFICIAL_DAMAGE)) {
                return hitAreas;
            } else if (effect.equals(FUSELAGE_A)) {
                return Arrays.asList(FUSELAGE_A_EFFECT);
            }
            hitAreas.add(BomberAreaType.valueOf(effect));
        } else if (approach == FighterApproach.VERTICAL_DIVE) {
            String effect = altitudeMap.get(FighterAltitude.HIGH).get(r);
            if (effect.equals(SUPERFICIAL_DAMAGE)) {
                return hitAreas;
            } else if (effect.equals(FUSELAGE_A)) {
                return Arrays.asList(FUSELAGE_A_EFFECT);
            }
            hitAreas.add(BomberAreaType.valueOf(effect));
        }

        if (!hitAreas.isEmpty())
            return hitAreas;

        String target = altitudeMap.get(altitude).get(r);
        if (target == null) {
            if (key.equals(FRONT) && (altitude == FighterAltitude.HIGH || altitude == FighterAltitude.LOW) && r == 6) {
                hitAreas.add(Util.roll() <= 3 ? BomberAreaType.PORT_WING : BomberAreaType.STBD_WING);
            } else {
                // This should never execute
                return null;
            }
        } else if (target.equals(WING_ATTACKING_SIDE)) {
            if (approach == FighterApproach.AREA_3) {
                hitAreas.add(BomberAreaType.STBD_WING);
            } else {
                hitAreas.add(BomberAreaType.PORT_WING);
            }
        } else if (target.equals(FUSELAGE_A)) {
            hitAreas.addAll(Arrays.asList(FUSELAGE_A_EFFECT));
        } else if (target.equals(WINGS)) {
            if (approach == FighterApproach.AREA_3) {
                hitAreas.add(BomberAreaType.STBD_WING);
                hitAreas.add(BomberAreaType.STBD_WING);
            } else {
                hitAreas.add(BomberAreaType.PORT_WING);
                hitAreas.add(BomberAreaType.PORT_WING);
            }
        } else if (target.equals(FUSELAGE_C)) {
            hitAreas.add(BomberAreaType.NOSE);
            hitAreas.add(approach == FighterApproach.AREA_3 ? BomberAreaType.STBD_WING : BomberAreaType.PORT_WING);
            hitAreas.add(BomberAreaType.WAIST);
            hitAreas.add(BomberAreaType.TAIL);
        }
        return hitAreas;
    }

    private AreaDamageTable() {
    }
}

