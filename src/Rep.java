package workout;

public class Rep {
	
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
		difficulty = getDifficulty();
		
	}
	public Rep(int difficulty)
	{
		//TODO generate
	}
	public String toString()
	{
		//in format [distance;intensity;recovery;rest,difficulty]
		return String.format("%d;%d;%d;%d", distance, intensity, recovery, rest);
	}
	private int getDifficulty()
	{
		//TODO set difficulty
		return 0;
	}
	
}
