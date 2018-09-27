import random
from constants import *

def roll( numdice=1, sum=True ):
    ret = 0
    for i in xrange( numdice ):
        r = random.randint( 1, 6 )
        if sum:
            ret += r
        else:
            if ret == 0:
                ret = str(r)
            else:
                ret += str(r)
    return int(ret)


class MissionTargetTable( object ):
    """ G-1, G-2, and G-3 """

    def __init__(self):
        self.mission1_5 = {
            1: ("St. Omer", "Airfield", 2),
            2: ("Cherbourg", "Airfield", 3),
            3: ("Amiens", "Rail Yard", 3),
            4: ("Meaulte", "Aircraft", 3),
            5: ("Abbeville", "Airfield", 3),
            6: ("Lille", "Industry", 3)
        }
        self.mission6_10 = {
            1: ("Abbeville", "Airfield", 3),
            2: ("Meaulte", "Aircraft", 3),
            3: ("Lille", "Industry", 3),
            4: ("Rotterdam", "Ship Yard", 4),
            5: ("Antwerp", "Industry", 4),
            6: ("Rouen", "Rail Yard", 4)
        }
        self.mission11_24 = {
            11: (ST_OMER, AIRFIELD, 2),
            12: (CHERBOURG, AIRFIELD, 3),
            13: (AMIENS, RAIL_YARD, 3),
            # TODO Finish this
        }


    def get_mission(self, mission_number):
        if mission_number <= 5:
            return self.mission1_5[ roll() ]
        elif mission_number <= 10:
            return self.mission6_10[ roll() ]
        return None



class FormationPositionTable( object ):
    """ G-4 """
    def __init__(self):
        pass

    def get_position(self):
        r = roll( 2 )
        if r == 2:
            return LEAD_BOMBER
        if r == 12:
            return TAIL_BOMBER
        return MIDDLE

    def get_squadron_position(self):
        r = roll( 2 )
        if r <= 2:
            return HIGH
        if r <= 4:
            return MIDDLE
        return LOW


class FighterCoverageTable( object ):
    """ G-5 """
    def __init__(self):
        pass

    def get_fighter_coverage(self, mission_number):
        if mission_number <= 5:
            return GOOD
        r = roll()
        if r <= 2:
            return POOR
        if r <= 4:
            return FAIR
        return GOOD


class FlightLogGazeteer( object ):
    """ G-11 """

    def __init__(self):
        self.table = {
            ABBEVILLE: {
                2: (-2, WATER),
                3: ( 1, FRANCE),
            },
            AMIENS: {
                2: (-2, WATER),
                3: ( 0, FRANCE),
            },
            ANTWERP: {
                2: (-2, WATER),
                3: (-1, BELGIUM),
                4: ( 0, BELGIUM),
            },
            BREMEN: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: (-1, WATER),
                5: (-1, WATER),
                6: (-1, WATER),
                7: ( 0, GERMANY),
            },
            BREST: {
                2: (-3, WATER),
                3: (-2, WATER),
                4: (-1, WATER),
                5: (-1, WATER),
                6: ( 1, FRANCE),
            },
            CHERBOURG: {
                2: (-2, WATER),
                3: ( 0, (FRANCE, WATER)),
            },
            EMDEN: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: (-1, WATER),
                5: (-1, WATER),
                6: (-1, WATER),
                7: ( 0, GERMANY),
            },
            HAMM: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: (-1, WATER),
                5: ( 0, NETHERLANDS),
                6: ( 0, NETHERLANDS),
                7: ( 0, GERMANY),
            },
            KIEL: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: (-1, WATER),
                5: (-1, WATER),
                6: (-1, WATER),
                7: (-1, WATER),
                8: ( 0, GERMANY),
            },
            LA_ROCHELLE: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: ( 0, FRANCE),
                5: ( 0, FRANCE),
                6: ( 0, FRANCE),
                7: ( 0, FRANCE),
                8: ( 0, FRANCE),
            },
            LILLE: {
                2: (-2, WATER),
                3: ( 0, FRANCE),
            },
            LORIENT: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: (-1, WATER),
                5: ( 0, FRANCE),
                6: ( 0, FRANCE),
            },
            MEAULTE: {
                2: (-2, WATER),
                3: ( 0, FRANCE),
            },
            PARIS: {
                2: (-2, WATER),
                3: ( 0, FRANCE),
                4: ( 0, FRANCE),
                5: ( 0, FRANCE),
            },
            RENNES: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: ( 0, FRANCE),
                5: ( 0, FRANCE),
            },
            ROMILLY_SUR_SEINE: {
                2: (-2, WATER),
                3: ( 0, FRANCE),
                4: ( 0, FRANCE),
                5: ( 0, FRANCE),
            },
            ROTTERDAM: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: ( 0, (WATER, NETHERLANDS)),
            },
            ROUEN: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: ( 0, FRANCE),
            },
            ST_OMER: {
                2: ( 0, (WATER, FRANCE)),
            },
            ST_NAZAIRE: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: ( 0, FRANCE),
                5: ( 0, FRANCE),
                6: ( 1, FRANCE),
            },
            VEGESACK: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: (-1, WATER),
                5: (-1, WATER),
                6: (-1, WATER),
                7: ( 0, GERMANY),
            },
            WILHELMSHAVEN: {
                2: (-2, WATER),
                3: (-1, WATER),
                4: (-1, WATER),
                5: (-1, WATER),
                6: (-1, WATER),
                7: ( 0, GERMANY),
            },
        }

    def get_modifier(self, target, zone):
        return self.table[ target ][ zone ]


class NumberOfGermanFighterWavesTable( object ):
    """ B-1 and B-2 """

    def __init__(self):
        pass

    def get(self, target_zone=False, weather=None ):
        r = roll()
        if target_zone:
            if weather == POOR:
                r -= 1
            return [ 1, 1, 1, 1, 2, 2, 3 ][ r ]
        return [ 0, 0, 0, 1, 1, 1, 2 ][ r ]


class WaveCompositionTable( object ):
    """ B-3 """
    def __init__(self):
        self.fighters = {
            11: [ (FIGHTER_109, AREA_6, HIGH) ],
            12: [ (FIGHTER_109, AREA_1_30, HIGH), (FIGHTER_109, AREA_9, LEVEL) ],
            13: [ (FIGHTER_190, AREA_12, HIGH), (FIGHTER_190, AREA_10_30, HIGH), (FIGHTER_190, AREA_3, HIGH) ],
            14: [ (FIGHTER_109, AREA_12, HIGH), (FIGHTER_109, AREA_10_30, HIGH), (FIGHTER_109, AREA_1_30, HIGH), (FIGHTER_109, AREA_12, LEVEL) ],
            15: [ (FIGHTER_190, AREA_12, HIGH), (FIGHTER_190, AREA_10_30, LEVEL), (FIGHTER_190, AREA_9, LEVEL), (FIGHTER_190, AREA_6, HIGH), (FIGHTER_190, VERTICAL_DIVE, HIGH) ],
            16: [],
            21: [ (FIGHTER_190, VERTICAL_DIVE, HIGH)],
            22: [ (FIGHTER_110, AREA_12, LOW), (FIGHTER_110, AREA_10_30, LOW) ],
            23: [ (FIGHTER_190, AREA_12, HIGH), (FIGHTER_190, AREA_3, LEVEL), (FIGHTER_190, AREA_3, HIGH) ],
            24: [ (FIGHTER_109, AREA_12, HIGH), (FIGHTER_109, AREA_3, HIGH), (FIGHTER_109, AREA_9, HIGH), (FIGHTER_109, AREA_9, LEVEL) ],
            25: [ (FIGHTER_190, AREA_12, HIGH), (FIGHTER_190, AREA_1_30, HIGH), (FIGHTER_190, AREA_3, HIGH), (FIGHTER_190, AREA_6, HIGH), (FIGHTER_190, AREA_9, HIGH) ],
            26: [],
            31: [ (FIGHTER_110, VERTICAL_CLIMB, LOW)],
            32: [ (FIGHTER_190, AREA_10_30, HIGH), (FIGHTER_190, AREA_3, LEVEL) ],
            33: [ (FIGHTER_109, AREA_12, LEVEL), (FIGHTER_109, AREA_12, HIGH), (FIGHTER_109, AREA_1_30, LEVEL) ],
            34: [ (FIGHTER_190, AREA_10_30, HIGH), (FIGHTER_110, VERTICAL_CLIMB, LOW) ],
            35: [ (FIGHTER_190, AREA_12, LEVEL), (FIGHTER_190, AREA_1_30, LOW) ],
            36: [],
            41: [ (FIGHTER_109, AREA_12, HIGH)],
            42: [ (FIGHTER_109, AREA_12, LEVEL), (FIGHTER_109, AREA_1_30, HIGH) ],
            43: [ (FIGHTER_190, AREA_12, HIGH), (FIGHTER_109, AREA_1_30, LEVEL), (FIGHTER_109, AREA_3, LEVEL) ],
            44: [ (FIGHTER_190, AREA_12, HIGH), (FIGHTER_190, AREA_12, LOW), (FIGHTER_109, AREA_1_30, LEVEL), (FIGHTER_110, AREA_6, LOW) ],
            45: [ (FIGHTER_109, AREA_10_30, LEVEL), (FIGHTER_109, AREA_12, LEVEL), (FIGHTER_110, AREA_10_30, LOW) ],
            46: [],
            51: [ (FIGHTER_190, AREA_10_30, HIGH)],
            52: [ (FIGHTER_110, AREA_6, LEVEL), (FIGHTER_110, AREA_9, LOW) ],
            53: [ (FIGHTER_110, AREA_12, LOW), (FIGHTER_110, AREA_10_30, LEVEL), (FIGHTER_110, AREA_6, LOW) ],
            54: [ (FIGHTER_109, AREA_12, LOW), (FIGHTER_109, AREA_12, LEVEL), (FIGHTER_109, AREA_12, HIGH), (FIGHTER_109, AREA_9, HIGH) ],
            55: [ (FIGHTER_190, AREA_12, LOW), (FIGHTER_109, AREA_12, LEVEL), (FIGHTER_109, AREA_12, HIGH), (FIGHTER_109, AREA_10_30, LEVEL) ],
            56: [],
            61: [ (FIGHTER_109, VERTICAL_DIVE, HIGH)],
            62: [ (FIGHTER_109, AREA_3, LOW), (FIGHTER_110, AREA_1_30, LOW) ],
            63: [ (FIGHTER_190, AREA_10_30, HIGH), (FIGHTER_190, AREA_12, HIGH), (FIGHTER_190, AREA_1_30, HIGH) ],
            64: [ (FIGHTER_190, AREA_12, LEVEL), (FIGHTER_190, AREA_1_30, LEVEL), (FIGHTER_190, AREA_3, LOW), (FIGHTER_190, AREA_9, HIGH) ],
            65: [ (FIGHTER_109, AREA_12, LEVEL), (FIGHTER_109, AREA_3, HIGH), (FIGHTER_109, AREA_1_30, HIGH), (FIGHTER_109, AREA_6, HIGH), (FIGHTER_109, VERTICAL_DIVE, HIGH) ],
            66: [],
        }

    def get(self, out_of_formation=False):
        r = roll( 2, False )
        if r == 66:
            # TODO Random Event
            return None
        while r in [ 16, 26, 36, 46, 56 ] and out_of_formation:
            r = roll( 2, False )
        return self.fighters[ r ]


class ShellHitsTable( object ):
    """ B-4 """

    def __init__(self):
        self.hits = {
            AREA_12:        [ 3, 2, 2, 2, 1, 1, 1, 2, 2, 2, 4 ],
            AREA_1_30:      [ 3, 2, 2, 2, 1, 1, 1, 2, 2, 2, 4 ],
            AREA_10_30:     [ 3, 2, 2, 2, 1, 1, 1, 2, 2, 2, 4 ],
            AREA_3:         [ 4, 3, 3, 3, 2, 1, 2, 3, 3, 3, 5 ],
            AREA_9:         [ 4, 3, 3, 3, 2, 1, 2, 3, 3, 3, 5 ],
            AREA_6:         [ 6, 5, 4, 3, 2, 2, 2, 3, 4, 5, 7 ],
            VERTICAL_DIVE:  [ 3, 2, 2, 1, 1, 1, 1, 1, 2, 2, 4 ],
            VERTICAL_CLIMB: [ 4, 4, 3, 2, 2, 1, 2, 2, 3, 4, 5 ],
        }

    def get(self, area, fighter):
        r = roll( 2 )
        hits = self.hits[ area ][ r - 2 ]
        if fighter == FIGHTER_190:
            hits = int( hits * 1.5 )
        elif fighter == FIGHTER_110:
            hits += 1
        return hits


class AreaDamageTable( object ):
    """ B-5 """
    FRONT = "Front"
    SIDE = "Side"
    WING_ATTACKING_SIDE = "Wing - attacking side"
    FUSELAGE_A = "Fuselage (a)"
    FUSELAGE_C = "Fuselage (c)"
    WINGS      = "Wings"

    def __init__(self):
        self.areas = {
            self.FRONT: {
                HIGH: [
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    RADIO_ROOM,
                    NOSE,
                    PILOT_COMPARTMENT,
                    [ PORT_WING, PORT_WING, PORT_WING, STBD_WING, STBD_WING, STBD_WING ],
                    WAIST,
                    TAIL,
                    BOMB_BAY,
                    self.FUSELAGE_A,
                ],
                LEVEL: [
                    PORT_WING,
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    PORT_WING,
                    NOSE,
                    STBD_WING,
                    PILOT_COMPARTMENT,
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    STBD_WING,
                ],
                LOW: [
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    RADIO_ROOM,
                    NOSE,
                    BOMB_BAY,
                    [ PORT_WING, PORT_WING, PORT_WING, STBD_WING, STBD_WING, STBD_WING ],
                    WAIST,
                    TAIL,
                    PILOT_COMPARTMENT,
                    self.FUSELAGE_A,
                ],
            },
            self.SIDE: {
                HIGH: [
                    self.WINGS,
                    NOSE,
                    PILOT_COMPARTMENT,
                    BOMB_BAY,
                    PORT_WING,
                    TAIL,
                    STBD_WING,
                    RADIO_ROOM,
                    WAIST,
                    SUPERFICIAL_DAMAGE,
                    self.FUSELAGE_A,
                ],
                LEVEL: [
                    BOMB_BAY,
                    self.WING_ATTACKING_SIDE,
                    NOSE,
                    WAIST,
                    self.WING_ATTACKING_SIDE,
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    TAIL,
                    RADIO_ROOM,
                    PILOT_COMPARTMENT,
                    self.FUSELAGE_C,
                ],
                LOW: [
                    self.WINGS,
                    NOSE,
                    BOMB_BAY,
                    RADIO_ROOM,
                    TAIL,
                    PORT_WING,
                    STBD_WING,
                    SUPERFICIAL_DAMAGE,
                    WAIST,
                    PILOT_COMPARTMENT,
                    self.FUSELAGE_A,
                ],
            },
            AREA_6: {
                HIGH: [
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    RADIO_ROOM,
                    BOMB_BAY,
                    PORT_WING,
                    TAIL,
                    STBD_WING,
                    WAIST,
                    PILOT_COMPARTMENT,
                    self.FUSELAGE_A,
                    NOSE
                ],
                LEVEL: [
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    TAIL,
                    TAIL,
                    PORT_WING,
                    TAIL,
                    STBD_WING,
                    TAIL,
                    TAIL,
                    WAIST,
                    SUPERFICIAL_DAMAGE,
                ],
                LOW: [
                    NOSE,
                    SUPERFICIAL_DAMAGE,
                    SUPERFICIAL_DAMAGE,
                    BOMB_BAY,
                    PORT_WING,
                    TAIL,
                    STBD_WING,
                    WAIST ,
                    RADIO_ROOM,
                    self.FUSELAGE_A,
                    PILOT_COMPARTMENT,
                ],
            },
            VERTICAL_DIVE:  [
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BOMB_BAY,
                RADIO_ROOM,
                PORT_WING,
                self.FUSELAGE_A,
                STBD_WING,
                PILOT_COMPARTMENT,
                TAIL,
                WAIST,
                NOSE
            ],
            VERTICAL_CLIMB: [
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                BOMB_BAY,
                TAIL,
                PORT_WING,
                RADIO_ROOM,
                STBD_WING,
                self.FUSELAGE_A,
                PILOT_COMPARTMENT,
                WAIST,
                NOSE
            ]
        }

    def get(self, area, altitude):
        r = roll( 2 )
        key = area
        if key in [ AREA_12, AREA_1_30, AREA_10_30 ]:
            key = self.FRONT
        elif key in [ AREA_3, AREA_9 ]:
            key = self.SIDE
        hitarea = self.areas[ key ]
        if key in [ VERTICAL_CLIMB, VERTICAL_DIVE ]:
            return hitarea[ r - 2 ]
        target = hitarea[ altitude ][ r - 2 ]
        if target == self.WING_ATTACKING_SIDE:
            if key == AREA_3:
                target = STBD_WING
            else:
                target = PORT_WING
        elif target == self.FUSELAGE_A:
            target = [ NOSE, PILOT_COMPARTMENT, BOMB_BAY, RADIO_ROOM, WAIST, TAIL ]
        elif target == self.WINGS:
            if key == AREA_3:
                target = [ STBD_WING, STBD_WING ]
            else:
                target = [ PORT_WING, PORT_WING ]
        elif target == self.FUSELAGE_C:
            if key == AREA_3:
                target = [ NOSE, STBD_WING, WAIST, TAIL ]
            else:
                target = [ NOSE, PORT_WING, WAIST, TAIL ]
        elif type(target) == list:
            target = target[ roll() ]
        return target



class DefensiveFireTable( object ):
    """ M-1 """
    def __init__(self):
        self.table = {  # { area: { altitude: { gun: { fighter: min_roll_for_hit } } } }
            AREA_12: {
                HIGH: {
                    TOP_TURRET: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    NOSE: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
                LEVEL: {
                    TOP_TURRET: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    NOSE: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
                LOW: {
                    BALL_TURRET: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    NOSE: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
            },
            AREA_1_30: {
                HIGH: {
                    TOP_TURRET: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    STBD_CHEEK: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    STBD_WAIST: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
                LEVEL: {
                    STBD_CHEEK: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                },
                LOW: {
                    BALL_TURRET: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    STBD_CHEEK: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
            },
            AREA_10_30: {
                HIGH: {
                    TOP_TURRET: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    PORT_CHEEK: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    PORT_WAIST: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
                LEVEL: {
                    PORT_CHEEK: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                },
                LOW: {
                    BALL_TURRET: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    PORT_CHEEK: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
            },
            AREA_3: {
                HIGH: {
                    TOP_TURRET: {
                        FIGHTER_109: 5,
                        FIGHTER_110: 4,
                        FIGHTER_190: 5,
                    },
                    STBD_WAIST: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
                LEVEL: {
                    TOP_TURRET: {
                        FIGHTER_109: 5,
                        FIGHTER_110: 4,
                        FIGHTER_190: 5,
                    },
                    BALL_TURRET: {
                        FIGHTER_109: 5,
                        FIGHTER_110: 4,
                        FIGHTER_190: 5,
                    },
                    STBD_WAIST: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                },
                LOW: {
                    BALL_TURRET: {
                        FIGHTER_109: 5,
                        FIGHTER_110: 4,
                        FIGHTER_190: 5,
                    },
                    STBD_WAIST: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
            },
            AREA_9: {
                HIGH: {
                    TOP_TURRET: {
                        FIGHTER_109: 5,
                        FIGHTER_110: 4,
                        FIGHTER_190: 5,
                    },
                    PORT_WAIST: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
                LEVEL: {
                    TOP_TURRET: {
                        FIGHTER_109: 5,
                        FIGHTER_110: 4,
                        FIGHTER_190: 5,
                    },
                    BALL_TURRET: {
                        FIGHTER_109: 5,
                        FIGHTER_110: 4,
                        FIGHTER_190: 5,
                    },
                    PORT_WAIST: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                },
                LOW: {
                    BALL_TURRET: {
                        FIGHTER_109: 5,
                        FIGHTER_110: 4,
                        FIGHTER_190: 5,
                    },
                    PORT_WAIST: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    }
                },
            },
            AREA_6: {
                HIGH: {
                    TOP_TURRET: {
                        FIGHTER_109: 4,
                        FIGHTER_110: 3,
                        FIGHTER_190: 4,
                    },
                    RADIO_ROOM: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    TAIL_TURRET: {
                        FIGHTER_109: 4,
                        FIGHTER_110: 3,
                        FIGHTER_190: 4,
                    },
                },
                LEVEL: {
                    TAIL_TURRET: {
                        FIGHTER_109: 4,
                        FIGHTER_110: 3,
                        FIGHTER_190: 4,
                    },
                },
                LOW: {
                    BALL_TURRET: {
                        FIGHTER_109: 4,
                        FIGHTER_110: 3,
                        FIGHTER_190: 4,
                    },
                    TAIL_TURRET: {
                        FIGHTER_109: 4,
                        FIGHTER_110: 3,
                        FIGHTER_190: 4,
                    }
                },
            },
            VERTICAL_CLIMB: {
                HIGH: {
                },
                LEVEL: {
                },
                LOW: {
                    BALL_TURRET: {
                        FIGHTER_109: 3,
                        FIGHTER_110: 3,
                        FIGHTER_190: 3,
                    },
                },
            },
            VERTICAL_DIVE: {
                HIGH: {
                    TOP_TURRET: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                    RADIO_ROOM: {
                        FIGHTER_109: 6,
                        FIGHTER_110: 6,
                        FIGHTER_190: 6,
                    },
                },
                LEVEL: {
                },
                LOW: {
                },
            },
        }


    def get_guns(self, area, altitude):
        return self.table[ area ][ altitude ]


    def get_min_hit_roll(self, fighter, area, altitude, gun):
        fighters = self.table[ area ][ altitude ]
        if gun in fighters.keys():
            return fighters[ gun ][ fighter ]
        return 99  # Return a number too big to allow any hit


class GermanFighterDamage( object ):
    """ M-2 """

    def __init__(self):
        pass

    def get(self, gun, fighter):
        r = roll()
        if fighter != FIGHTER_190 and gun in [ TOP_TURRET, BALL_TURRET, TAIL_TURRET ]:
            r += 1
        if fighter == FIGHTER_190 and gun not in [ TOP_TURRET, BALL_TURRET, TAIL_TURRET ]:
            r -= 1
        if r <= 2:
            return FCA
        if r <= 4:
            return FBOA
        return DESTROYED


class GermanOffensiveFire( object ):
    """ M-3 """

    def __init__(self):
        self.minrolls = {
            AREA_12: 5,
            AREA_1_30: 5,
            AREA_10_30: 5,
            AREA_3: 4,
            AREA_9: 4,
            AREA_6: 3,
            VERTICAL_DIVE: 5,
            VERTICAL_CLIMB: 4
        }

    def is_hit(self, area):
        r = roll()
        if r == 6:
            return True
        if r >= self.minrolls[ area ]:
            return True
        return False



class FighterCoverDefenseTable( object ):
    """ M-4 """

    def __init__(self):
        self.table = {
            POOR: [ (0, 0), (0, 0), (0, 0), (0, 0), (0, 0), (1, 0), (1, 0) ],
            FAIR: [ (0, 0), (0, 0), (0, 0), (1, 0), (1, 0), (2, 1), (2, 1) ],
            GOOD: [ (0, 0), (1, 0), (1, 0), (2, 1), (2, 1), (3, 2), (3, 2) ],
        }

    def get(self, coverage):
        r = roll()
        return self.table[ coverage ][ r ]


class WeatherTable( object ):
    """ O-1 """

    def __init__(self):
        self.weather = {
            2: BAD,
            3: POOR,
            4: GOOD,
            5: GOOD,
            6: GOOD,
            7: GOOD,
            8: GOOD,
            9: GOOD,
            10: GOOD,
            11: POOR,
            12: BAD,
        }

    def get(self):
        return self.weather[ roll( 2 ) ]


class FlakTable( object ):
    """ O-2, 0-3 """

    def __init__(self):
        self.flak_hits = {
            LIGHT_FLAK: {
                2: HIT,
                3: MISS,
                4: MISS,
                5: MISS,
                6: MISS,
                7: MISS,
                8: MISS,
                9: MISS,
                10: MISS,
                11: MISS,
                12: HIT,
            },
            MEDIUM_FLAK: {
                2: HIT,
                3: HIT,
                4: MISS,
                5: MISS,
                6: MISS,
                7: HIT,
                8: MISS,
                9: MISS,
                10: MISS,
                11: MISS,
                12: HIT,
            },
            HEAVY_FLAK: {
                2: HIT,
                3: HIT,
                4: MISS,
                5: HIT,
                6: MISS,
                7: HIT,
                8: MISS,
                9: HIT,
                10: MISS,
                11: HIT,
                12: HIT,
            },
        }

    def get(self):
        amount = [ NO_FLAK, LIGHT_FLAK, LIGHT_FLAK, MEDIUM_FLAK, MEDIUM_FLAK, HEAVY_FLAK ][ roll() ]
        if amount == NO_FLAK:
            return NO_FLAK, 0
        return amount, sum( [ 1 if self.flak_hits[ amount ][ roll( 2 ) ] == HIT else 0 for i in xrange( 3 ) ] )


class OnTargetTable( object ):
    """ O-6 """
    def __init__(self):
        pass

    def is_on_target(self, mission_number, hit_by_flak, bombardier):
        if bombardier.status in [ SERIOUS_WOUND, KIA ]:
            return False
        r = roll()
        if mission_number >= 11:
            r += 1
        if hit_by_flak:
            r -= 1
        return [ False, False, False, True, True, True, True, True ][ r ]


class BombingAccuracyTable( object ):
    """ O-7 """
    def __init__(self):
        self.on_target  = [ 75, 60, 30, 20, 30, 40, 30, 20, 30, 50, 88 ]
        self.off_target = [ 10, 5, 0, 0, 0, 0, 0, 0, 0, 5, 10 ]

    def get_accuracy(self, on_target):
        if on_target:
            return self.on_target[ roll( 2 ) - 2 ]
        return self.off_target[ roll( 2 ) - 2 ]


class LandingTable( object ):
    """ G-9, G-10 """
    def __init__(self):
        self.on_land = [
            (CREW_KIA, BOMBER_WRECKED),                       # -3
            (CREW_ROLL_FOR_WOUNDS_PLUS_ONE, BOMBER_WRECKED),  # -2
            (CREW_ROLL_FOR_WOUNDS, BOMBER_WRECKED),           # -1
            (CREW_SAFE, BOMBER_WRECKED),                      #  0
            (CREW_SAFE, BOMBER_REPAIRABLE),                   #  1
            (CREW_SAFE, BOMBER_SAFE)                          # 2-12
        ]
        self.on_water = [
            CREW_LOST,
            CREW_LOST,
            CREW_RESCUED,
            CREW_RESCUED,
            CREW_RESCUED,
            CREW_RESCUED,
            CREW_RESCUED,
            CREW_RESCUED,
            CREW_RESCUED,
            CREW_RESCUED,
            CREW_RESCUED,
        ]

    def get_effect(self, on_land=True, modifier=0, fighter_wave_modifier_code=WATER):
        r = roll( 2 )
        if on_land:
            r += modifier + 3
            if r < len(self.on_land):
                return self.on_land[ r ]
            return self.on_land[ -1 ]
        if r == 12:
            return CREW_RESCUED
        if fighter_wave_modifier_code in [ GERMANY, NETHERLANDS ]:
            return CREW_CAPTURED
        r += modifier


class BomberDamageTable( object ):
    def __init__(self):
        self.nose = [
            NORDEN_SIGHT,
            [
                NOSE_GUN_INOPERABLE,
                NOSE_GUN_INOPERABLE,
                PORT_CHEEK_INOPERABLE,
                PORT_CHEEK_INOPERABLE,
                STBD_CHEEK_INOPERABLE,
                STBD_CHEEK_INOPERABLE,
            ],
            BOMBARDIER_AND_NAVIGATOR_HIT,
            NAVIGATOR,
            BOMBARDIER,
            SUPERFICIAL_DAMAGE,
            SUPERFICIAL_DAMAGE,
            SUPERFICIAL_DAMAGE,
            [
                NAVIGATOR_EQUIPMENT_INOPERABLE,
                NAVIGATOR_EQUIPMENT_INOPERABLE,
                NAVIGATOR_EQUIPMENT_INOPERABLE,
                BOMB_CONTROLS_INOPERABLE,
                BOMB_CONTROLS_INOPERABLE,
                BOMB_CONTROLS_INOPERABLE,
            ],
            [
                BOMBARDIER_HEAT_OUT,
                BOMBARDIER_HEAT_OUT,
                NAVIGATOR_HEAT_OUT,
                NAVIGATOR_HEAT_OUT,
                BOMBARDIER_AND_NAVIGATOR_HEAT_OUT,
                BOMBARDIER_AND_NAVIGATOR_HEAT_OUT,
            ],
            [
                BOMBARDIER_OXYGEN_HIT,
                BOMBARDIER_OXYGEN_HIT,
                NAVIGATOR_OXYGEN_HIT,
                NAVIGATOR_OXYGEN_HIT,
                BOMBARDIER_AND_NAVIGATOR_OXYGEN_HIT,
                FIRE_AND_NOSE_OXYGEN_OUT,
            ],
        ]

        self.pilot = [
            PILOT_AND_COPILOT_HEAT_OUT,
            PILOT_AND_COPILOT_HIT,
            PILOT,
            COPILOT,
            SUPERFICIAL_DAMAGE,
            SUPERFICIAL_DAMAGE,
            [
                TOP_TURRET_INOPERABLE,
                TOP_TURRET_INOPERABLE,
                ENGINEER,
                ENGINEER,
                ENGINEER,
                TOP_TURRENT_INOPERABLE_AND_ENGINEER_HIT,
            ],
            INSTRUMENTS,
            [
                PILOT_AND_COPILOT_OXYGEN_HIT,
                PILOT_OXYGEN_HIT,
                COPILOT_OXYGEN_HIT,
                ENGINEER_OXYGEN_HIT,
                ENGINEER_OXYGEN_HIT,
                FIRE_AND_PILOT_COMPARTMENT_OXYGEN_OUT
            ],
            WINDOW,
            CONTROL_CABLES
        ]

        self.bomb_bay = [
            BOMBS_DROP_MANUALLY,
            [
                NO_EFFECT,
                NO_EFFECT,
                NO_EFFECT,
                NO_EFFECT,
                BOMBS_DETONATE,
                BOMBS_DETONATE,
            ],
            RUBBER_RAFTS_HIT,
            [
                BOMB_BAY_DOORS_INOPERABLE,
                BOMB_BAY_DOORS_INOPERABLE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
            ],
            SUPERFICIAL_DAMAGE,
            SUPERFICIAL_DAMAGE,
            SUPERFICIAL_DAMAGE,
            [
                NO_EFFECT,
                NO_EFFECT,
                NO_EFFECT,
                NO_EFFECT,
                BOMBS_DETONATE,
                BOMBS_DETONATE,
            ],
            [
                BOMB_BAY_DOORS_INOPERABLE,
                BOMB_BAY_DOORS_INOPERABLE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
                SUPERFICIAL_DAMAGE,
            ],
            [
                NO_EFFECT,
                NO_EFFECT,
                NO_EFFECT,
                NO_EFFECT,
                BOMBS_DETONATE,
                BOMBS_DETONATE,
            ],
            CONTROL_CABLES
        ]


        self.radio_room = [
            RADIO_ROOM_HEAT_OUT,
            INTERCOM_SYSTEM_OUT,
            RADIO_OUT,
            RADIO_OUT,
            RADIO_OPERATOR,
            SUPERFICIAL_DAMAGE,
            SUPERFICIAL_DAMAGE,
            SUPERFICIAL_DAMAGE,
            SUPERFICIAL_DAMAGE,
            [
                RADIO_ROOM_OXYGEN_HIT,
                RADIO_ROOM_OXYGEN_HIT,
                RADIO_ROOM_OXYGEN_HIT,
                RADIO_ROOM_OXYGEN_HIT,
                RADIO_ROOM_OXYGEN_HIT,
                FIRE_AND_RADIO_ROOM_OXYGEN_OUT,
            ],
            CONTROL_CABLES
        ]

        self.waist = [
            [
                PORT_WAIST_OXYGEN_HIT,
                PORT_WAIST_OXYGEN_HIT,
                STBD_WAIST_OXYGEN_HIT,
                STBD_WAIST_OXYGEN_HIT,
                BALL_GUNNER_OXYGEN_HIT,
                FIRE_AND_WAIST_OXYGEN_OUT,
            ],
            [
                PORT_WAIST_GUN_INOPERABLE,
                PORT_WAIST_GUN_INOPERABLE,
                PORT_WAIST_GUN_INOPERABLE,
                STBD_WAIST_GUN_INOPERABLE,
                STBD_WAIST_GUN_INOPERABLE,
                STBD_WAIST_GUN_INOPERABLE,
            ],
            SUPERFICIAL_DAMAGE,
            SUPERFICIAL_DAMAGE,
            PORT_WAIST_GUNNER,
            SUPERFICIAL_DAMAGE,
            STBD_WAIST_GUNNER,
            [
                BALL_GUNNER,
                BALL_GUNNER,
                BALL_GUNNER_HEAT_OUT,
                BALL_TURRET_INOPERABLE,
                BALL_TURRET_INOPERABLE,
                BALL_TURRET_MECHANISM_INOPERABLE
            ],
            PORT_WAIST_GUNNER_AND_STBD_WAIST_GUNNER_HIT,
            [
                PORT_WAIST_GUNNER_HEAT_OUT,
                PORT_WAIST_GUNNER_HEAT_OUT,
                PORT_WAIST_GUNNER_HEAT_OUT,
                STBD_WAIST_GUNNER_HEAT_OUT,
                STBD_WAIST_GUNNER_HEAT_OUT,
                STBD_WAIST_GUNNER_HEAT_OUT,
            ],
            CONTROL_CABLES
        ]

        self.tail = [
            TAIL_GUNNER_HEAT_OUT,
            [
                TAIL_WHEEL_DAMAGED,
                TAIL_WHEEL_DAMAGED,
                TAIL_WHEEL_DAMAGED,
                AUTOPILOT_INOPERABLE,
                AUTOPILOT_INOPERABLE,
                AUTOPILOT_INOPERABLE,
            ],
            TAIL_TURRET_INOPERABLE,
            TAIL_GUNNER,
            SUPERFICIAL_DAMAGE,
            RUDDER,
            SUPERFICIAL_DAMAGE,
            [
                NO_EFFECT,
                NO_EFFECT,
                PORT_ELEVATOR_INOPERABLE,
                STBD_ELEVATOR_INOPERABLE,
                PORT_TAILPLANE_ROOT_HIT,
                STBD_TAILPLANE_ROOT_HIT,
            ],
            [
                TAIL_OXYGEN_HIT,
                TAIL_OXYGEN_HIT,
                TAIL_OXYGEN_HIT,
                TAIL_OXYGEN_HIT,
                TAIL_OXYGEN_HIT,
                FIRE_AND_TAIL_OXYGEN_OUT,
            ],
            CONTROL_CABLES
        ]

    def get(self, where):
        r = roll( 2 ) - 2
        effect = None
        if where == NOSE:
            effect = self.nose[ r ]
        elif where == PILOT_COMPARTMENT:
            effect = self.pilot[ r ]
        elif where == BOMB_BAY:
            effect = self.bomb_bay[ r ]
        elif where == RADIO_ROOM:
            effect = self.radio_room[ r ]
        elif where == WAIST:
            effect = self.waist[ r ]
        elif where == TAIL:
            effect = self.tail[ r ]

        if type(effect) == list:
            effect = effect[ roll() ]
        return effect


