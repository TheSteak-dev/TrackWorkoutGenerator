package runners;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import data.MachineLearningFunctions;
import datastructure.Set;
import datastructure.Workout;

public class MLMain 
{
	private static double[] y;
	private static double[][] x;
	private static double[] theta;
	private static double alpha;
	
	private static int premadeNum = 50;
	
	private static final int maxSets = 8;
	private static final int parameters = 4;
	
	private static Workout[] presetWorkouts;
	
	
	public static void main(String[] args)
	{
		
		File preset = new File ("res/premade");
		File difficulties = new File("res/premade/difficulties.txt");
		Scanner scanner;
		try 
		{
			scanner = new Scanner(difficulties);
		} 
		catch (FileNotFoundException e) 
		{
			scanner = null;
			e.printStackTrace();
		}
		
		premadeNum = --presetWorkouts.length;
		
		presetWorkouts = new Workout[premadeNum];
		
		y = new double[premadeNum];
		x = new double[premadeNum * maxSets][parameters];
		theta = new double[maxSets];
		alpha = 0.1;
		
		for (int i = 0; i < premadeNum; i++)
		{
			Workout temp = new Workout(preset.listFiles()[i].toString());
			presetWorkouts[i] = temp;
			
			y[i] = scanner.nextInt();
			Set[] s = temp.getSets();
			for (int j = 0; i < s.length; j++)
			{
				x[premadeNum * i + j][0] = s[j].getDistance();
				x[premadeNum * i + j][1] = s[j].getRest();
				x[premadeNum * i + j][2] = s[j].getType();
				x[premadeNum * i + j][3] = s[j].getReps().length;
			}
		}
		
		MachineLearningFunctions.linearGradientDescent(theta, x, y, alpha, 100);
		
	}
}
