package workout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsFrame {
	
	JFrame frame;
	
	JPanel menuPage, loadSavedPage, loadPresetPage, loadRandomPage, currentPage = null, lastPage = null;
	
	JButton loadSaved, loadPreset, loadRandom;
	
	Container pane;
	

	public GraphicsFrame() {
		frame = new JFrame("Workout Generator");
		 pane = frame.getContentPane();
	}
	
	public void start()
	{
		
		
		menuPage = new JPanel();
		loadSavedPage = new JPanel();
		loadPresetPage = new JPanel();
		loadRandomPage = new JPanel();
		
		loadSaved = new JButton("Load Saved");
		loadSaved.setBounds(100, 100, 130, 30);
		loadSaved.addActionListener(new ActionListener() {@Override	public void actionPerformed(ActionEvent arg0) {goToScreen(loadSavedPage);}});
		
		loadPreset = new JButton("Load Pre-Set");
		loadPreset.setBounds(100, 200, 130, 30);
		loadPreset.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent arg0) {goToScreen(loadPresetPage);}});
		
		loadRandom = new JButton("Load Pre-Set");
		loadRandom.setBounds(100, 300, 130, 30);
		loadRandom.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent arg0) {goToScreen(loadPresetPage);}});
		 
		currentPage = menuPage;
		pane.add(menuPage);
		
		menuPage.add(loadSaved);
		menuPage.add(loadPreset);
		menuPage.add(loadRandomPage);
		
		
		
		frame.setBounds(100, 100, 500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void goToScreen(JPanel panel)
	{
		pane.remove(currentPage);
		pane.add(panel);
	}

}
