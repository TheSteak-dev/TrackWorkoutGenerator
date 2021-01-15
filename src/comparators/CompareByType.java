package comparators;

import java.util.Comparator;

import datastructure.Workout;

public class CompareByType implements Comparator<Workout>
{

	@Override
	public int compare(Workout one, Workout two) 
	{
		return one.getType() - two.getType();
	}

}