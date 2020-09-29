
import javax.swing.JPanel;

/*
 * A Stack for keeping track of panels
 */

public class PanelStack {
	
	private JPanel[] stack;
	private int last;
	
	public PanelStack(int capacity)
	{
		stack = new JPanel[capacity];
		last = 0;
	}
	
	public void append(JPanel panel)
	{
		stack[last] = panel;
		last += 1;
	}
	
	public JPanel pop ()
	{
		if (last < 0) throw new ArrayIndexOutOfBoundsException();
		last -= 1;
		JPanel temp = stack[last];
		stack[last] = null;
		return temp;
	}
	
	public JPanel current()
	{
		return stack[last - 1];
	}
}
