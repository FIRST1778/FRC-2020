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
}
