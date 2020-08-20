package workout;

import java.io.FileWriter;
import java.io.IOException;

public class Workout {
	
	private final Set[] sets;
	private final int difficulty;
	private final int totalDistance;
	private FileWriter writer;
	
	public static final int SPEED = 1234;
	public static final int SPEEDENDURANCE1 = 2345;
	public static final int SPEEDENDURANCE2 = 3456;
	public static final int ENDURANCE = 4567;
	
	public Workout(int type, String fileName) 
	{
		try 
		{
			writer = new FileWriter(fileName);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	public Workout(int type)
	{
		//TODO (generate)
	}
	
	public String toString()
	{
		return "";
	}
	
	public int getType()
	{
		return 0;
	}
	
	public int getTotalDistance()
	{
		return 0;
	}
	
	public int getDifficulty()
	{
		return 0;
	}
	
	public Set[] getSets()
	{
		return null;
	}
}
