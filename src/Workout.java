

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//a class that represents a whole workout

public class Workout {
	
	private Set[] sets;
	private final int difficulty;
	private int totalDistance;
	private Scanner scanner;
	private int type;
	
	public static final int SPEED = 1234;
	public static final int SPEEDENDURANCE1 = 2345;
	public static final int SPEEDENDURANCE2 = 3456;
	public static final int ENDURANCE = 4567;
	
	public Workout(String fileName) 
	{
		LogWriter.write("Workout Loaded: " + fileName);
		this.type = -1;
		totalDistance = 0;
		sets =  new Set[0];

		try
		{
			scanner = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e) 
		{

			e.printStackTrace();
		}
		type = scanner.nextInt();
		scanner.nextLine(); //eating a line
		
		ArrayList<String> reps = new ArrayList<String>();
		while(scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			if (line.equals("terminate")) break;
			if (line.equals("end"))
			{
				Set set = decode(reps);
				addSet(set);
				totalDistance += set.getDistance();
				reps.clear();
			}
			else
			{
				reps.add(line);
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
	
	public String toprint()
	{
		String text = "";
		for (Set set : sets)
		{
			text += set.tostring();
		}
		return text;
	}
	
	public String pack()
	{
		String text = type + "";
		for (Set set : sets)
		{
			text += set.pack();
		}
		return text;
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
	public String toString()
	{
		if (type == 1234) return "Type: Speed                          | Difficulty : " + difficulty;
		if (type == 2345) return "Type: Speed Endurance I   | Difficulty : " + difficulty;
		if (type == 3456) return "Type: Speed Endurance II  | Difficulty : " + difficulty;
		if (type == 4567) return "Type: Endurance                  | Difficulty : " + difficulty;
		return null;
	}
	private int calculateDifficulty()
	{
		int total = 0;
		for (Set set : sets)
		{
			total += set.getDifficulty();
		}
		//System.out.println(total);
		return total;
	}
	private Set decode(ArrayList<String> array)
	{
		if (array.size() == 3) //ladder
		{
			for (String bit : array)
			{
				System.out.println(bit);
			}
			int type = Integer.parseInt(array.get(0));
			String[] reps = array.get(1).split("-");
			for (String bit : reps)
			{
				System.out.println(bit);
			}
			int rest = Integer.parseInt(array.get(2));
			return new Ladder(type, reps, rest);
		}
		else if (array.size() == 4) //straight
		{
			int type = Integer.parseInt(array.get(0));
			String rep = array.get(1);
			int reps = Integer.parseInt(array.get(2));
			int rest = Integer.parseInt(array.get(3));
			return new Straight(type, rep, reps, rest);
		}
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
