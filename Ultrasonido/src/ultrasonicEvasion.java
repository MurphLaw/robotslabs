import lejos.hardware.Battery;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class ultrasonicEvasion {
	static String msTouch = "Touch: ";
	static String msLight = "Light: ";
	static String msUsound = "Usound: ";
	static String msGyro ="Gyro: ";
	static String msBattery = "Batt: ";
	static String msMain = "RM Lab No. 1";
	
	float sensorFrequency = 1;
	static EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S2);
	static EV3UltrasonicSensor sonicSensor = new EV3UltrasonicSensor(SensorPort.S3);
	static RegulatedMotor motorL=new EV3LargeRegulatedMotor(MotorPort.B);
	static RegulatedMotor motorR=new EV3LargeRegulatedMotor(MotorPort.A);
	static Battery myBat = new Battery();
	static Float obstacleDistance = 0.35f;
	
	public static void main (String[] args)
	{
		SensorMode myTouch = touchSensor.getTouchMode();
		float [] myTouchSample = new float[myTouch.sampleSize()];
		
		
		SampleProvider myUS = sonicSensor.getDistanceMode();
		float [] mySonarSample = new float[myUS.sampleSize()];
		
		//SampleProvider myAngle = gyroSensor.getAngleMode();
		//float [] myGyroSample = new float[myAngle.sampleSize()];
		while(Button.ESCAPE.isUp()) {
			myTouch.fetchSample(myTouchSample, 0);
			LCD.drawString(msTouch + myTouchSample[0], 0, 2);
			
			myUS.fetchSample(mySonarSample, 0);
			LCD.drawString(msUsound + mySonarSample[0], 0, 3);
			advance();
			if(mySonarSample[0] <= obstacleDistance || myTouchSample[0]== 1) {
				stop();
				do{
					myUS.fetchSample(mySonarSample, 0);
					rotate();
				}while(mySonarSample[0] <= obstacleDistance);
				
				//while(mySonarSample[0] >= 0.4f);
				//stop();
			}
			
			
			
			
			
			
		}

	}
	private static void advance() {
		motorL.forward();
		motorR.forward();
		
	}
	private static void stop() {
		motorL.stop();
		motorR.stop();
		
	}
	
	private static void rotate() {
		motorL.stop();
		motorR.forward();
	}
}
