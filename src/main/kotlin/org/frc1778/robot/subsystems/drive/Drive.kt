package org.frc1778.robot.subsystems.drive

import edu.wpi.first.wpilibj.controller.RamseteController
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward
import edu.wpi.first.wpilibj.geometry.Rotation2d
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry
import org.frc1778.robot.Constants
import org.frc1778.robot.subsystems.drive.commands.TeleopDriveCommand
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.motors.ctre.FalconFX
import org.ghrobotics.lib.subsystems.drive.FalconWestCoastDrivetrain

object Drive : FalconWestCoastDrivetrain() {

    override val leftMotor = FalconFX(Constants.Drive.LEFT_MASTER_ID, Constants.Drive.NATIVE_UNIT_MODEL)
    override val rightMotor = FalconFX(Constants.Drive.RIGHT_MASTER_ID, Constants.Drive.NATIVE_UNIT_MODEL)

    override val gyro = { Rotation2d() }

    override val controller = RamseteController(2.0, 0.7)
    override val kinematics = DifferentialDriveKinematics(Constants.Drive.TRACK_WIDTH.value)
    override val odometry = DifferentialDriveOdometry(gyro())

    override val leftCharacterization = SimpleMotorFeedforward(0.0, 0.0, 0.0)
    override val rightCharacterization = SimpleMotorFeedforward(0.0, 0.0, 0.0)

    override fun disableClosedLoopControl() {}

    override fun enableClosedLoopControl() {}

    init {
        val leftSlave = FalconFX(Constants.Drive.LEFT_SLAVE_ID, DefaultNativeUnitModel)
        val rightSlave = FalconFX(Constants.Drive.RIGHT_SLAVE_ID, DefaultNativeUnitModel)

        leftSlave.follow(leftMotor)
        rightSlave.follow(rightMotor)

        leftMotor.outputInverted = false
        leftSlave.outputInverted = false
        rightMotor.outputInverted = true
        rightSlave.outputInverted = true

        defaultCommand = TeleopDriveCommand()
    }
}
