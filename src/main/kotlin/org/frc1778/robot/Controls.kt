package org.frc1778.robot

import edu.wpi.first.wpilibj.Joystick
import org.ghrobotics.lib.wrappers.hid.FalconHIDBuilder

object Controls {

    val driverController = FalconHIDBuilder<Joystick>(new Joystick(0)).build()
}
