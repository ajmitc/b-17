package b17.game.mission.table;

import b17.game.mission.FighterAltitude;
import b17.game.mission.FighterApproach;
import b17.game.mission.FighterType;

public class FighterInfo {
    public FighterType fighterType;
    public FighterApproach approach;
    public FighterAltitude altitude;

    public FighterInfo(FighterType type, FighterApproach approach, FighterAltitude altitude) {
        this.fighterType = type;
        this.approach = approach;
        this.altitude = altitude;
    }
}
