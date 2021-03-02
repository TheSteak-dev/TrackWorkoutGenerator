package runners;

import java.io.File;

public class MLMain 
{
	public static void main(String[] args)
	{
		File directory = new File("C:\\Users\\skywa\\Documents\\Java Code\\WorkoutGenerator\\TrackWorkoutGenerator\\TrackWorkoutGenerator\\res\\premade");
		String[] files = directory.list();
		for (int i = 0; i < files.length - 1; i++)
		{
			//TODO unpack info
		}
		File difficulties = new File("C:\\Users\\skywa\\Documents\\Java Code\\WorkoutGenerator\\TrackWorkoutGenerator\\TrackWorkoutGenerator\\res\\premade\\difficulties.txt");
		
	}
}
