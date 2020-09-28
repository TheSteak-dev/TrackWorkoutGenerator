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
	public String pack()
	{
		//in format [distance;intensity;recovery;rest,difficulty]
		return String.format("%d;%d;%d;%d", distance, intensity, recovery, rest);
	}
	public String toString()
	{
		return String.format("Distance: %dm\t Effort: %d%%\t Recovery Jog: %dm\t Rest: %d seconds\n", distance, intensity, recovery, rest);
	}
	private int calculateDifficulty()
	{
		//TODO set difficulty
		int difficulty = 0;
		int distdiff = (int)(Math.pow(distance, 0.6) * 200); //1, 2
		int intediff = (int)(Math.pow(intensity, 1.85) * 0.7); //2, 1
		int recodiff = (int)(recovery * 3.5); //4, 4
		int restdiff = (int)(rest * 15); //3, 3
		difficulty = distdiff + intediff - recodiff - restdiff;
		System.out.println(difficulty + " Distance: " + distdiff + " Intensity: " + intediff + " Recovery: " + recodiff + " Rest: " + restdiff);
		return difficulty;
	}
	public static void main(String[] args)
	{
		Rep rep1 = new Rep(200, 200, 90, 95);
		Rep rep2 = new Rep(400, 200, 90, 90);
		Rep rep3 = new Rep(800, 200, 90, 80);
		rep1.getDifficulty();
		rep2.getDifficulty();
		rep3.getDifficulty();
	}
	
}
