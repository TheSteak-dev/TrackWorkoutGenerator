package workout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GraphicsFrame {
	
	private final int MAXFRAMES = 2;
	
	private JFrame frame;
	
	private JPanel menuPage, loadSavedPage, loadPresetPage, loadRandomPage;
	
	private JButton loadSaved, loadPreset, loadRandom, presetBack, savedBack, randomBack;
	
	private JLabel  menuLogo, presetLogo, savedLogo, randomLogo;
	
	private JComboBox<Workout> presetCB, savedCB;
	
	private Container pane;
	
	private Workout[] presetWorkouts, savedWorkouts;
	
	private PanelStack stack;
	
	private ActionListener back;
	

	public GraphicsFrame() 
	{
		frame = new JFrame("Workout Generator");
		pane = frame.getContentPane();
		stack = new PanelStack(MAXFRAMES);
		back = new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {back();}};
		{
			File preset = new File ("res/premade");
			presetWorkouts = new Workout[preset.listFiles().length];
			for (int i = 0; i < preset.listFiles().length; i++)
			{
				presetWorkouts[i] = new Workout(preset.listFiles()[i].toString());
			}
			File saved = new File("res/saved");
			savedWorkouts = new Workout[saved.listFiles().length];
			for (int i = 0; i < saved.listFiles().length; i++)
			{
				savedWorkouts[i] = new Workout(saved.listFiles()[i].toString());
			}
		}
	}
	
	public void start()
	{
		
		//set jPanels
		menuPage = new JPanel(null);
		loadSavedPage = new JPanel(null);
		loadPresetPage = new JPanel(null);
		loadRandomPage = new JPanel(null);
		
		//set jComponents for randomPage
		randomLogo = new JLabel("Random");
		randomLogo.setBounds(220, 0, 60, 20);
		
		randomBack = new JButton("Back");
		randomBack.setBounds(1, 450, 70, 20);
		randomBack.addActionListener(back);
		
		loadRandomPage.add(randomLogo);
		loadRandomPage.add(randomBack);
		
		//set jComponents for savedPage
		savedLogo = new JLabel("Saved");
		savedLogo.setBounds(230, 000, 40, 20);
		
		savedBack = new JButton("Back");
		savedBack.setBounds(1, 450, 70, 20);
		savedBack.addActionListener(back);
		
		savedCB= new JComboBox<Workout>(savedWorkouts);
		savedCB.setEditable(false);
		savedCB.setBounds(80, 100, 340, 30);
		savedCB.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {System.out.println("hye");}});
		
		loadSavedPage.add(savedLogo);
		loadSavedPage.add(savedBack);
		loadSavedPage.add(savedCB);
		
		//set jComponents for presetPage
		presetBack = new JButton("Back");
		presetBack.setBounds(1, 450, 70, 20);
		presetBack.addActionListener(back);
		
		presetCB= new JComboBox<Workout>(presetWorkouts);
		presetCB.setEditable(false);
		presetCB.setBounds(80, 100, 340, 30);
		presetCB.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {display(presetCB.getSelectedIndex(), "preset");}});
		

		presetLogo = new JLabel("Preset");
		presetLogo.setBounds(230, 000, 40, 20);
		
		loadPresetPage.add(presetLogo);
		loadPresetPage.add(presetBack);
		loadPresetPage.add(presetCB);
		
		//set jComponents for menu
		
		menuLogo = new JLabel("Menu");
		menuLogo.setBounds(230, 000, 40, 20);
			
		loadSaved = new JButton("Load Saved");
		loadSaved.setBounds(180, 165, 140, 30);
		loadSaved.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {goToScreen(loadSavedPage);}});
		
		loadPreset = new JButton("Load Pre-Set");
		loadPreset.setBounds(180, 200, 140, 30);
		loadPreset.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent arg0) {goToScreen(loadPresetPage);}});
		
		loadRandom = new JButton("Load Random");
		loadRandom.setBounds(180, 235, 140, 30);
		loadRandom.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent arg0) {goToScreen(loadRandomPage);}});
		 
		
		//add jComponents
		menuPage.add(loadSaved);
		menuPage.add(loadPreset);
		menuPage.add(loadRandom);
		menuPage.add(menuLogo);
		
		//initial addition to the panel stack
		stack.append(menuPage);
		pane.add(menuPage);
		
		//frame editing
		frame.setBounds(100, 100, 500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void goToScreen(JPanel panel) //go to a screen, and put it on the stack
	{
		pane.remove(stack.current());
		pane.add(panel);
		stack.append(panel);
		pane.validate();
		pane.repaint();
	}
	
	private void back() //go back to the last screen
	{
		pane.remove(stack.pop());
		pane.add(stack.current());
		pane.repaint();
	}
	private String display(int i, String system)
	{
		if (system.equals("preset"))
		{
			LogWriter.write("selected | preset | " + i);
			return presetWorkouts[i].toprint();
		}
		return "failed to load";
	}

}
