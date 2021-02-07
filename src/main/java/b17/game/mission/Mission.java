package b17.game.mission;

import b17.game.mission.table.FighterInfo;

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
    private Map<Integer, FighterCoverage> fighterCoverageOut;
    private Map<Integer, FighterCoverage> fighterCoverageBack;
    private Map<Integer, Integer> fighterWavesModifiers;
    private Map<Integer, MapAreaCode> fighterWaveCodes;
    private Map<Integer, List<List<FighterInfo>>> fighterWavesOut;
    private Map<Integer, List<List<FighterInfo>>> fighterWavesBack;
    private Weather baseWeather;
    private int bombRunPercentage;
    private int landingModifier;
    private Direction direction;
    private boolean aborted;
    private int zone;
    private int turnsInCurrentZone;
    private boolean outOfFormation;

    // Temporary variables used to track in-game progress
    private int numGermanFighterWaves;
    private int currentGermanFighterWave;
    private int numWaveAttacks;
    private int numFighterDefenseLeft;
    private List<GermanFighter> currentWaveFighters;

    public Mission(int missionNumber) {
        this.missionNumber = missionNumber;
        target = null;
        targetType = null;
        targetZone = 0;
        targetWeather = null;
        formationPosition = null;
        squadronPosition = null;
        fighterCoverageOut = new HashMap<>();
        fighterCoverageBack = new HashMap<>();
        fighterWavesModifiers = new HashMap<>();
        fighterWaveCodes = new HashMap<>();
        fighterWavesOut = new HashMap<>();
        fighterWavesBack = new HashMap<>();
        baseWeather = null;
        bombRunPercentage = 0;
        landingModifier = 0;
        direction = Direction.TO_TARGET;
        aborted = false;
        zone = 1;
        turnsInCurrentZone = 0;
        outOfFormation = false;

        numGermanFighterWaves = 0;
        currentGermanFighterWave = 0;
        numWaveAttacks = 0;
        numFighterDefenseLeft = 0;
        currentWaveFighters = null;
    }

    public int getMissionNumber() {
        return missionNumber;
    }

    public void setMissionNumber(int missionNumber) {
        this.missionNumber = missionNumber;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public int getTargetZone() {
        return targetZone;
    }

    public void setTargetZone(int targetZone) {
        this.targetZone = targetZone;
    }

    public Weather getTargetWeather() {
        return targetWeather;
    }

    public void setTargetWeather(Weather targetWeather) {
        this.targetWeather = targetWeather;
    }

    public FormationPosition getFormationPosition() {
        return formationPosition;
    }

    public void setFormationPosition(FormationPosition formationPosition) {
        this.formationPosition = formationPosition;
    }

    public SquadronPosition getSquadronPosition() {
        return squadronPosition;
    }

    public void setSquadronPosition(SquadronPosition squadronPosition) {
        this.squadronPosition = squadronPosition;
    }

    public Map<Integer, FighterCoverage> getFighterCoverageOut() {
        return fighterCoverageOut;
    }

    public void setFighterCoverageOut(Map<Integer, FighterCoverage> fighterCoverageOut) {
        this.fighterCoverageOut = fighterCoverageOut;
    }

    public Map<Integer, FighterCoverage> getFighterCoverageBack() {
        return fighterCoverageBack;
    }

    public void setFighterCoverageBack(Map<Integer, FighterCoverage> fighterCoverageBack) {
        this.fighterCoverageBack = fighterCoverageBack;
    }

    public Map<Integer, Integer> getFighterWavesModifiers() {
        return fighterWavesModifiers;
    }

    public void setFighterWavesModifiers(Map<Integer, Integer> fighterWavesModifiers) {
        this.fighterWavesModifiers = fighterWavesModifiers;
    }

    public Map<Integer, MapAreaCode> getFighterWaveCodes() {
        return fighterWaveCodes;
    }

    public void setFighterWaveCodes(Map<Integer, MapAreaCode> fighterWaveCodes) {
        this.fighterWaveCodes = fighterWaveCodes;
    }

    public Map<Integer, List<List<FighterInfo>>> getFighterWavesOut() {
        return fighterWavesOut;
    }

    public void setFighterWavesOut(Map<Integer, List<List<FighterInfo>>> fighterWavesOut) {
        this.fighterWavesOut = fighterWavesOut;
    }

    public Map<Integer, List<List<FighterInfo>>> getFighterWavesBack() {
        return fighterWavesBack;
    }

    public void setFighterWavesBack(Map<Integer, List<List<FighterInfo>>> fighterWavesBack) {
        this.fighterWavesBack = fighterWavesBack;
    }

    public List<FighterInfo> getFighterWave(){
        return direction == Direction.TO_TARGET?
                this.fighterWavesOut.get(zone).get(this.fighterWavesOut.get(zone).size() - 1):
                this.fighterWavesBack.get(zone).get(this.fighterWavesBack.get(zone).size() - 1);
    }

    public Weather getBaseWeather() {
        return baseWeather;
    }

    public void setBaseWeather(Weather baseWeather) {
        this.baseWeather = baseWeather;
    }

    public int getBombRunPercentage() {
        return bombRunPercentage;
    }

    public void setBombRunPercentage(int bombRunPercentage) {
        this.bombRunPercentage = bombRunPercentage;
    }

    public int getLandingModifier() {
        return landingModifier;
    }

    public void setLandingModifier(int landingModifier) {
        this.landingModifier = landingModifier;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isAborted() {
        return aborted;
    }

    public void setAborted(boolean aborted) {
        this.aborted = aborted;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public boolean isOutOfFormation() {
        return outOfFormation;
    }

    public void setOutOfFormation(boolean outOfFormation) {
        this.outOfFormation = outOfFormation;
    }

    public int getTurnsInCurrentZone() {
        return turnsInCurrentZone;
    }

    public void setTurnsInCurrentZone(int turnsInCurrentZone) {
        this.turnsInCurrentZone = turnsInCurrentZone;
    }

    public int getNumGermanFighterWaves() {
        return numGermanFighterWaves;
    }

    public void setNumGermanFighterWaves(int numGermanFighterWaves) {
        this.numGermanFighterWaves = numGermanFighterWaves;
    }

    public int getCurrentGermanFighterWave() {
        return currentGermanFighterWave;
    }

    public void setCurrentGermanFighterWave(int currentGermanFighterWave) {
        this.currentGermanFighterWave = currentGermanFighterWave;
    }

    public int getNumWaveAttacks() {
        return numWaveAttacks;
    }

    public void setNumWaveAttacks(int numWaveAttacks) {
        this.numWaveAttacks = numWaveAttacks;
    }

    public void incNumWaveAttacks(){
        this.numWaveAttacks += 1;
    }

    public int getNumFighterDefenseLeft() {
        return numFighterDefenseLeft;
    }

    public void setNumFighterDefenseLeft(int numFighterDefenseLeft) {
        this.numFighterDefenseLeft = numFighterDefenseLeft;
    }

    public void decNumFighterDefenseLeft(){
        this.numFighterDefenseLeft -= 1;
    }

    public List<GermanFighter> getCurrentWaveFighters() {
        return currentWaveFighters;
    }

    public void setCurrentWaveFighters(List<GermanFighter> currentWaveFighters) {
        this.currentWaveFighters = currentWaveFighters;
    }
}
