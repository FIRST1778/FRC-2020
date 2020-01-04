package org.frc1778.robot

import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.Joystick
import java.lang.Exception
import org.frc1778.freezylib.framework.LoggedTimedRobot
import org.frc1778.freezylib.logging.FreezyLog
import org.frc1778.freezylib.logging.PolledField
import org.frc1778.freezylib.logging.TaggedField
import org.frc1778.freezylib.util.Controllers
import org.frc1778.freezylib.util.Measurement

object Robot : LoggedTimedRobot() {

    private val logitechF310 = Joystick(0)
    private val autoSectionField = TaggedField("Auto Section", Measurement.Unitless.UNITLESS, String::class)
    private val testField = PolledField("Test", Measurement.Unitless.UNITLESS) { if (DriverStation.getInstance().isEnabled) Math.random().toString() else "" }
    private val timeField = PolledField("Time", Measurement.Duration.SECONDS) { if (DriverStation.getInstance().isEnabled) DriverStation.getInstance().matchTime.toString() else "" }

    init {
        FreezyLog.addField(timeField)
        FreezyLog.addField(autoSectionField)
        FreezyLog.addField(testField)
    }

    override fun autonomousPeriodic() {
        if (Math.random() < 0.1) {
            autoSectionField.updateTag("Auto is doing stuff")
        }
    }

    override fun teleopInit() {
        throw Exception("Test exception")
    }

    override fun teleopPeriodic() {
        if (logitechF310.getRawButtonPressed(Controllers.LogitechF310.A.ordinal)) {
            autoSectionField.updateTag("A pressed")
        }
    }
}
