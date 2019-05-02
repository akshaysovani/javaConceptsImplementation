package Interfaces;
import java.util.*;
import java.util.ArrayList;

public class Monster implements ISavable {
	private String name;
	private int hitpoints;
	private int strength;
	
	public Monster(String name, int hitpoints, int strength){
		this.name = name;
		this.hitpoints = hitpoints;
		this.strength = strength;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getHitpoints(){
		return this.hitpoints;
	}
	
	public int getStrength(){
		return this.strength;
	}
	
	public String toString(){
		return "Player:{ Name: " + this.name + ", Hitpoints: " + this.hitpoints +
				", Strength: " + this.strength + " }";
	}
	
	public List<String> write(){
		List<String> values = new ArrayList<>();
		values.add(this.name);
		values.add("" + this.hitpoints);
		values.add("" + this.strength);
		return values;
	}
	
	public void read(List<String> savedValues){
		if (!savedValues.isEmpty()){
			this.name = savedValues.get(0);
			this.hitpoints = Integer.parseInt(savedValues.get(1));
			this.strength = Integer.parseInt(savedValues.get(2));
		}
	}
}
