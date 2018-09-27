package b17.bomber;

import b17.crew.CrewMember;

public class Gun {
    private GunPosition position;
    private CrewMember crewMember;
    private int maxAmmo;
    private int ammoRemaining;

    public Gun( GunPosition position, int maxAmmo ) {
        this.position = position;
        this.crewMember = null;
        this.maxAmmo = maxAmmo;
        this.ammoRemaining = this.maxAmmo;
    }

    public GunPosition getPosition() {
        return position;
    }

    public void setPosition( GunPosition position ) {
        this.position = position;
    }

    public CrewMember getCrewMember() {
        return crewMember;
    }

    public void setCrewMember( CrewMember crewMember ) {
        this.crewMember = crewMember;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public void setMaxAmmo( int maxAmmo ) {
        this.maxAmmo = maxAmmo;
    }

    public int getAmmoRemaining() {
        return ammoRemaining;
    }

    public void setAmmoRemaining( int ammoRemaining ) {
        this.ammoRemaining = ammoRemaining;
    }
}
