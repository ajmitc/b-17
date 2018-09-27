package b17.mission;

public enum FighterAltitude {
    HIGH( "High" ),
    MIDDLE( "Middle" ),
    LOW( "Low" ),
    LEVEL( "Level" );

    private String name;
    FighterAltitude( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
