package org.frc1778.robot.subsystems.shooter.commands

import org.frc1778.robot.Controls
import org.frc1778.robot.subsystems.shooter.Shooter
import org.ghrobotics.lib.commands.FalconCommand

open class ShootCommand : FalconCommand(Shooter) {

    override fun execute() {
        Shooter.runShooter(if (shooterSource()) { 1.0 } else { 0.0 })
        Shooter.runFeeder(if (feederSource()) { 0.5 } else { 0.0 })
    }

    companion object {
        val shooterSource = Controls.operatorController.getRawButton(2)
        val feederSource = Controls.operatorController.getRawButton(1)
    }
}
