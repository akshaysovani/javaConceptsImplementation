package Generics;

public class Main {

	public static void main(String[] args) {
		SoccerPlayer ronaldo = new SoccerPlayer("Ronaldo");
		SoccerPlayer messi = new SoccerPlayer("Messi");
		SoccerPlayer neymar = new SoccerPlayer("Neymar");
		SoccerPlayer tevez = new SoccerPlayer("Tevez");
		SoccerPlayer lahm = new SoccerPlayer("Lahm");
		SoccerPlayer nueur = new SoccerPlayer("Nueur");
		SoccerPlayer ferdinand = new SoccerPlayer("Ferdinand");
		SoccerPlayer raul = new SoccerPlayer("Raul");
		SoccerPlayer benzema = new SoccerPlayer("Benzema");
		
		
		CricketPlayer sachin = new CricketPlayer("Sachin");
		CricketPlayer lara = new CricketPlayer("Lara");
		CricketPlayer dhoni = new CricketPlayer("Dhoni");
		CricketPlayer ponting = new CricketPlayer("Ponting");
		
		FootballPlayer brady = new FootballPlayer("Brady");
		FootballPlayer crews = new FootballPlayer("Crews");
		FootballPlayer brown = new FootballPlayer("Brown");
		FootballPlayer simpson = new FootballPlayer("Simpson");
		
		Team<SoccerPlayer> soccerTeam1 = new Team<>("Soccer Team 1");
		Team<SoccerPlayer> soccerTeam2 = new Team<>("Soccer Team 2");
		Team<SoccerPlayer> soccerTeam3 = new Team<>("Soccer Team 3");
		Team<CricketPlayer> cricketTeam1 = new Team<>("Cricket Team 1");
		Team<CricketPlayer> cricketTeam2 = new Team<>("Cricket Team 2");
		Team<FootballPlayer> footballTeam1 = new Team<>("Football Team1");
		Team<FootballPlayer> footballTeam2 = new Team<>("Football Team2");
		
		soccerTeam1.addPlayer(ronaldo);
		soccerTeam1.addPlayer(messi);
		soccerTeam1.addPlayer(neymar);
		soccerTeam2.addPlayer(tevez);
		soccerTeam2.addPlayer(lahm);
		soccerTeam2.addPlayer(nueur);
		soccerTeam3.addPlayer(ferdinand);
		soccerTeam3.addPlayer(raul);
		soccerTeam3.addPlayer(benzema);
		
		cricketTeam1.addPlayer(sachin);
		cricketTeam1.addPlayer(lara);
		cricketTeam2.addPlayer(dhoni);
		cricketTeam2.addPlayer(ponting);
		
		footballTeam1.addPlayer(brady);
		footballTeam1.addPlayer(crews);
		footballTeam2.addPlayer(brown);
		footballTeam2.addPlayer(simpson);
		
		League<Team<SoccerPlayer>> UEFA = new League<>("UEFA");
		League<Team<CricketPlayer>> IPL = new League<>("IPL");
		League<Team<FootballPlayer>> NFL = new League<>("NFL");
		
		UEFA.addTeam(soccerTeam1);
		UEFA.addTeam(soccerTeam2);
		UEFA.addTeam(soccerTeam3);
		
		IPL.addTeam(cricketTeam1);
		IPL.addTeam(cricketTeam2);
		
		NFL.addTeam(footballTeam1);
		NFL.addTeam(footballTeam2);
		
		soccerTeam1.matchResult(soccerTeam2, 1, 2);
		soccerTeam2.matchResult(soccerTeam3, 4, 0);
		soccerTeam1.matchResult(soccerTeam3, 1, 5);
		
		cricketTeam1.matchResult(cricketTeam2, 200, 400);
		
		footballTeam1.matchResult(footballTeam2, 22, 22);
		
		UEFA.sortThem();
		IPL.sortThem();
		NFL.sortThem();
	}
}
