package b17.game.mission;

public enum Flak {
    NO_FLAK( "No Flak" ),
    LIGHT_FLAK( "Light Flak" ),
    MEDIUM_FLAK( "Medium Flak" ),
    HEAVY_FLAK( "Heavy Flak" );

    private String name;
    Flak( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
