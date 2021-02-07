package b17.game.bomber;

public enum BomberStatus {
    WRECKED( "B-17 Wrecked" ),
    REPAIRABLE( "B-17 repairable by next mission" ),
    SAFE( "B-17 Safe" );

    private String name;
    BomberStatus( String name ) {
        this.name = name;
    }

    public String getName(){ return this.name; }
    public String toString(){ return this.name; }
}
