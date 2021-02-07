package b17.game.mission;

public enum Target {
    ABBEVILLE( "Abbeville" ),
    AMIENS( "Amiens" ),
    ANTWERP( "Antwerp" ),
    BREMEN( "Bremen" ),
    BREST( "Brest" ),
    CHERBOURG( "Cherbourg" ),
    EMDEN( "Emden" ),
    HAMM( "Hamm" ),
    KIEL( "Kiel" ),
    LA_ROCHELLE( "La Rochelle" ),
    LILLE( "Lille" ),
    LORIENT( "Lorient" ),
    MEAULTE( "Meaulte" ),
    PARIS( "Paris" ),
    RENNES( "Rennes" ),
    ROMILLY_SUR_SEINE( "Romilly-sur-Seine" ),
    ROTTERDAM( "Rotterdam" ),
    ROUEN( "Rouen" ),
    ST_OMER( "St. Omer" ),
    ST_NAZAIRE( "St. Nazaire" ),
    VEGESACK( "Vegesack" ),
    WILHELMSHAVEN( "Wilhelmshaven" );

    private String name;

    Target( String name ){
        this.name = name;
    }

    public String getName(){ return this.name; }
    public String toString(){ return this.name; }
}