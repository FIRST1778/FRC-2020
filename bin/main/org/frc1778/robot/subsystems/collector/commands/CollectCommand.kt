package org.frc1778.robot.subsystems.collector.commands

import org.frc1778.robot.Controls
import org.frc1778.robot.subsystems.collector.Collector
import org.ghrobotics.lib.commands.FalconCommand

open class CollectCommand : FalconCommand(Collector) {

    override fun execute() {
        Collector.runAgitator(if (agitatorSource()) { 0.25 } else { 0.0 })
    }

    companion object {
        val agitatorSource = Controls.operatorController.getRawButton(1)
    }
}
