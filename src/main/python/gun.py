
class Gun( object ):
    def __init__(self, name, operator, ammo):
        self.name = name          # String name
        self.operator = operator  # Crew instance
        self.ammo = ammo          # Integer; ammo left
        self.disabled = False     # is this gun disabled?
