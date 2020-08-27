package workout;

//a class that represents a set of reps

public interface Set {
	
	public int getDifficulty();
	
	public Rep[] getReps();
	
	public int getType();
	
	public int getRest();
	
	public int getDistance();
}
