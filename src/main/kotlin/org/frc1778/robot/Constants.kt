package org.frc1778.robot

import org.ghrobotics.lib.mathematics.units.inches
import org.ghrobotics.lib.mathematics.units.nativeunit.NativeUnitLengthModel
import org.ghrobotics.lib.mathematics.units.nativeunit.nativeUnits

object Constants {

    object Drive {
        const val LEFT_MASTER_ID = 1
        const val RIGHT_MASTER_ID = 3
        const val LEFT_SLAVE_ID = 2
        const val RIGHT_SLAVE_ID = 4

        val WHEEL_RADIUS = 2.5.inches
        val TRACK_WIDTH = 23.inches
        val NATIVE_UNIT_MODEL = NativeUnitLengthModel(2048.nativeUnits, WHEEL_RADIUS)
    }

    object Shooter {
        const val FEEDER_ID = 22
        const val SHOOTER_MASTER_ID = 20
        const val SHOOTER_SLAVE_ID = 21

        val SHOOTER_RADIUS = 2.inches
        val NATIVE_UNIT_MODEL = NativeUnitLengthModel((2048 * 16 / 24).nativeUnits, SHOOTER_RADIUS)
    }

    object Collector {
        const val INTAKE_WHEEL_ID = 30
        const val ACTUATION_LEFT_ID = 31
        const val ACTUATION_RIGHT_ID = 32
        const val AGITATION_ID = 33
        const val ACTUATION_LEFT_ENCODER_CHANNEL = 0
        const val ACTUATION_RIGHT_ENCODER_CHANNEL = 0
    }

    object Climber {
        const val CLIMBER_DEPLOY_ID = 42
        const val CLIMBER_WINCH_MASTER_ID = 40
        const val CLIMBER_WINCH_SLAVE_ID = 41

        val PULLEY_RADIUS = 0.625.inches
        val NATIVE_UNIT_MODE = NativeUnitLengthModel(42.nativeUnits, PULLEY_RADIUS)
    }
}
