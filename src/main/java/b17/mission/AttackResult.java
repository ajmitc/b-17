package b17.mission;

public enum AttackResult {
    HIT( "Hit" ),
    MISS( "Miss" );

    private String name;
    AttackResult( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
