package b17;

import b17.game.Phase;
import b17.game.PhaseStep;
import b17.game.bomber.Gun;
import b17.game.bomber.GunPosition;
import b17.game.mission.Direction;
import b17.game.mission.FighterType;
import b17.game.mission.GermanFighter;
import b17.game.mission.Mission;
import b17.game.mission.table.*;
import b17.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    private Model model;
    private View view;

    public Controller( Model model, View view ) {
        this.model = model;
        this.view = view;

        this.view.getMainMenuPanel().getBtnExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.view.getMainMenuPanel().getBtnNewCampaign().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.view.getMainMenuPanel().getBtnNewMission().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    protected void run(){
        while (model.getGame() != null && model.getGame().getPhase() != Phase.GAMEOVER){
            switch (model.getGame().getPhase()){
                case SETUP_MISSION:{
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            // Pre-Mission Steps
                            // 1.1.Roll target city (G-1 , G-2 or G-3)
                            // 1.2.Roll B-17 formation position; note attacking fighter modifier (G-4)
                            // 1.3.Roll flight log gazetteer; note attacking fighter modifier (G-11)
                            // 1.4.Combine and record modifications to attackers on Mission Chart
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        case END_PHASE:
                            model.getGame().setPhase(Phase.PLAY_MISSION);
                            break;
                    }
                }
                case PLAY_MISSION:{
                    Mission mission = model.getGame().getMission();
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_MOVE_NEXT_ZONE);
                            break;
                        // Flying to Target
                        case PLAY_MISSION_MOVE_NEXT_ZONE:
                            // 2.1. Move B-17 to next zone
                            //   A B-17 never spends more than two turns in one zone.
                            //   TODO If damaged by enemy fighters, may abort.  Must abort if 2+ engines out
                            boolean mustMove = mission.getTurnsInCurrentZone() >= 2;
                            if (!mustMove){
                                // TODO Ask player if they want to move to next zone
                            }

                            int currentZone = model.getGame().getMission().getZone();
                            if (model.getGame().getMission().getDirection() == Direction.TO_TARGET){
                                model.getGame().getMission().setZone(currentZone + 1);
                            }
                            else {
                                model.getGame().getMission().setZone(currentZone - 1);
                            }

                            // 2.2. Roll for fighter cover in Zones 2, 3 & 4 (G-5)
                            //   This step is unnecessary in Zone 1, see next footnote. Fighter cover does not extend past Zone 4.
                            if (mission.getZone() >= 2 && mission.getZone() <= 4){
                                if (mission.getDirection() == Direction.TO_TARGET)
                                    mission.getFighterCoverageOut().put(mission.getZone(), FighterCoverageTable.getFighterCoverage(model.getGame().getMission().getMissionNumber()));
                                else
                                    mission.getFighterCoverageBack().put(mission.getZone(), FighterCoverageTable.getFighterCoverage(model.getGame().getMission().getMissionNumber()));
                            }
                            // 2.3. Roll for number of attacking fighter waves (B-1 or B-2)
                            //   In Zone 1, no attacking waves form.
                            if (mission.getZone() > 1){
                                int waves = NumberGermanFighterWavesTable.get(false);
                                mission.setNumGermanFighterWaves(waves);
                            }
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_FIGHTER_WAVE);
                            break;
                        case PLAY_MISSION_FIGHTER_WAVE:
                            if (mission.getNumGermanFighterWaves() == 0){
                                model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_ANTIAIRCRAFT_FIRE);
                                break;
                            }

                            // 2.4. Repeat until all waves complete --
                            if (mission.getCurrentGermanFighterWave() >= mission.getNumGermanFighterWaves()){
                                model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_ANTIAIRCRAFT_FIRE);
                                break;
                            }

                            mission.setCurrentGermanFighterWave(mission.getCurrentGermanFighterWave() + 1);

                            // 2.4.1. Roll for attacking fighters in wave (B-3)
                            List<FighterInfo> fighterInfoList = WaveCompositionTable.get(mission.isOutOfFormation());
                            if (mission.getDirection() == Direction.TO_TARGET) {
                                if (!mission.getFighterWavesOut().containsKey(mission.getZone()))
                                    mission.getFighterWavesOut().put(mission.getZone(), new ArrayList<>());
                                mission.getFighterWavesOut().get(mission.getZone()).add(fighterInfoList);
                            }
                            else {
                                if (!mission.getFighterWavesBack().containsKey(mission.getZone()))
                                    mission.getFighterWavesBack().put(mission.getZone(), new ArrayList<>());
                                mission.getFighterWavesBack().get(mission.getZone()).add(fighterInfoList);
                            }

                            List<GermanFighter> germanFighters = new ArrayList<>();
                            fighterInfoList.stream().forEach(fi -> {
                                germanFighters.add(new GermanFighter(fi));
                            });
                            mission.setCurrentWaveFighters(germanFighters);

                            // 2.4.2. Roll for fighter cover defense. (M-4)
                            int fighterCoverDefense = 0;
                            if (mission.getDirection() == Direction.TO_TARGET) {
                                if (mission.getFighterCoverageOut().containsKey(mission.getZone())){
                                    if (mission.getNumWaveAttacks() == 1)
                                        fighterCoverDefense = FighterCoverDefenseTable.getInitialAttackDefense(mission.getBaseWeather());
                                    else
                                        fighterCoverDefense = FighterCoverDefenseTable.getSuccessiveAttackDefense(mission.getBaseWeather());
                                }
                            }
                            else {
                                if (mission.getFighterCoverageBack().containsKey(mission.getZone())){
                                    if (mission.getNumWaveAttacks() == 1)
                                        fighterCoverDefense = FighterCoverDefenseTable.getInitialAttackDefense(mission.getBaseWeather());
                                    else
                                        fighterCoverDefense = FighterCoverDefenseTable.getSuccessiveAttackDefense(mission.getBaseWeather());
                                }
                            }
                            mission.setNumFighterDefenseLeft(fighterCoverDefense);
                            mission.setNumWaveAttacks(0);
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_FIGHTER_WAVE_ATTACK);
                            break;
                        case PLAY_MISSION_FIGHTER_WAVE_ATTACK:
                            mission.incNumWaveAttacks();
                            if (mission.getNumWaveAttacks() > 3){
                                model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_FIGHTER_WAVE);
                                break;
                            }
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_FIGHTER_WAVE_ATTACK_CONTINUE);
                            break;
                        // 2.4.3. Repeat for 3 attacks max (initial, 1st & 2nd successive)
                        case PLAY_MISSION_FIGHTER_WAVE_ATTACK_CONTINUE:
                            // 2.4.3.1. If Successive Attack, roll bearing (B-6)
                            // 2.4.3.2. Place attacking fighters on board
                            // 2.4.3.3. Remove attackers from fighter cover defense
                            if (mission.getNumFighterDefenseLeft() > 0){
                                model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_FIGHTER_WAVE_ATTACK_FIGHTER_DEFENSE);
                                break;
                            }
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_FIGHTER_WAVE_ATTACK_B17_PLACE_FIRE);
                            break;
                        case PLAY_MISSION_FIGHTER_WAVE_ATTACK_B17_PLACE_FIRE:
                            // TODO 2.4.3.4. Place B-17 defensive fire counters
                            //    Only two of three guns may fire amongst nose and cheek guns combined.
                            //    Tail gunner may not fire passing shots if intercom is out.
                            //    Optional Rule 20.0: German fighter pilot status (aces, green pilots)
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_FIGHTER_WAVE_ATTACK_B17_FIRE);
                            break;
                        case PLAY_MISSION_FIGHTER_WAVE_ATTACK_B17_FIRE:
                            // Get german fighters
                            List<FighterInfo> fighterInfos =
                                    mission.getDirection() == Direction.TO_TARGET?
                                            mission.getFighterWavesOut().get(mission.getZone()).get(mission.getNumWaveAttacks()):
                                            mission.getFighterWavesBack().get(mission.getZone()).get(mission.getNumWaveAttacks());
                            for (FighterInfo fighterInfo: fighterInfos){
                                Map<GunPosition, Map<FighterType, Integer>> defFire =
                                        DefensiveFireTable.getGuns(fighterInfo.approach, fighterInfo.altitude);
                            }
                            // 2.4.3.5. For each B-17 gun firing
                            for (Map.Entry<GunPosition, Gun> entry: model.getGame().getBomber().getGuns().entrySet()) {
                                if (entry.getValue().isFireThisTurn()) {
                                    // 2.4.3.5.1. If spray fire then
                                    // 2.4.3.5.1.1. Resolve spray fire (M-5)
                                    // 2.4.3.5.2. If not spray fire
                                    // 2.4.3.5.2.1. Roll for hit (marking ammo spent) (M-1)
                                    //    After 5th kill, gunner is immediately an ace and adds one to his roll. Bonus does not apply if wounded/frostbitten.
                                    for (FighterInfo fighterInfo: fighterInfos){
                                        Map<GunPosition, Map<FighterType, Integer>> defFire =
                                                DefensiveFireTable.getGuns(fighterInfo.approach, fighterInfo.altitude);
                                    }
                                    // 2.4.3.5.2.2. If hit, resolve damage and result (M-2)
                                    GermanFighterDamageTable.get(entry.getKey(), null);
                                }
                            }
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_FIGHTER_WAVE_ATTACK);
                            break;
                        case PLAY_MISSION_FIGHTER_WAVE_ATTACK_GERMAN_FIRE:
                            // 2.4.3.6. For each attacker remaining
                            // 2.4.3.6.1. Roll for hit - if hit (M-3)
                            // 2.4.3.6.1.1. Roll for shell hits to B-17  (B-4)
                            //     If attacker is FW-190, multiply rolled number of hits by 1.5 and round down for actual number of hits.
                            // 2.4.3.6.1.2. Roll for area damage (B-5)
                            // 2.4.3.6.1.3. Resolve fuselage/tail damage (P-1 thru P-6)
                            //     Heat out: after moving one more zone, either drop out of formation below 10k ft or check for frostbite.
                            //     After two hits on crew member’s oxygen:  unless he can move to open station with oxygen, plane must drop out of formation below 10k ft. May ascend later, but always out of formation
                            // 2.4.3.6.1.4. Resolve wing/instrument/exting’r damage (BL-1 thru BL-3)
                            //     One engine out: must jettison bombs to stay in formation.
                            //     Two engines out: must jettison bombs and drop from formation below 10k ft. Attackers +1 on table M-3. No evasive action.
                            //     Three engines out: must jettison everything, drop from formation below 10k ft, and either bail out crash land after 2 more zones max. Attackers add +1 on table M-3. No evasive action.
                            // 2.4.3.6.1.5. Resolve crew injuries/frostbite (BL-4/BL-5)
                            // 2.4.3.6.1.6. Place 1st or 2nd Successive Attack marker
                            // 2.4.3.6.2. If no hit remove attacker
                            //   If B-17 is out of formation, attackers which do not hit remain in play –see Out of Formation Summary.
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_ANTIAIRCRAFT_FIRE);
                            break;
                        case PLAY_MISSION_FIGHTER_WAVE_ATTACK_FIGHTER_DEFENSE:
                            // TODO If all enemy fighters destroyed or all defensive hits taken, then continue with attack
                            if (mission.getNumFighterDefenseLeft() >= 0)
                                return;
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_FIGHTER_WAVE_ATTACK_CONTINUE);
                            break;
                        case PLAY_MISSION_ANTIAIRCRAFT_FIRE:
                            // Resolve anti-aircraft fire and bomb run
                            // 3.1. Roll for weather over target (O-1)
                            // 3.2. Roll for heavy/medium/light flak over target (O-2)
                            // 3.2.1. Roll for flak to hit (O-3)
                            // 3.2.2. For each “flak to hit”
                            // 3.2.2.1. Roll number of flak hits (O-4)
                            // 3.2.2.2. For number each flak hit
                            // 3.2.2.2.1. Roll for area damage (O-5)
                            // 3.2.2.2.2. Resolve fuselage/tail damage (P-1 thru P-6)
                            // 3.2.2.2.3. Resolve wing/instrument/exting’r damage (BL-1 thru BL-3)
                            //  See previous footnotes for engines out and oxygen out.See Out of Formation Summary.
                            // 3.2.2.2.4. Resolve crew injuries (BL-4)
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_BOMB_RUN);
                            break;
                        case PLAY_MISSION_BOMB_RUN:
                            // 3.3. Roll for bomb run on/off target O-6)
                            // 3.4. Roll for percentage of bombs within 1000 ft. of aiming point (O-7)
                            model.getGame().setPhaseStep(PhaseStep.PLAY_MISSION_MOVE_NEXT_ZONE);
                            break;
                            //
                            // 4. Returning home –repeat 2. above
                            //
                        // 5. Landing and AAR
                        case PLAY_MISSION_LANDING:
                            // 5.1.Roll for weather over base (O-1)
                            // 5.2. Roll for landing, applying modifiers (G9 or G-10)
                            // 5.3. Resolve crew disposition (BL-4/BL-5 notes)
                            // 5.4. Scrap aircraft if BIP or crash landing
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                            //
                            // 6. Out of Formation Summary
                            // 6.1.Add one Me-109 at 12 Level each attacking wave.
                            // 6.2. Modifiers on B-1 or B-2 are now 0.
                            // 6.3. Ignore added attacker for lead or tail bomber.
                            // 6.4. All fighters make three attacks unless destroyed or FBOA’d
                            // 6.5. If below 10k ft, take light flak each turn
                            // 6.5.1. Roll for flak to hit (only 2 times) (O-3)
                            // 6.5.2. For each “flak to hit”
                            // 6.5.2.1. Roll number of flak hits (O-4)
                            // 6.5.2.2. For number each flak hit
                            // 6.5.2.2.1. Roll for area damage (O-5)
                            // 6.5.2.2.2. Resolve fuselage/tail damage (P-1 thru P-6)
                            // 6.5.2.2.3. Resolve wing/instrument/exting’r damage (BL-1 thru BL-3)
                            //  See previous footnotes for engines out and oxygen out.See Out of Formation Summary.
                            // 6.5.2.2.4. Resolve crew injuries (BL-4)
                            // 6.6. May abort prior to bomb run.
                        case END_PHASE:
                            model.getGame().setPhase(Phase.TEARDOWN_MISSION);
                            break;
                    }
                }
                case TEARDOWN_MISSION:{
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        case END_PHASE:
                            model.getGame().setPhase(Phase.SETUP_MISSION);
                            break;
                    }
                }
            }
        }
    }
}
