package org.frc1778.robot.subsystems.collector

import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.RobotController
import edu.wpi.first.wpilibj.controller.PIDController
import kotlin.math.PI
import org.frc1778.robot.Constants
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.SIUnit
import org.ghrobotics.lib.mathematics.units.derived.Radian
import org.ghrobotics.lib.mathematics.units.derived.Volt
import org.ghrobotics.lib.mathematics.units.derived.radians
import org.ghrobotics.lib.mathematics.units.derived.volts
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.motors.rev.falconMAX

object Collector : FalconSubsystem() {

    var wantedActuatorAngle = 0.0.radians
    var wantedCollectorVoltage = 0.0.volts

    private val collectorWheel = falconMAX(Constants.Collector.INTAKE_WHEEL_ID, CANSparkMaxLowLevel.MotorType.kBrushless, DefaultNativeUnitModel) {
        brakeMode = false
    }

    private val actuationLeft = falconMAX(Constants.Collector.ACTUATION_LEFT_ID, CANSparkMaxLowLevel.MotorType.kBrushless, DefaultNativeUnitModel) {
        brakeMode = true
        outputInverted = false
    }

    private val actuationRight = falconMAX(Constants.Collector.ACTUATION_RIGHT_ID, CANSparkMaxLowLevel.MotorType.kBrushless, DefaultNativeUnitModel) {
        brakeMode = true
        outputInverted = false
    }

    private val leftPidController = PIDController(Constants.Collector.ACTUATION_KP, Constants.Collector.ACTUATION_KI, Constants.Collector.ACTUATION_KD).apply {
        enableContinuousInput(0.0, 2.0 * PI)
    }
    private val rightPidController = PIDController(Constants.Collector.ACTUATION_KP, Constants.Collector.ACTUATION_KI, Constants.Collector.ACTUATION_KD).apply {
        enableContinuousInput(0.0, 2.0 * PI)
    }

    private val leftEncoder = AnalogInput(Constants.Collector.ACTUATION_LEFT_ENCODER_CHANNEL)
    private val rightEncoder = AnalogInput(Constants.Collector.ACTUATION_RIGHT_ENCODER_CHANNEL)

    override fun periodic() {
        println(leftPidController.calculate(angleFromVoltage(leftEncoder.voltage.volts).plus(Constants.Collector.LEFT_ACTUATION_OFFSET).value))

        actuationLeft.setDutyCycle(leftPidController.calculate(angleFromVoltage(leftEncoder.voltage.volts).plus(Constants.Collector.LEFT_ACTUATION_OFFSET).value, wantedActuatorAngle.value))
        actuationRight.setDutyCycle(rightPidController.calculate(angleFromVoltage(rightEncoder.voltage.volts).plus(Constants.Collector.RIGHT_ACTUATION_OFFSET).value, (2.0 * PI).radians.minus(wantedActuatorAngle).value))

        collectorWheel.setVoltage(wantedCollectorVoltage)
    }

    private fun angleFromVoltage(voltage: SIUnit<Volt>): SIUnit<Radian> {
        return ((1.0 - voltage.value / RobotController.getVoltage5V()) * 2.0 * PI).radians
    }
}
