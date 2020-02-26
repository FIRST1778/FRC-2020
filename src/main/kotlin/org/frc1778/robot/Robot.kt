package org.frc1778.robot

import org.frc1778.robot.subsystems.collector.Collector
import org.frc1778.robot.subsystems.drive.Drive
import org.frc1778.robot.subsystems.shooter.Shooter
import org.ghrobotics.lib.wrappers.FalconTimedRobot

object Robot : FalconTimedRobot() {

    init {
        +Drive
        +Shooter
        +Collector
    }

    override fun robotPeriodic() {
        Controls.update()
    }
}
