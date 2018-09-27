package b17.bomber;

public enum GunPosition {
    NOSE( "Nose" ),
    TOP_TURRET( "Top Turret" ),
    BALL_TURRET( "Ball Turret" ),
    TAIL_TURRET( "Tail Turret" ),
    STBD_CHEEK( "Starboard Cheek" ),
    STBD_WAIST( "Starboard Waist" ),
    PORT_CHEEK( "Port Cheek" ),
    PORT_WAIST( "Port Waist" ),
    RADIO( "Radio" );

    private String name;
    GunPosition( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
