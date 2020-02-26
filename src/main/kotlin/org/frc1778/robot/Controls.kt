package org.frc1778.robot

import edu.wpi.first.wpilibj.Joystick
import org.frc1778.freezylib.util.Controllers
import org.frc1778.robot.subsystems.collector.commands.CollectBallCommand
import org.frc1778.robot.subsystems.collector.commands.StowCollector
import org.ghrobotics.lib.wrappers.hid.mapControls

object Controls {

    val driverController = Joystick(0).mapControls {
    }

    val operatorController = Joystick(1).mapControls {
        axisButton(Controllers.LogitechF310.AXIS_LEFT_TRIGGER.ordinal, 0.15)
            .changeOn(CollectBallCommand())
            .changeOff(StowCollector())
    }

    fun update() {
        driverController.update()
        operatorController.update()
    }
}
