package b17.mission;

public enum SquadronPosition {
    HIGH( "High" ),
    MIDDLE( "Middle" ),
    LOW( "Low" );

    private String desc;
    SquadronPosition( String desc ) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String toString(){ return desc; }
}
