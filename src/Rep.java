package workout;

public class Rep {
	
	//A class that represents a single set
	
	private int distance;
	private int difficulty;
	private int recovery;
	private int rest;
	private int intensity;
	public Rep(int distance, int recovery, int rest, int intensity)
	{
		this.distance = distance;
		this.intensity = intensity;
		this.recovery = recovery;
		this.rest = rest;
		difficulty = calculateDifficulty();
		
	}
	public Rep(int difficulty)
	{
		//TODO generate
	}
	public int getDistance()
	{
		return distance;
	}
	public int getRecovery()
	{
		return recovery;
	}
	public int getRest()
	{
		return rest;
	}
	public int getIntensity()
	{
		return intensity;
	}
	public int getDifficulty()
	{
		return difficulty;
	}
	public String toString()
	{
		//in format [distance;intensity;recovery;rest,difficulty]
		return String.format("%d;%d;%d;%d", distance, intensity, recovery, rest);
	}
	private int calculateDifficulty()
	{
		//TODO set difficulty
		return 0;
	}
	
}