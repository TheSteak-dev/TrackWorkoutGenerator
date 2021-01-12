package comparators;

import java.util.Comparator;

import datastructure.Workout;

public class CompareByDifficulty implements Comparator<Workout>
{

	@Override
	public int compare(Workout one, Workout two) 
	{
		return one.getDifficulty() - two.getDifficulty();
	}

}
