package b17.bomber;

import b17.crew.CrewMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bomber {
    private String name;
    private int numMissionsCompleted;
    private BomberStatus bomberStatus;
    private List<CrewMember> crew;
    private Map<BomberAreaType, BomberArea> areas;
    private Map<GunPosition, Gun> guns;

    public Bomber() {
        this.name = "";
        this.numMissionsCompleted = 0;
        this.bomberStatus = BomberStatus.SAFE;
        this.crew = new ArrayList<>();
        this.areas = new HashMap<>();
        this.guns = new HashMap<>();

        for( GunPosition position: GunPosition.values() ) {
            Gun gun = new Gun( position, getMaxAmmo( position ) );
            guns.put( position, gun );
        }
    }

    public void assignCrewToPositions() {
        areas.get( BomberAreaType.NOSE              ).getCrewAssignments().put( CrewPosition.BOMBARDIER,        getCrewMemberByDefaultRole( CrewPosition.BOMBARDIER ) );
        areas.get( BomberAreaType.NOSE              ).getCrewAssignments().put( CrewPosition.NAVIGATOR,         getCrewMemberByDefaultRole( CrewPosition.NAVIGATOR  ) );
        areas.get( BomberAreaType.PILOT_COMPARTMENT ).getCrewAssignments().put( CrewPosition.PILOT,             getCrewMemberByDefaultRole( CrewPosition.PILOT ) );
        areas.get( BomberAreaType.PILOT_COMPARTMENT ).getCrewAssignments().put( CrewPosition.COPILOT,           getCrewMemberByDefaultRole( CrewPosition.COPILOT ) );
        areas.get( BomberAreaType.PILOT_COMPARTMENT ).getCrewAssignments().put( CrewPosition.ENGINEER,          getCrewMemberByDefaultRole( CrewPosition.ENGINEER ) );
        areas.get( BomberAreaType.RADIO_ROOM        ).getCrewAssignments().put( CrewPosition.RADIO_OPERATOR,    getCrewMemberByDefaultRole( CrewPosition.RADIO_OPERATOR ) );
        areas.get( BomberAreaType.WAIST             ).getCrewAssignments().put( CrewPosition.BALL_GUNNER,       getCrewMemberByDefaultRole( CrewPosition.BALL_GUNNER ) );
        areas.get( BomberAreaType.WAIST             ).getCrewAssignments().put( CrewPosition.PORT_WAIST_GUNNER, getCrewMemberByDefaultRole( CrewPosition.PORT_WAIST_GUNNER ) );
        areas.get( BomberAreaType.WAIST             ).getCrewAssignments().put( CrewPosition.STBD_WAIST_GUNNER, getCrewMemberByDefaultRole( CrewPosition.STBD_WAIST_GUNNER ) );
        areas.get( BomberAreaType.TAIL              ).getCrewAssignments().put( CrewPosition.TAIL_GUNNER,       getCrewMemberByDefaultRole( CrewPosition.TAIL_GUNNER ) );
    }

    public CrewMember getCrewMemberByDefaultRole( CrewPosition role ) {
        for( CrewMember crewMember: this.crew ) {
            if( crewMember.getDefaultRole() == role ) {
                return crewMember;
            }
        }
        return null;
    }

    public int getMaxAmmo( GunPosition position ) {
        switch( position ) {
            case NOSE:
                return 15;
            case PORT_CHEEK:
                return 10;
            case STBD_CHEEK:
                return 10;
            case TOP_TURRET:
                return 16;
            case BALL_TURRET:
                return 20;
            case TAIL_TURRET:
                return 23;
            case STBD_WAIST:
                return 20;
            case PORT_WAIST:
                return 20;
            case RADIO:
                return 10;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getNumMissionsCompleted() {
        return numMissionsCompleted;
    }

    public void setNumMissionsCompleted( int numMissionsCompleted ) {
        this.numMissionsCompleted = numMissionsCompleted;
    }

    public BomberStatus getBomberStatus() {
        return bomberStatus;
    }

    public void setBomberStatus( BomberStatus bomberStatus ) {
        this.bomberStatus = bomberStatus;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public void setCrew( List<CrewMember> crew ) {
        this.crew = crew;
    }

    public Map<BomberAreaType, BomberArea> getAreas() {
        return areas;
    }

    public void setAreas( Map<BomberAreaType, BomberArea> areas ) {
        this.areas = areas;
    }

    public Map<GunPosition, Gun> getGuns() {
        return guns;
    }

    public void setGuns( Map<GunPosition, Gun> guns ) {
        this.guns = guns;
    }
}
