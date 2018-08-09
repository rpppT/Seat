import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

public class JButton_All_SetEnabled_ActoinLisnter implements ActionListener {
	static int DEFAULT_FONT_SIZE ;
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		int len = Main.button.length;

		if (Main.chButton_func[0] == item) {
			for (int i = 0; i < len; i++) {
					Main.button[i].setText("");
					Main.button[i].setEnabled(true);
			}
		} else {
			for (int i = 0; i < len; i++) {
				if (Main.button[i].isEnabled() && Main.button[i].getBackground() != Color.PINK) {
					Main.button[i].setText("비활성화");
					Main.button[i].setFont(new Font("sss", Font.BOLD, new JButton().getFont().getSize()));
					Main.button[i].setEnabled(false);
				}
			}
		}

		Jmenu_Assigned_Seat_Function.isCanFixed = false;

		Main.buttonPanel.revalidate();
		Main.buttonPanel.repaint();
	}
}
