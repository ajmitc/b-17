package b17.game.mission;

public enum Weather {
    BAD( "Bad" ),
    POOR( "Poor" ),
    FAIR( "Fair" ),
    GOOD( "Good" );

    private String name;
    Weather( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
