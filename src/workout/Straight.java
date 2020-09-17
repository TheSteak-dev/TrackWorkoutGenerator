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
		//TODO
		return 0;
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
		return String.format("%d x %s\n Rest: %d seconds", repNum, reps[0]);
	}
	@Override
	public String pack() 
	{
		return String.format("%d\n%s\n%d\n%d\nend\n", type, reps[0], repNum, rest);
	}
	

	


}
