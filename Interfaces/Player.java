package Interfaces;
import java.util.*;
public class Player implements ISavable {
	private String name;
	private int hitpoints;
	private int strength;
	private String weapon;
	
	public Player(String name, int hitpoints, int strength){
		this.name = name;
		this.hitpoints = hitpoints;
		this.strength = strength;
		this.weapon = "Sword";
	}
	
	public List<String> write(){
		List<String> values = new ArrayList<>();
		values.add(this.name);
		values.add("" + this.hitpoints);
		values.add("" + this.strength);
		values.add(this.weapon);
		return values;
	}
	
	public void read(List<String> savedValues){
		if (!savedValues.isEmpty()){
			this.name = savedValues.get(0);
			this.hitpoints = Integer.parseInt(savedValues.get(1));
			this.strength = Integer.parseInt(savedValues.get(2));
			this.weapon = savedValues.get(3);
		}
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setHitpoint(int hitpoint){
		this.hitpoints = hitpoint;
	}
	
	public void setStrength(int strength){
		this.strength = strength;
	}
	
	public void setWeapon(String weapon){
		this.weapon = weapon;
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
	
	public String getWeapon(){
		return this.weapon;
	}
	
	public String toString(){
		return "Player:{ Name: " + this.name + ", Hitpoints: " + this.hitpoints +
				", Strength: " + this.strength + ", Weapon: " + this.weapon + " }";
	}
	
	
	
}
