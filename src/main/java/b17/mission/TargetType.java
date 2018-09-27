package b17.mission;

public enum TargetType {
    AIRFIELD( "Airfield" ),
    AIRCRAFT( "Aircraft" ),
    RAIL_YARD( "Rail Yard" ),
    SHIP_YARD( "Ship Yard" ),
    INDUSTRY( "Industry" ),
    U_BOATS( "U Boats" );

    private String name;
    TargetType( String name ) {
        this.name = name;
    }

    public String getName(){ return name; }
    public String toString(){ return name; }
}
