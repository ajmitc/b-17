package b17.game;

import b17.game.bomber.Bomber;
import b17.game.mission.Mission;

public class Game {
    private Phase phase;
    private PhaseStep phaseStep;

    private Mission mission;
    private Bomber bomber;

    public Game() {
        setPhase(Phase.SETUP_MISSION);
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
        this.phaseStep = PhaseStep.START_PHASE;
    }

    public PhaseStep getPhaseStep() {
        return phaseStep;
    }

    public void setPhaseStep(PhaseStep phaseStep) {
        this.phaseStep = phaseStep;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Bomber getBomber() {
        return bomber;
    }

    public void setBomber(Bomber bomber) {
        this.bomber = bomber;
    }
}
