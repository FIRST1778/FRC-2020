package org.frc1778.robot.subsystems.drive.commands

import org.frc1778.freezylib.util.Controllers
import org.frc1778.robot.Controls
import org.frc1778.robot.subsystems.drive.Drive
import org.ghrobotics.lib.commands.FalconCommand

open class TeleopDriveCommand : FalconCommand(Drive) {

    override fun execute() {
        Drive.curvatureDrive(linearSource(), curvatureSource(), quickTurnSource())
    }

    companion object {
        val linearSource = Controls.driverController.getRawAxis(Controllers.FreezyController.AXIS_LEFT_Y.ordinal)
        val curvatureSource = Controls.driverController.getRawAxis(Controllers.FreezyController.AXIS_RIGHT_X.ordinal)
        val quickTurnSource = Controls.driverController.getRawButton(Controllers.FreezyController.RIGHT_SHOULDER_SWITCH.ordinal)
    }
}
