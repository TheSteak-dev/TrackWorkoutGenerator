package workout;

import java.util.Scanner;

//a class that represents a whole workout

public class Workout {
	
	private Set[] sets;
	private final int difficulty;
	private int totalDistance;
	private Scanner scanner;
	private final int type;
	
	public static final int SPEED = 1234;
	public static final int SPEEDENDURANCE1 = 2345;
	public static final int SPEEDENDURANCE2 = 3456;
	public static final int ENDURANCE = 4567;
	
	public Workout(int type, String fileName) 
	{

		this.type = -1;
		totalDistance = 0;
		sets =  new Set[0];
		
		
		scanner = new Scanner(fileName);
		type = scanner.nextInt();
		String reps = "";
		while(scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			if (line.equals("end"))
			{
				Set set = decode(reps);
				addSet(set);
				totalDistance += set.getDistance();
			}
		}
		difficulty = calculateDifficulty();
		scanner.close();

		
		
		
		
	}
	
//	public Workout(int type)
//	{
//		this.type = 0;
//		//TODO (generate)
//	}
	
	public String toString()
	{
		return "";
	}
	
	public int getType()
	{
		return type;
	}
	
	public int getTotalDistance()
	{
		return totalDistance;
	}
	
	public int getDifficulty()
	{
		return difficulty;
	}
	
	public Set[] getSets()
	{
		return sets;
	}
	
	private int calculateDifficulty()
	{
		return 0;
	}
	private Set decode(String str)
	{
		return null;
	}
	private void addSet(Set set)
	{
		int length = sets.length;
		Set[] copy = new Set[length + 1];
		for (int i = 0; i < length; i++)
		{
			copy[i] = sets[i];
		}
		copy[length] = set;
		sets = copy;
	}
}
