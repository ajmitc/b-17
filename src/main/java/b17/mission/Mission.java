package b17.mission;

import b17.bomber.Bomber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mission {
    private int missionNumber;
    private Target target;
    private TargetType targetType;
    private int targetZone;
    private Weather targetWeather;
    private FormationPosition formationPosition;
    private SquadronPosition squadronPosition;
    private Bomber bomber;
    private Map<Integer, FighterCoverage> fighterCoverageOut;
    private Map<Integer, FighterCoverage> fighterCoverageBack;
    private Map<Integer, Integer> fighterWavesModifiers;
    private Map<Integer, MapAreaCode> fighterWaveCodes;
    private Map<Integer, List<Integer>> fighterWavesOut;
    private Map<Integer, List<Integer>> fighterWavesBack;
    private Weather baseWeather;
    private int bombRunPercentage;
    private int landingModifier;

    public Mission( int missionNumber ) {
        this.missionNumber = missionNumber;
        target = null;
        targetType = null;
        targetZone = 0;
        targetWeather = null;
        formationPosition = null;
        squadronPosition = null;
        bomber = null;
        fighterCoverageOut = new HashMap<>();
        fighterCoverageBack = new HashMap<>();
        fighterWavesModifiers = new HashMap<>();
        fighterWaveCodes = new HashMap<>();
        fighterWavesOut = new HashMap<>();
        fighterWavesBack = new HashMap<>();
        baseWeather = null;
        bombRunPercentage = 0;
        landingModifier = 0;
    }

    public int getMissionNumber() {
        return missionNumber;
    }

    public void setMissionNumber( int missionNumber ) {
        this.missionNumber = missionNumber;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget( Target target ) {
        this.target = target;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType( TargetType targetType ) {
        this.targetType = targetType;
    }

    public int getTargetZone() {
        return targetZone;
    }

    public void setTargetZone( int targetZone ) {
        this.targetZone = targetZone;
    }

    public Weather getTargetWeather() {
        return targetWeather;
    }

    public void setTargetWeather( Weather targetWeather ) {
        this.targetWeather = targetWeather;
    }

    public FormationPosition getFormationPosition() {
        return formationPosition;
    }

    public void setFormationPosition( FormationPosition formationPosition ) {
        this.formationPosition = formationPosition;
    }

    public SquadronPosition getSquadronPosition() {
        return squadronPosition;
    }

    public void setSquadronPosition( SquadronPosition squadronPosition ) {
        this.squadronPosition = squadronPosition;
    }

    public Bomber getBomber() {
        return bomber;
    }

    public void setBomber( Bomber bomber ) {
        this.bomber = bomber;
    }

    public Map<Integer, FighterCoverage> getFighterCoverageOut() {
        return fighterCoverageOut;
    }

    public void setFighterCoverageOut( Map<Integer, FighterCoverage> fighterCoverageOut ) {
        this.fighterCoverageOut = fighterCoverageOut;
    }

    public Map<Integer, FighterCoverage> getFighterCoverageBack() {
        return fighterCoverageBack;
    }

    public void setFighterCoverageBack( Map<Integer, FighterCoverage> fighterCoverageBack ) {
        this.fighterCoverageBack = fighterCoverageBack;
    }

    public Map<Integer, Integer> getFighterWavesModifiers() {
        return fighterWavesModifiers;
    }

    public void setFighterWavesModifiers( Map<Integer, Integer> fighterWavesModifiers ) {
        this.fighterWavesModifiers = fighterWavesModifiers;
    }

    public Map<Integer, MapAreaCode> getFighterWaveCodes() {
        return fighterWaveCodes;
    }

    public void setFighterWaveCodes( Map<Integer, MapAreaCode> fighterWaveCodes ) {
        this.fighterWaveCodes = fighterWaveCodes;
    }

    public Map<Integer, List<Integer>> getFighterWavesOut() {
        return fighterWavesOut;
    }

    public void setFighterWavesOut( Map<Integer, List<Integer>> fighterWavesOut ) {
        this.fighterWavesOut = fighterWavesOut;
    }

    public Map<Integer, List<Integer>> getFighterWavesBack() {
        return fighterWavesBack;
    }

    public void setFighterWavesBack( Map<Integer, List<Integer>> fighterWavesBack ) {
        this.fighterWavesBack = fighterWavesBack;
    }

    public Weather getBaseWeather() {
        return baseWeather;
    }

    public void setBaseWeather( Weather baseWeather ) {
        this.baseWeather = baseWeather;
    }

    public int getBombRunPercentage() {
        return bombRunPercentage;
    }

    public void setBombRunPercentage( int bombRunPercentage ) {
        this.bombRunPercentage = bombRunPercentage;
    }

    public int getLandingModifier() {
        return landingModifier;
    }

    public void setLandingModifier( int landingModifier ) {
        this.landingModifier = landingModifier;
    }
}
