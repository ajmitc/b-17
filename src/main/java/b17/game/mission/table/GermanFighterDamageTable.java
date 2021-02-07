package b17.game.mission.table;

import b17.game.bomber.GunPosition;
import b17.game.mission.FighterType;
import b17.game.mission.GermanFighterDamage;
import b17.util.Util;

/**
 * M-2
 */
public class GermanFighterDamageTable {

    public static GermanFighterDamage get(GunPosition gun, FighterType fighter) {
        int r = Util.roll();
        if (fighter != FighterType.FIGHTER_190 && (gun == GunPosition.TOP_TURRET || gun == GunPosition.BALL_TURRET || gun == GunPosition.TAIL_TURRET)) {
            r += 1;
        }
        if (fighter == FighterType.FIGHTER_190 && gun != GunPosition.TOP_TURRET && gun != GunPosition.BALL_TURRET && gun != GunPosition.TAIL_TURRET) {
            r -= 1;
        }
        if (r <= 2)
            return GermanFighterDamage.FCA;
        if (r <= 4)
            return GermanFighterDamage.FBOA;
        return GermanFighterDamage.DESTROYED;
    }

    private GermanFighterDamageTable() {
    }
}
