package b17.game.mission;

public enum FighterApproach {
    AREA_12( "12" ),
    AREA_1_30( "1:30" ),
    AREA_3( "3" ),
    AREA_6( "6" ),
    AREA_9( "9" ),
    AREA_10_30( "10:30" ),
    VERTICAL_CLIMB( "Vertical Climb" ),
    VERTICAL_DIVE( "Vertical Dive" );

    private String name;
    FighterApproach( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
