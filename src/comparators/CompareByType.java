package comparators;

import java.util.Comparator;

import datastructure.Workout;

public class CompareByType implements Comparator<Workout>
{

	@Override
	public int compare(Workout one, Workout two) 
	{
		int i = one.getType() - two.getType();
		if (i == 0)
			return one.getDifficulty() - two.getDifficulty();
		return i;
	}

}