package runners;

import java.io.File;

import datastructure.Workout;

public class MLMain 
{
	private static double[] y;
	private static double[][] x;
	private static double[] theta;
	private static double alpha;
	
	private static int premadeNum = 0;
	
	private static final int parameters = 4;
	
	private static Workout[] presetWorkouts;
	
	public static void main(String[] args)
	{
		
		File preset = new File ("res/premade");
		premadeNum = presetWorkouts.length - 1;
		
		presetWorkouts = new Workout[premadeNum];
		
		y = new double[premadeNum];
		x = new double[premadeNum][parameters];
		theta = new double[parameters];
		alpha = 0.1;
		
		for (int i = 0; i < premadeNum; i++)
		{
			presetWorkouts[i] = new Workout(preset.listFiles()[i].toString());
			//TODO unpack info
		}
		
		File difficulties = new File("C:\\Users\\skywa\\Documents\\Java Code\\WorkoutGenerator\\TrackWorkoutGenerator\\TrackWorkoutGenerator\\res\\premade\\difficulties.txt");
		
	}
}
