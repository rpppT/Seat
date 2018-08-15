import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Heap_Info extends JFrame implements ActionListener, Runnable{
	final static JTextArea textArea = new JTextArea();
	final static JScrollPane scrollPane  = new JScrollPane(textArea);
	final static JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
	
	public Heap_Info() {
		setTitle("Heap-Debug(JVM Memory)");
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		add(scrollPane);
		setPreferredSize(new Dimension(400, 400));
		pack();
		setLocation(1000,300);
		setResizable(false);
		setVisible(false);
	}
	public static void update() {
		Stack<JButton[]> fowardStack = GoToFowardAndBackWard.foward_stack, backStack = GoToFowardAndBackWard.backward_stack;
		ArrayList<JButton []> foward_list = new ArrayList<>(fowardStack);
		ArrayList<JButton []> backward_list = new ArrayList<>(backStack);
		
		Iterator<JButton[]> iter_list = foward_list.iterator();
		
		textArea.append("Foward - Stack\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
		while(iter_list.hasNext()) {
			textArea.append(iter_list.next().toString()+"\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
		textArea.append("\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
		textArea.append("\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
		textArea.append("Backward - Stack\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	    iter_list = backward_list.iterator();
		while(iter_list.hasNext()) {
			textArea.append(iter_list.next().toString()+"\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
		textArea.append("\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
		textArea.append("\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(true);
	}
	@Override
	public void run() {
		while(true) {
			try {
				update();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
