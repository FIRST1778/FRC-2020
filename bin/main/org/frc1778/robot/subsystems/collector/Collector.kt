package org.frc1778.robot.subsystems.collector

import com.revrobotics.CANSparkMaxLowLevel
import org.frc1778.robot.Constants
import org.frc1778.robot.subsystems.collector.commands.CollectCommand
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.motors.rev.falconMAX

object Collector : FalconSubsystem() {
    private val agitator = falconMAX(Constants.Collector.AGITATION_ID, CANSparkMaxLowLevel.MotorType.kBrushless, DefaultNativeUnitModel) {
        brakeMode = true
        outputInverted = false
    }
    init {
        defaultCommand = CollectCommand()
    }

    fun runAgitator(percent: Double) {
        agitator.setDutyCycle(percent)
    }
}
