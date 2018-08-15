import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View_Task extends JFrame{
	public View_Task() {
		try {
			JTextArea t_area = new JTextArea();
			t_area.setEnabled(false);
			t_area.setSize(new Dimension(500, 600));
			t_area.setDisabledTextColor(Color.BLACK);;

			Main.buttonPanel.add(new JScrollPane(t_area));
			Main.buttonPanel.repaint();
			Main.buttonPanel.revalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
