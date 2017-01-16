import ShefRobot.*;
public class Roboy {

	//references to motor's components
	private static Robot myRobot = new Robot();
	private static Motor leftMotor = myRobot.getLargeMotor(Motor.Port.B);
	private static Motor rightMotor = myRobot.getLargeMotor(Motor.Port.C);
	private static ColorSensor colorSensor = myRobot.getColorSensor(Sensor.Port.S2);

	
	public static void rotate(int angleL, int angleR) {
		leftMotor.rotate(angleL,true);
		rightMotor.rotate(angleR,true);
	}
	
	public static void rightLeft() {
		if (colorSensor.getColor() == ColorSensor.Color.WHITE) {
			Roboy.rotate(230, -230);
		}		
		else {
			Roboy.forward();
		}
	}
	/*
	public static void realign() {
		while (colorSensor.getColor() != ColorSensor.Color.BLACK) {
			Roboy.rotate(4,-4);
		}
		Roboy.rotate(15,15);
		Roboy.rotate(30,-30);
	}
	
	*/
	
	public static void align() {
		int x = 90;
		int y = 10;
		int D = 10;
		int consec = 0;
		int goal = 10;
		
		//move forward roboy until he finds part of the path
		while (colorSensor.getColor() == ColorSensor.Color.WHITE){
			Roboy.forward();
		}
		
		//once on black line, roboy will adjust himself and 
		if (colorSensor.getColor() == ColorSensor.Color.BLACK) {
			System.out.println(colorSensor.getColor());
			while (consec != goal) {
				//Roboy.rotate(90,-90); //rotate an amount in degrees to the right
				Roboy.rotate(200,200); //move forward an amount
				Roboy.stop();
				
				if (colorSensor.getColor() == ColorSensor.Color.BLACK) {
					consec +=1;
				}
				else {
					consec = 0;
					Roboy.rotate(90,-90); //rotate an amount in degrees to the right
				}
				/*
				if (x > 0) {
					Roboy.rotate(90,-90); //rotate an amount in degrees to the right
					Roboy.rotate(200,200); //move forward an amount
					Roboy.stop();
					//after it moves forward... 
					if (colorSensor.getColor() == ColorSensor.Color.BLACK) {
					}
					else {
						Roboy.rotate(180,-180); //rotate an amount in degrees to the right to go back to starting point
						Roboy.rotate(200,200);
						x = x-y;
					}
				}
				else {
					x = 90;
					y = y-1;
				}
				*/
			}
		}
	}
	
	public static void stop() {
		leftMotor.stop();
		rightMotor.stop();
	}
	
	public static void forward() {
		leftMotor.forward();
		rightMotor.forward();
	}
	public static void backward() {
		leftMotor.backward();
		rightMotor.backward();
	}
	
	public static void main(String [] args) {
		Roboy control = new Roboy();
		//go forward
		leftMotor.setSpeed(150);
		rightMotor.setSpeed(150);
			
		//Roboy.rightLeft();
		/*
		while (colorSensor.getColor() == ColorSensor.Color.WHITE) {
			Roboy.rotate(230,-230);
		}
		while (colorSensor.getColor() == ColorSensor.Color.BLACK) {
			Roboy.forward();
		}
		
		*/
		
		Roboy.align();
		//stop
		Roboy.stop();
		
	}
}