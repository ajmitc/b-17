package b17.mission;

public enum GermanFighterDamage {
    FCA( "Fighter damaged but continues attack at -1" ),
    FBOA( "Fighter damaged and breaks off after this attack -2" ),
    DESTROYED( "Fighter destroyed and may not fire at B-17" );

    private String name;
    GermanFighterDamage( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
