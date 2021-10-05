package org.frc1778.robot.subsystems.climber.commands

import org.frc1778.robot.Controls
import org.frc1778.robot.subsystems.climber.Climber
import org.ghrobotics.lib.commands.FalconCommand

open class ClimbCommand : FalconCommand(Climber) {

    override fun execute() {
        Climber.runClimber(if (liftSourceUp()) { 0.75 } else { 0.0 })
    }

    companion object {
        val liftSourceUp = Controls.operatorController.getRawButton(6)
    }
}
