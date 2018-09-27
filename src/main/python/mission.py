from constants import *

class Mission( object ):

    def __init__(self, mission_number):
        self.mission_number = mission_number
        self.bomber = None
        self.target = None
        self.target_type = None
        self.target_zone = 0
        self.position_in_formation = None
        self.position_in_squadron = None
        self.fighter_coverage = {
            OUT: {},  # { Zone: coverage-level }
            BACK: {}
        }
        self.fighter_waves_modifiers = {}  # { Zone: (modifier, code) }
        self.fighter_waves = {
            OUT: {},   # { Zone: [ wave1, wave2, etc ] }
            BACK: {}
        }
        self.weather_target = None
        self.weather_base = None
        self.bomb_run_percentage = 0
        self.landing_modifier = 0
