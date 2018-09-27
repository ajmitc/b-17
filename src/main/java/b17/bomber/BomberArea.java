package b17.bomber;

import b17.crew.CrewMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A specific area of the bomber
 */
public class BomberArea {
    private BomberAreaType type;
    private Map<CrewPosition, CrewMember> crewAssignments;
    private List<Damage> damage;

    public BomberArea( BomberAreaType type ) {
        this.type = type;
        this.crewAssignments = new HashMap<>();
        this.damage = new ArrayList<>();
    }

    public BomberAreaType getType() {
        return type;
    }

    public void setType( BomberAreaType type ) {
        this.type = type;
    }

    public Map<CrewPosition, CrewMember> getCrewAssignments() {
        return crewAssignments;
    }

    public void setCrewAssignments( Map<CrewPosition, CrewMember> crewAssignments ) {
        this.crewAssignments = crewAssignments;
    }

    public CrewMember getCrewMemberInPosition( CrewPosition position ) {
        if( crewAssignments.containsKey( position ) )
            return crewAssignments.get( position );
        return null;
    }

    public List<Damage> getDamage() {
        return damage;
    }

    public void setDamage( List<Damage> damage ) {
        this.damage = damage;
    }
}
