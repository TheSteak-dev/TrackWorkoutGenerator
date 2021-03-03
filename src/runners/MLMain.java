package runners;

import java.io.File;

public class MLMain 
{
	private static double[] y;
	private static double[][] x;
	private static double[] theta;
	private static double alpha;
	
	private static int premadeNum = 0;
	
	private static final int parameters = 4;
	
	public static void main(String[] args)
	{
		File directory = new File("C:\\Users\\skywa\\Documents\\Java Code\\WorkoutGenerator\\TrackWorkoutGenerator\\TrackWorkoutGenerator\\res\\premade");
		String[] files = directory.list();
		
		premadeNum = files.length - 1;
		
		y = new double[premadeNum];
		x = new double[premadeNum][parameters];
		theta = new double[parameters];
		alpha = 0.1;
		
		
		for (int i = 0; i < premadeNum; i++)
		{
			//TODO unpack info
		}
		File difficulties = new File("C:\\Users\\skywa\\Documents\\Java Code\\WorkoutGenerator\\TrackWorkoutGenerator\\TrackWorkoutGenerator\\res\\premade\\difficulties.txt");
		
	}
}
