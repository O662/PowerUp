package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;
import org.usfirst.frc.team3335.robot.RobotPreferences;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DoubleUltrasonic extends Subsystem implements LoggableSubsystem{
	// TODO set voltageToInches correctly for ultrasonics
	private static final double kVoltageToInches = 40.2969;
	private final AnalogInput ultrasonicLeft;
	private final AnalogInput ultrasonicRight;
	private final AnalogInput ultrasonicFront;

	/**
	 * Constructor.
	 *
	 * <p>This implementation requires the ultrasonics be wired with Pin 3-AN as
	 * the signal pin.  More information from the MaxBotix LV-MaxSonar-EZ
	 * datasheet is below.</p>
	 *
	 * <pre>
	 * Pin Out Description
     * Pin 1-BW
     *  *Leave open or hold low for serial output on the TX output.
     *  When BW pin is held high the TX output sends a pulse
     *  (instead of serial data), suitable for low noise chaining.
     * Pin 2-PW
     *  This pin outputs a pulse width representation of range. The
     *  distance can be calculated using the scale factor of 147uS per inch. 
     * Pin 3-AN
     *  Outputs analog voltage with a scaling factor of (Vcc/512) per inch.
     *  A supply of 5V yields ~9.8mV/in. and 3.3V yields ~6.4mV/in. The
     *  output is buffered and corresponds to the most recent range data. 
     * Pin 4-RX
     *  This pin is internally pulled high. The LV-MaxSonar-EZ will
     *  continually measure range and output if RX data is left unconnected
     *  or held high. If held low the sensor will stop ranging. Bring high
     *  for 20uS or more to command a range reading. 
     * Pin 5-TX
     *  When the *BW is open or held low, the TX output delivers asynchronous
     *  serial with an RS232 format, except voltages are 0-Vcc. The output
     *  is an ASCII capital “R”, followed by three ASCII character digits
     *  representing the range in inches up to a maximum of 255, followed by
     *  a carriage return (ASCII 13). The baud rate is 9600, 8 bits, no 
     *  parity, with one stop bit. Although the voltage of 0-Vcc is outside
     *  the RS232 standard, most RS232 devices have sufficient margin to read
     *  0-Vcc serial data. If standard voltage level RS232 is desired, invert,
     *  and connect an RS232 converter such as a MAX232. When BW pin is held
     *  high the TX output sends a single pulse, suitable for low noise
     *  chaining. (no serial data)
     * Pin 6-+5V Vcc
     *  Operates on 2.5V - 5.5V. Recommended current capability of 3mA for 5V,
     *  and 2mA for 3V. Please reference page 4 for minimum operating voltage
     *  verses temperature information. 
     * Pin 7-GND
     *  Return for the DC power supply. GND (& Vcc) must be ripple and noise
     *  free for best operation. 
     * </pre>
	 */
	public DoubleUltrasonic() {
		ultrasonicLeft = new AnalogInput(RobotMap.ANALOG_ULTRASONIC_BACK_LEFT);
		ultrasonicRight = new AnalogInput(RobotMap.ANALOG_ULTRASONIC_BACK_RIGHT);
		ultrasonicFront = new AnalogInput(RobotMap.ANALOG_ULTRASONIC_FRONT);
		
		
	}
;
	public double getDistanceLeft() {
		return getDistance(ultrasonicLeft);
	}

	public double getDistanceRight() {
		return getDistance(ultrasonicRight);
	}
	
	public double getDistanceFront() {
		return getDistance(ultrasonicFront);
	}

	public double getDistance() {
		return 0.5*(getDistanceLeft()+getDistanceRight());
	}

	private double getDistance(AnalogInput ultrasonic) {
		return ultrasonic.getAverageVoltage()*kVoltageToInches;
	}

	@Override
	protected void initDefaultCommand() {
	}

	@Override
	public void log() {
		SmartDashboard.putNumber("UltraSonic Right distance", getDistanceRight());
		SmartDashboard.putNumber("UltraSonic Left distance", getDistanceLeft());
		SmartDashboard.putNumber("Ultrasonic Front distance", getDistanceFront());
		SmartDashboard.putNumber("UltraSonic combined distance", getDistance());
		
		
	}

}
