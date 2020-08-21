package workout;

public class Ladder implements Set {

	private Rep[] reps;
	private int type;
	private int difficulty;
	private int rest;
	private int totalDistance;
	
	public Ladder(int type) {
		// TODO Auto-generated constructor stub
	}
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
	public int getDifficulty() {
		return difficulty;
	}

	@Override
	public Rep[] getReps() {
		return reps;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public int getRest() {
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
	public int getDistance() {
		return totalDistance;
	}


}
