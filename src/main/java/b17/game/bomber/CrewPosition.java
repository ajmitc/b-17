package b17.game.bomber;

public enum CrewPosition {
    BOMBARDIER( "Bombardier" ),
    NAVIGATOR( "Navigator" ),
    PILOT( "Pilot" ),
    COPILOT( "Copilot" ),
    ENGINEER( "Engineer" ),
    RADIO_OPERATOR( "Radio Operator" ),
    BALL_GUNNER( "Ball Gunner" ),
    PORT_WAIST_GUNNER( "Port Waist Gunner" ),
    STBD_WAIST_GUNNER( "Stbd Waist Gunner" ),
    TAIL_GUNNER( "Tail Gunner" );

    private String name;
    CrewPosition( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
