package paraalgo;

import lejos.robotics.*;
import lejos.utility.Delay;
import lejos.hardware.motor.*;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.*;

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
		
		while(true) {
			doRectangle();
			motorR.rotate(treedAngle);
			doUpperFace();
			doComplete();
			
			
			
		}
	}
	
	private static void doRectangle() {
		
		for (int i = 0; i < 4; i++) {
			go();
			if(i<3) {
				motorL.rotate(rectangularAngle);
				motorL.stop();
			}
			motorL.resetTachoCount();
			motorR.resetTachoCount();
		}
	}
	private static void doUpperFace() {
		motorL.resetTachoCount();
		motorR.resetTachoCount();
		for (int i = 0; i < 3; i++) {
			go();
			if(i<2) {
				motorR.rotate(rectangularAngle);
				motorR.stop();
			}

		}
	}
	
	private static void doComplete() {
		go();
		motorL.rotate(45);
		go();
		motorL.rotate(45);
		go();
		
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