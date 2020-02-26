package org.frc1778.robot.subsystems.collector.commands

import org.frc1778.robot.Constants
import org.frc1778.robot.subsystems.collector.Collector
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.mathematics.units.derived.volts

open class StowCollector : FalconCommand(Collector) {

    override fun execute() {
        Collector.wantedActuatorAngle = Constants.Collector.STOW_POSITION
        Collector.wantedCollectorVoltage = 0.0.volts
    }
}
