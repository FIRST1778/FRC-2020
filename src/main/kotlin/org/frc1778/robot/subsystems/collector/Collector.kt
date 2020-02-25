package org.frc1778.robot.subsystems.collector

import com.revrobotics.CANSparkMaxLowLevel
import org.frc1778.robot.Constants
import org.frc1778.robot.subsystems.collector.commands.RunCollector
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.motors.rev.falconMAX

object Collector : FalconSubsystem() {

    private val collector = falconMAX(Constants.Collector.INTAKE_WHEEL_ID, CANSparkMaxLowLevel.MotorType.kBrushless, DefaultNativeUnitModel) {
        brakeMode = false
    }

    init {
        defaultCommand = RunCollector()
    }

    fun runCollector(percent: Double) {
        collector.setDutyCycle(percent)
    }
}
