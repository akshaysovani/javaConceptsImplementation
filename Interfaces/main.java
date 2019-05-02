package Interfaces;
import java.util.*;
public class main {

	public static void main(String[] args) {
		Player kunal = new Player("Kunal", 100, 500);
		System.out.println(kunal);
		kunal.setHitpoint(1400);
		System.out.println(kunal);
		saveObject(kunal);
		loadObject(kunal);
		System.out.println(kunal);
		
		ISavable wolf = new Monster("Wolf", 2700, 5000);
		System.out.println(wolf);
		saveObject(wolf);
		loadObject(wolf);
		System.out.println(wolf);
	}
	
	public static ArrayList<String> addStrings(){
		ArrayList<String> stringList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		System.out.println("Enter 1 of below");
		System.out.println("1. Add new String");
		System.out.println("2. Quit");
		while(!quit){
			System.out.println("Choose your option..");
			int input = sc.nextInt();
			sc.nextLine();
			switch(input){
			case 1: 
				System.out.println("Enter a string");
				String next = sc.nextLine();
				stringList.add(next);
				break;
			case 2:
				quit = true;
				break;
			}
		}
		return stringList;
	}
	
	public static void saveObject(ISavable objectToSave){
		for (int i=0;i<objectToSave.write().size();i++){
			System.out.println("Written " + objectToSave.write().get(i) + " to storage..");
		}
	}
	
	public static void loadObject(ISavable objectToLoad){
		List<String> values = addStrings();
		objectToLoad.read(values);
	}	
}