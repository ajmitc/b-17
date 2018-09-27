package b17.mission.table;

import b17.bomber.BomberAreaType;
import b17.mission.BomberDamageType;
import b17.util.Util;

import java.util.ArrayList;
import java.util.List;

public class BomberDamageTable {
    private static final List<BomberDamageType[]> NOSE = new ArrayList<>();
    private static final List<BomberDamageType[]> PILOT = new ArrayList<>();
    private static final List<BomberDamageType[]> RADIO_ROOM = new ArrayList<>();
    private static final List<BomberDamageType[]> BOMB_BAY = new ArrayList<>();
    private static final List<BomberDamageType[]> WAIST = new ArrayList<>();
    private static final List<BomberDamageType[]> TAIL = new ArrayList<>();

    static {
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.NORDEN_SIGHT
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.NOSE_GUN_INOPERABLE,
                BomberDamageType.NOSE_GUN_INOPERABLE,
                BomberDamageType.PORT_CHEEK_INOPERABLE,
                BomberDamageType.PORT_CHEEK_INOPERABLE,
                BomberDamageType.STBD_CHEEK_INOPERABLE,
                BomberDamageType.STBD_CHEEK_INOPERABLE
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.BOMBARDIER_AND_NAVIGATOR_HIT,
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.NAVIGATOR,
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.BOMBARDIER,
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.NAVIGATOR_EQUIPMENT_INOPERABLE,
                BomberDamageType.NAVIGATOR_EQUIPMENT_INOPERABLE,
                BomberDamageType.NAVIGATOR_EQUIPMENT_INOPERABLE,
                BomberDamageType.BOMB_CONTROLS_INOPERABLE,
                BomberDamageType.BOMB_CONTROLS_INOPERABLE,
                BomberDamageType.BOMB_CONTROLS_INOPERABLE,
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.BOMBARDIER_HEAT_OUT,
                BomberDamageType.BOMBARDIER_HEAT_OUT,
                BomberDamageType.NAVIGATOR_HEAT_OUT,
                BomberDamageType.NAVIGATOR_HEAT_OUT,
                BomberDamageType.BOMBARDIER_AND_NAVIGATOR_HEAT_OUT,
                BomberDamageType.BOMBARDIER_AND_NAVIGATOR_HEAT_OUT,
        } );
        NOSE.add( new BomberDamageType[]{
                BomberDamageType.BOMBARDIER_OXYGEN_HIT,
                BomberDamageType.BOMBARDIER_OXYGEN_HIT,
                BomberDamageType.NAVIGATOR_OXYGEN_HIT,
                BomberDamageType.NAVIGATOR_OXYGEN_HIT,
                BomberDamageType.BOMBARDIER_AND_NAVIGATOR_OXYGEN_HIT,
                BomberDamageType.FIRE_AND_NOSE_OXYGEN_OUT,
        } );

        PILOT.add( new BomberDamageType[]{
                BomberDamageType.PILOT_AND_COPILOT_HEAT_OUT,
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.PILOT_AND_COPILOT_HIT,
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.PILOT_HIT,
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.COPILOT_HIT,
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.TOP_TURRET_INOPERABLE,
                BomberDamageType.TOP_TURRET_INOPERABLE,
                BomberDamageType.ENGINEER_HIT,
                BomberDamageType.ENGINEER_HIT,
                BomberDamageType.ENGINEER_HIT,
                BomberDamageType.TOP_TURRENT_INOPERABLE_AND_ENGINEER_HIT,
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.INSTRUMENTS,
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.PILOT_AND_COPILOT_OXYGEN_HIT,
                BomberDamageType.PILOT_OXYGEN_HIT,
                BomberDamageType.COPILOT_OXYGEN_HIT,
                BomberDamageType.ENGINEER_OXYGEN_HIT,
                BomberDamageType.ENGINEER_OXYGEN_HIT,
                BomberDamageType.FIRE_AND_PILOT_COMPARTMENT_OXYGEN_OUT
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.WINDOW,
        } );
        PILOT.add( new BomberDamageType[]{
                BomberDamageType.CONTROL_CABLES
        } );

        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.BOMBS_DROP_MANUALLY,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.BOMBS_DETONATE,
                BomberDamageType.BOMBS_DETONATE,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.RUBBER_RAFTS_HIT,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.BOMB_BAY_DOORS_INOPERABLE,
                BomberDamageType.BOMB_BAY_DOORS_INOPERABLE,
                BomberDamageType.SUPERFICIAL_DAMAGE,
                BomberDamageType.SUPERFICIAL_DAMAGE,
                BomberDamageType.SUPERFICIAL_DAMAGE,
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.BOMBS_DETONATE,
                BomberDamageType.BOMBS_DETONATE,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.BOMB_BAY_DOORS_INOPERABLE,
                BomberDamageType.BOMB_BAY_DOORS_INOPERABLE,
                BomberDamageType.SUPERFICIAL_DAMAGE,
                BomberDamageType.SUPERFICIAL_DAMAGE,
                BomberDamageType.SUPERFICIAL_DAMAGE,
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.BOMBS_DETONATE,
                BomberDamageType.BOMBS_DETONATE,
        } );
        BOMB_BAY.add( new BomberDamageType[]{
                BomberDamageType.CONTROL_CABLES
        } );


        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.RADIO_ROOM_HEAT_OUT,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.INTERCOM_SYSTEM_OUT,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.RADIO_OUT,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.RADIO_OUT,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.RADIO_OPERATOR_HIT,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.RADIO_ROOM_OXYGEN_HIT,
                BomberDamageType.RADIO_ROOM_OXYGEN_HIT,
                BomberDamageType.RADIO_ROOM_OXYGEN_HIT,
                BomberDamageType.RADIO_ROOM_OXYGEN_HIT,
                BomberDamageType.RADIO_ROOM_OXYGEN_HIT,
                BomberDamageType.FIRE_AND_RADIO_ROOM_OXYGEN_OUT,
        } );
        RADIO_ROOM.add( new BomberDamageType[]{
                BomberDamageType.CONTROL_CABLES
        } );

        WAIST.add( new BomberDamageType[]{
                BomberDamageType.PORT_WAIST_OXYGEN_HIT,
                BomberDamageType.PORT_WAIST_OXYGEN_HIT,
                BomberDamageType.STBD_WAIST_OXYGEN_HIT,
                BomberDamageType.STBD_WAIST_OXYGEN_HIT,
                BomberDamageType.BALL_GUNNER_OXYGEN_HIT,
                BomberDamageType.FIRE_AND_WAIST_OXYGEN_OUT,
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.PORT_WAIST_GUN_INOPERABLE,
                BomberDamageType.PORT_WAIST_GUN_INOPERABLE,
                BomberDamageType.PORT_WAIST_GUN_INOPERABLE,
                BomberDamageType.STBD_WAIST_GUN_INOPERABLE,
                BomberDamageType.STBD_WAIST_GUN_INOPERABLE,
                BomberDamageType.STBD_WAIST_GUN_INOPERABLE,
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.PORT_WAIST_GUNNER_HIT,
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.STBD_WAIST_GUNNER_HIT,
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.BALL_GUNNER_HIT,
                BomberDamageType.BALL_GUNNER_HIT,
                BomberDamageType.BALL_GUNNER_HEAT_OUT,
                BomberDamageType.BALL_TURRET_INOPERABLE,
                BomberDamageType.BALL_TURRET_INOPERABLE,
                BomberDamageType.BALL_TURRET_MECHANISM_INOPERABLE
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.PORT_WAIST_GUNNER_AND_STBD_WAIST_GUNNER_HIT,
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.PORT_WAIST_GUNNER_HEAT_OUT,
                BomberDamageType.PORT_WAIST_GUNNER_HEAT_OUT,
                BomberDamageType.PORT_WAIST_GUNNER_HEAT_OUT,
                BomberDamageType.STBD_WAIST_GUNNER_HEAT_OUT,
                BomberDamageType.STBD_WAIST_GUNNER_HEAT_OUT,
                BomberDamageType.STBD_WAIST_GUNNER_HEAT_OUT,
        } );
        WAIST.add( new BomberDamageType[]{
                BomberDamageType.CONTROL_CABLES
        } );

        TAIL.add( new BomberDamageType[]{
                BomberDamageType.TAIL_GUNNER_HEAT_OUT,
        } );
        TAIL.add( new BomberDamageType[]{
                BomberDamageType.TAIL_WHEEL_DAMAGED,
                BomberDamageType.TAIL_WHEEL_DAMAGED,
                BomberDamageType.TAIL_WHEEL_DAMAGED,
                BomberDamageType.AUTOPILOT_INOPERABLE,
                BomberDamageType.AUTOPILOT_INOPERABLE,
                BomberDamageType.AUTOPILOT_INOPERABLE,
        } );
        TAIL.add( new BomberDamageType[]{
                BomberDamageType.TAIL_TURRET_INOPERABLE,
        } );
        TAIL.add( new BomberDamageType[]{
                BomberDamageType.TAIL_GUNNER_HIT,
        } );
        TAIL.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        TAIL.add( new BomberDamageType[]{
                BomberDamageType.RUDDER,
        } );
        TAIL.add( new BomberDamageType[]{
                BomberDamageType.SUPERFICIAL_DAMAGE,
        } );
        TAIL.add( new BomberDamageType[]{
                BomberDamageType.NO_EFFECT,
                BomberDamageType.NO_EFFECT,
                BomberDamageType.PORT_ELEVATOR_INOPERABLE,
                BomberDamageType.STBD_ELEVATOR_INOPERABLE,
                BomberDamageType.PORT_TAILPLANE_ROOT_HIT,
                BomberDamageType.STBD_TAILPLANE_ROOT_HIT,
        } );
        TAIL.add( new BomberDamageType[]{
                BomberDamageType.TAIL_OXYGEN_HIT,
                BomberDamageType.TAIL_OXYGEN_HIT,
                BomberDamageType.TAIL_OXYGEN_HIT,
                BomberDamageType.TAIL_OXYGEN_HIT,
                BomberDamageType.TAIL_OXYGEN_HIT,
                BomberDamageType.FIRE_AND_TAIL_OXYGEN_OUT,
        } );
        TAIL.add( new BomberDamageType[]{
                BomberDamageType.CONTROL_CABLES
        } );
    }

    public static BomberDamageType get( BomberAreaType where ) {
        int r = Util.roll( 2, true ) - 2;
        BomberDamageType[] effect = null;
        switch( where ) {
            case NOSE:
                effect = NOSE.get( r );
                break;
            case PILOT_COMPARTMENT:
                effect = PILOT.get( r );
                break;
            case BOMB_BAY:
                effect = BOMB_BAY.get( r );
                break;
            case RADIO_ROOM:
                effect = RADIO_ROOM.get( r );
                break;
            case WAIST:
                effect = WAIST.get( r );
                break;
            case TAIL:
                effect = TAIL.get( r );
                break;
        }
        if( effect.length > 1 )
            return effect[ Util.roll() ];
        return effect[ 0 ];
    }

    private BomberDamageTable(){}
}

