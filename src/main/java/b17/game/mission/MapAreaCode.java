package b17.game.mission;

public enum MapAreaCode {
    WATER( "W" ),
    FRANCE( "F" ),
    BELGIUM( "B" ),
    GERMANY( "G" ),
    NETHERLANDS( "N" );

    private String name;
    MapAreaCode( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
