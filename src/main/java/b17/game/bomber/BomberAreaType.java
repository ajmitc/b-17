package b17.game.bomber;

public enum BomberAreaType {
    NOSE( "Nose" ),
    PILOT_COMPARTMENT( "Pilot Compartment" ),
    BOMB_BAY( "Bomb Bay" ),
    RADIO_ROOM( "Radio Room" ),
    WAIST( "Waist" ),
    TAIL( "Tail" ),
    PORT_WING( "Port Wing" ),
    STBD_WING( "Starboard Wing" );

    private String name;
    BomberAreaType( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
