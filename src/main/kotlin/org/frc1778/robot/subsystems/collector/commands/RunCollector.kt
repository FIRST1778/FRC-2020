package org.frc1778.robot.subsystems.collector.commands

import org.frc1778.robot.Controls
import org.frc1778.robot.subsystems.collector.Collector
import org.ghrobotics.lib.commands.FalconCommand

open class RunCollector : FalconCommand(Collector) {

    override fun execute() {
        Collector.runCollector(collectorSource())
    }

    companion object {
        val collectorSource = { Controls.operatorController.getRawAxis(2)() - Controls.operatorController.getRawAxis(3)() }
    }
}
