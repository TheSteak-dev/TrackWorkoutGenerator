package workout;

import javax.swing.JFrame;

public class GraphicsFrame {
	
	JFrame frame;

	public GraphicsFrame() {
		// TODO Auto-generated constructor stub
	}
	
	public void start()
	{
		frame = new JFrame("Workout Generator");
		
		
		 
		
		frame.setBounds(100, 100, 500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
