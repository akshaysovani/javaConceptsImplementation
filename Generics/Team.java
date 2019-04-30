package Generics;
import java.util.*;
public class Team<T extends Player> implements Comparable<Team<T>>{
	private String name;
	private List<T> teamMembers = new ArrayList<>();
	int played = 0;
	int won = 0;
	int lost = 0;
	int tied = 0;
	
	public Team(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public boolean addPlayer(T player){
		if (!teamMembers.contains(player)){
			teamMembers.add(player);
			System.out.println("Player "+ player.getName() + " is added to the team "+this.getName());
			return true;
		}else{
			System.out.println("Player "+ player.getName() + " is already on the team");
			return false;
		}
	}
	
	public int getNumberOfPlayers(){
		return this.teamMembers.size();
	}
	
	public void matchResult(Team<T> opponent, int ourScore, int TheirScore){
		String message;
		if (ourScore>TheirScore){
			this.won++;
			message = " beat "; 
		}else if (ourScore<TheirScore){
			this.lost++;
			message = " lost to ";
		}else{
			this.tied++;
			message = " Tied with ";
		}
		if (opponent!=null){
			System.out.println(this.getName() + message + opponent.getName());
			opponent.matchResult(null, TheirScore, ourScore);
		}
	}
	
	public int getRanking(){
		return (this.won*2)+this.tied;
	}
	
	public int compareTo(Team<T> team){
		if (this.getRanking()>team.getRanking()){
			return -1;
		}else if (this.getRanking()<team.getRanking()){
			return 1;
		}else{
			return 0;
		}
	}
	
}
