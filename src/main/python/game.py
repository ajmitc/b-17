from mission import Mission
from bomber import Bomber
from table import *
from constants import *

class Game( object ):
    def __init__( self ):
        self.missions = []
        self.mission = None
        self.bomber_zone = 1
        self.direction = OUT



class GameRunner( object ):
    def __init__(self):
        self.game = None


    def pause(self):
        raw_input("(Press Enter to continue)")

    def run(self):
        while True:
            print "B-17 Queen of the Skies"
            print "C) Continue Campaign"
            print "N) New Campaign"
            print "S) Settings"
            print "Q) Quit"
            inp = raw_input( "> " ).strip().lower()
            if inp == "":
                continue
            if inp == "c":
                print "Saving not yet implemented"
                self.pause()
                continue
            if inp == "n":
                print "Creating new campaign"
                self.game = Game()
                self.run_game()
                continue
            if inp == "s":
                print "Settings not yet implemented"
                self.pause()
                continue
            if inp == 'q':
                break


    def run_game(self):
        if self.game is None:
            return
        if self.game.mission is None:
            self.init_mission()
        numfighterwavestable = NumberOfGermanFighterWavesTable()
        weathertable = WeatherTable()
        flaktable = FlakTable()
        ontargettable = OnTargetTable()
        bombingaccuracytable = BombingAccuracyTable()
        while True:
            if self.game.bomber_zone == 1:
                print "Ready to take off.  Come on, boys!"
                self.pause()
            # Phase 1: Move bomber
            self.game.bomber_zone += (1 if self.game.direction == OUT else -1)
            # Phase 2: Determine weather if in target zone or base
            in_target_zone = self.game.bomber_zone == self.game.mission.target_zone
            in_base_zone = self.game.bomber_zone == 1
            print "Entering Zone %d %s" % (self.game.bomber_zone, "" if not in_base_zone and not in_target_zone else (" [TARGET]" if in_target_zone else " [BASE]"))
            if in_target_zone:
                # Get weather
                self.game.mission.weather_target = weathertable.get()
                print "Weather is %s" % (self.game.mission.weather_target)
            if in_base_zone:
                self.game.mission.weather_base = weathertable.get()
                print "Weather is %s" % (self.game.mission.weather_base)
            # Phase 3: Roll for number of attacking fighter waves
            num_waves = numfighterwavestable.get( in_target_zone, self.game.mission.weather_target )
            # Apply Flight Log Gazeteer modifier
            if not in_base_zone:
                modifier, _ = self.game.mission.fighter_waves_modifiers[ self.game.bomber_zone ]
                num_waves = max( num_waves + modifier, 0 )
                if num_waves > 0:
                    print "%d waves of enemy fighters approaching!" % (num_waves)
                else:
                    print "Skies are clear of enemy fighters."
                self.pause()
                for wave in xrange( num_waves ):
                    print "Wave %d" % (wave + 1)
                    self.run_wave()
            if in_target_zone and self.game.direction == OUT:
                print "Bomber is in Target Zone!"
                self.pause()
                # Flak
                flak, numhits = flaktable.get()
                if flak != NO_FLAK:
                    print "Bomber experiences %s" % flak
                else:
                    if numhits == 0:
                        print "Bomber is lucky and unhit!"
                    else:
                        print "Bomber hit %d time(s)" % numhits
                self.pause()
                for i in xrange( numhits ):
                    self.run_flak_hit()
                # Determine if on-target
                ontarget = ontargettable.is_on_target( self.game.mission.mission_number, numhits > 0, self.game.mission.bomber.crew[ BOMBARDIER ] )
                print "Bombs are %s" % ("ON TARGET" if ontarget else "OFF TARGET")
                self.pause()
                self.game.mission.bomb_run_percentage = bombingaccuracytable.get_accuracy( ontarget )
                print "Bomb Run: %d%% within 1000ft of aiming point" % self.game.mission.bomb_run_percentage
                self.pause()
                self.game.direction = BACK
            if in_base_zone:
                # Landing
                self.resolve_landing()
                # TODO Resolve crew disposition (BL-4, BL-5 notes)
                # TODO Resolve bomber disposition (safe, repairable, wrecked)
                print "Mission Complete!"
                self.game.mission.bomber.missions_completed += 1
                self.game.missions.append( self.game.mission )
                inp = raw_input( "Play next mission (Y/n)? " ).strip().lower()
                if inp in [ 'n', 'no' ]:
                    break
                self.game.mission = None
                self.init_mission()





    def run_wave(self):
        wavetable = WaveCompositionTable()
        fightercoverdefensetable = FighterCoverDefenseTable()
        fighterdamage = GermanFighterDamage()
        offensivefire = GermanOffensiveFire()
        shellhitstable = ShellHitsTable()
        areadamagetable = AreaDamageTable()
        bomberdamagetable = BomberDamageTable()
        # Get fighters in wave (B-3)
        enemies = wavetable.get(self.game.mission.position_in_formation == OUT_OF_FORMATION)
        for type, direction, altitude in enemies:
            print "Enemy %s at %s %s" % (type, direction, altitude)
        coverage = self.game.mission.fighter_coverage[ self.game.direction ][ self.game.bomber_zone ]
        coverage_initial, coverage_subsequent = fightercoverdefensetable.get( coverage )
        print "Fighter cover defense: %d(%d)" % (coverage_initial, coverage_subsequent)

        # Each plane attacks at most 3 times
        for attack_number in xrange( 3 ):
            chase_away = coverage_initial if attack_number == 0 else coverage_subsequent
            if chase_away >= len(enemies):
                enemies = []
                chase_away = 0
                print "Fighter escorts chase away all enemy fighters"
                self.pause()
                break
            while chase_away > 0 and len(enemies) > 0:
                # Let player choose enemy to chase away
                while True:
                    print "Enemy fighters left to chase away: %d" % chase_away
                    print "Choose enemy plane to chase away"
                    for index, enemy in enumerate( enemies ):
                        print "%d) %s at %s %s" % (index + 1, enemy[ 0 ], enemy[ 1 ], enemy[ 2 ])
                    inp = raw_input( "> " ).strip().lower()
                    if inp == "":
                        continue
                    try:
                        inp = int(inp) - 1
                    except:
                        print "Invalid entry"
                        continue
                    if inp < 0 or inp >= len(enemies):
                        print "Invalid entry"
                        continue
                    enemies.pop( inp )
                    chase_away -= 1
                    break
            if len(enemies) > 0:
                enemies = [ {'type': enemy[ 0 ], 'area': enemy[ 1 ], 'altitude': enemy[ 2 ], 'damage': "Undamaged" } for enemy in enemies ]
                # Player assigns guns to enemy fighters
                assignments = self.assign_guns( enemies )  # { gun: (enemy, minroll) }
                # Bomber fires on enemy fighters (mark ammo used)
                for gun, t in assignments.iteritems():
                    enemy, minroll = t
                    print "Bomber firing on %s at %s %s (%s) with %s" % (enemy[ 'type' ], enemy[ 'area' ], enemy[ altitude ], enemy[ 'damage' ], gun)
                    r = roll()
                    hit = r >= minroll
                    print "  Firing %s (min roll: %d) ... rolled a %d (%s)" % (gun, minroll, r, "HIT!" if hit else "MISS")
                    self.game.mission.bomber.guns[ gun ].ammo -= 1
                    if hit:
                        enemy[ 'damage' ] = fighterdamage.get( gun, enemy[ 0 ] )
                        print enemy[ 'damage' ]
                # Enemy fighters fire on bomber
                removefighters = []
                for enemy in enemies:
                    if enemy[ 'damage' ] == DESTROYED:
                        continue
                    hit = offensivefire.is_hit( enemy[ 'area' ] )
                    print "%s at %s %s is firing on bomber: %s" % (enemy[ 'type' ], enemy[ 'area' ], enemy[ 'altitude' ], "HIT!" if hit else "MISS")
                    if hit:
                        shellhits = shellhitstable.get( enemy[ 'area' ], enemy[ 'type' ] )
                        if shellhits == 0:
                            removefighters.append( enemy )
                        print "   %d shells hit" % shellhits
                        for i in xrange( shellhits ):
                            hitarea = areadamagetable.get( enemy[ 'area' ], enemy[ 'altitude' ] )
                            # Lookup actual damage
                            damage = bomberdamagetable.get( hitarea )
                            self.apply_damage( damage )
                # If enemy fighter misses, remove
                for enemy in removefighters:
                    enemies.remove( enemy )
                    print "%s scored no hits, it is breaking away" % enemy[ 'type' ]
                if len(enemies) > 0 and attack_number < 2:
                    print "%d enemy fighters circle around for another shot" % len(enemies)
            # Enemy fighters removed
            if len(enemies) > 0:
                print "%d enemy fighters break away" % len(enemies)
            enemies = []


    def assign_guns(self, enemies):
        defensivefiretable = DefensiveFireTable()
        index = 1
        for enemy in enemies:
            if 'guns' not in enemy.keys():
                enemy[ 'guns' ] = {}
            # Get guns that can hit that area/altitude
            guns = defensivefiretable.get_guns( enemy[ 'area' ], enemy[ 'altitude' ] )
            for gun, fighters in guns.iteritems():
                if self.game.mission.bomber.guns[ gun ].ammo > 0:
                    enemy[ 'guns' ][ gun ] = { "assigned": False, "minroll": fighters[ 'type' ], "index": index }
                    index += 1
        assigned_guns = []
        while True:
            for enemy in enemies:
                print "%s (%s %s): %s" % (enemy[ 'type' ], enemy[ 'area' ], enemy[ 'altitude' ], enemy[ 'damage' ])
                for gun, d in guns.iteritems():
                    if gun in assigned_guns:
                        continue
                    print "%d) %s (min roll: %d)" % (d[ 'index' ], gun, d[ 'minroll' ])
            print "0) Done"
            inp = raw_input( "Enable Gun> " ).strip().lower()
            try:
                inp = int(inp)
            except:
                print "Invalid selection"
                continue
            if inp == 0:
                break
            if inp < 1 or inp >= index:
                print "Invalid selection"
                continue
            found = False
            for enemy in enemies:
                for gun in enemy[ 'guns' ].keys():
                    if enemy[ 'guns' ][ gun ][ 'index' ] == inp:
                        enemy[ 'guns' ][ gun ][ 'assigned' ] = True
                        assigned_guns.append( gun )
                        found = True
                        break
                if found:
                    break
        ret = {}  # { gun: (enemy, minroll) }
        for enemy in enemies:
            for gun in enemy[ 'guns' ].keys():
                if enemy[ 'guns' ][ gun ][ 'assigned' ]:
                    minroll = 6
                    for gunname, d in guns.iteritems():
                        if gunname == gun:
                            minroll = d[ 'minroll' ]
                    ret[ gun ] = (enemy, minroll)
        return ret


    def apply_damage(self, damage):
        if damage in [ NO_EFFECT, SUPERFICIAL_DAMAGE ]:
            print "   %s: %s" % (SUPERFICIAL_DAMAGE, NO_EFFECT)
            return
        print "   %s" % (damage)
        if damage == NORDEN_SIGHT:
            pass
        if damage == NOSE_GUN_INOPERABLE:
            pass
        if damage == PORT_CHEEK_INOPERABLE:
            pass
        if damage == STBD_CHEEK_INOPERABLE:
            pass
        if damage == BOMBARDIER_AND_NAVIGATOR_HIT:
            pass
        if damage == NAVIGATOR:
            pass
        if damage == BOMBARDIER:
            pass
        if damage == NAVIGATOR_EQUIPMENT_INOPERABLE:
            pass
        if damage == BOMB_CONTROLS_INOPERABLE:
            pass
        if damage == BOMBARDIER_HEAT_OUT:
            pass
        if damage == NAVIGATOR_HEAT_OUT:
            pass
        if damage == BOMBARDIER_AND_NAVIGATOR_HEAT_OUT:
            pass
        if damage == BOMBARDIER_OXYGEN_HIT:
            pass
        if damage == NAVIGATOR_OXYGEN_HIT:
            pass
        if damage == BOMBARDIER_AND_NAVIGATOR_OXYGEN_HIT:
            pass
        if damage == FIRE_AND_NOSE_OXYGEN_OUT:
            pass
        if damage == PILOT_AND_COPILOT_HEAT_OUT:
            pass
        if damage == PILOT_AND_COPILOT_HIT:
            pass
        if damage == TOP_TURRET_INOPERABLE:
            pass
        if damage == TOP_TURRENT_INOPERABLE_AND_ENGINEER_HIT:
            pass
        if damage == INSTRUMENTS:
            pass
        if damage == PILOT_AND_COPILOT_OXYGEN_HIT:
            pass
        if damage == PILOT_OXYGEN_HIT:
            pass
        if damage == COPILOT_OXYGEN_HIT:
            pass
        if damage == ENGINEER_OXYGEN_HIT:
            pass
        if damage == FIRE_AND_PILOT_COMPARTMENT_OXYGEN_OUT:
            pass
        if damage == WINDOW:
            pass
        if damage == CONTROL_CABLES:
            pass
        if damage == BOMBS_DROP_MANUALLY:
            pass
        if damage == BOMBS_DETONATE:
            pass
        if damage == RUBBER_RAFTS_HIT:
            pass
        if damage == BOMB_BAY_DOORS_INOPERABLE:
            pass
        if damage == RADIO_ROOM_HEAT_OUT:
            pass
        if damage == INTERCOM_SYSTEM_OUT:
            pass
        if damage == RADIO_OUT:
            pass
        if damage == RADIO_ROOM_OXYGEN_HIT:
            pass
        if damage == FIRE_AND_RADIO_ROOM_OXYGEN_OUT:
            pass
        if damage == PORT_WAIST_OXYGEN_HIT:
            pass
        if damage == STBD_WAIST_OXYGEN_HIT:
            pass
        if damage == BALL_GUNNER_OXYGEN_HIT:
            pass
        if damage == FIRE_AND_WAIST_OXYGEN_OUT:
            pass
        if damage == PORT_WAIST_GUN_INOPERABLE:
            pass
        if damage == STBD_WAIST_GUN_INOPERABLE:
            pass
        if damage == BALL_GUNNER_HEAT_OUT:
            pass
        if damage == BALL_TURRET_INOPERABLE:
            pass
        if damage == BALL_TURRET_MECHANISM_INOPERABLE:
            pass
        if damage == PORT_WAIST_GUNNER_AND_STBD_WAIST_GUNNER_HIT:
            pass
        if damage == PORT_WAIST_GUNNER_HEAT_OUT:
            pass
        if damage == STBD_WAIST_GUNNER_HEAT_OUT:
            pass
        if damage == TAIL_GUNNER_HEAT_OUT:
            pass
        if damage == TAIL_WHEEL_DAMAGED:
            pass
        if damage == AUTOPILOT_INOPERABLE:
            pass
        if damage == TAIL_TURRET_INOPERABLE:
            pass
        if damage == RUDDER:
            pass
        if damage == PORT_ELEVATOR_INOPERABLE:
            pass
        if damage == STBD_ELEVATOR_INOPERABLE:
            pass
        if damage == PORT_TAILPLANE_ROOT_HIT:
            pass
        if damage == STBD_TAILPLANE_ROOT_HIT:
            pass
        if damage == TAIL_OXYGEN_HIT:
            pass
        if damage == FIRE_AND_TAIL_OXYGEN_OUT:
            pass


    def run_flak_hit(self):
        pass


    def resolve_landing(self):
        pass



    def init_mission(self):
        self.game.mission = Mission( len(self.game.missions) + 1 )
        self.init_bomber()

        # Get Target City and Target Type
        targettable = MissionTargetTable()
        target, targettype, targetzone = targettable.get_mission( self.game.mission.mission_number )
        self.game.mission.target = target
        self.game.mission.target_type = targettype
        self.game.mission.target_zone = targetzone

        print "Mission %d: %s [%s] Zone %d" % (self.game.mission.mission_number, target, targettype, targetzone)
        self.pause()

        # Get formation position
        formationtable = FormationPositionTable()
        self.game.mission.position_in_formation = formationtable.get_position()
        self.game.mission.position_in_squadron  = formationtable.get_squadron_position()

        print "Formation Position: %s" % self.game.mission.position_in_formation
        if self.game.mission.mission_number >= 6:
            print "Squadron Position: %s" % self.game.mission.position_in_squadron
        self.pause()

        # Get fighter coverage
        fightercoveragetable = FighterCoverageTable()
        for zone in xrange( 2, targetzone + 1 ):
            self.game.mission.fighter_coverage[ OUT  ][ zone ] = fightercoveragetable.get_fighter_coverage( self.game.mission.mission_number )
            self.game.mission.fighter_coverage[ BACK ][ zone ] = fightercoveragetable.get_fighter_coverage( self.game.mission.mission_number )

        # Get fighter waves modifiers
        flightlogtable = FlightLogGazeteer()
        for zone in xrange( 2, targetzone + 1 ):
            self.game.mission.fighter_waves_modifiers[ zone ] = flightlogtable.get_modifier( target, zone )



    def init_bomber(self):
        if self.game.mission.bomber is not None:
            return
        bomber = Bomber()
        inp = raw_input( "Bomber Name (%s): " % bomber.name ).strip()
        if inp != "":
            bomber.name = inp
        self.game.mission.bomber = bomber
