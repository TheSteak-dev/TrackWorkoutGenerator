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
		
		presetWorkouts = new Workout[preset.listFiles().length];
		for (int i = 0; i < preset.listFiles().length; i++)
		{
			presetWorkouts[i] = new Workout(preset.listFiles()[i].toString());
		}
		
		premadeNum = presetWorkouts.length - 1;
		
		presetWorkouts = new Workout[premadeNum];
		
		y = new double[(parameters + 1) * parameters];
		x = new double[premadeNum * maxSets][(parameters + 1) * parameters];
		theta = new double[maxSets];
		alpha = 0.01;
		
		for (int i = 0; i < (parameters + 1) * parameters; i++)
		{
			Workout temp = new Workout(preset.listFiles()[i].toString());
			presetWorkouts[i] = temp;
			
			y[i] = scanner.nextInt();
			Set[] s = temp.getSets();
			for (int j = 0; j < s.length; j++)
			{
				Set set = s[j];
				x[maxSets * i + j][0] = set.getDistance();
				x[maxSets * i + j][1] = set.getRest();
				x[maxSets * i + j][2] = set.getType();
				x[maxSets * i + j][3] = set.getReps().length;
				x[maxSets * i + j][4] = set.getDistance() * set.getDistance();
				x[maxSets * i + j][5] = set.getRest() * set.getDistance();
				x[maxSets * i + j][6] = set.getType() * set.getDistance();
				x[maxSets * i + j][7] = set.getReps().length * set.getDistance();
				x[maxSets * i + j][8] = set.getDistance() * set.getRest();
				x[maxSets * i + j][9] = set.getRest() * set.getRest();
				x[maxSets * i + j][10] = set.getType() * set.getRest();
				x[maxSets * i + j][11] = set.getReps().length * set.getRest();
				x[maxSets * i + j][12] = set.getDistance() * set.getType();
				x[maxSets * i + j][13] = set.getRest() * set.getType();
				x[maxSets * i + j][14] = set.getType() * set.getType();
				x[maxSets * i + j][15] = set.getReps().length * set.getType();
				x[maxSets * i + j][16] = set.getDistance() * set.getReps().length;
				x[maxSets * i + j][17] = set.getRest() * set.getReps().length;
				x[maxSets * i + j][18] = set.getType() * set.getReps().length;
				x[maxSets * i + j][19] = set.getReps().length * set.getReps().length;
			}
		}
		System.out.println("\n\nCost: " + (double)MachineLearningFunctions.calculateLinearCost(theta, x, y));
		MachineLearningFunctions.linearGradientDescent(theta, x, y, alpha, 100);
		
	}
}
