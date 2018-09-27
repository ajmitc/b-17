package b17.mission;

public enum FighterType {
    FIGHTER_109( "Me 109" ),
    FIGHTER_110( "Me 110" ),
    FIGHTER_190( "Fw 190" );

    private String name;
    FighterType( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
