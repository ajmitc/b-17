from constants import *

class Crew:
    def __init__(self, role):
        self.name = role
        self.role = role
        self.kills = 0
        self.status = OK
        self.location = None  # Location inside bomber (ie. Pilot Compartment, Bomb Bay)

