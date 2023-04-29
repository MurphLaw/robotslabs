import lejos.robotics.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;

@SuppressWarnings("deprecation")
public class RMev3Touch {
    @SuppressWarnings("deprecation")
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