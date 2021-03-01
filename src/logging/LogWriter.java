package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogWriter 
{

	private static FileWriter writer;
	
	static
	{
		try
		{
			writer = new FileWriter("res/logs/Log.txt");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void write (String text)
	{
		try
		{
			writer.write(String.format("[%s] %s\n", LocalDateTime.now(), text));
			writer.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void logError(String error, Error e)
	{
		try
		{
			writer.write(String.format("[%s] %s\n", LocalDateTime.now(), error + e.getCause()));
			writer.flush();
		}
		catch(IOException E)
		{
			E.printStackTrace();
		}
	}


}
