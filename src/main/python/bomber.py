from crew import Crew
from gun import Gun
from constants import *

class Bomber:
    def __init__( self, name="Queen of the Skies" ):
        self.name = name
        self.missions_completed = 0
        self.status = BOMBER_SAFE

        self.crew = {
            BOMBARDIER:        Crew( BOMBARDIER ),
            NAVIGATOR:         Crew( NAVIGATOR ),
            PILOT:             Crew( PILOT ),
            COPILOT:           Crew( COPILOT ),
            ENGINEER:          Crew( ENGINEER ),
            RADIO_OPERATOR:    Crew( RADIO_OPERATOR ),
            BALL_GUNNER:       Crew( BALL_GUNNER ),
            PORT_WAIST_GUNNER: Crew( PORT_WAIST_GUNNER ),
            STBD_WAIST_GUNNER: Crew( STBD_WAIST_GUNNER ),
            TAIL_GUNNER:       Crew( TAIL_GUNNER )
        }

        self.guns = {
            NOSE:        Gun( NOSE,        self.crew[ BOMBARDIER        ], 15 ),
            PORT_CHEEK:  Gun( PORT_CHEEK,  self.crew[ NAVIGATOR         ], 10 ),
            STBD_CHEEK:  Gun( STBD_CHEEK,  self.crew[ NAVIGATOR         ], 10 ),
            TOP_TURRET:  Gun( TOP_TURRET,  self.crew[ ENGINEER          ], 16 ),
            RADIO:       Gun( RADIO,       self.crew[ RADIO_OPERATOR    ], 10 ),
            BALL_TURRET: Gun( BALL_TURRET, self.crew[ BALL_GUNNER       ], 20 ),
            PORT_WAIST:  Gun( PORT_WAIST,  self.crew[ PORT_WAIST_GUNNER ], 20 ),
            STBD_WAIST:  Gun( STBD_WAIST,  self.crew[ STBD_WAIST_GUNNER ], 20 ),
            TAIL_TURRET: Gun( TAIL_TURRET, self.crew[ TAIL_GUNNER       ], 23 ),
        }

        self.damage = []


