package org.frc1778.robot.subsystems.climber

import com.revrobotics.CANSparkMaxLowLevel
import org.frc1778.robot.Constants
import org.frc1778.robot.subsystems.climber.commands.ClimbCommand
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.motors.rev.falconMAX

object Climber : FalconSubsystem() {
    private val climbDeploy = falconMAX(Constants.Climber.CLIMBER_DEPLOY_ID, CANSparkMaxLowLevel.MotorType.kBrushless, DefaultNativeUnitModel) {
        brakeMode = true
        outputInverted = false
    }
    init {
        defaultCommand = ClimbCommand()
    }

    fun runClimber(percent: Double) {
        climbDeploy.setDutyCycle(percent)
    }
}
