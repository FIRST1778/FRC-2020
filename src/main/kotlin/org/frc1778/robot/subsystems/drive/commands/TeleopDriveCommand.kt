package org.frc1778.robot.subsystems.drive.commands

import org.frc1778.robot.Controls
import org.frc1778.robot.subsystems.drive.Drive
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.wrappers.hid.getRawButton

open class TeleopDriveCommand : FalconCommand(Drive) {

    override fun execute() {
        Drive.curvatureDrive(linearSource(), turnSource(), quickTurnSource())
    }

    companion object {
        val linearSource = Controls.driverController.getRawAxis(1)
        val turnSource = Controls.driverController.getRawAxis(2)
        val quickTurnSource = Controls.driverController.getRawButton(1)
    }
}
