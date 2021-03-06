package datastructure;


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
		generate();
		difficulty = calculateDifficulty();
		//TODO works, but not fast, needs to just calibrate the current values
		int changes = 0;
		while (Math.abs(this.difficulty - difficulty) > 500)
		{
			break;
		}
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
		return String.format("Distance: %dm\t Effort: %d%%\t Recovery: %dm\t Rest: %ds\n", distance, intensity, recovery, rest);
	}
	private void generate()
	{
		distance = (int)Math.pow(Math.random() * 100, 2.3);
		intensity = (int)Math.pow(Math.random() * 80, 1.1);
		recovery = (int)(Math.random() * 10) * 100;
		rest = (int)(Math.random() * 2 + 1) * 30;
		round();
	}
	private void round()
	{
		distance = Math.round(distance / 100) * 100;
		intensity = Math.round(intensity / 5) * 5;
		recovery = Math.round(recovery/ 50) * 50;
		rest = Math.round(rest / 30) * 30;
	}
	private int calculateDifficulty()
	{
		int difficulty = 0;
		int distdiff = (int)(Math.pow(distance, 0.6) * 200);
		int intediff = (int)(Math.pow(intensity, 1.85) * 0.7);
		int recodiff = (int)(recovery * 3.5);
		int restdiff = (int)(rest * 15);
		int extradiff = (int)(Math.pow(distance, 0.2) * intensity * 2);
		difficulty = distdiff + intediff - recodiff - restdiff + extradiff;
		//System.out.println(difficulty + " Distance: " + distdiff + " Intensity: " + intediff + " Recovery: " + recodiff + " Rest: " + restdiff);
		return difficulty;
	}

	
}
