

public class Main
{

	public static void main(String[] args) 
	{
		System.out.println("Started");
		LogWriter.write("started");
		GraphicsFrame frame = new GraphicsFrame();
		frame.start();
	}

}
