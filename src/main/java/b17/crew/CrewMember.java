package b17.crew;

import b17.bomber.CrewPosition;

public class CrewMember {
    private String name;
    private CrewPosition defaultRole;
    private int kills;
    private CrewStatus status;

    public CrewMember( String name, CrewPosition defaultRole ) {
        this.name = name;
        this.defaultRole = defaultRole;
        this.kills = 0;
        this.status = CrewStatus.OK;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public CrewPosition getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole( CrewPosition defaultRole ) {
        this.defaultRole = defaultRole;
    }

    public int getKills() {
        return kills;
    }

    public void setKills( int kills ) {
        this.kills = kills;
    }

    public CrewStatus getStatus() {
        return status;
    }

    public void setStatus( CrewStatus status ) {
        this.status = status;
    }
}
