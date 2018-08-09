import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

public class JButton_All_Fixed_ActionListner implements ActionListener {
	static boolean isTrue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		int i;
		int len = Main.button.length;

		if (item == Main.chButton_func[3]) {
			for (i = 0; i < len; i++) {
				Main.button[i].setBackground(new JButton().getBackground());
			}
		} else {
			for (i = 0; i < len; i++) {
				if (Main.button[i].isEnabled() && !Main.button[i].getText().equals("")) {
					Main.button[i].setBackground(Color.PINK);
				}
			}
		}

		Jmenu_Assigned_Seat_Function.isCanFixed = false;
		
		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
	}
}
