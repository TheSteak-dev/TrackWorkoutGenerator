package runners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
		File difficulties = new File("res/premade/difficulties.txt");
		
		try 
		{
			FileReader test = new FileReader(difficulties);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
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
		
		
		
	}
}
