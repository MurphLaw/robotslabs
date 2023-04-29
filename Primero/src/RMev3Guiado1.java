import lejos.robotics.*;
//import lejos.hardware.lcd.*;
import lejos.hardware.sensor.*;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.*;
import lejos.hardware.*;
import lejos.utility.*;

public class RMev3Guiado1 {
	static String msTouch = "Touch: ";
	static String msLight = "Light: ";
	static String msUsound = "Usound: ";
	static String msGyro ="Gyro: ";
	static String msBattery = "Batt: ";
	static String msMain = "RM Lab No. 1";
	
	float sensorFrequency = 1;
	static EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);
	static EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S2);
	static EV3UltrasonicSensor sonicSensor = new EV3UltrasonicSensor(SensorPort.S3);
	//static EV3GyroSensor gyroSensor = new EV3GyroSensor(SensorPort.S4);
	static Battery myBat = new Battery();
	
	public static void main (String[] args)
	{
		SensorMode myColor = colorSensor.getRGBMode();
		float [] myColorSample = new float[myColor.sampleSize()];
		
		SensorMode myTouch = touchSensor.getTouchMode();
		float [] myTouchSample = new float[myTouch.sampleSize()];
		
		SampleProvider myUS = sonicSensor.getDistanceMode();
		float [] mySonarSample = new float[myUS.sampleSize()];
		
		//SampleProvider myAngle = gyroSensor.getAngleMode();
		//float [] myGyroSample = new float[myAngle.sampleSize()];
		
		while(Button.ESCAPE.isUp()) 
		{
			LCD.clear();
			LCD.drawString(msMain, 3, 0);
			
			myColor.fetchSample(myColorSample, 0);
			myTouch.fetchSample(myTouchSample, 0);
			myUS.fetchSample(mySonarSample, 0);
			//myAngle.fetchSample(myGyroSample, 0);
			
			LCD.drawString(msLight + myColorSample[0], 0, 1);
			LCD.drawString(msTouch + myTouchSample[0], 0, 2);
			LCD.drawString(msUsound + mySonarSample[0], 0, 3);
			//LCD.drawString(msGyro + myGyroSample[0], 0, 4);
			//LCD.drawString(msBattery + myBat.getVoltage() + " V", 0, 5);
			
			Delay.msDelay((long) 1000);
		}
		
		colorSensor.close();
		touchSensor.close();
		sonicSensor.close();
		//gyroSensor.close();
	}
	private static void go() {
		motorL.forward();
		motorR.forward();
		Delay.msDelay(1000);
		motorL.stop();
		motorR.stop();
		motorL.resetTachoCount();
		motorR.resetTachoCount();
	}
}