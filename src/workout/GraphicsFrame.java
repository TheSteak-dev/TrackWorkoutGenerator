package workout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GraphicsFrame {
	
	JFrame frame;
	
	JPanel menuPage, loadSavedPage, loadPresetPage, loadRandomPage, currentPage = null, lastPage = null;
	
	JButton loadSaved, loadPreset, loadRandom;
	
	JLabel  menuLogo;
	
	Container pane;
	
	Workout[] premade, saved;
	

	public GraphicsFrame() 
	{
		frame = new JFrame("Workout Generator");
		pane = frame.getContentPane();
	}
	
	public void start()
	{
		
		
		menuPage = new JPanel(null);
		loadSavedPage = new JPanel();
		loadPresetPage = new JPanel();
		loadRandomPage = new JPanel();
		
		menuLogo = new JLabel("Menu");
		menuLogo.setBounds(230, 000, 40, 20);
		
		loadSaved = new JButton("Load Saved");
		loadSaved.setBounds(100, 100, 130, 30);
		loadSaved.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {goToScreen(loadRandomPage);}});
		
		loadPreset = new JButton("Load Pre-Set");
		loadPreset.setBounds(200, 200, 130, 30);
		loadPreset.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent arg0) {goToScreen(loadRandomPage);}});
		
		loadRandom = new JButton("Load Pre-Set");
		loadRandom.setBounds(300, 300, 130, 30);
		loadRandom.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent arg0) {goToScreen(loadRandomPage);}});
		 
		
		//need to add layout managers
		menuPage.add(loadSaved);
		menuPage.add(loadPreset);
		menuPage.add(loadRandom);
		menuPage.add(menuLogo);
		
		currentPage = menuPage;
		pane.add(menuPage);
		
		frame.setBounds(100, 100, 500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void goToScreen(JPanel panel)
	{
		System.out.println("Going To Page" + panel);
		pane.remove(currentPage);
		pane.add(panel);
		pane.revalidate();
	}

}
