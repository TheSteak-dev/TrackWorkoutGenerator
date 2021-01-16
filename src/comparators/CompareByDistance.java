package comparators;

import java.util.Comparator;

import datastructure.Workout;

public class CompareByDistance implements Comparator<Workout>
{

	@Override
	public int compare(Workout one, Workout two) 
	{
		return one.getTotalDistance() - two.getTotalDistance();
	}

}