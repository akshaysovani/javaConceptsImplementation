package Generics;
import java.util.*;
public class League<T extends Team> {
	private String name;
	List<T> allTeams = new ArrayList<>();
	public League(String name){
		this.name = name;
	} 
	
	public String getName(){
		return this.name;
	}
	
	public boolean addTeam(T team){
		if (!this.allTeams.contains(team)){
			this.allTeams.add(team);
			System.out.println("Added " + team.getName() + " to the league " + this.getName());
			return true;
		}else{
			System.out.println("Team " + team.getName() + " already exists in " + this.getName());
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void sortThem(){
		Collections.sort(this.allTeams);
		System.out.println();
		System.out.println("Rankings are as follows: ");
		for (T team: allTeams){
			System.out.println(team.getName() + " : " + team.getRanking());
		}
	}
}
