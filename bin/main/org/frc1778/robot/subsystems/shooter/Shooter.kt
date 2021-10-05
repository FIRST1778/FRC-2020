package org.frc1778.robot.subsystems.shooter

import com.revrobotics.CANSparkMaxLowLevel
import org.frc1778.robot.Constants
import org.frc1778.robot.subsystems.shooter.commands.ShootCommand
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.motors.ctre.falconFX
import org.ghrobotics.lib.motors.ctre.falconSRX
import org.ghrobotics.lib.motors.rev.falconMAX

object Shooter : FalconSubsystem() {

    private val shooterMaster = falconFX(Constants.Shooter.SHOOTER_MASTER_ID, DefaultNativeUnitModel) {
        brakeMode = false
        outputInverted = false
    }

    private val feeder = falconMAX(Constants.Shooter.FEEDER_ID, CANSparkMaxLowLevel.MotorType.kBrushless, DefaultNativeUnitModel) {
        brakeMode = true
        outputInverted = false
    }
    private val loader = falconSRX(Constants.Shooter.LOADER_ID, DefaultNativeUnitModel) {
        outputInverted = false
    }

    init {
        val shooterSlave = falconFX(Constants.Shooter.SHOOTER_SLAVE_ID, DefaultNativeUnitModel) {
            brakeMode = false
            outputInverted = true
            follow(shooterMaster)
        }

        defaultCommand = ShootCommand()
    }

    fun runShooter(percent: Double) {
        shooterMaster.setDutyCycle(percent)
    }

    fun runFeeder(percent: Double) {
        feeder.setDutyCycle(percent)
    }
    fun runLoader(percent: Double) {
        loader.setDutyCycle(percent)
    }
}
