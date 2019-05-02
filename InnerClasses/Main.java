package InnerClasses;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		GearBox ferrariGearBox = new GearBox(5);
		ferrariGearBox.turnOn();
		ferrariGearBox.addGear(1, 5.3);
		ferrariGearBox.addGear(2, 10.6);
		ferrariGearBox.addGear(3, 15.9);
		ferrariGearBox.operateClutch(true);
		ferrariGearBox.changeGear(1);
		ferrariGearBox.operateClutch(false);
		System.out.println("Wheel speed is :" + ferrariGearBox.wheelSpeed(1000));
		ferrariGearBox.operateClutch(false);
		ferrariGearBox.changeGear(2);
		ferrariGearBox.operateClutch(true);
		ferrariGearBox.changeGear(2);
		System.out.println("Wheel speed is :" + ferrariGearBox.wheelSpeed(2000));
		System.out.println("Drive speed of the current gear ("+ ferrariGearBox.getCurrentGear() + ") is: " + ferrariGearBox.getDriveSpeed(200));
	}
}
