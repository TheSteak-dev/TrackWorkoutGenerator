
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class GraphicsFrame {
	
	private final String[] sortOptions = new String[] {"default"};
	
	private final int MAXFRAMES = 2;
	
	private JFrame frame;
	
	private JPanel menuPage, loadSavedPage, loadPresetPage, loadRandomPage;
	
	private JButton loadSaved, loadPreset, loadRandom, presetBack, savedBack, randomBack;
	
	private JLabel  menuLogo, presetLogo, savedLogo, randomLogo;
	
	private JTextArea presetBox, savedBox, randomBox;
	
	private JComboBox<Workout> presetCB, savedCB;
	
	private JComboBox<String> presetSortBy, savedSortBy;
	
	private Container pane;
	
	private Workout[] presetWorkouts, savedWorkouts;
	
	private PanelStack stack;
	
	private ActionListener back;
	
	private final Border INFOBOXBORDER;
	

	public GraphicsFrame() 
	{
		INFOBOXBORDER = BorderFactory.createLineBorder(Color.black, 2);
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
		
		randomBox = new JTextArea("Not Implemented");
		randomBox.setEditable(false);
		randomBox.setBounds(40, 140, 420, 200);
		randomBox.setBorder(INFOBOXBORDER);
		
		loadRandomPage.add(randomLogo);
		loadRandomPage.add(randomBack);
		loadRandomPage.add(randomBox);
		
		//set jComponents for savedPage
		savedLogo = new JLabel("Saved");
		savedLogo.setBounds(230, 000, 40, 20);
		
		savedBack = new JButton("Back");
		savedBack.setBounds(1, 450, 70, 20);
		savedBack.addActionListener(back);
		
		savedCB= new JComboBox<Workout>(savedWorkouts);
		savedCB.setEditable(false);
		savedCB.setBounds(40, 100, 340, 30);
		savedCB.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {
			System.out.println("hye");}});
		
		savedBox = new JTextArea("Not Implemented");
		savedBox.setEditable(false);
		savedBox.setBounds(40, 140, 420, 200);
		savedBox.setBorder(INFOBOXBORDER);
		
		savedSortBy = new JComboBox<String>(sortOptions);
		savedSortBy.setEditable(false);
		savedSortBy.setBounds(390, 100, 100, 30);
		savedSortBy.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {
			changeSortBy("saved");
			}});
		
		loadSavedPage.add(savedLogo);
		loadSavedPage.add(savedBack);
		loadSavedPage.add(savedCB);
		loadSavedPage.add(savedBox);
		loadSavedPage.add(savedSortBy);
		
		//set jComponents for presetPage
		presetBack = new JButton("Back");
		presetBack.setBounds(1, 450, 70, 20);
		presetBack.addActionListener(back);
		
		presetCB = new JComboBox<Workout>(presetWorkouts);
		presetCB.setEditable(false);
		presetCB.setBounds(40, 100, 340, 30);
		presetCB.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {
			presetBox.setText(display(presetCB.getSelectedIndex(), "preset"));}});
		
		presetSortBy = new JComboBox<String>(sortOptions);
		presetSortBy.setEditable(false);
		presetSortBy.setBounds(390, 100, 100, 30);
		presetSortBy.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {
			changeSortBy("preset");
			}});

		
		presetBox = new JTextArea("Choose a Workout");
		presetBox.setEditable(false);
		presetBox.setBounds(40, 140, 420, 200);
		presetBox.setBorder(INFOBOXBORDER);

		presetLogo = new JLabel("Preset");
		presetLogo.setBounds(230, 0, 40, 20);
		
		loadPresetPage.add(presetLogo);
		loadPresetPage.add(presetBack);
		loadPresetPage.add(presetCB);
		loadPresetPage.add(presetBox);
		loadPresetPage.add(presetSortBy);
		
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
	
	private void changeSortBy(String panel)
	{
		
	}
	
	private String display(int i, String system)
	{
		if (system.equals("preset"))
		{
			LogWriter.write("selected | preset | " + i);
			return presetWorkouts[i].toprint();
		}
		else if (system.equals("saved"))
		{
			LogWriter.write("selected | saved | " + i);
			return savedWorkouts[i].toprint();
		}
		LogWriter.write("failed to load");
		return "failed to load";
	}

}
