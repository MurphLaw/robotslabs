import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;

public class triangleScript {


    
    public static void main(String[] args) {
        
       RegulatedMotor leftMotor=new EV3LargeRegulatedMotor(MotorPort.B);
       RegulatedMotor rightMotor=new EV3LargeRegulatedMotor(MotorPort.A);
        
       @SuppressWarnings("deprecation")
		DifferentialPilot pilot=new DifferentialPilot(6.24, 11.55, leftMotor, rightMotor);
        
       for(int i=0;i<3;i++) {
           pilot.travel(50);
           pilot.rotate(180);
       }
    }
    
}

/**
public class paraScript {
	static String msMain = "Lab RM No. 1 para";
	static String msMainT = "paralealgo";
	
	static int motorSpeed = 700;
	
	static int tacoCountLimit = 400;
	static int rectangularAngle = 90;
	static int treedAngle = 135;
	static int tacoCount;
	
	static RegulatedMotor motorL = new EV3LargeRegulatedMotor(MotorPort.A);
	static RegulatedMotor motorR = new EV3LargeRegulatedMotor(MotorPort.B);
	
	public static void main(String[] args)
	{
	
		
		motorL.resetTachoCount();
		motorR.resetTachoCount();
		
		motorL.setSpeed(motorSpeed);
		motorR.setSpeed(motorSpeed);
		
		LCD.clear();
		LCD.drawString(msMain, 3, 0);
		LCD.drawString(msMainT, 0, 1);
		
		while(Button.ESCAPE.isUp()) {
			doTriangle();
		}
	}
	
	private static void doTriangle() {
		
		for (int i = 0; i < 3; i++) {
			go();
			if(i<2) {
				motorL.rotate(triangularAngle);
				motorL.stop();
			}
			motorL.resetTachoCount();
			motorR.resetTachoCount();
		}
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
**/