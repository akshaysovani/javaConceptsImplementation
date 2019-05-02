package InnerClasses;
import java.util.*;
public class GearBox {
	private int maxGears;
	private int currentGear;
	List<Gear> gears;
	boolean clutchIsIn;
	public GearBox(int maxGears){
		this.maxGears = maxGears;
		gears = new ArrayList<>();
		Gear neutral = new Gear(0, 0.0);
		this.currentGear = 0;
		gears.add(neutral);
	}
	
	public void operateClutch(boolean state){
		System.out.println("Clutch engaged: " + state);
		this.clutchIsIn = state;
	}
	
	public void addGear(int gearNumber, double ratio){
		if (gearNumber>0 && gearNumber<=this.maxGears){
			this.gears.add(new Gear(gearNumber, ratio));
		}
	}

	public void changeGear(int gearNumber){
		if ((gearNumber>=0 && gearNumber<this.gears.size()) && clutchIsIn){
			this.currentGear = gearNumber;
			System.out.println("Changed gear to "+this.currentGear);
			clutchIsIn = false;
		}else{
			System.out.println("Cannot change gear.. Clutch is not in");
			this.currentGear = 0;
		}
	}
	
	public double wheelSpeed(int revs){
		if (clutchIsIn){
			System.out.println("Clutch is in. Can't accelerate now");
			return 0.0;
		}else{
			return revs*(this.gears.get(currentGear).getRatio());
		}
	}
	
	public double getDriveSpeed(int revs){
		return revs*(this.gears.get(currentGear)).driveSpeed(revs);
	}
	
	public int getCurrentGear(){
		return this.currentGear;
	}
	
	public void turnOn(){
		System.out.println("Turning on gearbox system..");
	}
	
	private class Gear{
		private int gearNumber;
		private double ratio; 
		public Gear(int number, double ratio){
			this.gearNumber = number;
			this.ratio = ratio;
		}
		
		public double getRatio(){
			return this.ratio;
		}
		
		public double driveSpeed(int revs){
			return revs*(this.ratio);
		}
	}
}
