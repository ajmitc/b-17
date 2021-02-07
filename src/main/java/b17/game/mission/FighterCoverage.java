package b17.game.mission;

public enum FighterCoverage {
    GOOD( "Good" ),
    FAIR( "Fair" ),
    POOR( "Poor" );

    private String name;
    FighterCoverage( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
