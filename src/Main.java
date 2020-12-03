import graphics.GraphicsFrame;
import logging.LogWriter;

public class Main
{

	public static void main(String[] args) 
	{
		LogWriter.write("started");
		GraphicsFrame frame = new GraphicsFrame();
		frame.start();
	}

}
