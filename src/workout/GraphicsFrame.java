package workout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GraphicsFrame {
	
	private final int MAXFRAMES = 2;
	
	private JFrame frame;
	
	private JPanel menuPage, loadSavedPage, loadPresetPage, loadRandomPage, currentPage = null, lastPage = null;
	
	private JButton loadSaved, loadPreset, loadRandom, allBack;
	
	private JLabel  menuLogo, presetLogo;
	
	private Container pane;
	
	private Workout[] premade, saved;
	
	private PanelStack stack;
	

	public GraphicsFrame() 
	{
		frame = new JFrame("Workout Generator");
		pane = frame.getContentPane();
		stack = new PanelStack(MAXFRAMES);
		{
			//load premade and saved
			premade = new Workout[0];
			saved = new Workout[0];
		}
	}
	
	public void start()
	{
		
		//set Jpanels
		menuPage = new JPanel(null);
		loadSavedPage = new JPanel(null);
		loadPresetPage = new JPanel(null);
		loadRandomPage = new JPanel(null);
		
		
		//set jComponents for presetPage
		allBack = new JButton("Back");
		allBack.setBounds(1, 450, 70, 20);
		allBack.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {back();}});

		presetLogo = new JLabel("Preset");
		presetLogo.setBounds(230, 000, 40, 20);
		
		loadPresetPage.add(presetLogo);
		loadPresetPage.add(allBack);
		
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
		System.out.println("Going To Page" + panel);
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
		//pane.validate();
		pane.repaint();
		System.out.println("finished");
	}

}
