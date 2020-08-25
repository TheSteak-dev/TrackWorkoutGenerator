package workout;

import javax.swing.JPanel;

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
		stack[last++] = panel;
	}
	
	public JPanel pop ()
	{
		if (last < 0) throw new ArrayIndexOutOfBoundsException();
		last--;
		JPanel temp = stack[last];
		stack[last] = null;
		return temp;
	}
	
	public JPanel current()
	{
		return stack[last - 1];
	}
}
