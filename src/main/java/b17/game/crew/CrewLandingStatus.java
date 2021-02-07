package b17.game.crew;

public enum CrewLandingStatus {
    KIA( "Crew KIA" ),
    ROLL_FOR_WOUNDS_PLUS_ONE( "Crew rolls for wounds (+1)" ),
    ROLL_FOR_WOUNDS( "Crew rolls for wounds" ),
    SAFE( "Crew Safe" ),
    LOST( "Crew lost" ),
    RESCUED( "Crew rescued" ),
    CAPTURED( "Crew captured" );

    private String name;
    CrewLandingStatus( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
