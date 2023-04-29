package paraalgo;

import lejos.robotics.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;
import lejos.hardware.motor.*;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.*;

public class paraScript {
	static String msMain = "Lab RM No. 1 para";
	static String msMainT = "paralealgo";
	
	static int lado = 80;
	static int ladoExt= 150;
	
	static int motorSpeed = 700;
	
	static int tacoCountLimit = 400;
	static int rectangularAngle = 90;
	static int treedAngle = 135;
	static int tacoCount;
	static RegulatedMotor leftMotor=new EV3LargeRegulatedMotor(MotorPort.B);
    static RegulatedMotor rightMotor=new EV3LargeRegulatedMotor(MotorPort.A);
     
    @SuppressWarnings("deprecation")
	static DifferentialPilot pilot=new DifferentialPilot(6.24, 11.55, leftMotor, rightMotor);

	
	public static void main(String[] args)
	{

		
		LCD.clear();
		LCD.drawString(msMain, 3, 0);
		LCD.drawString(msMainT, 0, 1);
		
		while(Button.ESCAPE.isUp()) {
			doRectangle();
			doUpperFace();
			doRightSide();
			doComplete();
			break;
			
			
		}
	}
	
	private static void doRectangle() {
		
		for (int i = 0; i < 4; i++) {
			pilot.travel(lado);
			if(i  < 3) {
				pilot.rotate(170);
			}

		}
	}
	private static void doUpperFace() {
		pilot.rotate(-190);
		for(int i = 0; i< 2; i ++) {
			pilot.travel(lado);
			pilot.rotate(-170);
			
		}
		
	}
	
	private static void doComplete() {
		
		pilot.rotate(-170);
		pilot.travel(lado);
		pilot.rotate(-170);
		pilot.travel(lado);
		
	}
	private static void doRightSide() {
		pilot.travel(ladoExt);
		pilot.rotate(-170);
		pilot.travel(lado);
	}
	
}