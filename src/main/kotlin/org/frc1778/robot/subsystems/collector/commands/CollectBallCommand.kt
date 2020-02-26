package org.frc1778.robot.subsystems.collector.commands

import org.frc1778.robot.Constants
import org.frc1778.robot.subsystems.collector.Collector
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.mathematics.units.derived.volts

open class CollectBallCommand : FalconCommand(Collector) {

    override fun initialize() {
        Collector.wantedActuatorAngle = Constants.Collector.COLLECT_POSITION
    }

    override fun execute() {
        Collector.wantedCollectorVoltage = 8.0.volts
    }
}
