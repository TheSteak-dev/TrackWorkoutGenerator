

public class Ladder implements Set 
{

	private Rep[] reps;
	private int type, difficulty, rest, totalDistance;
	
	public Ladder(int type) 
	{
		// TODO generate workout
	}
	
	//build off reading in
	public Ladder(int type, String[] stringReps, int rest)
	{
		this.rest = rest;
		this.type = type;
		for (int i = 0; i < stringReps.length; i++)
		{
			Rep rep = decode(stringReps[i]);
			reps[i] = rep;
			totalDistance += rep.getDistance();
		}
		difficulty = calculateDifficulty();
	}

	@Override
	public int getDifficulty() 
	{
		return difficulty;
	}

	@Override
	public Rep[] getReps() 
	{
		return reps;
	}

	@Override
	public int getType() 
	{
		return type;
	}

	@Override
	public int getRest() 
	{
		return rest;
	}
	
	private int calculateDifficulty()
	{
		int total = 0;
		for (Rep rep: reps)
		{
			total += rep.getDifficulty();
		}
		int restdiff = rest * 30;
		System.out.println(total + " Rest: " + restdiff);
		return total - restdiff;
	}
	
	private Rep decode(String rep) //def a easier way to do this, but nah not now
	{
		int a, b, c, d, i, j;
		i = 0;
		j = 0;
		i = rep.indexOf(';', j);
		a = Integer.parseInt(rep.substring(j,i));
		j = rep.indexOf(';', i);
		b = Integer.parseInt(rep.substring(i, j));
		i = rep.indexOf(';', j);
		c = Integer.parseInt(rep.substring(j,i));
		j = rep.indexOf(';', i);
		d = Integer.parseInt(rep.substring(i, j));
		return new Rep(a, b, c, d);
		
	}
	@Override
	public int getDistance() 
	{
		return totalDistance;
	}
	@Override
	public String tostring()
	{
		return String.format("%s\n Rest: %d seconds", reps.toString(), rest);
	}

	@Override
	public String pack() 
	{
		String temp = "";
		for (Rep run : reps)
			temp += run.toString() + "-";
		
		return String.format("%d\n%s\n%d", type, temp.substring(0, temp.length() - 2), rest);
	}
	
	


}
