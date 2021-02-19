package TrackWorkoutGenerator;

import graphics.GraphicsFrame;
import logging.LogWriter;

public class Main
{
	public static void main(String[] args) 
	{
		LogWriter.write("Program Started");
		GraphicsFrame frame = new GraphicsFrame();
		frame.start();
	}

}
