package b17.crew;

public enum CrewStatus {
    OK( "OK" ),
    LIGHT_WOUND( "Light Wound" ),
    SERIOUS_WOUND( "Serious Wound" ),
    KIA( "Killed-In-Action" );

    private String name;
    CrewStatus( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
