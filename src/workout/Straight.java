package workout;

//another class that is a set

public class Straight implements Set
{

	private Rep[] reps;
	private int type;
	private int difficulty;
	private int rest;
	private int repNum;
	private int totalDistance;
	
	public Straight(int type)
{
		// TODO generate
	}
	
	//build off input
	public Straight(int type, String _rep, int repNum, int rest)
	{
		this.reps = new Rep[repNum];
		this.rest = rest;
		this.repNum = repNum;
		Rep decoded = decode(_rep);
		for (int i = 0; i < repNum; i++)
		{
			this.reps[i] = decoded;
		}
		totalDistance = decoded.getDistance() * repNum;
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
		total = repNum * reps[0].getDifficulty();
		int restdiff = rest * 4;
		System.out.println(total + " Rest: " + restdiff);

		return total - restdiff;
	}
	
	private Rep decode(String rep) //def a easier way to do this, but nah not now
	{
		String[] nums = rep.split(";");
		return new Rep(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]), Integer.parseInt(nums[3]));
		
	}
	@Override
	public int getDistance() 
	{
		return totalDistance;
	}
	@Override
	public String tostring()
	{
		return String.format("%d x %sRest: %d seconds\n", repNum, reps[0].toString(), rest);
	}
	@Override
	public String pack() 
	{
		return String.format("%d\n%s\n%d\n%d\nend\n", type, reps[0].pack(), repNum, rest);
	}
	

	


}
